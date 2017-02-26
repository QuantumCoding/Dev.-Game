package com.GameName.PhysicsEngine.Detection.Colliders;

import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.Util.Vectors.Vector3f;

public class AABB extends CollisionBody {
	private static final float EPSILON = 0.0001f;
	private Vector3f radius;
	
	public AABB(Vector3f radius) {
		this.radius = radius.abs();
	}
	
	public AABB(Vector3f p1, Vector3f p2) {
		this.radius = p2.subtract(p1).divide(2).abs();
		setPosition(p1.add(p2).divide(2));
	}
	
	public boolean containsPoint(Vector3f point) {
 		return point.subtract(position).abs().lessThenOrEqual(radius);
	}

	public boolean containsLine(Vector3f p0, Vector3f p1) {
		p0 = p0.subtract(position);
		p1 = p1.subtract(position);
		
		Vector3f direction = p1.subtract(p0).divide(2);
		Vector3f rayCenter = p0.add(direction);
		Vector3f absDirect = direction.abs();
		
		if(rayCenter.abs().anyGreaterThen(radius))
			return false;
		
		if(Math.abs(direction.y * rayCenter.z - direction.z * rayCenter.y) > radius.y * absDirect.z + radius.z * absDirect.y + EPSILON)
			return false;
		
		if(Math.abs(direction.z * rayCenter.x - direction.x * rayCenter.z) > radius.z * absDirect.x + radius.x * absDirect.z + EPSILON)
			return false;

		if(Math.abs(direction.x * rayCenter.y - direction.y * rayCenter.x) > radius.x * absDirect.y + radius.y * absDirect.x + EPSILON)
			return false;

		return true;
	}
	
	public boolean contains(Triangle tri) {
		Vector3f A = tri.getA().subtract(position);
		Vector3f B = tri.getB().subtract(position);
		Vector3f C = tri.getC().subtract(position);

		Vector3f edgeAB = B.subtract(A);
		Vector3f edgeBC = C.subtract(B);
		Vector3f edgeCA = A.subtract(C);
		
//		if(!intersectsPlane(tri.getNormal(), A)) return false;
		
		if(triangleTestAxisX(A, C, edgeAB)) return false;
		if(triangleTestAxisY(A, C, edgeAB)) return false;
		if(triangleTestAxisZ(B, C, edgeAB)) return false;
		
		if(triangleTestAxisX(A, C, edgeBC)) return false;
		if(triangleTestAxisY(A, C, edgeBC)) return false;
		if(triangleTestAxisZ(A, B, edgeBC)) return false;

		if(triangleTestAxisX(A, B, edgeCA)) return false;
		if(triangleTestAxisY(A, B, edgeCA)) return false;
		if(triangleTestAxisZ(B, C, edgeCA)) return false;
		
		Vector3f X = new Vector3f(A.x, B.x, C.x);
		float xMin = X.min(), xMax = X.max();
		if(xMin > radius.x || xMax < -radius.x) return false;
		
		Vector3f Y = new Vector3f(A.y, B.y, C.y);
		float yMin = Y.min(), yMax = Y.max();
		if(yMin > radius.y || yMax < -radius.y) return false;
		
		Vector3f Z = new Vector3f(A.z, B.z, C.z);
		float zMin = Z.min(), zMax = Z.max();
		if(zMin > radius.z || zMax < -radius.z) return false;

//		return true;
		return intersectsPlane(tri.getNormal(), A);
	}
	
	public boolean intersectsPlane(Vector3f normal, Vector3f point) {
		Vector3f min = new Vector3f(), max = new Vector3f();
		
		if(normal.x > 0) {
			min.x = -radius.x - point.x;
			max.x =  radius.x - point.x;
		} else {
			min.x =  radius.x - point.x;
			max.x = -radius.x - point.x;
		}
		
		if(normal.y > 0) {
			min.y = -radius.y - point.y;
			max.y =  radius.y - point.y;
		} else {
			min.y =  radius.y - point.y;
			max.y = -radius.y - point.y;
		}
		
		if(normal.z > 0) {
			min.z = -radius.z - point.z;
			max.z =  radius.z - point.z;
		} else {
			min.z =  radius.z - point.z;
			max.z = -radius.z - point.z;
		}
		
		return !(normal.dot(max) < 0 || normal.dot(min) > 0);
	}
	
	private boolean triangleTestAxisX(Vector3f v0, Vector3f v1, Vector3f edge) {
		Vector3f absEdge = edge.abs();
		
		float p0 = edge.z * v0.y - edge.y * v0.z;
		float p1 = edge.z * v1.y - edge.y * v1.z;
		
		float min, max;
	    if(p0 < p1) { min = p0; max = p1; } 
	    else 		{ min = p1; max = p0; }
	    
		float rad = absEdge.z * radius.y + absEdge.y * radius.z;
		return min > rad || max < -rad;
	}
	
	private boolean triangleTestAxisY(Vector3f v0, Vector3f v1, Vector3f edge) {
		Vector3f absEdge = edge.abs();
		
		float p0 = -edge.z * v0.x + edge.x * v0.z;
		float p1 = -edge.z * v1.x + edge.x * v1.z;
		
		float min, max;
	    if(p0 < p1) { min = p0; max = p1; } 
	    else 		{ min = p1; max = p0; }
	    
		float rad = absEdge.z * radius.x + absEdge.x * radius.z;
		return min > rad || max < -rad;
	}
	
	private boolean triangleTestAxisZ(Vector3f v0, Vector3f v1, Vector3f edge) {
		Vector3f absEdge = edge.abs();
		
		float p0 = edge.y * v0.x - edge.x * v0.y;
		float p1 = edge.y * v1.x - edge.x * v1.y;
		
		float min, max;
	    if(p0 < p1) { min = p0; max = p1; } 
	    else 		{ min = p1; max = p0; }
	    
		float rad = absEdge.y * radius.x + absEdge.x * radius.y;
		return min > rad || max < -rad;
	}
	
	public void translate(Vector3f amount) { position.set(position.add(amount)); }
	public void moveTo(Vector3f position) { super.position.set(position); }
	public void setPosition(Vector3f position) { this.moveTo(position); }
	
	public Vector3f getCenter() { return position; }
	public Vector3f getPosition() { return getCenter(); }
	public Vector3f getRadius() { return radius; }
}
