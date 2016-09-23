package com.GameName.PhysicsEngine.Bodies;

import com.GameName.PhysicsEngine.Detection.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.IntersectionResult;
import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.Util.Vectors.Vector3f;

public class MovingBody extends PhysicsBody {
	private Vector3f velocity;
	private CollisionEllipse body; 
	
	private MovingBody(Vector3f radius) {
		velocity = new Vector3f();
		
		body = new CollisionEllipse(radius);
	}
	
	public IntersectionResult intersect(CollisionMesh mesh) {
		IntersectionResult result = null;
		
		for(Triangle tri : mesh.collect(body)) {
			IntersectionResult intersection = body.intersect(tri, velocity);
			if(intersection == null) continue;
			
			if(result == null || intersection.getDistance() < result.getDistance())
				result = intersection;
		}
			
		return result;
	}
}
