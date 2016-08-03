package com.GameName.RenderEngine.Util;

import static org.lwjgl.opengl.ARBDepthClamp.GL_DEPTH_CLAMP;
import static org.lwjgl.opengl.GL11.glEnable;

import org.lwjgl.opengl.GLContext;

import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.RenderStructs.Plane;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector3f;

public class Camera {
	public float x;
	public float y;
	public float z;
	
	public float rotX;
	public float rotY;
	public float rotZ;
	
	public float scale;
	
	private float fov;
	private float aspect;
	private float zNear;
	private float zFar;
	
	private Plane[] projectionMatrixFaces;
	
	public Camera(float fov, float aspect, float zNear, float zFar) {		
		this.fov = fov;
		this.aspect = aspect;
		this.zNear = zNear;
		this.zFar = zFar;
				
		Shader.setProjectionMatrix(MatrixUtil.initPerspectiveMatrix(fov, aspect, zNear, zFar));
		
		float adj = zFar / (float) Math.tan(Math.toRadians(fov/2.0f));
		Vector3f organ = new Vector3f();
		
		Vector3f topLeft = organ.add(-adj, adj, zFar);
		Vector3f topRight = organ.add(adj, adj, zFar);
		Vector3f bottomLeft = organ.add(-adj, -adj, zFar);
		Vector3f bottomRight = organ.add(adj, -adj, zFar);
		
		projectionMatrixFaces = new Plane[] {
			new Plane(organ, topLeft, bottomLeft),
			new Plane(organ, topRight, topLeft),
			new Plane(organ, bottomRight, topRight),
			new Plane(organ, bottomLeft, bottomRight),
		};
		
		this.scale = 1.0f;
	}
	
	public void applyOptimalStates() {
        if (GLContext.getCapabilities().GL_ARB_depth_clamp) {
            glEnable(GL_DEPTH_CLAMP);
        }
    }
	
	public void moveForward(float amt) {
		z += -amt * Math.sin(Math.toRadians(rotY + 90));
		x += -amt * Math.cos(Math.toRadians(rotY + 90));
	}

	public void moveRight(float amt) {
		z += amt * Math.sin(Math.toRadians(rotY));
		x += amt * Math.cos(Math.toRadians(rotY));
	}
	
	public void moveUp(float amt) { y += amt; }	

	public void rotateY(float amt) { rotY += amt; }
	public void rotateX(float amt) { rotX += amt; }
	public void rotateZ(float amt) { rotZ += amt; }

	public void setScale(float scale) { this.scale = scale; }
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }

	public float getRotX() { return rotX; }
	public float getRotY() { return rotY; }
	public float getRotZ() { return rotZ; }
	
	public float getScale() { return scale; }
	
	public float getFov() { return fov; }
	public float getAspect() { return aspect; }
	public float getZNear() { return zNear; }
	public float getZFar() { return zFar; }

	public Vector3f getPosition() {
		return new Vector3f(x, y, z);
	}
	
	public Vector3f getRotation() {
		return new Vector3f(rotX, rotY, rotZ);
	}
	
	public Plane[] getProjectionMatrixFaces() {
		return projectionMatrixFaces;
	}
}
