package com.GameName.PhysicsEngine.Response;

import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.Util.Math.Plane;
import com.GameName.Util.Vectors.Vector3f;

public class PlaneResponse {
	public static final float MIN_DISTANCE = 0.001f;
	
	private IntersectionResult intersection;
	private Vector3f position, velocity;
	
	private Plane slidingPlane;
	
	private Vector3f newPosition;
	private Vector3f newVelocity;
	
	public PlaneResponse(IntersectionResult intersection, Vector3f position, Vector3f velocity) {
		this.intersection = intersection;
		this.position = position;
		this.velocity = velocity;
	}
	
	public void process() {
		newPosition = position;
		Vector3f destinationPoint = position.add(velocity);
		Vector3f insterectPoint = intersection.getPoint();
		
		if(intersection.getDistance() > MIN_DISTANCE) {
			Vector3f scaledVelocity = velocity.multiply(intersection.getDistance() - MIN_DISTANCE);
			newPosition = position.add(scaledVelocity);
			
			insterectPoint = insterectPoint.subtract(velocity.multiply(MIN_DISTANCE));
		}
		
		this.slidingPlane = new Plane(insterectPoint, newPosition.subtract(insterectPoint).normalize());
		
		Vector3f newDestinationPoint = destinationPoint.subtract(
				slidingPlane.getNormal().multiply(slidingPlane.signedDistance(destinationPoint)));

		newVelocity = newDestinationPoint.subtract(insterectPoint);
	}
	
	public Vector3f getNewPosition() { return newPosition; }
	public Vector3f getNewVelocity() { return newVelocity; }

	public Plane getSlidingPlane() { return slidingPlane; }
	public IntersectionResult getIntersection() { return intersection; }
}
