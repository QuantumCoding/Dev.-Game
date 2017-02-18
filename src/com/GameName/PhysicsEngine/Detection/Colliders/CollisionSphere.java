package com.GameName.PhysicsEngine.Detection.Colliders;

import com.GameName.Util.Vectors.Vector3f;

public class CollisionSphere extends CollisionBody {
	private float radius, sqRadius;
	
	public CollisionSphere(float radius) { this(radius, new Vector3f()); }
	
	public CollisionSphere(float radius, Vector3f position) {
		super(position);
		
		this.radius = radius;
		this.sqRadius = radius * radius;
	}
	
	public boolean intersectsOctree(AABB aabb, Vector3f treeCenter) {
		Vector3f position = super.position.subtract(treeCenter).subtract(aabb.getCenter());
		Vector3f aabbRadius = aabb.getRadius();
		
		Vector3f lower = aabbRadius.multiply(-1);
		Vector3f upper = aabbRadius;
		
		float dist_squared = sqRadius;
		
		if(position.x < lower.x) dist_squared -= Math.pow(position.x - lower.x, 2);
		else if(position.x > upper.x) dist_squared -= Math.pow(position.x - upper.x, 2);
		
		if(position.y < lower.y) dist_squared -= Math.pow(position.y - lower.y, 2);
		else if(position.y > upper.y) dist_squared -= Math.pow(position.y - upper.y, 2);
		
		if(position.z < lower.z) dist_squared -= Math.pow(position.z - lower.z, 2);
		else if(position.z > upper.z) dist_squared -= Math.pow(position.z - upper.z, 2);
		
		return dist_squared > 0;
	}
	
	public float getRadius() { return radius; }
	public void setRadius(float radius) { this.radius = radius; }
}
