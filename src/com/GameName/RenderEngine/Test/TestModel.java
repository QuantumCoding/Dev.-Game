package com.GameName.RenderEngine.Test;

import com.GameName.Registry.ResourceManager.Shaders;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.Vector3f;

public class TestModel extends Model {
	private static final float[] VERTEX_DATA = {
		0.0f, 0.0f, 0.0f,		0.0f, 0.0f, 1.0f,	
		1.0f, 0.0f, 0.5f, 		0.5f, 1.0f, 0.5f,
	};
	
	private static final int[] INDICIES = {
		0, 1, 2, 		0, 3, 2,
		3, 1, 2, 		0, 1, 3
	};
	
	public TestModel() {
		super(null);
		
		super.modelData = new ModelData(0.5f, 1000, new Vector3f(0.5f));
		super.modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, VERTEX_DATA, false);
		super.modelData.loadIndicies(INDICIES);
		
		setShader(Shaders.TestShader);
	}
}
