package com.GameName.RenderEngine.Instancing.Testing;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL31.glDrawElementsInstanced;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Instancing.InstanceRenderer;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Shaders.Shader;

public class TestInstanceRenderer extends InstanceRenderer<TestInstanceRender, TestInstanceRenderProperties> {
	public TestInstanceRenderer(Shader shader) {
		super(shader);
	}
	
	public void prepInstanceVBO(InstanceVBO vbo, TestInstanceRender testInstanceRender) {
		TestInstanceShader shader = (TestInstanceShader) super.getShader();
		shader.bind();

		for(TestInstanceRenderProperties property : renders.get(testInstanceRender)) {
			vbo.putAll(property.getOffset());
		}
	}

	public void renderInstance(InstanceVBO vbo, TestInstanceRender testInstanceRender) {
		TestInstanceShader shader = (TestInstanceShader) super.getShader();
		shader.bind();
		
		shader.loadProjectionMatrix(Shader.getProjectionMatrix());
		shader.loadViewMatrix(Shader.getViewMatrix());
		
		glBindVertexArray(testInstanceRender.getModelData().getVAOId());
		glDrawElementsInstanced(GL_TRIANGLES, testInstanceRender.getModelData().getIndiceCount(), 
				GL_UNSIGNED_INT, 0, vbo.getRenderCount());

		Shader.unbind();
	}
	
	protected void prepareOpenGL() {
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_POSITIONS);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_TEXCOORDS);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_NORMALS);
		
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_OFFSET);
	}
	
	protected void revertOpenGL() {
	    glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_POSITIONS);     
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_TEXCOORDS);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_NORMALS);   
		
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_OFFSET);      
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_PRIMARY;
	}
}
