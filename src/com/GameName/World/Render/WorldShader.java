package com.GameName.World.Render;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Math.MathUtil;
import com.GameName.Util.Vectors.Vector3f;

public class WorldShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/DefaultWorldShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/DefaultWorldShader.fsh";
	
	public static final int MAX_ATTRIB_ID = MathUtil.max(Shader.ATTRIBUTE_LOC_POSITIONS, Shader.ATTRIBUTE_LOC_TEXCOORDS);
	
	private int location_skyColor;
	private int location_fogDensity;
	private int location_fogGradient;

	private int location_texture0;
	private int location_time;
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	
	public WorldShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, WorldRenderer.class);
	}

	protected void initUniformLocations() {
		bind();
		
		location_skyColor = super.getUniformLocation("skyColor");
		location_fogDensity = super.getUniformLocation("fogDensity");
		location_fogGradient = super.getUniformLocation("fogGradient");
		
		location_texture0 = super.getUniformLocation("texture0");
		location_time = super.getUniformLocation("time");

		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix =  super.getUniformLocation("viewMatrix");
	}

	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
		super.bindAttribute(ATTRIBUTE_LOC_TEXCOORDS, "texCoord");
		
		super.loadInt(location_texture0, 0);
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
	
	public void loadFogValues(float density, float gradient) {
		super.loadFloat(location_fogDensity, density);
		super.loadFloat(location_fogGradient, gradient);
	}
	
	public void loadSkyColor(Vector3f skyColor) {
		super.loadVector3f(location_skyColor, skyColor);
	}
	
	public void loadTime(float time) {
		super.loadFloat(location_time, time);
	}
}
