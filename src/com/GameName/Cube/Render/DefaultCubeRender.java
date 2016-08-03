package com.GameName.Cube.Render;

import java.util.ArrayList;
import java.util.HashMap;

import com.GameName.Cube.Cube;
import com.GameName.Registry.ResourceManager.Shaders;
import com.GameName.RenderEngine.Models.SBModel.SBModel;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;
import com.GameName.Util.Side;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.World;

public class DefaultCubeRender implements ICubeRender {

	private ArrayList<Vertex> vertices;
	private HashMap<Side, ArrayList<Integer>> indicesMap;
	
	public DefaultCubeRender(SBModel model) {
		vertices = new ArrayList<>();
		indicesMap = new HashMap<>();
		
		for(Vertex vertex : model.getModelData().getVertices()) {
			vertices.add(vertex.clone());
		}
		
		for(Side side : Side.values()) {
			ArrayList<Integer> indices = new ArrayList<>();
			for(int[] faceInfo : model.getFaces()) {
				if(faceInfo.length > 3) continue;
//				System.out.println(faceInfo[2]);
				
				if(faceInfo[2] == side.index() * 2 || faceInfo[2] == side.index() * 2 + 1) {
					for(int i = 0; i < faceInfo[1]; i ++) {	
						indices.add(model.getModelData().getIndices()[faceInfo[0] + i]);
					}
				}
			}
			
			indicesMap.put(side, indices);
		}
	}
	
	public DefaultCubeRender(ArrayList<Vertex> vertices, HashMap<Side, ArrayList<Integer>> indicesMap) {
		this.vertices = vertices;
		this.indicesMap = indicesMap;
	}

	public ArrayList<Vertex> getVertices(Vector3f position, Cube cube, int metadata) {
		ArrayList<Vertex> vertices = new ArrayList<>();
		position = position.multiply(World.CUBE_SIZE).multiply(2);
		
		for(Vertex vertex : this.vertices) {
			vertices.add(new Vertex(
				vertex.getPosition().multiply(World.CUBE_SIZE).add(position), 
				getTextureCoord(cube, metadata, vertex.getTexCoord()), 
				vertex.getNormal().multiply(World.CUBE_SIZE).add(position)));
		}
		
		return vertices;
	}

	private Vector2f getTextureCoord(Cube cube, int metadata, Vector2f texcord) {
		int frame = cube.getFrameFromMetadata(metadata);
		texcord = texcord.multiply(cube.getTextures()[frame].getSize());
		Vector2f imageScalePos = cube.getTextureSheet(metadata).getTexturePos_ImageScale(cube.getName() + ":" + frame);
		return texcord.divide(cube.getTextureSheet(metadata).getImageSize()).add(imageScalePos);
	}
	
	public ArrayList<Integer> getIndecies(Cube cube, int metadata, boolean[] visableFaces) {
		ArrayList<Integer> indices = new ArrayList<>();
		for(Side side : Side.values()) {
			if(!visableFaces[side.index()]) continue;
			indices.addAll(indicesMap.get(side));
		}
		
		return indices;
	}

//	public boolean[] getVisableFaces(Vector3f position, Cube cube, int metadata, Chunk c) {
//		boolean[] faces = new boolean[Side.values().length];
//		Cube[] surroundingCubes = c.getSurroundingCubes((int) position.x, (int) position.y, (int) position.z);
//		int[] surroundingCubesMetadata = c.getSurroundingCubesMetadata((int) position.x, (int) position.y, (int) position.z);
//		
//		for(Side side : Side.values()) {
//			faces[side.index()] = surroundingCubes[side.index()] != null && 
//					!surroundingCubes[side.index()].isSolid(surroundingCubesMetadata[side.index()]);
//		}
//		
//		return faces;
//	}

	public int getVerticeCount(Cube cube, int metadata, boolean[] visableFaces) {
		int count = 0;
		for(Side side : Side.values()) {
			if(!visableFaces[side.index()]) continue;
			count += indicesMap.get(side).size();
		}
		
		return count;
	}

	public Shader getShader(int metadata) {
		return Shaders.WorldShader;
	}
}
