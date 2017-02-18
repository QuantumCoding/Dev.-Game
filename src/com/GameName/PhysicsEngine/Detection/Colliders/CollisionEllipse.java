package com.GameName.PhysicsEngine.Detection.Colliders;

import java.util.Arrays;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionPeriod;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Math.MathUtil;
import com.GameName.Util.Vectors.Vector3f;

public class CollisionEllipse extends CollisionBody {
	private Vector3f radius;
	
	private Transform transform;
	private Matrix4f inverserTransfrom;
	
	public CollisionEllipse(Vector3f radius) {
		this.radius = radius;
		
		transform = new Transform();
		updateTransform();
	}
	
	private void updateTransform() {
		transform.setScale(radius);
		transform.setRotation(super.rotation);
	
		inverserTransfrom = (Matrix4f) transform.getTransformMatrix().invert();
	}
	
	public void setRotation(Vector3f rotation) {
		super.setRotation(rotation);
		updateTransform();
	}
	
	public void setRadius(Vector3f radius) {
		this.radius = radius;
		updateTransform();
	}
	
	public IntersectionResult intersect(Triangle tri, Vector3f velocity, Vector3f meshRotation) {
		tri = tri.changeSpace(inverserTransfrom, meshRotation);
		if(tri.getNormal().dot(velocity.normalize()) >= 0) return null; // Back-Side
		
		IntersectionPeriod period = findIntersection(tri, velocity);
		if(!period.isValid()) return null; // False
		period.clamp();
		
		float intersectionDistance = 0;
		Vector3f intersectionPoint = null;
		
		intersectionPoint = position.subtract(tri.getNormal()).add(velocity.multiply(period.t0()));
		boolean inTriangle = tri.containsPoint(intersectionPoint);
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
			if(!intersection.period.isLowerValid()) continue;
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
			if(!intersection.period.isLowerValid()) continue;
			return intersection;
		}
		
		return null;
	}
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	private IntersectionLocation findIntersection(Vector3f point, Vector3f velocity) {
		float a = velocity.lengthSquared();
		float b = 2 * velocity.dot(position.subtract(point));
		float c = point.subtract(position).lengthSquared() - 1;
		
		float[] results = sortedQuadradicFormula(a, b, c);
		return new IntersectionLocation(results[0], results[1], point);
	}
	
	private LineIntersection findIntersection(Vector3f p1, Vector3f p2, Vector3f velocity) {
		Vector3f edge = p2.subtract(p1);
		Vector3f direction = p1.subtract(position);
		
		float a = edge.lengthSquared() * -velocity.lengthSquared() + (float) Math.pow(edge.dot(velocity), 2);
		float b = edge.lengthSquared() * (2 * velocity.dot(direction)) - (2 * (edge.dot(velocity) * edge.dot(direction)));
		float c = edge.lengthSquared() * (1 - direction.lengthSquared()) + (float) Math.pow(edge.dot(direction), 2);
		
		float[] results = sortedQuadradicFormula(a, b, c);
		return new LineIntersection(results[0], results[1], p1, p2);
	}
	
	private float[] sortedQuadradicFormula(float a, float b, float c) {
		float[] results = MathUtil.quadicFormula(a, b, c);
		
		float min = results[0];
		float max = results[1];
		
		if(!Float.isNaN(min)) {
			if(min > max) {
				float temp = min;
				min = max; max = temp;
			}
			
			if(min < 0) min = max;
			if(min < 0) min = max = Float.NaN;
		}
		
		return new float[] { min, max };
	}
	
	private IntersectionPeriod findIntersection(Triangle tri, Vector3f velocity) {
		float t0 = 0, t1 = 1;
		
		float velDotNorm = velocity.dot(tri.getNormal());
		float distance = tri.signedDistance(position);
		
		if(Math.abs(velDotNorm) < 0.00001f) {
			if(Math.abs(distance) > 1)
				return IntersectionPeriod.NO_INTERSECTION;
			
		} else {
			t0 = ( 1 - distance) / velDotNorm;
			t1 = (-1 - distance) / velDotNorm;
			
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
	public Matrix4f getInverseTransform() { return inverserTransfrom; }
	
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
