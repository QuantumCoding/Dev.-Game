package com.GameName.PhysicsEngine.Bodies;

import java.util.ArrayList;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Detection.Colliders.CollisionBody;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector3f;

public abstract class PhysicsBody {
	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	
	protected ArrayList<CollisionBody> bodies;
	
	private Matrix4f transform;
	private Matrix4f inverseTransform;
	
	public PhysicsBody() {
		position = new Vector3f();
		rotation = new Vector3f();
		scale = new Vector3f(1);
		
		bodies = new ArrayList<>();
	}
	
	public Matrix4f getTransform() {
		if(transform == null) {
			transform = MatrixUtil.initTransformationMatrix(position, rotation, scale);
			inverseTransform = null;
		}
		
		return transform;
	}
	
	public Matrix4f getInverseTransform() {
		if(inverseTransform == null || transform == null) {
			inverseTransform = Matrix4f.invert(getTransform(), null);
		}
		
		return inverseTransform;
	}
	
	public ArrayList<CollisionBody> getBodies() { return bodies; }
	public void addBody(CollisionBody body) { bodies.add(body); }
	
	public Vector3f getPosition() { return position; }
	public Vector3f getRotation() { return rotation; }
	public Vector3f getScale() { return scale; }

	protected void setPosition(Vector3f position) { this.position = position; transform = null; }
	protected void setRotation(Vector3f rotation) { this.rotation = rotation; transform = null; }
	protected void setScale(Vector3f scale) { this.scale = scale; transform = null; }
}
