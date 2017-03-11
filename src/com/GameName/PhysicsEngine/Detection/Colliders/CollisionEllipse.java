package com.GameName.PhysicsEngine.Detection.Colliders;

import com.GameName.Util.Vectors.Vector3f;

public class CollisionEllipse extends CollisionBody {
	private Vector3f radius;
	
	public CollisionEllipse(Vector3f radius) {
		this.radius = radius;
	}
	
	public void setRadius(Vector3f radius) { this.radius = radius; }
	public Vector3f getRadius() { return radius; }
}
