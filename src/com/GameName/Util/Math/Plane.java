package com.GameName.Util.Math;

import com.GameName.Util.Vectors.Vector3f;

public class Plane {
	private Vector3f normal;
	private float D;
	private Vector3f Q;
	
	public Plane(Vector3f a, Vector3f b, Vector3f c) {
		Vector3f AB = b.subtract(a);
		Vector3f AC = c.subtract(a);
		
		normal = AB.crossProduct(AC).normalize();
		D = -normal.dot(a);
		Q = new Vector3f(0, 0, D / normal.z);
	}		
	
	public Plane(Vector3f Q, Vector3f normal) {
		this.Q = Q;
		this.normal = normal;
		
		D = -normal.dot(Q);
	}
	
	public float getDistance(Vector3f point) {
		Vector3f PQ = Q.subtract(point);
		return PQ.dot(normal);
	}
	
	public float signedDistance(Vector3f point) {
		return normal.dot(point) + D;
	}

	public Vector3f getNormal() { return normal; }
	public float getD() { return D; }
	public Vector3f getQ() { return Q; }
}
