package com.GameName.RenderEngine.Instancing.Testing;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.GameName.RenderEngine.Instancing.IRenderableInstance;
import com.GameName.RenderEngine.Instancing.InstanceUtil;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class TestInstanceRender implements IRenderableInstance<TestInstanceRenderProperties> {
	
	public static Texture2D TEXTURE;
	
	private static final float[] VERTICES = {
		-.1f,  .1f,	-.1f, -.1f,
		 .1f, -.1f,	 .1f,  .1f,
	};
	
//	private static final float[] VERTICES = {
//		-0.1f,  0.1f,	-0.1f, -0.1f,
//		 0.1f, -0.1f,	 0.1f,  0.1f,
//	};
	
	private static final int[] INDICES = {
		0, 1, 2,	0, 2, 3 
	};
		
	private static final ModelData modelData;
	
	static {
		try {
			TEXTURE = new Texture2D(ImageIO.read(new File("res/textures/cubes/MapingSheet.png")));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		modelData = new ModelData(10, 1000, new Vector3f());
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 2, VERTICES, false);
		modelData.loadIndicies(INDICES);
	}
	
	public static final int MAX_RENDER_COUNT = 1;
	public static final int INSTANCE_DATA_LENGTH = 32;//16;
	
	private Shader shader;
	private Renderer<TestInstanceRender, TestInstanceRenderProperties> renderer;

	@SuppressWarnings("unchecked")
	public TestInstanceRender(Shader shader) {
		this.shader = shader;
		this.renderer = (Renderer<TestInstanceRender, TestInstanceRenderProperties>) shader.getRenderer();
	}
	
	public void addInstanceAttributes(InstanceVBO vbo) {
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_0, 4, INSTANCE_DATA_LENGTH, 0, 1);
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_1, 4, INSTANCE_DATA_LENGTH, 4, 1);
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_2, 4, INSTANCE_DATA_LENGTH, 8, 1);
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_3, 4, INSTANCE_DATA_LENGTH, 12, 1);
		
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_4, 4, INSTANCE_DATA_LENGTH, 16, 1);
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_5, 4, INSTANCE_DATA_LENGTH, 20, 1);
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_6, 4, INSTANCE_DATA_LENGTH, 24, 1);
		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_7, 4, INSTANCE_DATA_LENGTH, 28, 1);
		
//		vbo.nextAttribute(modelData.getVAOId(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_0, 4, 1);
//		vbo.nextAttribute(modelData.getVAOId(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_1, 4, 1);
//		vbo.nextAttribute(modelData.getVAOId(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_2, 4, 1);
//		vbo.nextAttribute(modelData.getVAOId(), TestInstanceShader.ATTRIBUTE_LOC_MATRIX_3, 4, 1);
		
//		vbo.nextAttribute(modelData.getVAOId(), TestInstanceShader.ATTRIBUTE_LOC_COLOR, 3, 1);
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
