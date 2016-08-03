package com.GameName.RenderEngine.Instancing.Testing;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;

public class TestInstanceRenderProperties extends RenderProperties {
	
	public TestInstanceRenderProperties() { 
		super();
	}
	
	public TestInstanceRenderProperties(Transform transform) { 
		super(transform);
	}
	
	public RenderProperties clone() {
		return new TestInstanceRenderProperties(getTransform().clone());
	}
}
