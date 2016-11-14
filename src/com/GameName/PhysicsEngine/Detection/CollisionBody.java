package com.GameName.PhysicsEngine.Detection;

import com.GameName.Util.Vectors.Vector3f;

public abstract class CollisionBody {
	protected Vector3f position;
	protected Vector3f rotation;
	
	public CollisionBody() { this(new Vector3f()); }
	public CollisionBody(Vector3f posistion) { this(posistion, new Vector3f()); }
	public CollisionBody(Vector3f position, Vector3f rotation) {
		this.position = position;
		this.rotation = rotation;
	}
	
	public Vector3f getPosition() { return position; }
	public void setPosition(Vector3f position) { this.position = position; }

	public Vector3f getRotation() { return rotation; }
	public void setRotation(Vector3f rotation) { this.rotation = rotation; }
}
