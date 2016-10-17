package com.GameName.PhysicsEngine.Detection;

import java.util.ArrayList;
import java.util.HashSet;

import com.GameName.PhysicsEngine.MathContext.SpatialContext;
import com.GameName.Util.Vectors.Vector3f;

public class CollisionMesh extends CollisionBody {
	private Octree<Triangle> octree;
	private SpatialContext context;
	
	protected CollisionMesh(AABB bounds, ArrayList<Triangle> faces) {
		octree = new Octree<>(bounds, faces);
		context = new SpatialContext(null, position, null);
		
		for(Triangle tri : faces)
			tri.setContext(context);
	}

	public HashSet<Triangle> collect(CollisionEllipse ellipse) { 
		return octree.collect(ellipse, super.position);
	}

	public Octree<Triangle> getOctree() { return octree; }
	public SpatialContext getSpatialContext() { return context; }
	
	public void setPosition(Vector3f position) { 
		super.setPosition(position);
		context.setOrigin(context.scale(position));
	}
}
