package com.GameName.PhysicsEngine.Detection;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.Util.Vectors.Vector3f;

public class Triangle {
	private Vector3f A, B, C; // Points
	
	private Vector3f normal;
	private float D;
	
	public Triangle(Vector3f a, Vector3f b, Vector3f c) {
		A = a;	B = b;	C = c;
		
		Vector3f AB = B.subtract(A);
		Vector3f AC = C.subtract(A);
		
		normal = AB.crossProduct(AC).normalize();
		D = -normal.dot(A);
	}	
	
	public Triangle changeSpace(Matrix4f transform, Vector3f preRotation) {
		Vector3f a = A.clone(), b = B.clone(), c = C.clone();
		
		if(preRotation != null) {
			a = a.rotate(preRotation);
			b = b.rotate(preRotation);
			c = c.rotate(preRotation);
		}
		
		a = a.transform(transform);
		b = b.transform(transform);
		c = c.transform(transform);
		
		return new Triangle(a, b, c);
	}

	public float signedDistance(Vector3f point) {
		return normal.dot(point) + D;
	}
	
	public boolean containsPoint(Vector3f P) {
		Vector3f AC = C.subtract(A);
		Vector3f AB = B.subtract(A);
		Vector3f AP = P.subtract(A);
		
		float dotAC_AC = AC.dot(AC);
		float dotAC_AB = AC.dot(AB);
		float dotAC_AP = AC.dot(AP);
		float dotAB_AB = AB.dot(AB);
		float dotAB_AP = AB.dot(AP);
		
		float invDenom = 1 / (dotAC_AC * dotAB_AB - dotAC_AB * dotAC_AB);
		float u = (dotAB_AB * dotAC_AP - dotAC_AB * dotAB_AP) * invDenom;
		float v = (dotAC_AC * dotAB_AP - dotAC_AB * dotAC_AP) * invDenom;
		
		return u >= 0 && v >= 0 && u + v < 1;
	}

	public Vector3f getA() { return A; }
	public Vector3f getB() { return B; }
	public Vector3f getC() { return C; }

	public Vector3f getNormal() { return normal; }
	public float getD() { return D; }
	
	public String toString() {
		return normal.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((A == null) ? 0 : A.hashCode());
		result = prime * result + ((B == null) ? 0 : B.hashCode());
		result = prime * result + ((C == null) ? 0 : C.hashCode());
		
		result = prime * result + Float.floatToIntBits(D);
		
		result = prime * result + ((normal == null) ? 0 : normal.hashCode());
		
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Triangle)) return false;
		
		Triangle other = (Triangle) obj;
		
		if(A == null) {
			if(other.A != null) return false;
		} else if(!A.equals(other.A)) return false;
		
		if(B == null) {
			if(other.B != null) return false;
		} else if(!B.equals(other.B)) return false;
		
		if(C == null) {
			if(other.C != null) return false;
		} else if(!C.equals(other.C)) return false;
		
		if(Float.floatToIntBits(D) != Float.floatToIntBits(other.D)) return false;
		
		if(normal == null) {
			if(other.normal != null) return false;
		} else if(!normal.equals(other.normal)) return false;
		
		return true;
	}
}
