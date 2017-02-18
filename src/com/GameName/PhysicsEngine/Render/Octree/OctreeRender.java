package com.GameName.PhysicsEngine.Render.Octree;

import java.util.ArrayList;
import java.util.HashMap;

import com.GameName.PhysicsEngine.Detection.Octree;
import com.GameName.PhysicsEngine.Detection.Colliders.AABB;
import com.GameName.PhysicsEngine.Detection.Octree.Node;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.Vector3f;

public class OctreeRender extends Model {

	public OctreeRender(Octree<?> octree) {
		super(null);
		
		modelData = new ModelData(octree.getRoot().getBounds().getRadius().max(), 1000, new Vector3f());
		
		HashMap<Vector3f, Integer> map = new HashMap<>();
		ArrayList<Vector3f> vertices = new ArrayList<>();
		ArrayList<Integer> indices = new ArrayList<>();
		
		addNode(octree.getRoot(), map, vertices, indices);
		
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
	
	private void addNode(Node<?> node, HashMap<Vector3f, Integer> map, ArrayList<Vector3f> v, ArrayList<Integer> i) {
		addAABB(node.getBounds(), map, v, i);
		for(Node<?> child : node.getSubsections()) {
			if(child == null) continue;
			addNode(child, map, v, i);
		}
	}
	
	private void addAABB(AABB aabb, HashMap<Vector3f, Integer> map, ArrayList<Vector3f> v, ArrayList<Integer> i) {
		Vector3f r = aabb.getRadius();
		Vector3f c = aabb.getCenter();
		
		Vector3f nnn = c.add(-r.x, -r.y, -r.z);
		Vector3f nnp = c.add(-r.x, -r.y,  r.z);
		Vector3f pnp = c.add( r.x, -r.y,  r.z);
		Vector3f pnn = c.add( r.x, -r.y, -r.z);
		
		Vector3f npn = c.add(-r.x,  r.y, -r.z);
		Vector3f npp = c.add(-r.x,  r.y,  r.z);
		Vector3f ppp = c.add( r.x,  r.y,  r.z);
		Vector3f ppn = c.add( r.x,  r.y, -r.z);
		
		addQuad(nnn, nnp, npp, npn, map, v, i);
		addQuad(pnn, pnp, ppp, ppn, map, v, i);
		
		addQuad(nnn, pnn, ppn, npn, map, v, i);
		addQuad(nnp, pnp, ppp, npp, map, v, i);

		addQuad(nnn, pnn, pnp, nnp, map, v, i);
		addQuad(npn, ppn, ppp, npp, map, v, i);
	}
	
	private void addQuad(Vector3f a, Vector3f b, Vector3f c, Vector3f d, HashMap<Vector3f, Integer> map, ArrayList<Vector3f> v, ArrayList<Integer> i) {
		addPoint(a, map, v, i); addPoint(b, map, v, i);
		addPoint(b, map, v, i); addPoint(c, map, v, i);
		addPoint(c, map, v, i); addPoint(d, map, v, i);
		addPoint(d, map, v, i); addPoint(a, map, v, i);
	}
	
	private void addPoint(Vector3f pos, HashMap<Vector3f, Integer> map, ArrayList<Vector3f> v, ArrayList<Integer> i) {
		if(!map.containsKey(pos)) {
			map.put(pos, v.size());
			v.add(pos);
		}
		
		i.add(map.get(pos));
	}
}