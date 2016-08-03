package com.GameName.Cube.Render;

import java.util.ArrayList;

import com.GameName.Cube.Cube;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;
import com.GameName.Util.Vectors.Vector3f;

public interface ICubeRender {
	public ArrayList<Vertex> getVertices(Vector3f position, Cube cube, int metadata);	
	public ArrayList<Integer> getIndecies(Cube cube, int metadata, boolean[] visableFaces);
	
//	public boolean[] getVisableFaces(Vector3f position, Cube cube, int metadata, Chunk c);
	public int getVerticeCount(Cube cube, int metadata, boolean[] visableFaces);
	
	public Shader getShader(int metadata);
}