package com.GameName.PhysicsEngine;

import java.util.HashSet;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.PhysicsEngine.Response.PlaneResponse;
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
	
	public void remove(PhysicsBody body) {
		if(!bodies.remove(body)) return;
		
		if(body instanceof MovingBody)
			movingBodies.remove((MovingBody) body);
	}
	
	public void simulate(float delta) {
		for(MovingBody moving : movingBodies) {
			moving.setVelocity(moving.getVelocity().multiply(0.99f));
			
			IntersectionResult intersection = findClosestIntersection(moving);
			moving.setIntersection(intersection);
			
			if(intersection == null) {
				moving.setPosition(moving.getPosition().add(moving.getVelocity()));
				continue;
			}
			
			Vector3f position = intersection.getIntersected().getPosition().subtract(moving.getPosition())
					.transform(moving.getBody().getInverseTransform()).multiply(-1);
			
			Vector3f velocity = moving.getVelocity().transform(moving.getBody().getInverseTransform());
			
			PlaneResponse response = new PlaneResponse(intersection, position, velocity);
			response.process();
			
			moving.setPosition(response.getNewPosition()
					.transform(Matrix4f.invert(moving.getBody().getInverseTransform(), null))
					.add(intersection.getIntersected().getPosition()));
					
			moving.setVelocity(response.getNewVelocity().transform(Matrix4f.invert(moving.getBody().getInverseTransform(), null)));
			
//			moving.setPosition(moving.getPosition().add(moving.getVelocity().multiply(delta)));
//			moving.setVelocity(new Vector3f());
		}
	}

	private IntersectionResult findClosestIntersection(MovingBody moving) {
		IntersectionResult result = null;
		
		for(PhysicsBody body : bodies) {
			if(body == moving) continue;
			if(body.getMesh() == null) continue;
			
			IntersectionResult intersection = moving.intersect(body.getMesh());
			if(intersection == null) continue;
			
			intersection.setIntersected(body);
			if(result == null || intersection.getDistance() < result.getDistance())
				result = intersection;
		}
		
		return result;
	}
}
