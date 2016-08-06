package com.GameName.RenderEngine.Particles_NonInst.Render;

import com.GameName.Registry.ResourceManager.Shaders;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleModel extends Model {
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
	
	public ParticleModel() {
		super(PARTICLE_MODEL_DATA);
		setShader(Shaders.ParticleNonShader);
	}
}
