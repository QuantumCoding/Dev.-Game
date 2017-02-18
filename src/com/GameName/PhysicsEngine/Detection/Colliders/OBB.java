package com.GameName.PhysicsEngine.Detection.Colliders;

import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Matrix4f;

import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;

public class OBB extends CollisionBody {
//	public static void main(String[] args) {
//		
//		for(int i = 0; i < 360; i ++) {
//			CollisionEllipse ellipse = new CollisionEllipse(new Vector3f(1, 1, 1));
//			OBB obb = new OBB(new Vector3f(0, 0, 0), new Vector3f(0, i, 0), new Vector3f(1));
//	
//			ellipse.setPosition(new Vector3f(2.9, 0, 0));
//			System.out.println(i + ": " + obb.interseting(ellipse));
//		}
//	}
	
	private Vector3f radius;
	private Vector3f axisA, axisB, axisC;
	
	public OBB(AABB aabb, Vector3f rotation) { this(aabb.getPosition(), rotation, aabb.getRadius()); }
	
	public OBB(Vector3f position, Vector3f rotation, Vector3f radius) {
		super(position, null);
		this.radius = radius;
		
		setRotation(rotation);
	}
	
	public boolean interseting(CollisionEllipse ellipse) {
		Face[] visibleFaces = collectVisibleFaces(ellipse);
		if(visibleFaces[0] == null) return true;
		
		Parallelepiped parallelepiped = convertToParallelepiped(ellipse);
		Parallelogram[] faces = parallelepiped.getFaces(visibleFaces);
		
		for(Parallelogram face : faces) {
			if(face == null) return false;
			if(face.sqDistance > 1) return false;
			if(intersectUnitSphere(face)) return true;
		}
		
		return false;
	}
	
	private Face[] collectVisibleFaces(CollisionEllipse ellipse) {
		Vector3f w = ellipse.getPosition().subtract(position);
		Face[] visibleFaces = new Face[3];
		int index = 0;
		
		// |w * v1|	  > e1
		float distX = w.dot(axisA);
		if(Math.abs(distX) > radius.x) {
			visibleFaces[index ++] = distX > 0 ? Face.Right : Face.Left;
		}
		
		// |w * v2|	  > e2
		float distY = w.dot(axisB);
		if(Math.abs(distY) > radius.y) {
			visibleFaces[index ++] = distY > 0 ? Face.Top : Face.Bottom;
		}
		
		// |w * v3|	  > e3
		float distZ = w.dot(axisC);
		if(Math.abs(distZ) > radius.z) {
			visibleFaces[index ++] = distZ > 0 ? Face.Front : Face.Back;
		}
		
		return visibleFaces;
	}
	
	private Parallelepiped convertToParallelepiped(CollisionEllipse ellipse) {
		Matrix maxtrix = MatrixUtil.initTransformationMatrix(new Vector3f(), ellipse.rotation, ellipse.getRadius()).invert();
		Matrix4f transfrom = (Matrix4f) maxtrix;
		
		return new Parallelepiped(
					axisA.multiply(radius.x).transform(transfrom),
					axisB.multiply(radius.y).transform(transfrom),
					axisC.multiply(radius.z).transform(transfrom),
					
					position.subtract(ellipse.getPosition()).transform(transfrom)
				);
	}
	
	private boolean intersectUnitSphere(Parallelogram face) {
		Vector3f absNormal = face.normal.abs();
		Vector3f plane = new Vector3f(1).subtract(absNormal.divide(absNormal.max()).truncate());
		
		Edge[] edges = getVisibleEdges(face.projectOriginOnto(), face, plane);
		if(edges[0] == null) return true;
		
		for(Edge edge : edges) {
			if(edge == null) return false;
			if(edge.sqDistance <= 1) return true;
		}
		
		return false;
	}
	
	private Edge[] getVisibleEdges(Vector3f point, Parallelogram face, Vector3f plane) {
		Edge[] visibleEdges = new Edge[2];
		int index = 0;
		
		Vector2f center = project(face.center.add(face.zNormal), plane);
		
		Vector2f xNormal = project(face.xNormal, plane);
		Vector2f yNormal = project(face.yNormal, plane);
		
		Vector2f radius = new Vector2f(xNormal.length(), yNormal.length());
		xNormal = xNormal.divide(radius.x);
		yNormal = yNormal.divide(radius.y);
		
		Vector2f prjPont = project(point, plane).subtract(center);
		
		float distX = prjPont.dot(xNormal);
		if(Math.abs(distX) > radius.x) {
			visibleEdges[index ++] = distX > 0 ? new Edge(face.v1, face.v2) : new Edge(face.v0, face.v3);
		}

		float distY = prjPont.dot(yNormal);
		if(Math.abs(distY) > radius.y) {
			visibleEdges[index ++] = distY > 0 ? new Edge(face.v0, face.v1) : new Edge(face.v2, face.v3);
		}
		
		return visibleEdges;
	}
	
	private Vector2f project(Vector3f point, Vector3f plane) {
		return new Vector2f(plane.x == 0 ? point.z : point.x, plane.y == 0 ? point.z : point.y);
	}
	
	private static enum Face { //     7 --- 6
		Left  (3, 7, 4, 0),    //    /|    /|
		Right (1, 5, 6, 2),	   //   4 +-- 5 |
		Top	  (4, 7, 6, 5),	   //   | |   | |
		Bottom(3, 0, 1, 2),    //   | 3 --+ 2
		Front (2, 6, 7, 3),    //   |/    |/ 
		Back  (0, 4, 5, 1);    //   0 --- 1  
		                    
		int v0, v1, v2, v3;
		Face(int v0, int v1, int v2, int v3) {
			this.v0 = v0; this.v1 = v1;
			this.v2 = v2; this.v3 = v3;
		}
	}
	
	private static class Edge {
		float sqDistance;

		public Edge(Vector3f v0, Vector3f v1) {
			Vector3f direction = v1.subtract(v0);
			Vector3f point = new Vector3f();
			
			float d0, d1;
			if((d0 = direction.dot(point.subtract(v0))) <= 0) // Before v0
				sqDistance = sqDistance(point, v0);
			
			else if((d1 = direction.lengthSquared()) <= d0) // After v1
				sqDistance = sqDistance(point, v1);
			
			else
				sqDistance = sqDistance(point, v0.add(direction.multiply(d0 / d1)));
			
//			sqDistance = direction.crossProduct(v0).lengthSquared() / direction.lengthSquared();
		}
		
		private float sqDistance(Vector3f p0, Vector3f p1) {
			return p0.subtract(p1).lengthSquared();
		}
	}
	
	private static class Parallelogram {
		Vector3f center;
		Vector3f normal, xNormal, yNormal, zNormal;
		Vector3f v0, v1, v2, v3;
		float sqDistance;
		
		Parallelogram(Vector3f center, Vector3f normal, Vector3f xNormal, Vector3f yNormal, Vector3f v0, Vector3f v1, Vector3f v2, Vector3f v3) {
			this.center = center;
			
			this.v0 = v0; this.v1 = v1;
			this.v2 = v2; this.v3 = v3;
			
			this.xNormal = xNormal;
			this.yNormal = yNormal;
			this.zNormal = normal;
			
			Vector3f AB = v1.subtract(v0);
			Vector3f AC = v2.subtract(v0);
			
			this.normal = AB.crossProduct(AC).normalize();
//			this.normal = normal.normalize();
			float D = -this.normal.dot(v0);
			
			sqDistance = D*D;// / normal.lengthSquared();
		}
		
		public Vector3f projectOriginOnto() {
			return normal.multiply(-(float) Math.sqrt(sqDistance));
		}
	}
	
	private static class Parallelepiped {
		Vector3f[] vertices;
		Vector3f axisA, axisB, axisC;
		Vector3f negAxisA, negAxisB, negAxisC;
		Vector3f center;
		
		Parallelepiped(Vector3f axisA, Vector3f axisB, Vector3f axisC, Vector3f center) {
			this.axisA = axisA;
			this.axisB = axisB;
			this.axisC = axisC;
			
			this.negAxisA = axisA.multiply(-1);
			this.negAxisB = axisB.multiply(-1);
			this.negAxisC = axisC.multiply(-1);
			
			this.center = center;
			this.vertices = new Vector3f[8];
		}
		
		public Parallelogram[] getFaces(Face[] faces) {
			Parallelogram[] parallelograms = new Parallelogram[faces.length];
			
			for(int i = 0; i < faces.length; i ++) {
				Face face = faces[i];
				if(face == null) return parallelograms;
				
				parallelograms[i] = new Parallelogram(center, getNormal(face), getXNormal(face), getYNormal(face),
						getVertex(face.v0), getVertex(face.v1), getVertex(face.v2), getVertex(face.v3));
			}
			
			return parallelograms;
		}
		
		private Vector3f getNormal(Face face) {
			switch(face) {
				case Right:  return axisA;
				case Top: 	 return axisB;
				case Front:  return axisC;

				case Left: 	 return negAxisA;
				case Bottom: return negAxisB;
				case Back: 	 return negAxisC;
			}
			
			throw new IllegalArgumentException(face + " is not a valid Face");
		}
		
		private Vector3f getXNormal(Face face) {
			switch(face) {
				case Left: case Right: return axisB;
				case Bottom: case Top: return axisC;
				case Back: case Front: return axisB;
			}
			
			throw new IllegalArgumentException(face + " is not a valid Face");
		}
		
		private Vector3f getYNormal(Face face) {
			switch(face) {
				case Left: case Right: return axisC;
				case Bottom: case Top: return axisA;
				case Back: case Front: return axisA;
			}
			
			throw new IllegalArgumentException(face + " is not a valid Face");
		}
		
		private Vector3f getVertex(int index) {
			if(vertices[index] == null) {
				switch(index) {
					case 0: return vertices[index] = center.subtract(axisA).subtract(axisB).subtract(axisC);
					case 1: return vertices[index] = center.add(axisA).subtract(axisB).subtract(axisC);
					case 2: return vertices[index] = center.add(axisA).subtract(axisB).add(axisC);
					case 3: return vertices[index] = center.subtract(axisA).subtract(axisB).add(axisC);

					case 4: return vertices[index] = center.subtract(axisA).add(axisB).subtract(axisC);
					case 5: return vertices[index] = center.add(axisA).add(axisB).subtract(axisC);
					case 6: return vertices[index] = center.add(axisA).add(axisB).add(axisC);
					case 7: return vertices[index] = center.subtract(axisA).add(axisB).add(axisC);
				}
			}
			
			return vertices[index];
		}
	}
	
	public void setRotation(Vector3f rotation) {
		super.setRotation(rotation);
		rotation = rotation.toRadians();
		
		axisA = Vector3f.calculateRotationAxis_A(rotation).normalize();
		axisB = Vector3f.calculateRotationAxis_B(rotation).normalize();
		axisC = Vector3f.calculateRotationAxis_C(rotation).normalize();
	}
	
	public Vector3f getRadius() { return radius; }
}
