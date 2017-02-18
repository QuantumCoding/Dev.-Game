package com.GameName.PhysicsEngine.Render.Sphere;

import java.util.ArrayList;
import java.util.HashMap;

import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.Vector3f;

public class SphereRender extends Model {

	public SphereRender(CollisionEllipse ellipse, int resolution) {
		super(null);
		
		modelData = new ModelData(ellipse.getRadius().max(), 1000, new Vector3f());
		
		HashMap<Vector3f, Integer> map = new HashMap<>();
		ArrayList<Vector3f> vertices = new ArrayList<>();
		ArrayList<Integer> indices = new ArrayList<>();
		
		int inc_s = Math.max(1, 180 / resolution);
		int inc_t = Math.max(1, 360 / resolution);
		
		for(int s = 0; s < 180; s += inc_s) {
		for(int t = 0; t < 360; t += inc_t) {
			Vector3f pos = getPoint(s, t, ellipse.getRadius(), resolution);
			Vector3f pos_last = getPoint(s - inc_s, t, ellipse.getRadius(), resolution);
			Vector3f pos_across = getPoint(s - inc_s, t - inc_t, ellipse.getRadius(), resolution);
			Vector3f pos_next = getPoint(s, t + inc_t, ellipse.getRadius(), resolution);
			
			addPoint(pos, map, vertices, indices);
			addPoint(pos_last, map, vertices, indices);
			addPoint(pos_across, map, vertices, indices);

			addPoint(pos, map, vertices, indices);
			addPoint(pos_last, map, vertices, indices);
			addPoint(pos_next, map, vertices, indices);
		}}
		
		float[] data = new float[vertices.size() * 3];
		for(int i = 0; i < vertices.size(); i ++) {
			Vector3f pos = vertices.get(i);
			
			data[i * 3 + 0] = pos.getX();
			data[i * 3 + 1] = pos.getY();
			data[i * 3 + 2] = pos.getZ();
		}
		
		int[] ind = new int[indices.size()];
		for(int i = 0; i < indices.size(); i ++)
			ind[i] = indices.get(i).intValue();
		
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, data, false);
		modelData.loadIndicies(ind);
	}
	
	private void addPoint(Vector3f pos, HashMap<Vector3f, Integer> map, ArrayList<Vector3f> v, ArrayList<Integer> i) {
		if(!map.containsKey(pos)) {
			map.put(pos, v.size());
			v.add(pos);
		}
		
		i.add(map.get(pos));
	}
	
	private Vector3f getPoint(float s, float t, Vector3f radius, int resolution) {
		float sin_s = (float) Math.sin(Math.toRadians(s));
		float sin_t = (float) Math.sin(Math.toRadians(t));
		float cos_s = (float) Math.cos(Math.toRadians(s));
		float cos_t = (float) Math.cos(Math.toRadians(t));
		
		return new Vector3f(
					cos_s * sin_t * radius.getX(),
					sin_s * sin_t * radius.getY(),
					        cos_t * radius.getZ()
				);
	}
}