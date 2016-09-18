package com.GameName.RenderEngine.Test;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import com.GameName.Registry.ResourceManager.Shaders;
import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;

public class TestRenderer extends Renderer<TestModel, TestRenderProperties> {
	
	public TestRenderer(Shader shader) {
		super(shader);
	}

	public void renderModels() {
		for(Model model : renders.keySet()) {
			glEnableVertexAttribArray(Shader.ATTRIBUTE_LOC_POSITIONS);	
			
			TestShader shader = (TestShader) model.getShader();
			shader.bind();
			
			shader.loadProjectionMatrix(Shader.getProjectionMatrix());
			shader.loadViewMatrix(Shader.getViewMatrix());
			
			for(TestRenderProperties property : renders.get(model)) {
				shader.loadTransformationMatrix(property.getTransformMatrix());
				
				glBindVertexArray(model.getVAOId());
				glDrawElements(GL_TRIANGLES, model.getIndiceCount(), GL_UNSIGNED_INT, 0);
			}

			Shader.unbind();

			glDisableVertexAttribArray(Shader.ATTRIBUTE_LOC_POSITIONS);
		}
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_PRIMARY;
	}
}
