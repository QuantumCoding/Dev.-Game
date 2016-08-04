package com.GameName.RenderEngine.Instancing.Testing;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;

public class TestInstanceShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/TestInstanceShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/TestInstanceShader.fsh";

	public static final int ATTRIBUTE_LOC_OFFSET = 3;
	
	private int location_projectionMatrix;
	private int location_viewMatrix;
	
	private int location_texture0;
	
	public TestInstanceShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, TestInstanceRenderer.class);
	}

	protected void initUniformLocations() {
		bind();
		
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		
		location_texture0 = super.getUniformLocation("texture0");
	}

	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
		super.bindAttribute(ATTRIBUTE_LOC_TEXCOORDS, "texCoord");
		super.bindAttribute(ATTRIBUTE_LOC_NORMALS,   "normal");

		super.bindAttribute(ATTRIBUTE_LOC_OFFSET, "offset");
		
		super.loadInt(location_texture0, 0);
	}
	
	public void loadProjectionMatrix(Matrix4f projectionMatrix) {
		super.loadMatrix(location_projectionMatrix, projectionMatrix);
	}
	
	public void loadViewMatrix(Matrix4f viewMatrix) {
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
}