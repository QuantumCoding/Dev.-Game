package com.GameName.RenderEngine.Shaders;

import java.util.List;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Lights.Light;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;

public class DefaultShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/DefaultShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/DefaultShader.fsh";

	private static final int LIGHT_COUNT = 4;
	
	private int location_skyColor;
	private int location_fogDensity;
	private int location_fogGradient;

	private int location_lightPosition[];
	private int location_lightColor[];
	private int location_lightAttenuation[];
	private int location_shineDamper;
	private int location_reflectivity;

	private int location_numberOfRows;
	private int location_offset;
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	
	private int location_texture0;
	
	private int location_time;
	
	public DefaultShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, DefaultRenderer.class);
	}

	@Override
	protected void initUniformLocations() {
		bind();
		
		location_skyColor = super.getUniformLocation("skyColor");
		location_fogDensity = super.getUniformLocation("fogDensity");
		location_fogGradient = super.getUniformLocation("fogGradient");
		
		location_shineDamper = super.getUniformLocation("shineDamper");
		location_reflectivity = super.getUniformLocation("reflectivity");
		

		location_numberOfRows = super.getUniformLocation("numberOfRows");
		location_offset = super.getUniformLocation("offset");
		
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix =  super.getUniformLocation("viewMatrix");

		location_texture0 = super.getUniformLocation("texture0");
		location_time = super.getUniformLocation("time");
		
		location_lightPosition = new int[LIGHT_COUNT];
		location_lightColor = new int[LIGHT_COUNT];
		location_lightAttenuation = new int[LIGHT_COUNT];
		
		for(int i = 0; i < LIGHT_COUNT; i ++) {
			location_lightPosition[i] = super.getUniformLocation("lightPosition[" + i + "]");
			location_lightColor[i] = super.getUniformLocation("lightColor[" + i + "]");
			location_lightAttenuation[i] = super.getUniformLocation("lightAttenuation[" + i + "]");
		}
	}

	@Override
	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
		super.bindAttribute(ATTRIBUTE_LOC_TEXCOORDS, "texCoord");
		super.bindAttribute(ATTRIBUTE_LOC_NORMALS,   "normal");
		
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
	
	public void loadLights(List<Light> lights) {	
		for(int i = 0; i < LIGHT_COUNT; i ++) {
			if(i < lights.size()) {
				super.loadVector3f(location_lightPosition[i], lights.get(i).getPosition());
				super.loadVector3f(location_lightColor[i], lights.get(i).getColor());
				super.loadVector3f(location_lightAttenuation[i], lights.get(i).getAttenuation());
			} else {
				super.loadVector3f(location_lightPosition[i], new Vector3f());
				super.loadVector3f(location_lightColor[i], new Vector3f());		
				super.loadVector3f(location_lightAttenuation[i], new Vector3f(1, 0, 0));		
			}
		}
	}
	
	public void loadShineVariables(float damper, float reflectivity) {
		super.loadFloat(location_shineDamper, damper);
		super.loadFloat(location_reflectivity, reflectivity);
	}
	
	public void loadTextureAtlasIndex(float numberOfRows, Vector2f offset) {
		super.loadFloat(location_numberOfRows, numberOfRows);
		super.loadVector2f(location_offset, offset);
	}
	
	public void loadTime(float time) {
		super.loadFloat(location_time, time);
	}
}