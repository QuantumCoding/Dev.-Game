package com.GameName.PhysicsEngine.Detection.Intersection;

import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionBody;

public interface IntersectionTest<S extends CollisionBody, T extends CollisionBody> {
	public boolean intersects(PhysicsBody bodyA, S colliderA, PhysicsBody bodyB, T colliderB);
}
