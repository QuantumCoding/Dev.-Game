package com.GameName.PhysicsEngine.Detection;

import com.GameName.Util.Math.MathUtil;
import com.GameName.Util.Vectors.Vector3f;

public class CollisionEllipse extends CollisionBody {
	private Vector3f radius;
	
	public CollisionEllipse(Vector3f radius) {
		this.radius = radius;
	}

	public boolean intersects(AABB aabb) {
		Vector3f aabbCenter = aabb.getCenter().divide(radius);
		Vector3f aabbRadius = aabb.getRadius().divide(radius);
		
		Vector3f lower = aabbCenter.subtract(aabbRadius);
		Vector3f upper = aabbCenter.add(aabbRadius);
		
		float dist_squared = 1;
		
		if(position.x < lower.x) dist_squared -= Math.pow(position.x - lower.x, 2);
		else if(position.x > upper.x) dist_squared -= Math.pow(position.x - upper.x, 2);
		
		if(position.y < lower.y) dist_squared -= Math.pow(position.y - lower.y, 2);
		else if(position.y > upper.y) dist_squared -= Math.pow(position.y - upper.y, 2);
		
		if(position.z < lower.z) dist_squared -= Math.pow(position.z - lower.z, 2);
		else if(position.z > upper.z) dist_squared -= Math.pow(position.z - upper.z, 2);
		
		return dist_squared > 0;
	}
	
	public IntersectionResult intersect(Triangle tri, Vector3f velocity) {
		tri = tri.changeSpace(radius);
		IntersectionPeriod period = findIntersection(tri, velocity);
		if(!period.isValid()) return null; // False
		period.clamp();
		
		float intersectionDistance = 0;
		Vector3f intersectionPoint = null;
		
		intersectionPoint = position.subtract(tri.getNormal()).add(velocity.multiply(period.t0()));
		boolean inTriangle = tri.containsPoint(intersectionPoint);
		if(inTriangle) intersectionDistance = period.t0() * velocity.length(); // True, In Triangle
		
		if(!inTriangle) {
			
			Object[] results = findSmallestIntersectingPoint(tri, velocity);
			IntersectionPeriod smallestIntersectTime = (IntersectionPeriod) results[0];
			intersectionPoint = (Vector3f) results[1];

			Object[] lineResults = findSmallestIntersectingLine(tri, velocity, smallestIntersectTime);
			if(lineResults != null) smallestIntersectTime = (IntersectionPeriod) lineResults[1];
			if(lineResults != null) intersectionPoint = (Vector3f) lineResults[0];
			
			intersectionDistance = velocity.length() * smallestIntersectTime.t0();
		}
		
		return new IntersectionResult(intersectionPoint, intersectionDistance);
	}
	
	private Vector3f findLineIntersectionPoint(Vector3f p1, Vector3f p2, float time, Vector3f velocity) {
		Vector3f edge = p2.subtract(p1);
		Vector3f direction = p1.subtract(position);
		
		float val = (edge.dot(velocity) * time - edge.dot(direction)) / edge.lengthSquared();
		return val >= 0 && val <= 1 ? p1.add(edge.multiply(val)) : null;
	}
	
	private Object[] findSmallestIntersectingLine(Triangle tri, Vector3f velocity, IntersectionPeriod smallestTime) {
		IntersectionPeriod intersectAB = findIntersection(tri.getA(), tri.getB(), velocity);
		IntersectionPeriod intersectAC = findIntersection(tri.getA(), tri.getC(), velocity);
		IntersectionPeriod intersectBC = findIntersection(tri.getB(), tri.getC(), velocity);
			 
		if(intersectAB.isValid() && intersectAB.compareTo(intersectAC) < 0 && intersectAB.compareTo(intersectBC) < 0) {
			if(smallestTime == null || intersectAB.compareTo(smallestTime) < 0) {
				Vector3f point = findLineIntersectionPoint(tri.getA(), tri.getB(), intersectAB.t0(), velocity);
				if(point != null) return new Object[] { point, intersectAB };
			}
		}
		
		if(intersectAC.isValid() && intersectAC.compareTo(intersectAB) < 0 && intersectAC.compareTo(intersectBC) < 0) {
			if(smallestTime == null || intersectAC.compareTo(smallestTime) < 0) {
				Vector3f point = findLineIntersectionPoint(tri.getA(), tri.getB(), intersectAC.t0(), velocity);
				if(point != null) return new Object[] { point, intersectAC };
			}
		}
		
		if(intersectBC.isValid() && intersectBC.compareTo(intersectAC) < 0 && intersectBC.compareTo(intersectAB) < 0) {
			if(smallestTime == null || intersectBC.compareTo(smallestTime) < 0) {
				Vector3f point = findLineIntersectionPoint(tri.getA(), tri.getB(), intersectBC.t0(), velocity);
				if(point != null) return new Object[] { point, intersectBC };
			}
		}
		
		return null;
	}
	
	private Object[] findSmallestIntersectingPoint(Triangle tri, Vector3f velocity) {
		IntersectionPeriod intersectTimeA = findIntersection(tri.getA(), velocity);
		IntersectionPeriod intersectTimeB = findIntersection(tri.getB(), velocity);
		IntersectionPeriod intersectTimeC = findIntersection(tri.getC(), velocity);
		
		IntersectionPeriod smallestIntersectTime = !intersectTimeA.isValid() ? !intersectTimeB.isValid() ? !intersectTimeC.isValid() ?
				null : intersectTimeC : intersectTimeB : intersectTimeA;
		Vector3f intersectionPoint = !intersectTimeA.isValid() ? !intersectTimeB.isValid() ? !intersectTimeC.isValid() ?
				null : tri.getC() : tri.getB() : tri.getA();
				
		if(smallestIntersectTime == null) 
			return new Object[] {(IntersectionPeriod) null, (Vector3f) null};
		
		if(intersectTimeB.compareTo(smallestIntersectTime) < 0) {
			smallestIntersectTime = intersectTimeB;
			intersectionPoint = tri.getB();
		}
		
		if(intersectTimeC.compareTo(smallestIntersectTime) < 0) {
			smallestIntersectTime = intersectTimeC;
			intersectionPoint = tri.getC();
		}
		
		return new Object[] { smallestIntersectTime, intersectionPoint };
	}
	
	private IntersectionPeriod findIntersection(Vector3f point, Vector3f velocity) {
		float a = velocity.dot(velocity);
		float b = 2 * velocity.dot(position.subtract(point));
		float c = point.subtract(position).lengthSquared() - 1;
		
		float[] results = MathUtil.quadicFormula(a, b, c);
		return new IntersectionPeriod(Math.min(results[0], results[1]), Math.max(results[0], results[1]));
	}
	
	private IntersectionPeriod findIntersection(Vector3f p1, Vector3f p2, Vector3f velocity) {
		Vector3f edge = p2.subtract(p1);
		Vector3f direction = p1.subtract(position);
		
		float a = edge.lengthSquared() * -velocity.lengthSquared() + (float) Math.pow(edge.dot(velocity), 2);
		float b = edge.lengthSquared() * 2 * velocity.dot(direction) - 2 * (edge.dot(velocity) * edge.dot(direction));
		float c = edge.lengthSquared() * (1 - direction.lengthSquared()) + (float) Math.pow(edge.dot(direction), 2);
		
		float[] results = MathUtil.quadicFormula(a, b, c);
		return new IntersectionPeriod(Math.min(results[0], results[1]), Math.max(results[0], results[1]));
	}
	
	private IntersectionPeriod findIntersection(Triangle tri, Vector3f velocity) {
		float t0 = 0, t1 = 1;
		
		if(velocity.dot(tri.getNormal()) < 0.00001f) {
			if(Math.abs(tri.signedDistance(position)) > 1)
				return IntersectionPeriod.NO_INTERSECTION;
			
		} else {
			float velDotNorm = velocity.dot(tri.getNormal());
			t0 = ( 1 - tri.signedDistance(position)) / velDotNorm;
			t1 = (-1 - tri.signedDistance(position)) / velDotNorm;
			
			if(t0 > t1) {
				float temp = t0;
				t0 = t1; t1 = temp;
			}
		}
		
		return new IntersectionPeriod(t0, t1);
	}
	
	public Vector3f getRadius() { return radius; }
	
	public CollisionEllipse shift(Vector3f shift) { position = position.subtract(shift); return this; }
}
