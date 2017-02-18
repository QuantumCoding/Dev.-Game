package com.GameName.PhysicsEngine.Detection.Colliders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.Util.Vectors.Vector3f;

public class CollisionMeshLoader {
	public static CollisionMesh loadObj(String filePath) {
		if(!filePath.toLowerCase().endsWith(".obj")) 
			throw new InvalidParameterException("loadOBJ can only load \"*.obj\" files!");
		
		try {
			BufferedReader read = new BufferedReader(new FileReader(new File(filePath)));
			
			ArrayList<String> verticiesRaw = new ArrayList<>();
			ArrayList<String> facesRaw = new ArrayList<>();
			
			String line = null;
			while((line = read.readLine()) != null) {
				if(line.startsWith("v ")) verticiesRaw.add(line);
				else if(line.startsWith("f ")) facesRaw.add(line);
			} read.close();		
			
			ArrayList<Triangle> faces = new ArrayList<>();
			Vector3f min = null, max = null;
			
			for(String face : facesRaw) {
				String[] faceData = face.split(" ");
				
				Vector3f a = null, b = null, c = null;
				for(String vertexData : faceData) {
					if(vertexData.startsWith("f")) continue;
					String[] data = vertexData.split("/");

					Vector3f position = new Vector3f(toFloatArray(verticiesRaw.get(Integer.parseInt(data[0]) - 1).split(" ")));
					if(a == null) a = position;
					else if(b == null) b = position;
					else if(c == null) c = position;
					
					if(min == null) min = position.clone(); else {
						min.setX(Math.min(position.x, min.x));
						min.setY(Math.min(position.y, min.y));
						min.setZ(Math.min(position.z, min.z));
					}
					
					if(max == null) max = position.clone(); else {
						max.setX(Math.max(position.x, max.x));
						max.setY(Math.max(position.y, max.y));
						max.setZ(Math.max(position.z, max.z));
					}
				}
				
				faces.add(new Triangle(a, b, c));
			}
			
//			min = min.subtract(0.1f * 20); max = max.add(0.1f * 20);
			return new CollisionMesh(new AABB(min, max), faces);
			
		} catch(IOException e) {
			System.err.println("Failed to load Collision Mesh from: " + filePath);
			e.printStackTrace();
		}
		
		return null;	
	}
		
	private static float[] toFloatArray(String[] strings) {
		float[] floats = new float[strings.length - 1];
		for(int i = 0; i < floats.length; i ++) {
			floats[i] = Float.parseFloat(strings[i + 1]);
		} return floats;
	}

}
