package com.GameName.RenderEngine.Particles_NonInst.Render;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.Vector2f;

public class ParticleShader extends Shader {
	private static final String VERTEX_SHADER_LOC = "res/shaders/NonParticleShader.vsh";
	private static final String FRAGMENT_SHADER_LOC = "res/shaders/NonParticleShader.fsh";

    private int location_modelViewMatrix;
    private int location_projectionMatrix;

    private int location_textureDivisor;
    private int location_texOffset1;
    private int location_texOffset2;
    private int location_blend;
    
    private int location_texture0;
	
	public ParticleShader() {
		super(VERTEX_SHADER_LOC, FRAGMENT_SHADER_LOC, ParticleRenderer.class);
	}

	@Override
	protected void initUniformLocations() {
		bind();
		
		location_modelViewMatrix = super.getUniformLocation("modelViewMatrix");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
        
        location_textureDivisor = super.getUniformLocation("textureDivisor");
        location_texOffset1 = super.getUniformLocation("texOffset1");
        location_texOffset2 = super.getUniformLocation("texOffset2");
        location_blend = super.getUniformLocation("blendFactor");

        location_texture0 = super.getUniformLocation("texture0");
	}

	@Override
	protected void bindAttributies() {
		bind();
		
		super.bindAttribute(ATTRIBUTE_LOC_POSITIONS, "position");
		super.bindAttribute(ATTRIBUTE_LOC_TEXCOORDS, "texCoord");
		
		super.loadInt(location_texture0, 0);
	}
	
	public void loadTextureData(float textureDivisor, Vector2f offset1, Vector2f offset2, float blend) {
		super.loadFloat(location_textureDivisor, textureDivisor);
		
		super.loadVector2f(location_texOffset1, offset1);
		super.loadVector2f(location_texOffset2, offset2);
		
		super.loadFloat(location_blend, blend);
	}
	
	public void loadModelViewMatrix(Matrix4f modelView) {
        super.loadMatrix(location_modelViewMatrix, modelView);
    }
 
    public void loadProjectionMatrix(Matrix4f projectionMatrix) {
        super.loadMatrix(location_projectionMatrix, projectionMatrix);
    }
}
