package com.GameName.RenderEngine.Particles.Render;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;

public class ParticleShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/ParticleShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/ParticleShader.fsh";

	public static final int ATTRIBUTE_LOC_OFFSET = 3;
	public static final int ATTRIBUTE_LOC_TEX_COORD_SCALE = 4;
	public static final int ATTRIBUTE_LOC_BLEND_VALUE = 5;
	
	public static final int ATTRIBUTE_LOC_MODLE_VIEW_MAT = 6;
	
	private int location_projectionMatrix;
	private int location_texture0;
	
	public ParticleShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, ParticleRenderer.class);
	}

	protected void initUniformLocations() {
		bind();
		
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_texture0 = super.getUniformLocation("texture0");
	}

	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
		super.bindAttribute(ATTRIBUTE_LOC_TEXCOORDS, "texCoord");

		super.bindAttribute(ATTRIBUTE_LOC_OFFSET, "offset");
		super.bindAttribute(ATTRIBUTE_LOC_TEX_COORD_SCALE, "texCoordScale");
		super.bindAttribute(ATTRIBUTE_LOC_BLEND_VALUE, "blendValue");
		
		super.bindAttribute(ATTRIBUTE_LOC_MODLE_VIEW_MAT, "modelViewMatrix");

		super.loadInt(location_texture0, 0);
	}
	
	public void loadProjectionMatrix(Matrix4f projectionMatrix) {
		super.loadMatrix(location_projectionMatrix, projectionMatrix);
	}
}