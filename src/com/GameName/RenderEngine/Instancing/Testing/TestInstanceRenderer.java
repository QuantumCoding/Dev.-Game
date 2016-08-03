package com.GameName.RenderEngine.Instancing.Testing;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDepthMask;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL31.glDrawElementsInstanced;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Instancing.InstanceRenderer;
import com.GameName.RenderEngine.Instancing.InstanceVBO;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.Util.Vectors.MatrixUtil;
import com.GameName.Util.Vectors.Vector4f;

public class TestInstanceRenderer extends InstanceRenderer<TestInstanceRender, TestInstanceRenderProperties> {
	public TestInstanceRenderer(Shader shader) {
		super(shader);
	}
	
	public void prepInstanceVBO(InstanceVBO vbo, TestInstanceRender testInstanceRender) {
//		TestInstanceShader shader = (TestInstanceShader) super.getShader();
//		shader.bind();
//		
		for(TestInstanceRenderProperties property : renders.get(testInstanceRender)) {
			Matrix4f modelViewMatrix = MatrixUtil.createModelViewMatrix(property.getTransform(), Shader.getViewMatrix());
//			System.out.println(modelViewMatrix);
			
			Vector4f modelViewMatrix0 = new Vector4f(modelViewMatrix.m00, modelViewMatrix.m01, modelViewMatrix.m02, modelViewMatrix.m03);
			Vector4f modelViewMatrix1 = new Vector4f(modelViewMatrix.m10, modelViewMatrix.m11, modelViewMatrix.m12, modelViewMatrix.m13);
			Vector4f modelViewMatrix2 = new Vector4f(modelViewMatrix.m20, modelViewMatrix.m21, modelViewMatrix.m22, modelViewMatrix.m23);
			Vector4f modelViewMatrix3 = new Vector4f(modelViewMatrix.m30, modelViewMatrix.m31, modelViewMatrix.m32, modelViewMatrix.m33);
			
			System.out.println(modelViewMatrix0.x + ", " + modelViewMatrix1.y + ", " + modelViewMatrix2.z);
			vbo.putAll(modelViewMatrix0, modelViewMatrix1, modelViewMatrix2, modelViewMatrix3, modelViewMatrix0, modelViewMatrix1, modelViewMatrix2, modelViewMatrix3);//modelViewMatrix0, modelViewMatrix1, modelViewMatrix2, modelViewMatrix3);
		}
	}

	public void renderInstance(InstanceVBO vbo, TestInstanceRender testInstanceRender) {
		TestInstanceShader shader = (TestInstanceShader) super.getShader();
		shader.bind();
		
		shader.loadProjectionMatrix(Shader.getProjectionMatrix());
		
		glBindVertexArray(testInstanceRender.getModelData().getVAOId());
		glDrawElementsInstanced(GL_TRIANGLES, testInstanceRender.getModelData().getIndiceCount(), 
				GL_UNSIGNED_INT, 0, vbo.getRenderCount());

		Shader.unbind();
	}
	
	protected void prepareOpenGL() {
		glDepthMask(false);
		
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_POSITIONS);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_0);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_1);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_2);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_3);
		
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_4);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_5);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_6);
		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_7);
//		glEnableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_COLOR);
	}
	
	protected void revertOpenGL() {
		glDepthMask(true);

	    glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_POSITIONS);     
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_0);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_1);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_2);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_3);   
		
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_4);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_5);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_6);      
		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_MATRIX_7);     
//		glDisableVertexAttribArray(TestInstanceShader.ATTRIBUTE_LOC_COLOR);         
	}

	public boolean isAcceptedShader(Shader shader) {
		return shader == this.shader;
	}
	
	public int getRenderStage() {
		return RenderEngine.RENDER_STEP_PRIMARY;
	}
}
