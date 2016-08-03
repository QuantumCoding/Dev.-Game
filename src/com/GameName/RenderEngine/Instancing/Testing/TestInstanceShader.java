package com.GameName.RenderEngine.Instancing.Testing;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;

public class TestInstanceShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/TestInstanceShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/TestInstanceShader.fsh";

	public static final int ATTRIBUTE_LOC_MATRIX_0 = 1;
	public static final int ATTRIBUTE_LOC_MATRIX_1 = 2;
	public static final int ATTRIBUTE_LOC_MATRIX_2 = 3;
	public static final int ATTRIBUTE_LOC_MATRIX_3 = 4;
	public static final int ATTRIBUTE_LOC_MATRIX_4 = 5;
	public static final int ATTRIBUTE_LOC_MATRIX_5 = 6;
	public static final int ATTRIBUTE_LOC_MATRIX_6 = 7;
	public static final int ATTRIBUTE_LOC_MATRIX_7 = 8;
//	public static final int ATTRIBUTE_LOC_COLOR = 5;
	
	private int location_projectionMatrix;
	
	public TestInstanceShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, TestInstanceRenderer.class);
	}

	protected void initUniformLocations() {
		bind();
		
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
	}

	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");

		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_0, "modelViewMatrix0");
		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_1, "modelViewMatrix1");
		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_2, "modelViewMatrix2");
		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_3, "modelViewMatrix3");

		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_4, "modelViewMatrix4");
		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_5, "modelViewMatrix5");
		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_6, "modelViewMatrix6");
		super.bindAttribute(ATTRIBUTE_LOC_MATRIX_7, "modelViewMatrix7");
//		super.bindAttribute(ATTRIBUTE_LOC_COLOR, "colorIn");
	}
	
	public void loadProjectionMatrix(Matrix4f projectionMatrix) {
		super.loadMatrix(location_projectionMatrix, projectionMatrix);
	}
}