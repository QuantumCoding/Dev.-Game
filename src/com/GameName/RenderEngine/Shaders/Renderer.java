package com.GameName.RenderEngine.Shaders;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.IRenderable;
import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Plane;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector3f;

public abstract class Renderer<T extends IRenderable<? super E>, E extends RenderProperties> {
	protected Shader shader;
	protected HashMap<T, ArrayList<E>> renders;
	private boolean renderBehind;
	
	public Renderer(Shader shader) {
		this.shader = shader;
		renders = new HashMap<>();
	}
	
	public boolean addModel(T model, E property, Camera camera) {
		if(!isAcceptedShader(model.getShader())) 
			throw new IllegalArgumentException("Models shader is not excepted by the " + this.getClass());
		
		if(!renderBehind) {
			Vector3f vertex = model.getModelData().getCenter();
			float radius = model.getModelData().getRadius();
			
			Vector4f rawPosition = new Vector4f(vertex.x, vertex.y, vertex.z, 1);
			Matrix4f transformationMatrix = Matrix4f.mul(Shader.getProjectionMatrix(), 
					Matrix4f.mul(MatrixUtil.initViewMatrix(camera), property.getTransformMatrix(), null), null);
			Matrix4f.transform(transformationMatrix, rawPosition, rawPosition);
			Vector3f position = new Vector3f(rawPosition.x, rawPosition.y, rawPosition.z);

			if(position.z + radius < camera.getZNear()) return false; // Z Near
			if(position.z - radius > camera.getZFar())  return false; // Z Far
			
			for(Plane plane : camera.getProjectionMatrixFaces()) {
				if(plane.getDistance(position) - radius > 0)
					return false;
			} 
			
		}
		
		if(!renders.containsKey(model)) {
			renders.put(model, new ArrayList<E>());
		}
		
		renders.get(model).add(property);
		return true;
	}
	
	public void render() {
		prepareOpenGL();
		renderModels();	
		revertOpenGL();
		
		renders.clear();
	}

	protected void prepareOpenGL() {}
	protected void revertOpenGL() {}
	
	public abstract void renderModels();	
	public abstract boolean isAcceptedShader(Shader shader);
	public abstract int getRenderStage();
	
	public Shader getShader() {
		return shader;
	}
	
	public void setRenderBehind(boolean renderBehind) {
		this.renderBehind = renderBehind;
	}
}
