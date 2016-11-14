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
	
	private IntersectionResult intersection;
	
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
	
	public void setRotation(Vector3f rotation) {
		body.setRotation(rotation);
		super.rotation = rotation;
	}
	
	public void setVelocity(Vector3f velocity) {
		this.velocity = velocity;
	}
	
	public IntersectionResult intersect(CollisionMesh mesh) {
		IntersectionResult result = null;
		
		Vector3f meshPos_Save = mesh.getPosition().clone();

		Vector3f bodyPos = body.getPosition();
		Vector3f meshPos = mesh.getPosition();
		
		SpatialContext sc1 = new SpatialContext(body.getRadius(), position, null); // RE-CENTER
		bodyPos = sc1.convert(bodyPos);
		meshPos = sc1.convert(meshPos);
//															   mesh.getRotation().subtract(rotation)
		SpatialContext sc4 = new SpatialContext(null, meshPos, mesh.getRotation()); // RE-CENTER
		bodyPos = sc4.convert(bodyPos);
		meshPos = sc4.convert(meshPos);
		
		body.setPosition(bodyPos);//ellipsoidSpace_meshOrigin.convert(position));
		mesh.setPosition(meshPos);
		
		HashSet<Triangle> possibleCollisions = mesh.collect(body);
		
		SpatialContext ellipsoidSpace_meshOrigin = new SpatialContext(body.getRadius(), meshPos, null);
				//new SpatialContext(body.getRadius(), meshPos, null);
		Vector3f transVelocity = meshPos.subtract(bodyPos).normalize().divide(100); //new Vector3f(-0.001, 0, 0);//.scale(velocity);
		
		for(Triangle tri : possibleCollisions) {
			IntersectionResult intersection = body.intersect(tri, transVelocity, ellipsoidSpace_meshOrigin);
			if(intersection == null) continue;
			
			if(result == null || intersection.getDistance() < result.getDistance())
				result = intersection;
		}
		
		body.setPosition(position);
		mesh.setPosition(meshPos_Save);
		
		return result;
	}
	
	public IntersectionResult getIntersection() { return intersection; }
	public void setIntersection(IntersectionResult intersection) { this.intersection = intersection; }
	
	public Vector3f getVelocity() { return velocity; }
	public void addVelocity(Vector3f add) { velocity = velocity.add(add); }
	public void addRotation(Vector3f add) { this.setRotation(rotation.add(add)); }
}
