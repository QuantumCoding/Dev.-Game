package com.GameName.RenderEngine.Instancing;

import com.GameName.RenderEngine.Util.IRenderable;
import com.GameName.RenderEngine.Util.RenderProperties;

public interface IRenderableInstance<T extends RenderProperties> extends IRenderable<T> {
	public int getInstanceLength();
	public int getInstanceCount();
	
	public void addInstanceAttributes(InstanceVBO vbo);
}
