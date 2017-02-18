package com.GameName.PhysicsEngine.Detection.Colliders;

import java.util.ArrayList;
import java.util.HashSet;

import com.GameName.PhysicsEngine.Detection.Octree;
import com.GameName.PhysicsEngine.Detection.Triangle;

public class CollisionMesh extends CollisionBody {
	private Octree<Triangle> octree;
	
	protected CollisionMesh(AABB bounds, ArrayList<Triangle> faces) {
		octree = new Octree<>(bounds, faces);
	}

	public HashSet<Triangle> collect(CollisionSphere sphere) { 
		return octree.collect(sphere, super.position);
	}

	public Octree<Triangle> getOctree() { return octree; }
}
