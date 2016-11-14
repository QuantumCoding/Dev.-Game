package com.GameName.PhysicsEngine.Render;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Math.MathUtil;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/physics/PhysicsSphereShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/physics/PhysicsSphereShader.fsh";
	
	public static final int MAX_ATTRIB_ID = MathUtil.max(Shader.ATTRIBUTE_LOC_POSITIONS, Shader.ATTRIBUTE_LOC_TEXCOORDS);
	
	private int location_color;
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;

	private int location_globalTranslation;
	private int location_globalRotation;
	private int location_globalScale;
	
	public PhysicsShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, PhysicsRenderer.class);
	}

	protected void initUniformLocations() {
		bind();
		
		location_color = super.getUniformLocation("color");

		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix =  super.getUniformLocation("viewMatrix");

		location_globalTranslation = super.getUniformLocation("globalTranslation");
		location_globalRotation = super.getUniformLocation("globalRotation");
		location_globalScale = super.getUniformLocation("globalScale");
	}

	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
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
	
	public void loadColor(Vector3f color) {
		super.loadVector3f(location_color, color);
	}
	
	public void loadGlobalTranslation(Vector3f translation) {
		super.loadVector3f(location_globalTranslation, translation);
	}
	
	public void loadGlobalRotation(Vector3f rotation) {
		super.loadVector3f(location_globalRotation, rotation);
	}
	
	public void loadGlobalScale(Vector3f scale) {
		super.loadVector3f(location_globalScale, scale);
	}
}
