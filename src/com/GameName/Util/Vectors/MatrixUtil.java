package com.GameName.Util.Vectors;

import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Matrix2f;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;

public class MatrixUtil {
	
	public static Matrix4f initPerspectiveMatrix(float fov, float aspectRatio, float zNear, float zFar) {
		Matrix4f matrix = new Matrix4f();
		
		float scaleY = (float) (1.0f / Math.tan(Math.toRadians(fov / 2.0f)) * aspectRatio);
		float scaleX = scaleY / aspectRatio;
		float frustumLength = zFar - zNear;
		
		matrix.m00 = scaleX;
		matrix.m11 = scaleY;
		matrix.m22 = -((zFar + zNear) / frustumLength);
		matrix.m23 = -1;
		matrix.m32 = -((2 * zNear * zFar) / frustumLength);
		matrix.m33 = 0;
		
		return matrix;
	}

	public static Matrix4f initOrthographicMatrix(float left, float right, float bottom, float top, float near, float far) {
		Matrix4f matrix = new Matrix4f();
		
		float width = right - left;
		float height = top - bottom;
		float depth = far - near;

		matrix.m00 =  2/width;
		matrix.m11 =  2/height;
		matrix.m22 = -2/depth;
		           
		matrix.m03 = -(right + left)/width; 
		matrix.m13 = -(top + bottom)/height;
		matrix.m23 = -(far + near)/depth;   
		matrix.m33 = 1;                     

		return matrix;
	}
	
	public static Matrix4f initRotationMatrix(Vector3f rotation) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		
		matrix.rotate((float) Math.toRadians(rotation.x), new org.lwjgl.util.vector.Vector3f(1, 0, 0));
		matrix.rotate((float) Math.toRadians(rotation.y), new org.lwjgl.util.vector.Vector3f(0, 1, 0));
		matrix.rotate((float) Math.toRadians(rotation.z), new org.lwjgl.util.vector.Vector3f(0, 0, 1));

		return matrix;
	}
	
	public static Matrix4f initTransformationMatrix(Vector3f translation, Vector3f rotation, Vector3f scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		
		matrix.translate(translation.toLWJGL());
		matrix.rotate((float) Math.toRadians(rotation.x), new org.lwjgl.util.vector.Vector3f(1, 0, 0));
		matrix.rotate((float) Math.toRadians(rotation.y), new org.lwjgl.util.vector.Vector3f(0, 1, 0));
		matrix.rotate((float) Math.toRadians(rotation.z), new org.lwjgl.util.vector.Vector3f(0, 0, 1));
		matrix.scale(scale.toLWJGL());
		
		return matrix;
	}
	
	public static Matrix4f initViewMatrix(Camera camera) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		
		matrix.scale(new org.lwjgl.util.vector.Vector3f(camera.scale, camera.scale, camera.scale));
		
		matrix.rotate((float) Math.toRadians(camera.rotX), new org.lwjgl.util.vector.Vector3f(1, 0, 0));
		matrix.rotate((float) Math.toRadians(camera.rotY), new org.lwjgl.util.vector.Vector3f(0, 1, 0));
		matrix.rotate((float) Math.toRadians(camera.rotZ), new org.lwjgl.util.vector.Vector3f(0, 0, 1));
		
		matrix.translate(new org.lwjgl.util.vector.Vector3f(-camera.x, -camera.y, -camera.z));
		
		return matrix;
	}
	
	public static Matrix4f createModelViewMatrix(Transform transform, Matrix4f viewMatrix) {
		Matrix4f modelMatrix = new Matrix4f().translate(transform.getTranslation().toLWJGL());
		MatrixUtil.transposeRotation(viewMatrix, modelMatrix);
		
		modelMatrix.rotate((float) Math.toRadians(transform.getRotation().x), new org.lwjgl.util.vector.Vector3f(1, 0, 0));
		modelMatrix.rotate((float) Math.toRadians(transform.getRotation().y), new org.lwjgl.util.vector.Vector3f(0, 1, 0));
		modelMatrix.rotate((float) Math.toRadians(transform.getRotation().z), new org.lwjgl.util.vector.Vector3f(0, 0, 1));
		
		modelMatrix.scale(transform.getScale().toLWJGL());
		return Matrix4f.mul(viewMatrix, modelMatrix, null);
	}
	
	public static Matrix4f lookAt(Vector3f eye, Vector3f center, Vector3f up) {
		return lookAt(eye, center, up, false);}
	public static Matrix4f lookAt(Vector3f eye, Vector3f center, Vector3f up, boolean leftHanded) {
		Matrix4f result = (Matrix4f) new Matrix4f().setIdentity();
		Vector3f f = center.subtract(eye).normalize();
		Vector3f s, u;
		if(leftHanded) {
			s = up.crossProduct(f).normalize();
			u = f.crossProduct(s);
		} else {
			s = f.crossProduct(up).normalize();
			u = s.crossProduct(f);
		}

		result.m00 = s.x;
		result.m10 = s.y;
		result.m20 = s.z;
		
		result.m01 = u.x;
		result.m11 = u.y;
		result.m21 = u.z;
		
		result.m02 = f.x * (leftHanded ? 1 : -1);
		result.m12 = f.y * (leftHanded ? 1 : -1);
		result.m22 = f.z * (leftHanded ? 1 : -1);
		
		result.m30 = -s.dot(eye);
		result.m31 = -u.dot(eye);
		result.m32 = -f.dot(eye) * (leftHanded ? 1 : -1);
		
		return result;
	}
	
	public static Matrix4f transposeRotation(Matrix4f matrix, Matrix4f dest) {
		if(dest == null) 
			dest = new Matrix4f();
		
		dest.m00 = matrix.m00;
		dest.m01 = matrix.m10;
		dest.m02 = matrix.m20;

		dest.m10 = matrix.m01;
		dest.m11 = matrix.m11;
		dest.m12 = matrix.m21;

		dest.m20 = matrix.m02;
		dest.m21 = matrix.m12;
		dest.m22 = matrix.m22;
		
		return dest;
	}
	
	public static Matrix subMatrix(Matrix subMatrix, int newLength, int xOff, int yOff) {
		Matrix toRep = null;
		if(newLength == 2) toRep = new Matrix2f();
		else if(newLength == 3) toRep = new Matrix3f();
		else if(newLength == 4) toRep = new Matrix4f();
		else throw new IllegalArgumentException("Length of new Matrix cannot > 4 or < 2");
		
		int a = 1;
		if(1==a) 
			throw new IllegalArgumentException("Incompleat Method Turn back now");
//		if(subMatrix.)
		
		return toRep;
	}
}