package com.GameName.RenderEngine.Instancing;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STREAM_DRAW;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glBufferSubData;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;
import org.lwjgl.util.vector.Matrix4f;

import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.Util.Vectors.Vector4f;

public class InstanceVBO {
	private int vbo;
	
	private FloatBuffer buffer;
	private float[] dataPool;
	private int poolIndex;
	
	private int attrubiuteOffset;
	private int instanceLength;
	private int instanceCount;
	
	private int renderCount;
	
	protected InstanceVBO(int instanceLength, int instanceCount) {
		this.instanceLength = instanceLength;
		this.instanceCount = instanceCount;
		
		int floatCount = instanceLength * instanceCount;
		vbo = InstanceUtil.createEmptyVBO(floatCount);
		buffer = BufferUtils.createFloatBuffer(floatCount);
		dataPool = new float[floatCount];
	}
	
	public static InstanceVBO createInstaceVBO(int instanceLength, int instanceCount) {
		return new InstanceVBO(instanceLength, instanceCount);
	}
	
	public void nextAttribute(int vao, int attribute, int unitSize, int renderStrid) {
		InstanceUtil.addInstanceAttribute(vao, vbo, attribute, unitSize, instanceLength, attrubiuteOffset, renderStrid);
		attrubiuteOffset += unitSize;
	}
	
	public void prepVBO() {
		buffer.clear(); buffer.put(dataPool); buffer.flip();
		
		bind();
		
		glBufferData(GL_ARRAY_BUFFER, buffer.capacity() * 4, GL_STREAM_DRAW);
		glBufferSubData(GL_ARRAY_BUFFER, 0, buffer);
		
		unbind();
	}
	
	public int getRenderCount() { return renderCount; }
	
	public void reset() {
		renderCount = poolIndex = 0; 
	}
	
	public void putAll(Object... objects) {
		if(renderCount >= instanceCount) return;
		
		for(int i = 0; i < objects.length; i ++) {
			Object obj = objects[i];
			if(obj instanceof Matrix4f) putMatrix4f((Matrix4f) obj);
			
			else if(obj instanceof Vector2f) putVector2f((Vector2f) obj);
			else if(obj instanceof Vector3f) putVector3f((Vector3f) obj);
			else if(obj instanceof Vector4f) putVector4f((Vector4f) obj);
			
			else if(obj instanceof Float) 	putFloat((Float) obj);
			else if(obj instanceof Boolean) putBoolean((Boolean) obj);
			
			else throw new IllegalArgumentException("Type " + obj.getClass().getSimpleName() + "is not accepeted");
		}
		
		renderCount ++;
	}
	
	public void putMatrix4f(Matrix4f matrix) {
		dataPool[poolIndex ++] = matrix.m00;	dataPool[poolIndex ++] = matrix.m01;
		dataPool[poolIndex ++] = matrix.m02;	dataPool[poolIndex ++] = matrix.m03;
		
		dataPool[poolIndex ++] = matrix.m10;	dataPool[poolIndex ++] = matrix.m11;
		dataPool[poolIndex ++] = matrix.m12;	dataPool[poolIndex ++] = matrix.m13;
		
		dataPool[poolIndex ++] = matrix.m20;	dataPool[poolIndex ++] = matrix.m21;
		dataPool[poolIndex ++] = matrix.m22;	dataPool[poolIndex ++] = matrix.m23;
		
		dataPool[poolIndex ++] = matrix.m30;	dataPool[poolIndex ++] = matrix.m31;
		dataPool[poolIndex ++] = matrix.m32;	dataPool[poolIndex ++] = matrix.m33;
	}
	
	public void putVector4f(Vector4f vector) {
		dataPool[poolIndex ++] = vector.x;	dataPool[poolIndex ++] = vector.y;
		dataPool[poolIndex ++] = vector.z;	dataPool[poolIndex ++] = vector.w;
	}
	
	public void putVector3f(Vector3f vector) {
		dataPool[poolIndex ++] = vector.x;	dataPool[poolIndex ++] = vector.y;
		dataPool[poolIndex ++] = vector.z;
	}
	
	public void putVector2f(Vector2f vector) {
		dataPool[poolIndex ++] = vector.x;	dataPool[poolIndex ++] = vector.y;
	}
	
	public void putFloat(float value) {
		dataPool[poolIndex ++] = value;
	}
	
	public void putBoolean(boolean bool) {
		dataPool[poolIndex ++] = bool ? 1 : 0;
	}
	
	public int getVBO() { return vbo; }
	
	public void bind() {
		GL15.glBindBuffer(GL_ARRAY_BUFFER, vbo);
	}
	
	public static void unbind() {
		GL15.glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
}
