package com.GameName.PhysicsEngine.Detection.Colliders;

import java.util.ArrayList;
import java.util.HashSet;

import com.GameName.PhysicsEngine.Detection.Octree;
import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.Util.Vectors.Vector3f;

public class CollisionMesh extends CollisionBody {
	private Octree<Triangle> octree;
	
	protected CollisionMesh(AABB bounds, ArrayList<Triangle> faces) {
		octree = new Octree<>(bounds, faces);
	}

	public HashSet<Triangle> collect(CollisionSphere sphere, Vector3f velocity) { 
		return octree.collect(sphere, super.position, velocity);
	}

	public Octree<Triangle> getOctree() { return octree; }
}
