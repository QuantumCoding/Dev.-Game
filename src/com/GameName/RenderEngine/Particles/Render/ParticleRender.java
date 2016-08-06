package com.GameName.RenderEngine.Particles.Render;

import com.GameName.RenderEngine.Instancing.IRenderableInstance;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleRender implements IRenderableInstance<ParticleRenderProperties> {
	
	private static final float[] VERTICES = {
		-0.5f,  0.5f,	-0.5f, -0.5f,
		 0.5f, -0.5f,	 0.5f,  0.5f,
	};
	
	private static final float[] TEX_COORDS = {
		0.0f, 0.0f,		0.0f, 1.0f,
		1.0f, 1.0f,		1.0f, 0.0f,
	};
	
	private static final int[] INDICES = {
		0, 1, 2,	0, 2, 3 
	};
		
	private static final ModelData modelData;
	
	static {
		modelData = new ModelData(10, 1000, new Vector3f());
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 2, VERTICES, false);
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_TEXCOORDS, 2, TEX_COORDS, false);
		modelData.loadIndicies(INDICES);
	}
	
	public static final int MAX_PARTICLE_COUNT = 100;
	public static final int INSTANCE_DATA_LENGTH = 22;
	
	private Shader shader;
	private Renderer<ParticleRender, ParticleRenderProperties> renderer;

	private boolean additiveBlending;

	@SuppressWarnings("unchecked")
	public ParticleRender(Shader shader, boolean additiveBlending) {
		this.shader = shader;
		this.renderer = (Renderer<ParticleRender, ParticleRenderProperties>) shader.getRenderer();
		this.additiveBlending = additiveBlending;
	}
	
	public void addInstanceAttributes(InstanceVBO vbo) {
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 2, 4, INSTANCE_DATA_LENGTH, 0, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 3, 4, INSTANCE_DATA_LENGTH, 4, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 4, 4, INSTANCE_DATA_LENGTH, 8, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 5, 4, INSTANCE_DATA_LENGTH, 12, 1);
//		
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 6, 4, INSTANCE_DATA_LENGTH, 16, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 7, 1, INSTANCE_DATA_LENGTH, 20, 1);
//		InstanceUtil.addInstanceAttribute(modelData.getVAOId(), vbo.getVBO(), 8, 1, INSTANCE_DATA_LENGTH, 21, 1);

		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_OFFSET, 4, 1);
		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_TEX_COORD_SCALE, 1, 1);
		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_BLEND_VALUE, 1, 1);
		
		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_MODLE_VIEW_MAT + 0, 4, 1);
		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_MODLE_VIEW_MAT + 1, 4, 1);
		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_MODLE_VIEW_MAT + 2, 4, 1);
		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_MODLE_VIEW_MAT + 3, 4, 1);
		

//		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_OFFSET, 4, 1);
//		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_TEX_COORD_SCALE, 1, 1);
//		vbo.nextAttribute(modelData.getVAOId(), ParticleShader.ATTRIBUTE_LOC_BLEND_VALUE, 1, 1);
	}
	
	public void render(ParticleRenderProperties properties, Camera camera) {
		renderer.addModel(this, properties, camera);
	}
	
	public Shader getShader() { return shader; }
	public ModelData getModelData() { return modelData; }

	public int getInstanceLength() { return INSTANCE_DATA_LENGTH; }
	public int getInstanceCount() { return MAX_PARTICLE_COUNT; }

	public boolean usingAdditive() { return additiveBlending; }
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (additiveBlending ? 1231 : 1237);
		result = prime * result + ((renderer == null) ? 0 : renderer.hashCode());
		result = prime * result + ((shader == null) ? 0 : shader.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof ParticleRender)) return false;
		
		ParticleRender other = (ParticleRender) obj;
		if(renderer == null) {
			if(other.renderer != null) return false;
		} else if(!renderer.equals(other.renderer)) return false;
		
		if(shader == null) {
			if(other.shader != null) return false;
		} else if(!shader.equals(other.shader)) return false;

		if(other.additiveBlending != additiveBlending)  return false;
		
		return true;
	}
}