package com.GameName.RenderEngine.Test;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;

public class TestRenderProperties extends RenderProperties {

	public TestRenderProperties(Transform transform) {
		super(transform);
	}
	
	public RenderProperties clone() {
		return new TestRenderProperties(super.getTransform().clone());
	}
}
