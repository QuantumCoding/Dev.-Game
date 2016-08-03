package com.GameName.RenderEngine.Util;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;

public abstract class RenderProperties {
	private Transform transform;

	public RenderProperties() { 
		this(new Transform());
	}
	
	public RenderProperties(Transform transform) {
		this.transform = transform;
	}

	public void translate(Vector3f amount) { transform.translate(amount); }
	public void rotate(Vector3f amount) { transform.rotate(amount); }
	public void scale(Vector3f amount) { transform.scale(amount); }

	public void setTransform(Transform transform) {
		this.transform = transform;
	}
	
	public Transform getTransform() { return transform; }
	
	public Matrix4f getTransformMatrix() {
		return transform.getTransformMatrix();
	}

	public abstract RenderProperties clone();
}
