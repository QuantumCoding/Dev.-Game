package com.GameName.PhysicsEngine.Bodies;

import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMesh;
import com.GameName.Util.Vectors.Vector3f;

public class StaticBody extends PhysicsBody {
	public StaticBody(CollisionMesh mesh) {
		setMesh(mesh);
	}
	
	public void setPosition(Vector3f position) {
		super.position = position;
		super.mesh.setPosition(position);
	}
	
	public void setRotation(Vector3f rotation) {
		super.rotation = rotation;
		super.mesh.setRotation(rotation);
	}
}
