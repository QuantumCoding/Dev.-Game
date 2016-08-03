package com.GameName.RenderEngine.Models.SBModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.BufferedModelData;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Models.SBModel.SBMAnimation.Bone;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;

public class SBModel extends Model {
	private int[][] faces;
	private ArrayList<Bone> bones;
	private ArrayList<SBMAnimation> animations;
	private HashMap<SBMAnimation, Integer> preloadedAnimations;
	private boolean usingPreloadedFrame;
	
	public SBModel(BufferedModelData renderData) {
		super(renderData);
		
		bones = new ArrayList<>();
		animations = new ArrayList<>();
		preloadedAnimations = new HashMap<>();
	}
	
	public void addAnimation(SBMAnimation animation) {
		animations.add(animation);
	}
	
	public void addBone(Bone bone) {
		bones.add(bone);
	}
	
	public boolean applyAnimation(SBMAnimation animation, int frame) {
		if(preloadedAnimations.get(animation) != null) {
			((BufferedModelData) modelData).loadState(frame);
			return usingPreloadedFrame = true;
		}	

		bones = animation.applyFrame(frame, bones);
		return usingPreloadedFrame = false;
	}
	
	public void applyBonesTransforms() {
		if(!usingPreloadedFrame) {
			applyBonesTransforms(true);
		}
	}
	
	private void applyBonesTransforms(boolean dynamic) {
		float[] vertices = Arrays.copyOf(((BufferedModelData)modelData).getPositions(0), ((BufferedModelData)modelData).getPositions(0).length);
		float[] normals = Arrays.copyOf(((BufferedModelData)modelData).getNormals(0), ((BufferedModelData)modelData).getNormals(0).length);
		
		for(Bone bone : bones) {
			vertices = bone.applyTransfrom(vertices);
			normals = bone.applyTransfrom(normals);
		}
		
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, vertices, dynamic);
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_NORMALS, 3, normals, dynamic);
	}
	
	public void preloadAnimation(SBMAnimation animation) {
		int offset = 0;
		for(SBMAnimation key : preloadedAnimations.keySet()) 
			offset = key.getFrameCount();
		preloadedAnimations.put(animation, offset);

		int[] indices = ((BufferedModelData) modelData).getIndices();
		float[] texCoords = Arrays.copyOf(((BufferedModelData)modelData).getTexCoords(0), ((BufferedModelData)modelData).getTexCoords(0).length);
		while(((BufferedModelData) modelData).getArraySize() < offset + animation.getFrameCount())
			((BufferedModelData) modelData).expandArrays();
		
		for(int i = 0; i < animation.getFrameCount(); i ++) {
			bones = animation.applyFrame(i, bones);
			
			float[] vertices = Arrays.copyOf(((BufferedModelData)modelData).getPositions(0), ((BufferedModelData)modelData).getPositions(0).length);
			float[] normals = Arrays.copyOf(((BufferedModelData)modelData).getNormals(0), ((BufferedModelData)modelData).getNormals(0).length);
			
			for(Bone bone : bones) {
				vertices = bone.applyTransfrom(vertices);
				normals = bone.applyTransfrom(normals);
			}
			
			Vertex[] vertexs = new Vertex[vertices.length / 3];
			for(int j = 0; j < vertexs.length; j++) {
				Vector3f position = new Vector3f(vertices[j * 3 + 0], vertices[j * 3 + 1], vertices[j * 3 + 2]);
				Vector2f texCoord = new Vector2f(texCoords[j * 2 + 0], texCoords[j * 2 + 1]);
				Vector3f normal = new Vector3f(normals[j * 3 + 0], normals[j * 3 + 1], normals[j * 3 + 2]);
				
				vertexs[j] = new Vertex(position, texCoord, normal);
			}
			
			((BufferedModelData) modelData).addState(vertexs, indices);
		}
	}
	
	public int[][] getFaces() { return faces; }
	public void setFaces(int[][] faces) {
		this.faces = faces;
	}
	
	public ModelData getModelData() { return modelData; }
	
	public float getRadius() { return modelData.getRadius();  }
	public float getRenderDistacne() { return modelData.getRenderDistance(); }
	public Vector3f getCenter() { return modelData.getCenter(); }
	
	public ArrayList<SBMAnimation> getAnimations() {
		return animations;
	}
	
	public ArrayList<Bone> getBones() {
		return bones;
	}

	public void cleanUp() {
		super.cleanUp();
	}
}
