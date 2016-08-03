package com.GameName.RenderEngine.Models.ModelData;

import java.util.ArrayList;
import java.util.HashMap;

import com.GameName.Util.Vectors.Vector3f;

public class PreModleData {
	private HashMap<Integer, ArrayList<Float>> data;
	
	private Vector3f center;
	private float renderRadius;
	private float renderDistance;
	
	public PreModleData(float renderRadius, float renderDistance, Vector3f center) {
		this.center = center;
		this.renderRadius = renderRadius;
		this.renderDistance = renderDistance;

		data = new HashMap<>();
	}
	
	public void storeData(int attrib, ArrayList<Float> addData) {
		ArrayList<Float> dataSet = null;
		if((dataSet = data.get(attrib)) == null)
			data.put(attrib, dataSet = new ArrayList<>());
		dataSet.addAll(addData);
	}
	
	public ModelData createModelData() {
		ModelData modelData = new ModelData(renderRadius, renderDistance, center);
		for(Integer attrib : data.keySet()) {
			modelData.storeDataInAttributeList(attrib, size, data, dynamic);
		}
	}
}
