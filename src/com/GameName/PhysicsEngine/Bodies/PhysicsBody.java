package com.GameName.PhysicsEngine.Bodies;

import com.GameName.PhysicsEngine.Detection.CollisionMesh;
import com.GameName.Util.Vectors.Vector3f;

public abstract class PhysicsBody {
	protected Vector3f position;
	
	protected CollisionMesh mesh;
	
	public PhysicsBody() {
		position = new Vector3f();
	}
	
	public CollisionMesh getMesh() { return mesh; }
	protected void setMesh(CollisionMesh mesh) { this.mesh = mesh; }
	
	public Vector3f getPosition() { return position; }
}