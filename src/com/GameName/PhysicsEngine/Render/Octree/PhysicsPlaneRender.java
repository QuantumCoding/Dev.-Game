package com.GameName.PhysicsEngine.Render.Octree;

import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsPlaneRender extends Model {

	public PhysicsPlaneRender(Vector3f p0, Vector3f p1, Vector3f p2) {
		super(null);
		
		modelData = new ModelData(1000, 1000, new Vector3f());
		
		float[] data = new float[] {
			p0.x, p0.y, p0.z,
			p1.x, p1.y, p1.z,
			p2.x, p2.y, p2.z,
		};
		
		int[] ind = new int[] { 0, 1, 2 };
		
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, data, false);
		modelData.loadIndicies(ind);
	}
}
