package com.GameName.RenderEngine.Instancing;

import java.util.HashMap;

import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderProperties;

public abstract class InstanceRenderer<T extends IRenderableInstance<? super E>, E extends RenderProperties> extends Renderer<T, E> {
	protected HashMap<T, InstanceVBO> instanceVBOs;

	public InstanceRenderer(Shader shader) {
		super(shader);
		
		instanceVBOs = new HashMap<>();
	}

	public boolean addModel(T model, E property, Camera camera) {
		if(super.addModel(model, property, camera)) {
			if(!instanceVBOs.containsKey(model)) {
				InstanceVBO vbo = new InstanceVBO(model.getInstanceLength(), model.getInstanceCount());
				model.addInstanceAttributes(vbo);
				instanceVBOs.put(model, vbo);
			}
			
			return true;
		}
		
		return false;
	}
	
	public void renderModels() {
		for(T model : renders.keySet()) {
			InstanceVBO vbo = instanceVBOs.get(model);
			
			prepInstanceVBO(vbo, model);
			vbo.prepVBO();
			
			renderInstance(vbo, model);
			vbo.reset();
		}
	}
	
	public abstract void prepInstanceVBO(InstanceVBO instanceVBO, T model); 
	public abstract void renderInstance(InstanceVBO instanceVBO, T model); 
}
