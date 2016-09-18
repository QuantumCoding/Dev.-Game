package com.GameName.RenderEngine.Particles.Render;

import com.GameName.RenderEngine.Instancing.IRenderableInstance;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleInstanceRender implements IRenderableInstance<ParticleRenderProperties> {

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
	
	private static final ModelData PARTICLE_MODEL_DATA; static {
		PARTICLE_MODEL_DATA = new ModelData(1, 1000, new Vector3f());
		
		PARTICLE_MODEL_DATA.storeDataInAttributeList(ParticleShader.ATTRIBUTE_LOC_POSITIONS, 2, VERTICES, false);
		PARTICLE_MODEL_DATA.storeDataInAttributeList(ParticleShader.ATTRIBUTE_LOC_TEXCOORDS, 2, TEX_COORDS, false);
		
		PARTICLE_MODEL_DATA.loadIndicies(INDICES);
	}
	
	public static final int MAX_PARTICLE_COUNT = 5000;
	public static final int INSTANCE_DATA_LENGTH = 22;
	
	private Shader shader;
	private Renderer<ParticleInstanceRender, ParticleRenderProperties> renderer;
	
	@SuppressWarnings("unchecked")
	public ParticleInstanceRender(Shader shader) {
		this.shader = shader;
		renderer = (Renderer<ParticleInstanceRender, ParticleRenderProperties>) shader.getRenderer();
	}
	
	public void addInstanceAttributes(InstanceVBO vbo) {
		int vao = PARTICLE_MODEL_DATA.getVAOId();
		
		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_OFFSET_1, 2, 1);
		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_OFFSET_2, 2, 1);

		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_DIVISOR, 1, 1);
		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_BLEND, 1, 1);

		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 0, 4, 1);
		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 1, 4, 1);
		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 2, 4, 1);
		vbo.nextAttribute(vao, ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 3, 4, 1);
	}
	
	public void render(ParticleRenderProperties properties, Camera camera) {
		renderer.addModel(this, properties, camera);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shader == null) ? 0 : shader.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof ParticleInstanceRender)) return false;
		
		ParticleInstanceRender other = (ParticleInstanceRender) obj;
		if(shader == null) {
			if(other.shader != null) return false;
		} else if(!shader.equals(other.shader)) return false;
		
		return true;
	}

	public Shader getShader() { return shader; }
	public ModelData getModelData() { return PARTICLE_MODEL_DATA; }
	
	public int getInstanceLength() { return INSTANCE_DATA_LENGTH; }
	public int getInstanceCount() { return MAX_PARTICLE_COUNT; }
	
	
}
