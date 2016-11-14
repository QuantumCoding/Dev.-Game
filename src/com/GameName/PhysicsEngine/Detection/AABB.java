package com.GameName.PhysicsEngine.Detection;

import com.GameName.PhysicsEngine.MathContext.SpatialContext;
import com.GameName.Util.Vectors.Vector3f;

public class AABB extends CollisionBody {
	private Vector3f radius;
	private SpatialContext context;
	
	public AABB(Vector3f radius) {
		this.radius = radius.abs();
		context = new SpatialContext(radius, position, null);
	}
	
	public AABB(Vector3f p1, Vector3f p2) {
		this.radius = p2.subtract(p1).divide(2).abs();
		setPosition(p1.add(p2).divide(2));
		context = new SpatialContext(radius, position, null);
	}
	
	public boolean containsPoint(Vector3f point) { return containsPoint(point, null); }
	public boolean containsPoint(Vector3f point, SpatialContext pointContext) {
		
 		return context.convert(point, pointContext).abs().lessThenOrEqual(1);
	}

	public boolean containsLine(Vector3f p0, Vector3f p1) { return containsLine(p0, p1, null); }
	public boolean containsLine(Vector3f p0, Vector3f p1, SpatialContext pointContext) {
		
		return context.convert(p0, pointContext).lessThenOrEqual(1) && 
			   context.convert(p1, pointContext).greaterThenOrEqual(-1);
	}
	
	public boolean contains(Triangle tri) {
		Vector3f A = context.convert(tri.getA(), tri.getContext());
		Vector3f B = context.convert(tri.getB(), tri.getContext());
		Vector3f C = context.convert(tri.getC(), tri.getContext());
		
		return containsPoint(A, context) || containsPoint(B, context)   || containsPoint(C, context) ||
			 containsLine(A, B, context) || containsLine(A, C, context) || containsLine(C, B, context);
	}
	
	public void translate(Vector3f amount) { position.set(position.add(amount.divide(radius))); }
	public void moveTo(Vector3f position) { super.position.set(position); }
	public void setPosition(Vector3f position) { this.moveTo(position); }
	
	public Vector3f getCenter() { return position; }
	public Vector3f getPosition() { return getCenter(); }
	public Vector3f getRadius() { return radius; }
	
	public void setSpatialContext(SpatialContext context) { this.context = context; }
}
