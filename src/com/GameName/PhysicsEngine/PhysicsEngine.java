package com.GameName.PhysicsEngine;

import java.util.HashSet;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.PhysicsEngine.Detection.IntersectionResult;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsEngine {
	private HashSet<PhysicsBody> bodies;
	private HashSet<MovingBody> movingBodies;
	
	public PhysicsEngine() {
		bodies = new HashSet<>();
		movingBodies = new HashSet<>();
	}
	
	public void add(PhysicsBody body) {
		bodies.add(body);
		
		if(body instanceof MovingBody)
			movingBodies.add((MovingBody) body);
	}
	
	public void simulate(float delta) {
		for(MovingBody moving : movingBodies) {
			IntersectionResult intersection = findClosestIntersection(moving);
			moving.setIntersection(intersection);
			
			moving.setPosition(moving.getPosition().add(moving.getVelocity()));
			moving.setVelocity(new Vector3f());
		}
	}

	private IntersectionResult findClosestIntersection(MovingBody moving) {
		IntersectionResult result = null;
		
		for(PhysicsBody body : bodies) {
			if(body == moving) continue;
			
			IntersectionResult intersection = moving.intersect(body.getMesh());
			if(intersection == null) continue;
			
			if(result == null || intersection.getDistance() < result.getDistance())
				result = intersection;
		}
		
		return result;
	}
}
