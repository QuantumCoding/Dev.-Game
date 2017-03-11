package com.GameName.PhysicsEngine.Detection.Colliders;

import com.GameName.Util.Vectors.Vector3f;

public abstract class CollisionBody {
	/**
	 *   Internal Variables used to pass addition information through the Physics Engine <BR>
	 *   Do not assume that the value will reflect that of its accompanied 
	 *   	{@link com.GameName.PhysicsEngine.Bodies.PhysicsBody PhysicsBody}
	 */
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
