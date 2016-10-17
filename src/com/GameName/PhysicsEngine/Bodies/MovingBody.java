package com.GameName.PhysicsEngine.Bodies;

import java.util.HashSet;

import com.GameName.PhysicsEngine.Detection.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.IntersectionResult;
import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.PhysicsEngine.MathContext.SpatialContext;
import com.GameName.Util.Vectors.Vector3f;

public class MovingBody extends PhysicsBody {
	private Vector3f velocity;
	private CollisionEllipse body; 
	
	private boolean isIntersecting;
	
	public MovingBody(Vector3f radius) {
		this(new CollisionEllipse(radius));
	}
	
	public MovingBody(CollisionEllipse body) {
		velocity = new Vector3f();
		this.body = body;
	}
	
	public void setPosition(Vector3f position) {
		body.setPosition(position);
		super.position = position;
	}
	
	public void setVelocity(Vector3f velocity) {
		this.velocity = velocity;
	}
	
	public IntersectionResult intersect(CollisionMesh mesh) {
		IntersectionResult result = null;

		HashSet<Triangle> possibleCollisions = mesh.collect(body);
		
		SpatialContext ellipsoidSpace_meshOrigin = new SpatialContext(body.getRadius(), 
				body.getSpatialContext().convert(mesh.getPostion()), null);
		body.setPosition(ellipsoidSpace_meshOrigin.convert(position));
		
		Vector3f transVelocity = ellipsoidSpace_meshOrigin.scale(velocity);
		
		for(Triangle tri : possibleCollisions) {
			IntersectionResult intersection = body.intersect(tri, transVelocity, ellipsoidSpace_meshOrigin);
			if(intersection == null) continue;
			
			if(result == null || intersection.getDistance() < result.getDistance())
				result = intersection;
		}
		
		body.setPosition(position);
		return result;
	}
	
	public boolean isIntersecting() { return isIntersecting; }
	public void setIntersectin(boolean isIntersecting) { this.isIntersecting = isIntersecting; }
	
	public Vector3f getVelocity() { return velocity; }
	public void addVelocity(Vector3f add) { velocity = velocity.add(add); }
}
