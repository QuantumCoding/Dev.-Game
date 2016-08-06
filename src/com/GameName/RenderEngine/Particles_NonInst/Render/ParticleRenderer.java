package com.GameName.RenderEngine.Particles_NonInst.Render;

import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDepthMask;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Particles_NonInst.Texture.ParticleTexture;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.Util.Vectors.MatrixUtil;

public class ParticleRenderer extends Renderer<ParticleModel, ParticleRenderProperties> {
	
	public ParticleRenderer(Shader shader) {
		super(shader);
	}

	public void renderModels() {
		for(ParticleModel model : renders.keySet()) {
			for(int i = 0; i < model.getLargestAttribute()+1; i++)
				glEnableVertexAttribArray(i);
				
			ParticleShader shader = (ParticleShader) model.getShader();
			shader.bind();
			
			glDepthMask(false);
			shader.loadProjectionMatrix(Shader.getProjectionMatrix());
			
			Texture2D texture = ParticleTexture.getRegistry().getTextureMap();
			texture.bind(0);
			
			for(ParticleRenderProperties property : renders.get(model)) {
				shader.loadModelViewMatrix(MatrixUtil.createModelViewMatrix(property.getTransform(), Shader.getViewMatrix()));
				shader.loadTextureData(property.getTextureDivisor(), property.getOffset1(), property.getOffset2(), property.getBlend());
				
				if(property.usingAdditive()) 
					glBlendFunc(GL_SRC_ALPHA, GL_ONE);
				else
					glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
				
				glBindVertexArray(model.getVAOId());
				glDrawElements(GL_TRIANGLES, model.getIndiceCount(), GL_UNSIGNED_INT, 0);
			}
			
			glDepthMask(true);
			Shader.unbind();
			
			for(int i = 0; i < model.getLargestAttribute()+1; i++)
				glDisableVertexAttribArray(i);
		}
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_ALPHA;
	}
}