package com.GameName.PhysicsEngine.Detection;

import java.util.ArrayList;
import java.util.HashSet;

import com.GameName.Util.Vectors.Vector3f;

public class Octree<T extends Triangle> {
	private static final int NODE_LIMIT = 5;
	private static final float MIN_SIZE = 0.2f;
	
	private Node<T> root;
	
	public Octree(AABB bounds, ArrayList<T> elements) {
		root = new Node<>(bounds, elements);
	}
	
	public HashSet<T> collect(CollisionEllipse ellipse) {
		return collect(ellipse, root, new HashSet<>());
	}
	
	private HashSet<T> collect(CollisionEllipse ellipse, Node<T> root, HashSet<T> results) {
		if(ellipse.intersects(root.bounds)) {
			results.addAll(root.elements);
			
			for(Node<T> child : root.subsets) {
				if(child == null) continue;
				collect(ellipse, child, results);
			}
		}
		
		return results;
	}
	
	private static class Node<T extends Triangle> {
		private Node<T>[] subsets;
		private AABB bounds;
		
		private ArrayList<T> elements;
		
		public Node(AABB bounds, ArrayList<T> elements) {
			subsets = Node.makeArray(null, null, null, null, null, null, null, null);
			
			this.bounds = bounds;
			this.elements = elements;
			
			subdivide();
		}
		
		private void subdivide() {
			if(bounds.getRadius().lessThenOrEqual(MIN_SIZE)) return;
			if(elements.size() <= NODE_LIMIT) return;

			int index = 0;
			HashSet<T> toRem = new HashSet<>();
			for(AABB aabb : Node.subdivide(bounds)) {
				ArrayList<T> subContained = new ArrayList<>();
				
				for(T element : elements) {
					if(aabb.contains(element)) {
						subContained.add(element);
						toRem.add(element);
					}
				}
				
				subsets[index ++] = new Node<>(aabb, elements);
			}
			
			elements.remove(toRem);
		}
		
		private static AABB[] subdivide(AABB bounds) {
			AABB[] results = new AABB[8];
			Vector3f center = bounds.getCenter();
			Vector3f radius = bounds.getRadius();
			float x = radius.x, y = radius.y, z = radius.z;
			
			results[0] = new AABB(center.add(-x, -y, -z), center);
			results[1] = new AABB(center.add(-x, -y,  z), center);
			results[2] = new AABB(center.add( x, -y,  z), center);
			results[3] = new AABB(center.add( x, -y, -z), center);

			results[4] = new AABB(center.add(-x,  y, -z), center);
			results[5] = new AABB(center.add(-x,  y,  z), center);
			results[6] = new AABB(center.add( x,  y,  z), center);
			results[7] = new AABB(center.add( x,  y, -z), center);
			
			return results;
		}
		
		@SafeVarargs
		private static <T> T[] makeArray(T... array) { return array; }
	}
}
