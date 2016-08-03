package com.GameName.RenderEngine.Models.ModelData;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;

import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;
import com.GameName.Util.ArrayUtil;
import com.GameName.Util.Vectors.Vector3f;

public class BufferedModelData extends ModelData {

	private int arraySize;
	private Vertex[][] vertices;
	private int[][] indices;
	
	private int[] indiciesIds;
	private int[] verticesIds;
	private int[] texCoordIds;
	private int[] normalIds;
	
	public BufferedModelData(int initalSize, float renderRadius, float renderDistance, Vector3f modelCenter) {
		super(renderRadius, renderDistance, modelCenter);
		arraySize = initalSize;
		
		vertices = new Vertex[initalSize][];
		indices = new int[initalSize][];
		
		indiciesIds = new int[initalSize];
		verticesIds = new int[initalSize];
		texCoordIds = new int[initalSize];
		normalIds   = new int[initalSize];
	}
	
	public void addState(Vertex[] vertices, int[] indices) {
		int i = 0;
		for(i = 0; i < this.vertices.length; i ++) {
			if(this.vertices[i] == null) {
				break;
			}
		}
		
		if(i >= this.vertices.length) 
			expandArrays();
		
		this.vertices[i] = vertices;
		this.indices[i] = indices;
		
		super.attribIds[Shader.ATTRIBUTE_LOC_POSITIONS] = 0;
		super.attribIds[Shader.ATTRIBUTE_LOC_TEXCOORDS] = 0;
		super.attribIds[Shader.ATTRIBUTE_LOC_NORMALS] = 0;
		super.indiciesId = 0;
		
		float[] positions = new float[vertices.length * 3];
		float[] texCoords = new float[vertices.length * 2];
		float[] normals   = new float[vertices.length * 3];
		
		for(int j = 0; j < vertices.length; j ++) {
			positions[j * 3 + 0] = vertices[j].getPosition().x;
			positions[j * 3 + 1] = vertices[j].getPosition().y;
			positions[j * 3 + 2] = vertices[j].getPosition().z;

			texCoords[j * 2 + 0] = vertices[j].getTexCoord().x;
			texCoords[j * 2 + 1] = vertices[j].getTexCoord().y;

			normals[j * 3 + 0] = vertices[j].getNormal().x;
			normals[j * 3 + 1] = vertices[j].getNormal().y;
			normals[j * 3 + 2] = vertices[j].getNormal().z;
		}
		
		super.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, positions, false);
		super.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_TEXCOORDS, 2, texCoords, false);
		super.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_NORMALS, 3, normals, false);
		super.loadIndicies(indices);
		
		verticesIds[i] = super.attribIds[Shader.ATTRIBUTE_LOC_POSITIONS];
		texCoordIds[i] = super.attribIds[Shader.ATTRIBUTE_LOC_TEXCOORDS];
		normalIds[i] = super.attribIds[Shader.ATTRIBUTE_LOC_NORMALS];
		indiciesIds[i] = super.indiciesId;
	}
	
	public void expandArrays() {
		arraySize = arraySize * 2;
		
		vertices = ArrayUtil.expandArray(vertices, new Vertex[arraySize][]);
		indices = ArrayUtil.expandArray(indices, new int[arraySize][]);
		
		indiciesIds = ArrayUtil.expandArray(indiciesIds, new int[arraySize]);
		verticesIds = ArrayUtil.expandArray(verticesIds, new int[arraySize]);
		texCoordIds = ArrayUtil.expandArray(texCoordIds, new int[arraySize]);
		normalIds   = ArrayUtil.expandArray(normalIds,   new int[arraySize]);
	}
	
	public void loadState(int state) {
		glBindVertexArray(vaoId);

		glBindBuffer(GL_ARRAY_BUFFER, verticesIds[state]);
		glVertexAttribPointer(Shader.ATTRIBUTE_LOC_POSITIONS, 3, GL_FLOAT, false, 0, 0);
		
		glBindBuffer(GL_ARRAY_BUFFER, texCoordIds[state]);
		glVertexAttribPointer(Shader.ATTRIBUTE_LOC_TEXCOORDS, 2, GL_FLOAT, false, 0, 0);
		
		glBindBuffer(GL_ARRAY_BUFFER, normalIds[state]);
		glVertexAttribPointer(Shader.ATTRIBUTE_LOC_NORMALS, 3, GL_FLOAT, false, 0, 0);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indiciesIds[state]);
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}

	public int getArraySize() { return arraySize; }
	public Vertex[][] getAllVertices() { return vertices; }
	public int[][] getAllIndices() { return indices; }
	
	@Override
	public Vertex[] getVertices() {
		return vertices[0];
	}	

	@Override
	public int[] getIndices() {
		return indices[0];
	}	
	
	@Override
	public float[] getPositions() {
		return getPositions(0);
	}	
	
	public float[] getPositions(int frame) {
		float[] positions = new float[vertices[frame].length * 3];
		
		for(int j = 0; j < vertices[frame].length; j ++) {
			positions[j * 3 + 0] = vertices[frame][j].getPosition().x;
			positions[j * 3 + 1] = vertices[frame][j].getPosition().y;
			positions[j * 3 + 2] = vertices[frame][j].getPosition().z;
		}
		
		return positions;
	}
	
	@Override
	public float[] getTexCoords() {
		return getTexCoords(0);
	}
	
	public float[] getTexCoords(int frame) {
		float[] texCoords = new float[vertices[frame].length * 2];
		
		for(int j = 0; j < vertices[frame].length; j ++) {
			texCoords[j * 2 + 0] = vertices[frame][j].getTexCoord().x;
			texCoords[j * 2 + 1] = vertices[frame][j].getTexCoord().y;
		}
		
		return texCoords;
	}
	
	@Override
	public float[] getNormals() {
		return getNormals(0);
	}
	
	public float[] getNormals(int frame) {
		float[] normals   = new float[vertices[frame].length * 3];
		
		for(int j = 0; j < vertices[frame].length; j ++) {
			normals[j * 3 + 0] = vertices[frame][j].getNormal().x;
			normals[j * 3 + 1] = vertices[frame][j].getNormal().y;
			normals[j * 3 + 2] = vertices[frame][j].getNormal().z;
		}
	
		return normals;
	}
	
	public void cleanUp() {
		glDeleteVertexArrays(vaoId);
		
		for(int i = 0; i < arraySize; i++) {
			if(verticesIds[i] != 0) glDeleteBuffers(verticesIds[i]);
			if(texCoordIds[i] != 0) glDeleteBuffers(texCoordIds[i]);
			if(normalIds[i] != 0) 	glDeleteBuffers(normalIds[i]);
			if(indiciesIds[i] != 0) glDeleteBuffers(indiciesIds[i]);
		}
	}
}
