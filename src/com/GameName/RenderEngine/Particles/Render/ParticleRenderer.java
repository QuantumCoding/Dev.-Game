package com.GameName.RenderEngine.Particles.Render;

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

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Instancing.InstanceRenderer;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleRenderer extends InstanceRenderer<ParticleRender, ParticleRenderProperties> {
	public ParticleRenderer(Shader shader) {
		super(shader);
	}
	
	public void prepInstanceVBO(InstanceVBO vbo, ParticleRender particleRender) {
		ParticleShader shader = (ParticleShader) super.getShader();
		shader.bind();
		
		for(ParticleRenderProperties property : renders.get(particleRender)) {
			Matrix4f modelViewMatrix = MatrixUtil.createModelViewMatrix(property.getTransform(), Shader.getViewMatrix());
			
//			ParticleTexture texture = property.getTexture();
//			Vector2f offset1 = texture.getOffset(property.getTextureAtlasIndex());
//			Vector2f offset2 = texture.getOffset(property.getTextureAtlasIndex() < 
//					Math.pow(texture.getNumberOfRows(), 2) - 1 ? 
//						property.getTextureAtlasIndex() + 1 : property.getTextureAtlasIndex());
			
			vbo.putAll(modelViewMatrix, Vector3f.random(1));
					
//						offset1, offset2, property.getBlendValue(),
//					texture.getNumberOfRows() * ParticleTexture.getRegistry().getImageSize() / texture.getSize().x);
		}
	} 

	public void renderInstance(InstanceVBO vbo, ParticleRender particleRender) {
		ParticleShader shader = (ParticleShader) super.getShader();
		shader.bind();
		
		shader.loadProjectionMatrix(Shader.getProjectionMatrix());
		ParticleTexture.getRegistry().getTextureMap().bind(0);
		
//		if(particleRender.usingAdditive()) 
//			glBlendFunc(GL_SRC_ALPHA, GL_ONE);
//		else
//			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glBindVertexArray(particleRender.getModelData().getVAOId());
		glDrawElementsInstanced(GL_TRIANGLES, particleRender.getModelData().getIndiceCount(), 
				GL_UNSIGNED_INT, 0, vbo.getRenderCount());

		Shader.unbind();
	}
	
	protected void prepareOpenGL() {
		glDepthMask(false);
		
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		glEnableVertexAttribArray(3);
		glEnableVertexAttribArray(4);
		glEnableVertexAttribArray(5);
		glEnableVertexAttribArray(6);
		glEnableVertexAttribArray(7);
		glEnableVertexAttribArray(8);
	}
	
	protected void revertOpenGL() {
		glDepthMask(true);

	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	    
	    glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(3);
		glDisableVertexAttribArray(4);
		glDisableVertexAttribArray(5);
		glDisableVertexAttribArray(6);
		glDisableVertexAttribArray(7);
		glDisableVertexAttribArray(8);
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_ALPHA;
	}
}
