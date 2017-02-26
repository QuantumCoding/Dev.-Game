package com.GameName.PhysicsEngine.Bodies;

import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.Intersection.IntersectionResult;
import com.GameName.Util.Vectors.Vector3f;

public class Raycast extends MovingBody {
	
	private Vector3f startPos;
	private Vector3f endPos;

	public Raycast(Vector3f startPos, Vector3f endPos) {
		super(new CollisionEllipse(new Vector3f(0.01f)));
	
		super.setPosition(startPos);
		this.startPos = startPos;
		this.endPos = endPos;
	}
	
	public IntersectionResult intersect(CollisionMesh mesh) {
		setVelocity(endPos.subtract(startPos));
		return super.intersect(mesh);
	}
	
	public Vector3f getStartPosition() { return startPos; }
	public Vector3f getEndPosition() { return endPos; }
	
	public static Vector3f cast(Vector3f angle, float radius) {
		float sin_s = (float) Math.sin(Math.toRadians(angle.x));
		float sin_t = (float) Math.sin(Math.toRadians(angle.y));
		float cos_s = (float) Math.cos(Math.toRadians(angle.x));
		float cos_t = (float) Math.cos(Math.toRadians(angle.y));
		
		return new Vector3f(
					cos_s * sin_t * radius,
					sin_s * sin_t * radius,
					        cos_t * radius
				);
	}
}
