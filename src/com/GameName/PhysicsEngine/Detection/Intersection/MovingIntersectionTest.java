package com.GameName.PhysicsEngine.Detection.Intersection;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionBody;

public interface MovingIntersectionTest<S extends CollisionBody, T extends CollisionBody> {
	public IntersectionResult intersects(MovingBody bodyA, S colliderA, PhysicsBody bodyB, T colliderB);
	
	@SuppressWarnings("unchecked")
	public default IntersectionResult intersect(MovingBody bodyA, CollisionBody colliderA, PhysicsBody bodyB, CollisionBody colliderB) {
		IntersectionResult result = intersects(bodyA, (S) colliderA, bodyB, (T) colliderB);
		
		if(result != null) {
			result.setSource(bodyA);
			result.setIntersected(bodyB);
		}
			
		return result;
	}
	
	public Class<S> getMovingBodyType();
	public Class<T> getOtherBodyType();
}
