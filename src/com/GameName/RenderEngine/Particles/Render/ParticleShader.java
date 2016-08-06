package com.GameName.RenderEngine.Particles.Render;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;

public class ParticleShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/NonParticleShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/NonParticleShader.fsh";

	public static final int ATTRIBUTE_LOC_OFFSET_1 = 2;
	public static final int ATTRIBUTE_LOC_OFFSET_2 = 3;

	public static final int ATTRIBUTE_LOC_DIVISOR = 4;
	public static final int ATTRIBUTE_LOC_BLEND = 5;
	
	public static final int ATTRIBUTE_LOC_MODEL_VIEW = 6;
	
    private int location_projectionMatrix;
    private int location_texture0;
	
	public ParticleShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, ParticleInstanceRenderer.class);
	}

	@Override
	protected void initUniformLocations() {
		bind();
		
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
        location_texture0 = super.getUniformLocation("texture0");
	}

	@Override
	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
		super.bindAttribute(ATTRIBUTE_LOC_TEXCOORDS, "texCoord");

		super.bindAttribute(ATTRIBUTE_LOC_OFFSET_1, "texOffset1");
		super.bindAttribute(ATTRIBUTE_LOC_OFFSET_2, "texOffset2");

		super.bindAttribute(ATTRIBUTE_LOC_DIVISOR, "textureDivisor");
		super.bindAttribute(ATTRIBUTE_LOC_BLEND, "blendFactor");

		super.bindAttribute(ATTRIBUTE_LOC_MODEL_VIEW, "modelViewMatrix");
		
		super.loadInt(location_texture0, 0);
	}
	
    public void loadProjectionMatrix(Matrix4f projectionMatrix) {
        super.loadMatrix(location_projectionMatrix, projectionMatrix);
    }
}
