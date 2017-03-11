package com.GameName.PhysicsEngine.Detection.Intersection.Tests;

import java.util.Arrays;
import java.util.HashSet;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionSphere;
import com.GameName.PhysicsEngine.Detection.Intersection.Intersection;
import com.GameName.PhysicsEngine.Detection.Intersection.Intersection.IntersectionLocation;
import com.GameName.PhysicsEngine.Detection.Intersection.Intersection.LineIntersection;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionPeriod;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.PhysicsEngine.Detection.Intersection.MovingIntersectionTest;
import com.GameName.Util.Math.MathUtil;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector3f;

public class MovingEllipsoidMeshIntersectionTest implements MovingIntersectionTest<CollisionEllipse, CollisionMesh> {
	
	private Vector3f position;

	public Class<CollisionEllipse> getMovingBodyType() { return CollisionEllipse.class; }
	public Class<CollisionMesh> getOtherBodyType() { return CollisionMesh.class; }
	
	public IntersectionResult intersects(MovingBody moving, CollisionEllipse ellipse, PhysicsBody bodyB, CollisionMesh mesh) {
		IntersectionResult result = null;
		Vector3f velocity = moving.getVelocity();

		CollisionSphere sphere = new CollisionSphere(ellipse.getRadius().divide(bodyB.getScale()).max());
		Vector3f meshSpaceVeclocity = MatrixUtil.rotateScale(bodyB.getInverseTransform(), velocity);
		position = moving.getPosition().transform(bodyB.getInverseTransform()); 
		sphere.setPosition(position);
		
		HashSet<Triangle> possibleCollisions = mesh.collect(sphere, meshSpaceVeclocity);
		if(possibleCollisions.isEmpty()) return null;
			
//		Matrix4f inMatrix4f = (Matrix4f) MatrixUtil.initTransformationMatrix(
//				moving.getPosition(), moving.getRotation(), moving.getScale().multiply(ellipse.getRadius())).invert();
		
		Matrix4f inverseTransfrom = (Matrix4f) MatrixUtil.copyScale(ellipse.getRadius(), moving.getTransform(), null).invert();
			
//		System.out.println("Faster: ");
//		System.out.println(inMatrix4f);
//		
//		System.out.println("Current:");
//		System.out.println(inverseTransfrom);
		
		Vector3f transVelocity = MatrixUtil.rotateScale(inverseTransfrom, velocity);
		position = new Vector3f();//bodyB.getPosition().transform(inverseTransfrom).multiply(-1);
		
		for(Triangle tri : possibleCollisions) {
			IntersectionResult intersection = checkIntersection(tri, transVelocity, inverseTransfrom, bodyB.getTransform());
			if(intersection == null) continue;
			
			if(result == null || intersection.getDistance() < result.getDistance()) {
				result = intersection;
				result.setResultSpace(inverseTransfrom);
				
//				Vector3f point = intersection.getPoint().transform(Matrix4f.invert(body.getInverseTransform(), null));
//				point = point.add(mesh.getPosition());
//				result = new IntersectionResult(point, intersection.getDistance());
			}
		}

		return result;
	}
	
	private IntersectionResult checkIntersection(Triangle tri, Vector3f velocity, Matrix4f inverse, Matrix4f transform) {
		tri = recalculateTriange(tri, inverse, transform);
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
	
	private Triangle recalculateTriange(Triangle tri, Matrix4f inverse, Matrix4f transform) {
		Vector3f a = tri.getA(), b = tri.getB(), c = tri.getC();
		
		if(transform != null) {
			a = a.transform(transform);
			b = b.transform(transform);
			c = c.transform(transform);
		}
		
		a = a.transform(inverse);
		b = b.transform(inverse);
		c = c.transform(inverse);
		
//		if(transform != null) {
//			a = MatrixUtil.rotateScale(transform, a);
//			b = MatrixUtil.rotateScale(transform, b);
//			c = MatrixUtil.rotateScale(transform, c);
//		}
//		
//		a = MatrixUtil.rotateScale(inverse, a);
//		b = MatrixUtil.rotateScale(inverse, b);
//		c = MatrixUtil.rotateScale(inverse, c);
		
		return new Triangle(a, b, c);
	}
}
