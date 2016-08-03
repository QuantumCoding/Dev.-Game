package com.GameName.World.Render;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;

public class WorldRenderProperties extends RenderProperties {
	
	public WorldRenderProperties() { super(); }
	
	public WorldRenderProperties(Transform transform) {
		super(transform);
	}
	
	public RenderProperties clone() {
		return new WorldRenderProperties(getTransform().clone());
	}
}
