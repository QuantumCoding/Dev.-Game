package com.GameName.RenderEngine.Models.SBModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;

import com.GameName.RenderEngine.Models.SBModel.SBModelLoader.SBMFileFormat;
import com.GameName.RenderEngine.Models.SBModel.SBModelLoader.SBMFileFormat.VertexData;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;

public class SBMConverter {
	private static final String INITIAL_COMMENTS = "SBM Converted v1.0.0 - Converted from .OBJ file";
	
	public static File convertOBJ(File objFile, File outputFolder, float renderRadius, float renderDistance, Vector3f center) {
		SBMFileFormat format = new SBMFileFormat(); format.setDefault();
		return convertOBJ(objFile, outputFolder, format, renderRadius, renderDistance, center);
	}
	
	public static File convertOBJ(File objFile, File outputFolder, SBMFileFormat format, float renderRadius, float renderDistance, Vector3f center) {
		if(!objFile.getAbsolutePath().toLowerCase().endsWith(".obj")) 
			throw new InvalidParameterException("loadOBJ can only load \"*.obj\" files!");
		
		try {
			BufferedReader read = new BufferedReader(new FileReader(objFile));
			
			ArrayList<String> verticiesRaw = new ArrayList<>();
			ArrayList<String> texCoordsRaw = new ArrayList<>();
			ArrayList<String> normalsRaw = new ArrayList<>();
			ArrayList<String> facesRaw = new ArrayList<>();
			
			String line = null;
			while((line = read.readLine()) != null) {
				if(line.startsWith("v ")) verticiesRaw.add(line);
				else if(line.startsWith("vt ")) texCoordsRaw.add(line);
				else if(line.startsWith("vn ")) normalsRaw.add(line);
				else if(line.startsWith("f ")) facesRaw.add(line);
			} read.close();		
			
			HashSet<Vertex> vertexsCheck = new HashSet<>();
			ArrayList<Vertex> vertexs = new ArrayList<>();
			ArrayList<Integer> indicies = new ArrayList<>();
			
			boolean hasTexCoords = texCoordsRaw.size() > 0;
			boolean hasNormals = normalsRaw.size() > 0;			
			
			for(String face : facesRaw) {
				String[] faceData = face.split(" ");
				for(String vertexData : faceData) {
					if(vertexData.startsWith("f")) continue;
					
					String[] data = vertexData.split("/");

					Vector2f texCoord = new Vector2f();
					Vector3f normal = new Vector3f();
										
					Vector3f position = new Vector3f(toFloatArray(verticiesRaw.get(Integer.parseInt(data[0]) - 1).split(" ")));
					if(hasTexCoords) 
						texCoord = new Vector2f(toFloatArray(texCoordsRaw.get(Integer.parseInt(data[1]) - 1).split(" "))).add(0, -1).abs();
					if(hasNormals)   
						normal = new Vector3f(toFloatArray(normalsRaw.get(Integer.parseInt(data[2]) - 1).split(" ")));
					
					Vertex vertex = new Vertex(position, texCoord, normal);
					if(vertexsCheck.add(vertex)) {
						vertexs.add(vertex);
					} 
					
					indicies.add(vertexs.indexOf(vertex));
				}
			}
			
			int index = objFile.getAbsolutePath().lastIndexOf("/");
			if(index == -1) index = objFile.getAbsolutePath().lastIndexOf("\\");
			index += 1;
			
			String name = objFile.getAbsolutePath().substring(index, objFile.getAbsolutePath().length() - 4);
			File outputFile = new File(outputFolder + "/" + name + ".sbm");
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			String com = SBMFileFormat.COMMAND_CHAR + " ";
			
			writer.write(INITIAL_COMMENTS); writer.newLine();
			writer.write("Original File: " + name + ".obj"); writer.newLine();
			writer.newLine();
			writer.write("GameName rendering information:"); writer.newLine();
			writer.write("\tRender Radius: " + renderRadius + ", Render Distance: " + renderDistance); writer.newLine();
			writer.write("\tModel Relitive Center: " + center.x + ", " + center.y + ", " + center.z); writer.newLine();
			writer.newLine();
			
			writer.write(com + SBMFileFormat.IDENTIFIERS_REF[0]); writer.newLine();
			writer.write("\t" + format.positionID + " = " + SBMFileFormat.POSITION_REF[0]); writer.newLine();
			writer.write("\t" + format.texCoordID + " = " + SBMFileFormat.TEX_COORD_REF[0]); writer.newLine();
			writer.write("\t" + format.normalID + " = " + SBMFileFormat.NORMAL_REF[0]); writer.newLine();
			writer.newLine();

			writer.write(com + SBMFileFormat.POSITION_REF[0] + " " + SBMFileFormat.SPLIT_REF[0] + " '" + format.positionSpacer + "'"); writer.newLine();
			writer.write(com + SBMFileFormat.POSITION_REF[0] + " " + SBMFileFormat.SIZE_REF[0] + " " + format.positionSize); writer.newLine();
			writer.newLine();

			writer.write(com + SBMFileFormat.TEX_COORD_REF[0] + " " + SBMFileFormat.SPLIT_REF[0] + " '" + format.texCoordSpacer + "'"); writer.newLine();
			writer.write(com + SBMFileFormat.TEX_COORD_REF[0] + " " + SBMFileFormat.SIZE_REF[0] + " " + format.texCoordSize); writer.newLine();
			writer.newLine();

			writer.write(com + SBMFileFormat.NORMAL_REF[0] + " " + SBMFileFormat.SPLIT_REF[0] + " '" + format.normalSpacer + "'"); writer.newLine();
			writer.write(com + SBMFileFormat.NORMAL_REF[0] + " " + SBMFileFormat.SIZE_REF[0] + " " + format.normalSize); writer.newLine();
			writer.newLine();

			writer.write(com + SBMFileFormat.VERTEX_REF[0] + " " + SBMFileFormat.SPLIT_REF[0] + " '" + format.vertexSpacer + "'"); writer.newLine();
			writer.write(com + SBMFileFormat.VERTEX_REF[0] + " " + SBMFileFormat.FORMAT_REF[0]); writer.newLine();
			writer.write("\t"); for(VertexData data : format.vertexOrder) 
				switch(data) {
					case Normal: writer.write(format.normalID + " "); break;
					case Position: writer.write(format.positionID + " "); break;
					case TexCoord: writer.write(format.texCoordID + " "); break;
						
					default: break;
				}
			writer.newLine();
			writer.newLine();
			
			writer.write(com + SBMFileFormat.VERTEXS_REF[0]); writer.newLine();
			for(Vertex vertex : vertexs) {
				writer.write("\t" + getString(vertex, format));
				writer.newLine();
			} writer.newLine();

			writer.write(com + SBMFileFormat.FACE_REF[2] + " " + SBMFileFormat.GROUP_REF[0] + " '" + format.faceGroup + "'"); writer.newLine(); 
			writer.newLine();
			
			writer.write(com + SBMFileFormat.FACE_REF[0] + " " + SBMFileFormat.SPLIT_REF[0] + " '" + format.faceSplit + "'"); writer.newLine();
			writer.write(com + SBMFileFormat.FACE_REF[0]); writer.newLine(); writer.write("\t");
			for(int i = 0; i < indicies.size(); i++) {
				writer.write(indicies.get(i) + "");

				if(i % 3 == 2) {
					writer.newLine();
					writer.write("\t");
				} else {
					writer.write(format.faceSplit);
				}
			}

			writer.flush();
			writer.close();
			return outputFile;
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private static String getString(Vertex vertex, SBMFileFormat format) {
		String line = "", part = null;
		for(VertexData data : format.vertexOrder) { 
			part = "";
			
			switch(data) {
				case Normal:   
					part += vertex.getNormal().x + format.normalSpacer; 
					part += vertex.getNormal().y + format.normalSpacer; 
					part += vertex.getNormal().z + format.normalSpacer; 
				break;

				case Position: 
					part += vertex.getPosition().x + format.positionSpacer; 
					part += vertex.getPosition().y + format.positionSpacer; 
					part += vertex.getPosition().z + format.positionSpacer; 
				break;
					
				case TexCoord: 
					part += vertex.getTexCoord().x + format.texCoordSpacer; 
					part += vertex.getTexCoord().y + format.texCoordSpacer; 
				break;
					
				default: part = ""; break;
			}
			
			if(!part.equals(""))
				line += part.substring(0, part.length()-1) + format.vertexSpacer;
		}
		
		return line.substring(0, line.length() - format.vertexSpacer.length());
	}
	
	private static float[] toFloatArray(String[] strings) {
		float[] floats = new float[strings.length - 1];
		for(int i = 0; i < floats.length; i ++) {
			floats[i] = Float.parseFloat(strings[i + 1]);
		} return floats;
	}
}
