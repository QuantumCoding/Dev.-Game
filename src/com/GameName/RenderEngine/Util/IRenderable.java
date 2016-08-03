package com.GameName.RenderEngine.Util;

import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Shader;

public interface IRenderable<T extends RenderProperties> {
	public void render(T properties, Camera camera);
	
	public Shader getShader();
	public ModelData getModelData();

	public boolean equals(Object other);
	public int hashCode();
}
