package com.GameName.World.Render;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Textures.Texture2D;

public class WorldRenderer extends Renderer<WorldRenderSection, WorldRenderProperties> {

	public WorldRenderer(Shader shader) {
		super(shader);
		setRenderBehind(true);
	}

	public void renderModels() {
		for(int i = 0; i < 3; i++)
			glEnableVertexAttribArray(i);
		
		for(WorldRenderSection renderSection : renders.keySet()) {
//			System.out.println("Rendering Section");
			WorldShader shader = (WorldShader) super.getShader();
			shader.bind();
			
			shader.loadFogValues(0.007f, 1.5f);
			shader.loadSkyColor(Shader.getSkyColor());
			
			shader.loadProjectionMatrix(Shader.getProjectionMatrix());
			shader.loadViewMatrix(Shader.getViewMatrix());

			shader.loadTime((float) (System.currentTimeMillis() % Float.MAX_VALUE));
//			System.out.println( System.currentTimeMillis() % 360);
			
			Texture2D texture = renderSection.getTexture();
			texture.bind(0);
			
			for(WorldRenderProperties property : renders.get(renderSection)) {
				shader.loadTransformationMatrix(property.getTransformMatrix());
								
				glBindVertexArray(renderSection.getVAOId());
				glDrawElements(GL_TRIANGLES, renderSection.getIndiceCount(), GL_UNSIGNED_INT, 0);
			}

			Shader.unbind();
		}
		
		for(int i = 0; i < 3; i++)
			glDisableVertexAttribArray(i);
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_PRIMARY;
	}
}
