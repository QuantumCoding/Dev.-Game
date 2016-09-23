package com.GameName.PhysicsEngine.Detection;

import com.GameName.Util.Vectors.Vector3f;

public class AABB extends CollisionBody {
	private Vector3f nomalizedCenter;
	private Vector3f radius;
	
	public AABB(Vector3f radius) {
		this.radius = radius.abs();
	}
	
	public AABB(Vector3f point1, Vector3f point2) {
		this.radius = point2.subtract(point1).divide(2);
		setPosition(radius.add(point1));
	}
	
	public boolean containsPoint(Vector3f point) {
		return Math.abs(point.divide(radius).subtract(nomalizedCenter).length() - 1) < 0.0001;
	}
	
	public boolean containsLine(Vector3f p0, Vector3f p1) {
		p0 = p0.divide(radius).subtract(nomalizedCenter);
		p1 = p1.divide(radius).subtract(nomalizedCenter);
		
		return p0.lessThenOrEqual(radius) && p1.greaterThenOrEqual(radius.multiply(-1));
	}
	
	public boolean contains(Triangle tri) {
		return containsPoint(tri.getA()) || containsPoint(tri.getB()) || containsPoint(tri.getC()) ||
			containsLine(tri.getA(), tri.getB()) || containsLine(tri.getA(), tri.getC()) || 
							containsLine(tri.getC(), tri.getB());
	}
	
	public void translate(Vector3f amount) { position = position.add(amount.divide(radius)); }
	public void moveTo(Vector3f position) { super.position = position.divide(radius); }
	public void setPosition(Vector3f position) { this.moveTo(position); }
	
	public Vector3f getCenter() { return position.multiply(radius); }
	public Vector3f getPostion() { return getCenter(); }
	public Vector3f getRadius() { return radius; }
}
