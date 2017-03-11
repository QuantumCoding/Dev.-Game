package com.GameName.PhysicsEngine.Detection.Intersection;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.PhysicsBody;
import com.GameName.Util.Vectors.Vector3f;

public class IntersectionResult {
	private Vector3f point;
	private float distance;
	
	private PhysicsBody intersected;
	private MovingBody source;
	
	private Matrix4f resultSpace;
	private Matrix4f inverseResultSpace;
	
	public IntersectionResult(Vector3f point, float distance) {
		this.point = point;
		this.distance = distance;
	}

	public Vector3f getPoint() { return point; }
	public float getDistance() { return distance; }

	public void setIntersected(PhysicsBody intersected) { this.intersected = intersected; }
	public void setSource(MovingBody source) { this.source = source; }
	
	public PhysicsBody getIntersected() { return intersected; }
	public PhysicsBody getSource() { return source; }
	
	public void setResultSpace(Matrix4f resultSpace) { this.resultSpace = resultSpace; this.inverseResultSpace = null; }
	public Matrix4f getResultSpace() { return resultSpace; }
	
	public Matrix4f getInverseResultSpace() {
		if(inverseResultSpace == null) {
			inverseResultSpace = Matrix4f.invert(resultSpace, null);
		}
		
		return inverseResultSpace;
	}
	
	public String toString() {
		return "IntersectionResult [point=" + point + ", distance=" + distance + "]";
	}
}
