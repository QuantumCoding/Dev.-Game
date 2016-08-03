package com.GameName.RenderEngine.Shaders;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Textures.Texture2D;

public class DefaultRenderer extends Renderer<Model, DefaultRenderProperties> {
	
	public DefaultRenderer(Shader shader) {
		super(shader);
	}

//	long totalDiff = 0; int count = 0;
	public void renderModels() {
		for(Model model : renders.keySet()) {
			for(int i = 0; i < model.getLargestAttribute()+1; i++)
				glEnableVertexAttribArray(i);
				
			DefaultShader shader = (DefaultShader) model.getShader();
			shader.bind();
			
			shader.loadFogValues(0.007f, 1.5f);
			shader.loadSkyColor(Shader.getSkyColor());
			
			shader.loadProjectionMatrix(Shader.getProjectionMatrix());
			shader.loadViewMatrix(Shader.getViewMatrix());
			
			Texture2D texture = model.getTexture();
			texture.bind(0);
			
			for(DefaultRenderProperties property : renders.get(model)) {
//				long startTime = Time.getSystemTime();
				
				shader.loadTransformationMatrix(property.getTransformMatrix());
				shader.loadShineVariables(property.getShineDamper(), property.getReflectivity());
				shader.loadTextureAtlasIndex(texture.getNumberOfRows(), 
						texture.getOffset(property.getTextureAtlasIndex()));
				
				glBindVertexArray(model.getVAOId());
				glDrawElements(GL_TRIANGLES, model.getIndiceCount(), GL_UNSIGNED_INT, 0);
				
//				long endTime = Time.getSystemTime();
//				totalDiff += endTime- startTime;
//				count ++;
				
			}

//			System.out.println("Render Cycle: " + totalDiff / count);
			
//			TextureGroup.unbind();			
			Shader.unbind();
			
			for(int i = 0; i < model.getLargestAttribute()+1; i++)
				glDisableVertexAttribArray(i);
		}
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_PRIMARY;
	}
}
