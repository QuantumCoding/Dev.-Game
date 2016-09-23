package com.GameName.PhysicsEngine.Detection;

import com.GameName.Util.Vectors.Vector3f;

public abstract class CollisionBody {
	protected Vector3f position;
	
	public CollisionBody() { this(new Vector3f()); }
	public CollisionBody(Vector3f position) {
		this.position = position;
	}
	
	public Vector3f getPostion() { return position; }
	public void setPosition(Vector3f position) { this.position = position; }
}
