package com.GameName.PhysicsEngine;

import java.util.HashMap;
import java.util.HashSet;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionBody;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.PhysicsEngine.Detection.Intersection.MovingIntersectionTest;
import com.GameName.PhysicsEngine.Response.PlaneResponse;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.MutableVector3f;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsEngine {	
	private HashSet<PhysicsBody> bodies;
	private HashSet<MovingBody> movingBodies;
	
	private HashMap<Class<? extends CollisionBody>, HashMap<Class<? extends CollisionBody>, MovingIntersectionTest<?,?>>> movingTests;
	
	public PhysicsEngine() {
		bodies = new HashSet<>();
		movingBodies = new HashSet<>();
		
		movingTests = new HashMap<>();
	}
	
	public void addIntersectionTest(MovingIntersectionTest<? extends CollisionBody, ? extends CollisionBody> test) {
		HashMap<Class<? extends CollisionBody>, MovingIntersectionTest<?, ?>> tests = null;
		if((tests = movingTests.get(test.getMovingBodyType())) == null)
			movingTests.put(test.getMovingBodyType(), tests = new HashMap<>());
		tests.put(test.getOtherBodyType(), test);
	}
	
	public void add(PhysicsBody body) {
		bodies.add(body);
		
		if(body instanceof MovingBody)
			movingBodies.add((MovingBody) body);
	}
	
	public void remove(PhysicsBody body) {
		bodies.remove(body);
		
		if(body instanceof MovingBody)
			movingBodies.remove((MovingBody) body);
	}
	
	public void simulate(float delta) {
		for(MovingBody moving : movingBodies) {
			moving.update(delta);
			
			MutableVector3f newVelocty = new MutableVector3f();
			for(Vector3f force : moving.getAllforce()) {
				moving.setVelocity(force);
				
				IntersectionResult intersection = findClosestIntersection(moving);
				moving.setIntersection(intersection);
				
				if(intersection == null) {
					newVelocty.add(force);
					continue;
				}
				
				Vector3f position = moving.getPosition().transform(intersection.getResultSpace()); //new Vector3f(); //intersection.getIntersected().getPosition();//.transform(moving.getInverseTransform()).multiply(-1);
				Vector3f velocity = MatrixUtil.rotateScale(intersection.getResultSpace(), moving.getVelocity());
				
				PlaneResponse response = new PlaneResponse(intersection, position, velocity);
				response.process();
				
				Vector3f modifiedVel = MatrixUtil.rotateScale(intersection.getInverseResultSpace(), response.getNewVelocity());
				modifiedVel = modifiedVel.divide(0.0001f).truncate().multiply(0.0001f);
				newVelocty.add(modifiedVel);
			}
			
			moving.setVelocity(newVelocty.lock());
			
			IntersectionResult intersection = findClosestIntersection(moving);
			moving.setIntersection(intersection);
			
			if(intersection == null) {
				moving.setPosition(moving.getPosition().add(moving.getVelocity()));
				
			} else {
				Vector3f position = moving.getPosition().transform(intersection.getResultSpace()); //new Vector3f(); //intersection.getIntersected().getPosition();//.transform(moving.getInverseTransform()).multiply(-1);
				Vector3f velocity = MatrixUtil.rotateScale(intersection.getResultSpace(), moving.getVelocity());
				
				PlaneResponse response = new PlaneResponse(intersection, position, velocity);
				response.process();
				
				moving.setPosition(response.getNewPosition().transform(intersection.getInverseResultSpace()));
				moving.setVelocity(MatrixUtil.rotateScale(intersection.getInverseResultSpace(), response.getNewVelocity()));
			}
			
			moving.getAllforce().clear();
		}
	}

	private IntersectionResult findClosestIntersection(MovingBody moving) {
		IntersectionResult result = null;
		
		for(PhysicsBody body : bodies) {
			if(body == moving) continue;
			
			MovingIntersectionTest<? extends CollisionBody, ? extends CollisionBody> intersectionTest = null;
			CollisionBody movingCollider = null, physicsCollider = null;
			
			intersectionTestSearch:
			for(CollisionBody mBody : moving.getBodies()) {
				HashMap<Class<? extends CollisionBody>, MovingIntersectionTest<?,?>> tests = movingTests.get(mBody.getClass());
				if(tests == null || tests.isEmpty()) continue;
				
				for(CollisionBody pBody : body.getBodies()) {
					if((intersectionTest = tests.get(pBody.getClass())) != null) {
						movingCollider = mBody;
						physicsCollider = pBody;
						
						break intersectionTestSearch;
					}
				}
			}
			
			if(intersectionTest == null) {
				System.err.println("Cannot find registered Collider for " + moving + " and " + body);
				continue;
			}
			
			IntersectionResult intersection = intersectionTest.intersect(moving, movingCollider, body, physicsCollider);
			if(intersection == null) continue;
			if(result == null || intersection.getDistance() < result.getDistance())
				result = intersection;
		}
		
		return result;
	}
}
