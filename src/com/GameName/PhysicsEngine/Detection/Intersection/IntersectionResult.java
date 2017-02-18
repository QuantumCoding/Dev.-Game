package com.GameName.PhysicsEngine.Detection.Intersection;

import com.GameName.Util.Vectors.Vector3f;

public class IntersectionResult {
	private Vector3f point;
	private float distance;
	
	public IntersectionResult(Vector3f point, float distance) {
		this.point = point;
		this.distance = distance;
	}

	public Vector3f getPoint() { return point; }
	public float getDistance() { return distance; }

	public String toString() {
		return "IntersectionResult [point=" + point + ", distance=" + distance + "]";
	}
}
