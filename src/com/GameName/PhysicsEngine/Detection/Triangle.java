package com.GameName.PhysicsEngine.Detection;

import com.GameName.Util.Vectors.Vector3f;

public class Triangle {
	private Vector3f A, B, C; // Points
	
	private Vector3f normal;
	private float D;
	
	public Triangle(Vector3f a, Vector3f b, Vector3f c) {
		A = a;	B = b;	C = c;
		
		Vector3f AB = B.subtract(A);
		Vector3f AC = C.subtract(A);
		
		normal = AB.crossProduct(AC);
		D = -normal.dot(A);
	}	
	
	public Triangle changeSpace(Vector3f divisor) {
		return new Triangle(A.divide(divisor), B.divide(divisor), C.divide(divisor));
	}
	
	public float signedDistance(Vector3f point) {
		return normal.dot(point) + D;
	}
	
	public boolean containsPoint(Vector3f P) {
		Vector3f AB = B.subtract(A);
		Vector3f AC = C.subtract(A);
		Vector3f BC = C.subtract(B);
		
		Vector3f AP = P.subtract(A);
		Vector3f BP = P.subtract(B);
		
		float AB_side = AP.x * AB.y - AP.y * AB.x;
		float AC_side = AP.x * AC.y - AP.y * AC.x;
		float BC_side = BP.x * BC.y - BP.y * BC.x;
		
		return Math.signum(AB_side) == Math.signum(AC_side) && Math.signum(AB_side) == Math.signum(BC_side);
	}

	public Vector3f getA() { return A; }
	public Vector3f getB() { return B; }
	public Vector3f getC() { return C; }

	public Vector3f getNormal() { return normal; }
	public float getD() { return D; }

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
