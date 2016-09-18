package com.GameName.RenderEngine.Test;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;

public class TestShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/TestShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/TestShader.fsh";
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	
	public TestShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, TestRenderer.class);
	}

	@Override
	protected void initUniformLocations() {
		bind();
		
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix =  super.getUniformLocation("viewMatrix");
	}
	
	@Override
	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "pos");
	}
	
	public void loadTransformationMatrix(Matrix4f transformationMatrix) {
		super.loadMatrix(location_transformationMatrix, transformationMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projectionMatrix) {
		super.loadMatrix(location_projectionMatrix, projectionMatrix);
	}
	
	public void loadViewMatrix(Matrix4f viewMatrix) {
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
}
