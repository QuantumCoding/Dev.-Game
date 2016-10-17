package com.GameName.PhysicsEngine.Render;

import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL11.glPolygonMode;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Shaders.Renderer;
import com.GameName.RenderEngine.Shaders.Shader;

public class PhysicsRenderer extends Renderer<Model, PhysicsRenderProperties> {

	public PhysicsRenderer(Shader shader) {
		super(shader);
		setRenderBehind(true);
	}

	public void renderModels() {
		for(Model renderSection : renders.keySet()) {
			PhysicsShader shader = (PhysicsShader) super.getShader();
			shader.bind();
			
			shader.loadProjectionMatrix(Shader.getProjectionMatrix());
			shader.loadViewMatrix(Shader.getViewMatrix());

			for(PhysicsRenderProperties property : renders.get(renderSection)) {
				shader.loadTransformationMatrix(property.getTransformMatrix());
				shader.loadColor(property.getColor());

				glBindVertexArray(renderSection.getVAOId());
				glEnableVertexAttribArray(Shader.ATTRIBUTE_LOC_POSITIONS);
				
				if(!property.isSolid())
					glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);

				if(property.useQuadRender())
					glDrawElements(GL_LINES, renderSection.getIndiceCount(), GL_UNSIGNED_INT, 0);
				else
					glDrawElements(GL_TRIANGLES, renderSection.getIndiceCount(), GL_UNSIGNED_INT, 0);
				
				glDisableVertexAttribArray(Shader.ATTRIBUTE_LOC_POSITIONS);
				glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
			}

			Shader.unbind();
		}
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_PRIMARY;
	}
}
