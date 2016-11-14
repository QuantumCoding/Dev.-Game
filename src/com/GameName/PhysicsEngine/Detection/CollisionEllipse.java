package com.GameName.PhysicsEngine.Detection;

import java.util.Arrays;

import com.GameName.PhysicsEngine.MathContext.SpatialContext;
import com.GameName.Util.Math.MathUtil;
import com.GameName.Util.Vectors.Vector3f;

public class CollisionEllipse extends CollisionBody {
	private Vector3f radius;
	private SpatialContext context;
	
	public CollisionEllipse(Vector3f radius) {
		this.radius = radius;
		context = new SpatialContext(radius, null, null);
	}

	public boolean intersects(AABB aabb) {
		SpatialContext context = new SpatialContext(radius, aabb.getCenter(), null);
		
		Vector3f position = context.convert(super.position);
		Vector3f aabbRadius = context.scale(aabb.getRadius());
		
		Vector3f lower = aabbRadius.multiply(-1);
		Vector3f upper = aabbRadius;
		
		float dist_squared = 1;
		
		if(position.x < lower.x) dist_squared -= Math.pow(position.x - lower.x, 2);
		else if(position.x > upper.x) dist_squared -= Math.pow(position.x - upper.x, 2);
		
		if(position.y < lower.y) dist_squared -= Math.pow(position.y - lower.y, 2);
		else if(position.y > upper.y) dist_squared -= Math.pow(position.y - upper.y, 2);
		
		if(position.z < lower.z) dist_squared -= Math.pow(position.z - lower.z, 2);
		else if(position.z > upper.z) dist_squared -= Math.pow(position.z - upper.z, 2);
		
		return dist_squared > 0;
	}
	
	public boolean intersectsOctree(AABB aabb, Vector3f treeCenter) {
//													radius
		SpatialContext context = new SpatialContext(radius, treeCenter.add(aabb.getCenter().divide(radius)), null);
		
		Vector3f position = context.translate(super.position);
		Vector3f aabbRadius = context.scale(aabb.getRadius());
		
		Vector3f lower = aabbRadius.multiply(-1);
		Vector3f upper = aabbRadius;
		
		float dist_squared = 1;
		
		if(position.x < lower.x) dist_squared -= Math.pow(position.x - lower.x, 2);
		else if(position.x > upper.x) dist_squared -= Math.pow(position.x - upper.x, 2);
		
		if(position.y < lower.y) dist_squared -= Math.pow(position.y - lower.y, 2);
		else if(position.y > upper.y) dist_squared -= Math.pow(position.y - upper.y, 2);
		
		if(position.z < lower.z) dist_squared -= Math.pow(position.z - lower.z, 2);
		else if(position.z > upper.z) dist_squared -= Math.pow(position.z - upper.z, 2);
		
		return dist_squared > 0;
	}
	
	public IntersectionResult intersect(Triangle tri, Vector3f velocity, SpatialContext context) {
		tri = tri.scaleSpace(context);//.changeSpace(context);
		if(tri.getNormal().dot(velocity.normalize()) >= 0) return null; // Back-Side
		
		IntersectionPeriod period = findIntersection(tri, velocity, context);
//		System.out.println(period);
		if(!period.isValid()) return null; // False
		period.clamp();
		
		float intersectionDistance = 0;
		Vector3f intersectionPoint = null;
		
		intersectionPoint = position.subtract(tri.getNormal()).add(velocity.multiply(period.t0()));
		boolean inTriangle = tri.containsPoint(intersectionPoint, context);
		if(inTriangle) intersectionDistance = period.t0() * velocity.length(); // True, In Triangle
		
		if(!inTriangle) {
			
			IntersectionLocation results = findSmallestIntersectingPoint(tri, velocity);
			IntersectionPeriod smallestIntersectTime = results == null ? null : results.period;
			intersectionPoint = results == null ? null : results.instersectionPoint;

			results = findSmallestIntersectingLine(tri, velocity, results);
			if(results != null) smallestIntersectTime = results.period;
			if(results != null) intersectionPoint = results.instersectionPoint;
			
			if(smallestIntersectTime != null)
				intersectionDistance = velocity.length() * smallestIntersectTime.t0();
		}
		
		return intersectionPoint == null ? null : new IntersectionResult(intersectionPoint, intersectionDistance);
	}
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	private Vector3f findLineIntersectionPoint(Vector3f p1, Vector3f p2, float time, Vector3f velocity) {
		Vector3f edge = p2.subtract(p1);
		Vector3f direction = p1.subtract(position);
		
		float val = (edge.dot(velocity) * time - edge.dot(direction)) / edge.lengthSquared();
		return val >= 0 && val <= 1 ? p1.add(edge.multiply(val)) : null;
	}
	
	private IntersectionLocation findSmallestIntersectingLine(Triangle tri, Vector3f velocity, IntersectionLocation loc) {
		
		Intersection[] intersections = new Intersection[] { loc,
			findIntersection(tri.getA(), tri.getB(), velocity),
			findIntersection(tri.getA(), tri.getC(), velocity),
			findIntersection(tri.getB(), tri.getC(), velocity)
		};

		Arrays.sort(intersections);
		for(Intersection intersection : intersections) {
			if(intersection == null) continue;
			if(!intersection.period.isValid()) continue;
			if(intersection == loc) break;
			
			LineIntersection lineItersect = (LineIntersection) intersection;
			Vector3f pnt = findLineIntersectionPoint(lineItersect.p0, lineItersect.p1, intersection.period.t0(), velocity);
			if(pnt != null) return new IntersectionLocation(intersection.period, pnt);
		}
		
		return null;
	}
	
	private IntersectionLocation findSmallestIntersectingPoint(Triangle tri, Vector3f velocity) {
		IntersectionLocation[] intersections = new IntersectionLocation[] {
			findIntersection(tri.getA(), velocity),
			findIntersection(tri.getB(), velocity),
			findIntersection(tri.getC(), velocity)
		};
		
		Arrays.sort(intersections);
		for(IntersectionLocation intersection : intersections) {
			if(!intersection.period.isValid()) continue;
			
			return intersection;
		}
		
		return null;
	}
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	private IntersectionLocation findIntersection(Vector3f point, Vector3f velocity) {
		float a = velocity.lengthSquared();
		float b = 2 * velocity.dot(position.subtract(point));
		float c = point.subtract(position).lengthSquared() - 1;
		
		float[] results = MathUtil.quadicFormula(a, b, c);
		return new IntersectionLocation(Math.min(results[0], results[1]), Math.max(results[0], results[1]), point);
	}
	
	private LineIntersection findIntersection(Vector3f p1, Vector3f p2, Vector3f velocity) {
		Vector3f edge = p2.subtract(p1);
		Vector3f direction = p1.subtract(position);
		
		float a = edge.lengthSquared() * -velocity.lengthSquared() + (float) Math.pow(edge.dot(velocity), 2);
		float b = edge.lengthSquared() * (2 * velocity.dot(direction)) - 2 * edge.dot(velocity) * edge.dot(direction);
		float c = edge.lengthSquared() * (1 - direction.lengthSquared()) + (float) Math.pow(edge.dot(direction), 2);
		
		float[] results = MathUtil.quadicFormula(a, b, c);
		return new LineIntersection(Math.min(results[0], results[1]), Math.max(results[0], results[1]), p1, p2);
	}
	
	private IntersectionPeriod findIntersection(Triangle tri, Vector3f velocity, SpatialContext context) {
		float t0 = 0, t1 = 1;
		
		if(Math.abs(velocity.dot(tri.getNormal())) < 0.00001f) {
			if(Math.abs(tri.signedDistance(position, context)) > 1)
				return IntersectionPeriod.NO_INTERSECTION;
			
		} else {
			float velDotNorm = velocity.dot(tri.getNormal());
			t0 = ( 1 - tri.signedDistance(position, context)) / velDotNorm;
			t1 = (-1 - tri.signedDistance(position, context)) / velDotNorm;
			
			if(t0 > t1) {
				float temp = t0;
				t0 = t1; t1 = temp;
			}
		}
		
		return new IntersectionPeriod(t0, t1);
	}
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	public Vector3f getRadius() { return radius; }
	
	public CollisionEllipse shift(Vector3f shift) { position = position.subtract(shift); return this; }
	public void setPosition(Vector3f position) { super.position = position; }
	
	public SpatialContext getSpatialContext() { return context; }
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	private static class LineIntersection extends Intersection {
		private Vector3f p0, p1;
		
		public LineIntersection(float t0, float t1, Vector3f p0, Vector3f p1) {
			super(t0, t1);
			this.p0 = p0;
			this.p1 = p1;
		}
		
		public LineIntersection(IntersectionPeriod period, Vector3f p0, Vector3f p1) {
			super(period);
			this.p0 = p0;
			this.p1 = p1;
		}
	}
	
	private static class IntersectionLocation extends Intersection {
		private final Vector3f instersectionPoint;
		
		public IntersectionLocation(IntersectionPeriod period, Vector3f instersectionPoint) {
			super(period);
			this.instersectionPoint = instersectionPoint;
		}
		
		public IntersectionLocation(float t0, float t1, Vector3f instersectionPoint) {
			super(t0, t1);
			this.instersectionPoint = instersectionPoint;
		}
	}
	
	private static abstract class Intersection implements Comparable<Intersection> {
		final IntersectionPeriod period;
		
		public Intersection(float t0, float t1) {
			this(new IntersectionPeriod(t0, t1));
		}
		
		public Intersection(IntersectionPeriod period) {
			this.period = period;
		}
		
		public int compareTo(Intersection o) {
			if(o == null) return -1;
			return period.compareTo(o.period);
		}
	}
}
