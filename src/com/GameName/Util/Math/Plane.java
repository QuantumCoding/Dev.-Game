package com.GameName.Util.Math;

import com.GameName.Util.Vectors.Vector3f;

public class Plane {
	private Vector3f A, B, C; // Points
	private Vector3f AB, AC;  // Directional Vectors
	
	private Vector3f normal;
	private float D;
	private Vector3f Q;
	
	public Plane(Vector3f a, Vector3f b, Vector3f c) {
		A = a;	B = b;	C = c;
		
		AB = B.subtract(A);
		AC = C.subtract(A);
		
		normal = AB.crossProduct(AC);
		D = -normal.dot(A);
		Q = new Vector3f(0, 0, D / normal.z);
	}		
	
	public float getDistance(Vector3f point) {
		Vector3f PQ = Q.subtract(point);
		return PQ.dot(normal) / normal.length();
	}

	public Vector3f getA() { return A; }
	public Vector3f getB() { return B; }
	public Vector3f getC() { return C; }

	public Vector3f getAB() { return AB; }
	public Vector3f getAC() { return AC; }

	public Vector3f getNormal() { return normal; }
	public float getD() { return D; }
	public Vector3f getQ() { return Q; }
}
