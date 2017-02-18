package com.GameName.PhysicsEngine.Detection;

import java.util.ArrayList;
import java.util.HashSet;

import com.GameName.PhysicsEngine.Detection.Colliders.AABB;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionSphere;
import com.GameName.Util.Vectors.Vector3f;

public class Octree<T extends Triangle> {
	private static final int NODE_LIMIT = 10;
	private static final float MIN_SIZE = 0.2f;
	
	private Node<T> root;
	
	public Octree(AABB bounds, ArrayList<T> elements) {
		root = new Node<>(bounds, elements);
		root.removeParentChildDuplicuts(null);
	}
	
	public HashSet<T> collect(CollisionSphere sphere, Vector3f treeCenter) {
		return collect(sphere, treeCenter, root, new HashSet<>());
	}
	
	private HashSet<T> collect(CollisionSphere sphere, Vector3f treeCenter, Node<T> root, HashSet<T> results) {
		if(sphere.intersectsOctree(root.bounds, treeCenter)) {
			results.addAll(root.elements);
			
			if(!root.hasSubsets) return results;
			
			for(Node<T> child : root.subsets) {
				if(child == null) continue;
				collect(sphere, treeCenter, child, results);
			}
		}
		
		return results;
	}
	
	public Node<T> getRoot() { return root; }
	
	public static class Node<T extends Triangle> {
		private Node<T>[] subsets;
		private AABB bounds;
		
		private ArrayList<T> elements;
		private boolean hasSubsets;
		
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
			for(AABB aabb : Node.subdivide(bounds)) {
				ArrayList<T> subContained = new ArrayList<>();
				
				for(T element : elements) {
					if(aabb.contains(element)) {
						subContained.add(element);
					}
				}
				
				if(subContained.size() != elements.size()) {
					subsets[index] = new Node<>(aabb, subContained);
					this.hasSubsets = true;
				}
				
				index ++;
			}
		}
		
		private void removeParentChildDuplicuts(Node<T> parent) {
			if(parent != null)
				parent.elements.removeAll(elements);
				
			for(Node<T> child : subsets) {
				if(child == null) continue;
				child.removeParentChildDuplicuts(this);
			}
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
	
		public AABB getBounds() { return bounds; }
		public Node<T>[] getSubsections() { return subsets; }
	}
}
