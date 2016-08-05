package com.GameName.RenderEngine.Instancing.Testing;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;

public class TestInstanceRenderProperties extends RenderProperties {
	
	private Vector3f color;
	
	public TestInstanceRenderProperties(Transform transform, Vector3f color) {
		super(transform);
		this.color = color;
	}
	
	public Vector3f getColor() { return color; }
	
	public RenderProperties clone() {
		return new TestInstanceRenderProperties(getTransform().clone(), color.clone());
	}
}
