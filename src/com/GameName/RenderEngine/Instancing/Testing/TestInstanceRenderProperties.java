package com.GameName.RenderEngine.Instancing.Testing;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.Util.Vectors.Vector3f;

public class TestInstanceRenderProperties extends RenderProperties {
	private Vector3f offset;
	
	public TestInstanceRenderProperties(Vector3f offset) { 
		super(null);
		
		this.offset = offset;
	}
	
	public Vector3f getOffset() { return offset; } 
	
	public RenderProperties clone() {
		return new TestInstanceRenderProperties(offset);
	}
}
