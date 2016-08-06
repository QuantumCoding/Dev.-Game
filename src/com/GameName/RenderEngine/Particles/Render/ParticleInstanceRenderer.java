package com.GameName.RenderEngine.Particles.Render;

import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDepthMask;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL31.glDrawElementsInstanced;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Instancing.InstanceRenderer;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.Util.Vectors.MatrixUtil;

public class ParticleInstanceRenderer extends InstanceRenderer<ParticleInstanceRender, ParticleRenderProperties> {

	public ParticleInstanceRenderer(Shader shader) {
		super(shader);
		setRenderBehind(true);
	}
	
	public void prepInstanceVBO(InstanceVBO vbo, ParticleInstanceRender particleInstanceRender) {
		ParticleShader shader = (ParticleShader) super.getShader();
		shader.bind();
		
		for(ParticleRenderProperties property : renders.get(particleInstanceRender)) {
			if(property.usingAdditive()) 
				glBlendFunc(GL_SRC_ALPHA, GL_ONE);
			else
				glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			
			vbo.putAll(
					property.getOffset1(), property.getOffset2(),
					property.getTextureDivisor(), property.getBlend(),
					MatrixUtil.createModelViewMatrix(property.getTransform(), Shader.getViewMatrix())
				);
		}
	}

	public void renderInstance(InstanceVBO vbo, ParticleInstanceRender particleInstanceRender) {
		ParticleShader shader = (ParticleShader) super.getShader();
		shader.bind();
		
		glDepthMask(false);
		shader.loadProjectionMatrix(Shader.getProjectionMatrix());
		
		Texture2D texture = ParticleTexture.getRegistry().getTextureMap();
		texture.bind(0);
		
		glBindVertexArray(particleInstanceRender.getModelData().getVAOId());
		glDrawElementsInstanced(GL_TRIANGLES, particleInstanceRender.getModelData().getIndiceCount(), 
				GL_UNSIGNED_INT, 0, vbo.getRenderCount());

		glDepthMask(true);
		Shader.unbind();
	}
	
	protected void prepareOpenGL() {
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_POSITIONS);
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_TEXCOORDS);
		
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_OFFSET_1);
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_OFFSET_2);
		
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_DIVISOR);
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_BLEND);
		
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 0);
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 1);
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 2);
		glEnableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 3);
	}
	
	protected void revertOpenGL() {
	    glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_POSITIONS);     
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_TEXCOORDS);      

		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_OFFSET_1); 
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_OFFSET_2); 

		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_DIVISOR);
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_BLEND);
		
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 0); 
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 1); 
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 2); 
		glDisableVertexAttribArray(ParticleShader.ATTRIBUTE_LOC_MODEL_VIEW + 3); 

		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_ALPHA;
	}
}
