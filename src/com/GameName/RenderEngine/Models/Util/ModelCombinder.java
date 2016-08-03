package com.GameName.RenderEngine.Models.Util;

import java.util.ArrayList;

import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelLoader;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.RenderEngine.Textures.TextureUtil;
import com.GameName.RenderEngine.Textures.TextureUtil.CombindTexture;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;

public class ModelCombinder {
	public static Model combindModels(Model baseModel, Model addModel) {
		if(baseModel.getRenderer() != addModel.getRenderer())
			throw new IllegalArgumentException("Can not combind models! Models are using different Renders");
		if(baseModel.getShader() != addModel.getShader())
			throw new IllegalArgumentException("Can not combind models! Models are using different Shaders");
		
		Texture2D texture = null;
		CombindTexture combindData = null;
		
		if(baseModel.getTexture().getTextureId() == addModel.getTexture().getTextureId())
			texture = baseModel.getTexture();
		else {
			combindData = TextureUtil.combindTextures(baseModel.getTexture(), addModel.getTexture());
			texture = combindData.getFullTexture();
		}
		
		ArrayList<Vertex> vertices = new ArrayList<>();
		ArrayList<Integer> indices = new ArrayList<>();
		
		for(Vertex vertex : baseModel.getModelData().getVertices()) {
			if(combindData != null) {
				Vertex newVertex = new Vertex(vertex.getPosition(), 
						combindData.getTextureCoord(vertex.getTexCoord(), baseModel.getTexture()), vertex.getNormal());
				if(!vertices.contains(newVertex))
					vertices.add(newVertex);
				indices.add(vertices.indexOf(newVertex));
				
			} else {
				if(!vertices.contains(vertex))
					vertices.add(vertex);
				indices.add(vertices.indexOf(vertex));
			}
		}
		
		for(Vertex vertex : addModel.getModelData().getVertices()) { 
			if(combindData != null) {
				Vertex newVertex = new Vertex(vertex.getPosition(), 
						combindData.getTextureCoord(vertex.getTexCoord(), addModel.getTexture()), vertex.getNormal());
				if(!vertices.contains(newVertex))
					vertices.add(newVertex);
				indices.add(vertices.indexOf(newVertex));
				
			} else {
				if(!vertices.contains(vertex))
					vertices.add(vertex);
				indices.add(vertices.indexOf(vertex));
			}
		}
		
		float[] positions = new float[vertices.size() * 3];
		float[] texCoords = new float[vertices.size() * 2];
		float[] normals   = new float[vertices.size() * 3];
		int[] indicesArray = new int[indices.size()];
		
		for(int i = 0; i < vertices.size(); i ++)
			vertices.get(i).addTo(i, positions, texCoords, normals);
		for(int i = 0; i < indices.size(); i ++)
			indicesArray[i] = indices.get(i);
		
		ModelData data = ModelLoader.loadModel(positions, texCoords, normals, indicesArray, new boolean[] {true, true, true},
				Math.max(baseModel.getModelData().getRadius(), addModel.getModelData().getRadius()), 
				Math.max(baseModel.getModelData().getRenderDistance(), addModel.getModelData().getRenderDistance()), 
				baseModel.getModelData().getCenter().add(addModel.getModelData().getCenter()).divide(2));
		
		Model model = new Model(data);
		model.setTexture(texture);
		model.setShader(baseModel.getShader());
		
		return model;
	}
}
