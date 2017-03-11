package com.GameName.PhysicsEngine.Bodies;

import java.util.LinkedList;

import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.Util.Vectors.Vector3f;

public class MovingBody extends PhysicsBody {

	private Vector3f velocity;
	private LinkedList<Vector3f> forces;
	private IntersectionResult intersection;
	
	public MovingBody(Vector3f radius) {
		this(new CollisionEllipse(radius));
	}
	
	public MovingBody(CollisionEllipse body) {
		velocity = new Vector3f();
		forces = new LinkedList<>();
		addBody(body);
	}
	
	public void update(float delta) {
		forces.add(velocity);
	}
	
	public void setVelocity(Vector3f velocity) { this.velocity = velocity; }
	
	public IntersectionResult getIntersection() { return intersection; }
	public void setIntersection(IntersectionResult intersection) { this.intersection = intersection; }
	
	public Vector3f getVelocity() { return velocity; }
	public void addForce(Vector3f add) { forces.add(add); }
	public void addRotation(Vector3f add) { this.setRotation(getRotation().add(add)); }
	
	public void setPosition(Vector3f position) { super.setPosition(position); }
	public void setRotation(Vector3f rotation) { super.setRotation(rotation); }
	
	public LinkedList<Vector3f> getAllforce() { return forces; }
}
