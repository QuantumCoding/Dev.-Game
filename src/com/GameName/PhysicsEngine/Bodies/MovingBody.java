package com.GameName.PhysicsEngine.Bodies;

import java.util.HashSet;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionSphere;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.Util.Vectors.Vector3f;

public class MovingBody extends PhysicsBody {
	private Vector3f velocity;
	private CollisionEllipse body;
	private CollisionSphere broadPhaseSphere; 
	
	private IntersectionResult intersection;
	
	public MovingBody(Vector3f radius) {
		this(new CollisionEllipse(radius));
	}
	
	public MovingBody(CollisionEllipse body) {
		velocity = new Vector3f();
		this.body = body;
		
		broadPhaseSphere = new CollisionSphere(body.getRadius().max());
	}
	
	public void setPosition(Vector3f position) {
		body.setPosition(position);
		super.position = position;
	}
	
	public void setRotation(Vector3f rotation) {
		body.setRotation(rotation);
		super.rotation = rotation;
	}
	
	public void setVelocity(Vector3f velocity) {
		this.velocity = velocity;
	}
	
	public IntersectionResult intersect(CollisionMesh mesh) {
		IntersectionResult result = null;
		
		if(mesh == null) return null;
		broadPhaseSphere.setPosition(position.subtract(mesh.getPosition()).invertRotate(mesh.getRotation()).add(mesh.getPosition()));
		Vector3f meshSpaceVeclocity = velocity.invertRotate(mesh.getRotation());
		
		HashSet<Triangle> possibleCollisions = mesh.collect(broadPhaseSphere, meshSpaceVeclocity);
		Vector3f transVelocity = velocity.transform(body.getInverseTransform());
		//mesh.getPosition().subtract(body.getPosition()).normalize().divide(1000); //new Vector3f(-0.001, 0, 0);//.scale(velocity);
		
		body.setPosition(mesh.getPosition().subtract(position).transform(body.getInverseTransform()).multiply(-1));
		
		for(Triangle tri : possibleCollisions) {
			IntersectionResult intersection = body.intersect(tri, transVelocity, mesh.getRotation()); // ellipsoidSpace_meshOrigin
			if(intersection == null) continue;
			body.intersect(tri, transVelocity, mesh.getRotation()); // ellipsoidSpace_meshOrigin
			
			if(result == null || intersection.getDistance() < result.getDistance()) {
				result = intersection;
				
//				Vector3f point = intersection.getPoint().transform(Matrix4f.invert(body.getInverseTransform(), null));
//				point = point.add(mesh.getPosition());
//				result = new IntersectionResult(point, intersection.getDistance());
			}
		}
		
//		if(possibleCollisions.size() > 0) {
//			result = new IntersectionResult(mesh.getPosition(), 0);
//		}
		
		return result;
	}
	
	public CollisionEllipse getBody() { return body; }
	public CollisionSphere getBroad() { return broadPhaseSphere; }
	
	public IntersectionResult getIntersection() { return intersection; }
	public void setIntersection(IntersectionResult intersection) { this.intersection = intersection; }
	
	public Vector3f getVelocity() { return velocity; }
	public void addVelocity(Vector3f add) { velocity = velocity.add(add); }
	public void addRotation(Vector3f add) { this.setRotation(rotation.add(add)); }
}
