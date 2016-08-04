package com.GameName.RenderEngine.Instancing.Testing;

import com.GameName.RenderEngine.Instancing.IRenderableInstance;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;

public class TestInstanceRender implements IRenderableInstance<TestInstanceRenderProperties> {
	
	public static final int MAX_RENDER_COUNT = 1000;
	public static final int INSTANCE_DATA_LENGTH = 3;//16;
	
	private Shader shader;
	private ModelData modelData;
	private Renderer<TestInstanceRender, TestInstanceRenderProperties> renderer;

	@SuppressWarnings("unchecked")
	public TestInstanceRender(Shader shader, ModelData modelData) {
		this.shader = shader;
		this.modelData = modelData;
		this.renderer = (Renderer<TestInstanceRender, TestInstanceRenderProperties>) shader.getRenderer();
	}
	
	public void addInstanceAttributes(InstanceVBO vbo) {
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_0, 4, INSTANCE_DATA_LENGTH, 0, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_1, 4, INSTANCE_DATA_LENGTH, 4, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_2, 4, INSTANCE_DATA_LENGTH, 8, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_3, 4, INSTANCE_DATA_LENGTH, 12, 1);
		
		vbo.nextAttribute(modelData.getVAOId(), TestInstanceShader.ATTRIBUTE_LOC_OFFSET, 3, 1);
	}
	
	public void render(TestInstanceRenderProperties properties, Camera camera) {
		renderer.addModel(this, properties, camera);
	}
	
	public Shader getShader() { return shader; }
	public ModelData getModelData() { return modelData; }

	public int getInstanceLength() { return INSTANCE_DATA_LENGTH; }
	public int getInstanceCount() { return MAX_RENDER_COUNT; }

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((renderer == null) ? 0 : renderer.hashCode());
		result = prime * result + ((shader == null) ? 0 : shader.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof TestInstanceRender)) return false;
		
		TestInstanceRender other = (TestInstanceRender) obj;
		if(renderer == null) {
			if(other.renderer != null) return false;
		} else if(!renderer.equals(other.renderer)) return false;
		
		if(shader == null) {
			if(other.shader != null) return false;
		} else if(!shader.equals(other.shader)) return false;
		
		return true;
	}
}
