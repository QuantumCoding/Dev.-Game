package com.GameName.RenderEngine.Models.SBModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.GameName.RenderEngine.Models.ModelLoader;
import com.GameName.RenderEngine.Models.ModelData.BufferedModelData;
import com.GameName.RenderEngine.Models.SBModel.SBMAnimation.Bone;
import com.GameName.RenderEngine.Models.SBModel.SBModelLoader.SBMFileFormat.VertexData;
import com.GameName.Util.Vectors.Vector3f;

public class SBModelLoader {
	public static SBModel loadSBM(File file) throws IOException {
		if(!file.getAbsolutePath().toLowerCase().endsWith(".sbm"))
			throw new IOException("loadSBM can only load \"*.SBM\" files!");
	
		float renderRadius = 10.0f;
		float renderDistance = 1000.0f;
		Vector3f modelCenter = new Vector3f();
		
		SBMFileFormat format = new SBMFileFormat();
		BufferedReader read = new BufferedReader(new FileReader(file));
		String line = ""; String currentCommand = "";
		VertexData storeType = null;
		
		ArrayList<Float> vertices = new ArrayList<>();
		ArrayList<Float> texCoords = new ArrayList<>();
		ArrayList<Float> normals = new ArrayList<>();
		ArrayList<Float> colors = new ArrayList<>();
		
		ArrayList<Integer> indices = new ArrayList<>();
		ArrayList<Integer> faces = null;
		ArrayList<Integer> facesOrder = null;
		int faceGroupSize = 0;
		
		ArrayList<Bone> bones = new ArrayList<>();
		
		readLoop:
		while((line = read.readLine()) != null) {
			line = removeComments(line);
			line = line.trim();
			
			if(line.startsWith(SBMFileFormat.COMMAND_CHAR)) { 
				line = shrink(line, SBMFileFormat.COMMAND_CHAR);

				if(isType(line, SBMFileFormat.VERTEXS_REF)) {
					currentCommand = "vertxes";
					
					if(format.positionSpacer == null)
						format.positionSpacer = SBMFileFormat.DEFAULT_POSIOTION_SPACER;
					
					if(format.texCoordSpacer == null)
						format.texCoordSpacer = SBMFileFormat.DEFAULT_TEX_COORD_SPACER;
					
					if(format.normalSpacer == null)
						format.normalSpacer = SBMFileFormat.DEFAULT_NORMAL_SPACER;
					
					if(format.colorSpacer == null)
						format.colorSpacer = SBMFileFormat.DEFAULT_COLOR_SPACER;
					
					if(format.faceSplit == null)
						format.faceSplit = SBMFileFormat.DEFAULT_FACE_SPACER;
					
					if(format.vertexSpacer == null)
						format.vertexSpacer = SBMFileFormat.DEFAULT_VERTEX_SPACER;
					
					continue;
				}
				
		// =========================== Types ===============================================================================
				VertexData type = getType(line);
				if(type != null) { 
					switch(type) {
						case Color: line = shrink(line, SBMFileFormat.COLOR_REF); break;
						case Normal: line = shrink(line, SBMFileFormat.NORMAL_REF); break;
						case Position: line = shrink(line, SBMFileFormat.POSITION_REF); break;
						case TexCoord: line = shrink(line, SBMFileFormat.TEX_COORD_REF); break;
						case Vertex: line = shrink(line, SBMFileFormat.VERTEX_REF); break; 
					}
					
					if(isType(line, SBMFileFormat.FORMAT_REF)) { 
						storeType = type;
						currentCommand = "format";
						continue;
					}
					
					if(isType(line, SBMFileFormat.SIZE_REF)) {
						line = shrink(line, SBMFileFormat.SIZE_REF);
						
						try {
							switch(type) {
								case Color: format.colorSize = Integer.parseInt(line); break;
								case Normal: format.normalSize = Integer.parseInt(line); break;
								case Position: format.positionSize = Integer.parseInt(line); break;
								case TexCoord: format.texCoordSize = Integer.parseInt(line); break;
								
								default: break;
							}
						} catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
						
						continue;
					}
					
					if(isType(line, SBMFileFormat.SPLIT_REF)) { 
						line = shrink(line, SBMFileFormat.SPLIT_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMFileFormat.VALID_SEPARATORS)) {
							switch(type) {
								case Color: 
									if(format.colorSpacer == null)
										format.colorSpacer = line; 
									continue;
									
								case Normal: 
									if(format.normalSpacer == null) 
										format.normalSpacer = line; 
									continue;
									
								case Position: 
									if(format.positionSpacer == null) 
										format.positionSpacer = line; 
									continue;
									
								case TexCoord: 
									if(format.texCoordSpacer == null) 
										format.texCoordSpacer = line; 
									continue;
									
								case Vertex: 
									if(format.vertexSpacer == null) 
										format.vertexSpacer = line; 
									continue;
								
								default: continue;
							}
						}
						
						continue;
					}
				}
				
		// ========================= Others ================================================================================
				if(isType(line, SBMFileFormat.BONE_REF)) {
					line = shrink(line, SBMFileFormat.BONE_REF);
					
					if(isType(line, SBMFileFormat.COUNT_REF)) {
						line = shrink(line, SBMFileFormat.COUNT_REF);
						bones = new ArrayList<>();
						try {
							for(int i = 0; i < Integer.parseInt(line); i++) { 
								bones.add(new Bone());
							}
						} catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
						
						continue;
					}
					
					if(isType(line, SBMFileFormat.SPLIT_REF)) {
						line = shrink(line, SBMFileFormat.SPLIT_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMFileFormat.VALID_SEPARATORS)) {
							format.boneSplit = line;
						}
						
						continue;
					}
					
					if(isType(line, SBMFileFormat.PARENT_REF)) {
						if(format.boneSplit == null)
							format.boneSplit = SBMFileFormat.DEFAULT_BONE_SPACER;
						
						currentCommand = "parent";
						continue;
					}
					
					if(isType(line, SBMFileFormat.WEIGHT_REF)) {
						if(format.boneSplit == null)
							format.boneSplit = SBMFileFormat.DEFAULT_BONE_SPACER;
						
						currentCommand = "weight";
						continue;
					}
					
					continue;
				}
				
				if(isType(line, SBMFileFormat.IDENTIFIERS_REF)) { 
					currentCommand = "identifiers";					
					continue;
				}
				
				if(isType(line, SBMFileFormat.FACE_REF)) { 
					line = shrink(line, SBMFileFormat.FACE_REF);
					
					if(isType(line, SBMFileFormat.ORDER_REF)) { 
						line = shrink(line, SBMFileFormat.ORDER_REF);
						
						if(isType(line, SBMFileFormat.SPLIT_REF)) { 
							line = shrink(line, SBMFileFormat.SPLIT_REF);
							line = line.replace("'", "");
							
							if(onlyContains(line, SBMFileFormat.VALID_SEPARATORS)) {
								format.faceOrder = line;
							}
							
							continue;
						}	
						
						facesOrder = new ArrayList<>();
						currentCommand = "indicesGroup";	
						continue;
					}
					
					if(isType(line, SBMFileFormat.SPLIT_REF)) { 
						line = shrink(line, SBMFileFormat.SPLIT_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMFileFormat.VALID_SEPARATORS)) {
							format.faceSplit = line;
						}
						
						continue;
					}	
					
					if(isType(line, SBMFileFormat.GROUP_REF)) { 
						line = shrink(line, SBMFileFormat.GROUP_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMFileFormat.VALID_SEPARATORS)) {
							format.faceGroup = line;
							faces = new ArrayList<>();
						}
						
						continue;
					}	
					
					currentCommand = "indices";					
					continue;
				}
			}
			
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Command
			if(currentCommand != null && !currentCommand.equals("")) {
				if(currentCommand.equals("identifiers")) {
					String[] splits = line.split("=");
					if(splits.length < 2) continue;
					
					for(int i = 0; i < splits.length; i++) { 
						splits[i] = splits[i].trim();
					}
					
					switch(getType(splits[1])) {
						case Color: format.colorID = splits[0]; continue;
						case Normal: format.normalID = splits[0]; continue;
						case Position: format.positionID = splits[0]; continue;
						case TexCoord: format.texCoordID = splits[0]; continue;
						
						default: continue; 
					}
				}
				
				if(currentCommand.equals("format")) {
					line = replace(line, " ", SBMFileFormat.VALID_SEPARATORS);
					String[] splits = line.split(" ");
					for(int i = 0; i < splits.length; i++) { 
						splits[i] = splits[i].trim();
					}
					
					if(storeType == VertexData.Vertex) {
						VertexData[] order = new VertexData[splits.length];
						for(int i = 0; i < splits.length; i++) {
							String split = splits[i];
							
							if(split.equals(format.positionID)) 
								order[i] = VertexData.Position;
							else if(split.equals(format.texCoordID)) 
								order[i] = VertexData.TexCoord;
							else if(split.equals(format.normalID)) 
								order[i] = VertexData.Normal;
							else if(split.equals(format.colorID)) 
								order[i] = VertexData.Color;
							else continue readLoop;
						}
						
						format.vertexOrder = order;
						continue;
					}
					
					continue;
				}
				
				if(currentCommand.equals("vertxes")) {
					String[] splits = line.split(format.vertexSpacer);
					
					try {
						for(int i = 0; i < splits.length; i++) {
							if(format.vertexOrder[i] == VertexData.Position) {
								String[] splits2 = splits[i].split(format.positionSpacer);
								for(String part : splits2) { if(part.length() < 1) continue;
									vertices.add(Float.parseFloat(part));
								}
								
								continue;
							}
							
							if(format.vertexOrder[i] == VertexData.TexCoord) {
								String[] splits2 = splits[i].split(format.texCoordSpacer);
								for(String part : splits2) { if(part.length() < 1) continue;
									texCoords.add(Float.parseFloat(part));
								}
								
								continue;
							}
							
							if(format.vertexOrder[i] == VertexData.Normal) {
								String[] splits2 = splits[i].split(format.normalSpacer);
								for(String part : splits2) { if(part.length() < 1) continue;
									normals.add(Float.parseFloat(part));
								}
								
								continue;
							}
							
							if(format.vertexOrder[i] == VertexData.Color) {
								String[] splits2 = splits[i].split(format.colorSpacer);
								for(String part : splits2) { if(part.length() < 1) continue;
									colors.add(Float.parseFloat(part));
								}
								
								continue;
							}
						}
					} catch(IndexOutOfBoundsException | NumberFormatException e) { e.printStackTrace(); continue readLoop; }
					
					continue;
				}
				
				if(currentCommand.equals("parent")) {
					String[] splits = line.split(format.boneSplit);
					if(splits.length < 2) continue;
					
					for(int i = 0; i < splits.length; i++) { 
						splits[i] = splits[i].trim();
					}
					
					try {
						bones.get(Integer.parseInt(splits[0])).setParent(bones.get(Integer.parseInt(splits[1])));
					} catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
					
					continue;
				}
				
				if(currentCommand.equals("weight")) {
					String[] splits = line.split(format.boneSplit);
					if(splits.length < 3) continue;
					
					for(int i = 0; i < splits.length; i++) { 
						splits[i] = splits[i].trim();
					}
					
					try {
						bones.get(Integer.parseInt(splits[0])).addVertice(
								Integer.parseInt(splits[1]), Float.parseFloat(splits[2]));
						
					} catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
					
					continue;
				}
				
				if(currentCommand.equals("indices")) {
					String[] splits = line.split(format.faceSplit);
					for(String split : splits) {
						if(split.trim().equals("")) continue;
						
						if(split.equals(format.faceGroup)) {
							if(faces != null) {
								faces.add(faceGroupSize);
								faceGroupSize = 0;
							}
							
							continue;
						}
						
						try { indices.add(Integer.parseInt(split)); } 
						catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
						faceGroupSize ++;
					}
				}
				
				if(currentCommand.equals("indicesGroup")) {
					String[] splits = line.split(format.faceOrder);
					
					for(String split : splits) {
						if(split.trim().equals("")) continue;	
						try { facesOrder.add(Integer.parseInt(split)); } 
						catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
					}
				}
				
				continue;
			}
			
			if(line.contains("Render Radius:")) {
				line = line.substring(line.indexOf("Render Radius:") + "Render Radius:".length() + 1);
				String rawRadius = line.split(",")[0];
				rawRadius = rawRadius.trim();
				renderRadius = Float.parseFloat(rawRadius);
			}
			
			if(line.contains("Render Distance:")) {
				line = line.substring(line.indexOf("Render Distance:") + "Render Distance:".length() + 1);
				String rawDistance = line;
				rawDistance = rawDistance.trim();
				renderDistance = Float.parseFloat(rawDistance);
			}
			
			if(line.contains("Model Relitive Center:")) {
				String[] centerParts = line.substring(line.indexOf("Model Relitive Center") + 
						"Model Relitive Center:".length() + 1).trim().split(",");
				modelCenter = new Vector3f(Float.parseFloat(centerParts[0].trim()), 
						Float.parseFloat(centerParts[1].trim()), Float.parseFloat(centerParts[2].trim()));
			}
		}
		
		read.close();
		
		int[] indicesArray = new int[indices.size()];
		float[] verticesArray = new float[vertices.size()];
		float[] texCoordsArray = new float[texCoords.size()];
		float[] normalsArray = new float[normals.size()];
		
		for(int i=0;i<indicesArray.length;i++) indicesArray[i]=indices.get(i);
		for(int i=0;i<verticesArray.length;i++) verticesArray[i]=vertices.get(i);
		for(int i=0;i<texCoordsArray.length;i++) texCoordsArray[i]=texCoords.get(i);
		for(int i=0;i<normalsArray.length;i++) normalsArray[i]=normals.get(i);
		
		BufferedModelData modelData = ModelLoader.loadBufferedModel(verticesArray, texCoordsArray, normalsArray, 
				indicesArray, renderRadius, renderDistance, modelCenter, 10);
		
		SBModel model = new SBModel(modelData);
		for(Bone bone : bones) model.addBone(bone);
		
		if(facesOrder != null && faces != null) {
			boolean facesOrdered = faces.size() == facesOrder.size();
			int[][] faceIndexMap = new int[faces.size()][facesOrdered ? 3 : 2];
			int i = 0, currentPos = 0;
			for(Integer indexCount : faces) {
				faceIndexMap[i][0] = currentPos;
				faceIndexMap[i][1] = indexCount;
				if(facesOrdered) 
					faceIndexMap[i][2] = facesOrder.indexOf(i);
				currentPos += indexCount; i ++;
			} model.setFaces(faceIndexMap);
		}
		
		return model; 
	}
	
	private static boolean isType(String check, String... types) {
		for(String type : types) {
			if(check.toLowerCase().contains(type))
				return true;
		}
		
		return false;
	}
	
	private static String shrink(String toShrink, String... skips) {
		String[] splits = toShrink.split(" ");
		for(int i = 0; i < splits.length; i ++) {
			for(String skip : skips) {
				if(splits[i].toLowerCase().equals(skip)) {
					String end = "";
					for(int j = i+1; j < splits.length; j ++)
						end += splits[j] + " ";
					return end.trim();
				}
			}
		}
		
		return "";
	}
	
	private static String replace(String line, String replaceWith, char... toReplace) {
		String[] strings = new String[toReplace.length];
		for(int i = 0; i < strings.length; i++) {
			strings[i] = toReplace[i] + "";
		} return replace(line, replaceWith, strings);
	}
	
	private static String replace(String line, String replaceWith, String... toReplace) {
		String replaced = line + "";
		for(String replacing : toReplace) {
			replaced = replaced.replace(replacing, replaceWith);
		} return replaced;
	}
	
	private static VertexData getType(String line) {
		if(isType(line, SBMFileFormat.POSITION_REF)) 
			return VertexData.Position;
		
		
		if(isType(line, SBMFileFormat.TEX_COORD_REF)) 
			return VertexData.TexCoord;
		
		
		if(isType(line, SBMFileFormat.NORMAL_REF)) 
			return VertexData.Normal;
		
		
		if(isType(line, SBMFileFormat.COLOR_REF))  
			return VertexData.Color;
		
		
		if(isType(line, SBMFileFormat.VERTEX_REF)) 
			return VertexData.Vertex;
		
		return null;
	}
	
	private static boolean onlyContains(String line, char... contains) {
		outer:
		for(char c : line.toCharArray()) {
			for(char compare : contains) {
				if(c == compare) continue outer;
			}
			
			return false;
		}
	
		return true;
	}
	
	private static String removeComments(String line) {
		String noComments = "";
		boolean inComment = false;
		for(int i = 0; i < line.length(); i++) {
			if(i + 1 < line.length()) {
				String commentCheck = line.substring(i, i + 2);
				
				if(commentCheck.equals(SBMFileFormat.COMMENT))
					break;
				
				if(commentCheck.equals(SBMFileFormat.COMMENT_OPEN))
					inComment = true;
				else if(commentCheck.equals(SBMFileFormat.COMMENT_CLOSE))
					inComment = false;
			}
			
			if(!inComment)
				noComments += line.charAt(i);
		}
		
		return noComments;
	}
	
	public static class SBMFileFormat {
		public static final String COMMAND_CHAR = "#";
		public static final String[] IDENTIFIERS_REF = {"Identifiers", "Ids", "Identifier", "id"};
		public static final String[] FORMAT_REF = {"Format"};
		public static final String[] SIZE_REF = {"Size"};
		public static final String[] SPLIT_REF = {"Split", "Spacer", "Space"};
		
		public static final String[] POSITION_REF = {"position"};		
		public static final String[] TEX_COORD_REF = {
			"textureCoords", "texCoords", "texture_coords","tex_Coordinates", "texture", 
			"textureCoordinates", "texCoordinates", "texture_Coordinates", "texCoords"
		};		
		public static final String[] NORMAL_REF = {"normal"};
		public static final String[] COLOR_REF = {"color", "colour"};
		
		public static final String[] VERTEX_REF = {"Vertex"};
		public static final String[] VERTEXS_REF = {"Vertexes", "Vertices", "Positions"};
		public static final String[] FACE_REF = {"Indices", "Indice", "Faces", "Face"};
		public static final String[] GROUP_REF = {"Group", "Set"};
		public static final String[] ORDER_REF = {"Order"};
		
		public static final String[] BONE_REF = {"Bone"};
		public static final String[] WEIGHT_REF = {"Weight"};
		public static final String[] COUNT_REF = {"Count"};
		public static final String[] PARENT_REF = {"Parents", "Parent"};
		
		public static final char[] VALID_SEPARATORS = {',', ' ', '/', '\\', '-', '~', ':', ';', '<', '>', '|'};
		
		public static final String COMMENT = "//";
		public static final String COMMENT_OPEN  = "/*";
		public static final String COMMENT_CLOSE = "*/";
		
		static {
			for(int i=0;i<IDENTIFIERS_REF.length;i++) IDENTIFIERS_REF[i] = IDENTIFIERS_REF[i].toLowerCase();
			for(int i=0;i<FORMAT_REF.length;i++) FORMAT_REF[i] = FORMAT_REF[i].toLowerCase();
			for(int i=0;i<SIZE_REF.length;i++) SIZE_REF[i] = SIZE_REF[i].toLowerCase();
			for(int i=0;i<SPLIT_REF.length;i++) SPLIT_REF[i] = SPLIT_REF[i].toLowerCase();
			
			for(int i=0;i<POSITION_REF.length;i++) POSITION_REF[i] = POSITION_REF[i].toLowerCase();
			for(int i=0;i<TEX_COORD_REF.length;i++) TEX_COORD_REF[i] = TEX_COORD_REF[i].toLowerCase();
			for(int i=0;i<NORMAL_REF.length;i++) NORMAL_REF[i] = NORMAL_REF[i].toLowerCase();
			for(int i=0;i<COLOR_REF.length;i++) COLOR_REF[i] = COLOR_REF[i].toLowerCase();
			
			for(int i=0;i<VERTEX_REF.length;i++) VERTEX_REF[i] = VERTEX_REF[i].toLowerCase();	
			for(int i=0;i<VERTEXS_REF.length;i++) VERTEXS_REF[i] = VERTEXS_REF[i].toLowerCase();	
			for(int i=0;i<FACE_REF.length;i++) FACE_REF[i] = FACE_REF[i].toLowerCase();		
			for(int i=0;i<GROUP_REF.length;i++) GROUP_REF[i] = GROUP_REF[i].toLowerCase();		
			for(int i=0;i<ORDER_REF.length;i++) ORDER_REF[i] = ORDER_REF[i].toLowerCase();		
			
			for(int i=0;i<BONE_REF.length;i++) BONE_REF[i] = BONE_REF[i].toLowerCase();	
			for(int i=0;i<WEIGHT_REF.length;i++) WEIGHT_REF[i] = WEIGHT_REF[i].toLowerCase();
			for(int i=0;i<COUNT_REF.length;i++) COUNT_REF[i] = COUNT_REF[i].toLowerCase();	
			for(int i=0;i<PARENT_REF.length;i++) PARENT_REF[i] = PARENT_REF[i].toLowerCase();	
		}
		
		public static final String DEFAULT_POSIOTION_ID = "p";
		public static final String DEFAULT_TEX_COORD_ID = "tc";
		public static final String DEFAULT_NORMAL_ID = "n";
		public static final String DEFAULT_COLOR_ID = "c";
		public static final String DEFAULT_VERTEX_ID = "v";

		public static final String DEFAULT_POSIOTION_SPACER = " ";
		public static final String DEFAULT_TEX_COORD_SPACER = " ";
		public static final String DEFAULT_NORMAL_SPACER = " ";
		public static final String DEFAULT_COLOR_SPACER = " ";
		public static final String DEFAULT_VERTEX_SPACER = " / ";
		public static final String DEFAULT_FACE_GROUP = ";";
		public static final String DEFAULT_FACE_ORDER = " ";
		public static final String DEFAULT_FACE_SPACER = " ";
		public static final String DEFAULT_BONE_SPACER = ":";

		public static final int DEFAULT_POSIOTION_SIZE = 3;
		public static final int DEFAULT_TEX_COORD_SIZE = 2;
		public static final int DEFAULT_NORMAL_SIZE = 3;
		public static final int DEFAULT_COLOR_SIZE = 4;
		public static final VertexData[] DEFAULT_VERTEX_ORDER = {
			VertexData.Position, VertexData.TexCoord, VertexData.Normal, VertexData.Color
		};
		
		public String positionID = DEFAULT_POSIOTION_ID;		public String texCoordID = DEFAULT_TEX_COORD_ID;    
		public String positionSpacer = null;					public String texCoordSpacer = null;
		public int positionSize = DEFAULT_POSIOTION_SIZE;		public int texCoordSize = DEFAULT_TEX_COORD_SIZE;  

		public String normalID = DEFAULT_NORMAL_ID;				public String colorID = DEFAULT_COLOR_ID;    
		public String normalSpacer = null;						public String colorSpacer = null;
		public int normalSize = DEFAULT_NORMAL_SIZE;			public int colorSize = DEFAULT_COLOR_SIZE;  

		public String vertexSpacer = null;						public String faceSplit = null;
		public VertexData[] vertexOrder = DEFAULT_VERTEX_ORDER;	public String boneSplit = null;
		public String faceGroup = null;							public String faceOrder = null;
		
		public void setDefault() {
			positionID = DEFAULT_POSIOTION_ID;			texCoordID = DEFAULT_TEX_COORD_ID;    
			positionSpacer = DEFAULT_POSIOTION_SPACER;	texCoordSpacer = DEFAULT_TEX_COORD_SPACER;
			positionSize = DEFAULT_POSIOTION_SIZE;	texCoordSize = DEFAULT_TEX_COORD_SIZE;  

			normalID = DEFAULT_NORMAL_ID;				colorID = DEFAULT_COLOR_ID;    
			normalSpacer = DEFAULT_NORMAL_SPACER;		colorSpacer = DEFAULT_COLOR_SPACER;
			normalSize = DEFAULT_NORMAL_SIZE;			colorSize = DEFAULT_COLOR_SIZE;  

			vertexSpacer = DEFAULT_VERTEX_SPACER;		faceSplit = DEFAULT_FACE_SPACER;
			vertexOrder = DEFAULT_VERTEX_ORDER;			boneSplit = DEFAULT_BONE_SPACER;
			faceGroup = DEFAULT_FACE_GROUP;				faceOrder = DEFAULT_FACE_ORDER;
		}
		
		public static enum VertexData {
			Position, TexCoord, Normal, Color, Vertex
		}
	}
}
