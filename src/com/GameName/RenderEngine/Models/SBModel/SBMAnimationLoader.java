package com.GameName.RenderEngine.Models.SBModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.GameName.RenderEngine.Models.SBModel.SBModelLoader.SBMFileFormat;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.Util.Vectors.Vector4f;

public class SBMAnimationLoader {
	public static HashMap<String, SBMAnimation> loadSBMAnimation(File file) throws IOException {
		if(!file.getAbsolutePath().toLowerCase().endsWith(".sbma")) throw new IOException("loadSBMAnimation can only load \"*.SBMA\" files!");
		
		SBMAFileFormat format = new SBMAFileFormat();
		BufferedReader read = new BufferedReader(new FileReader(file));
		String line = ""; String currentCommand = "";
		
		HashMap<SBMADataFormat, ArrayList<Vector4f>> dataMap = new HashMap<>();
		String dataSplit = SBMADataFormat.DEFAULT_SPLIT;
		String dataAccess = SBMADataFormat.DEFAULT_ACCESS;
		SBMADataFormat dataFormat = new SBMADataFormat();
		
		HashMap<String, SBMAnimation> animations = new HashMap<>();
		SBMAnimation workingAnimation;
		
		String animationName = "";
		int currentBoneIndex = 0;
		
		HashMap<Integer, Transform> frame = new HashMap<>();
		
		readLoop:
		while((line = read.readLine()) != null) {
			line = removeComments(line);
			line = line.trim();
			
			if(isType(line, SBMAFileFormat.COMMAND_CHAR)) {
				line = shrink(line, SBMAFileFormat.COMMAND_CHAR);
				
				if(isType(line, SBMAFileFormat.IDENTIFIERS_REF)) { 
					currentCommand = "identifiers";					
					continue;
				}
				
				if(isType(line, SBMAFileFormat.BONE_REF)) {
					line = shrink(line, SBMAFileFormat.BONE_REF);
										
					if(isType(line, SBMAFileFormat.SPLIT_REF)) {
						line = shrink(line, SBMAFileFormat.SPLIT_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMAFileFormat.VALID_SEPARATORS)) {
							format.boneSplit = line;
						}
						
						continue;
					}
				}
				
				if(isType(line, SBMAFileFormat.ANIMATION_REF)) {
					line = shrink(line, SBMAFileFormat.ANIMATION_REF);
					
					if(isType(line, SBMAFileFormat.SPLIT_REF)) {
						line = shrink(line, SBMAFileFormat.SPLIT_REF);
						
						if(isType(line, SBMAFileFormat.PART_REF)) {
							line = shrink(line, SBMAFileFormat.PART_REF);
							line = line.replace("'", "");
							
							if(onlyContains(line, SBMAFileFormat.VALID_SEPARATORS)) {
								format.animationPartSplit = line;							
								continue;
							}
							
							continue;
						}

						if(isType(line, SBMAFileFormat.DATA_REF)) {
							line = shrink(line, SBMAFileFormat.DATA_REF);
							line = line.replace("'", "");
							
							if(onlyContains(line, SBMAFileFormat.VALID_SEPARATORS)) {
								format.animationDataSplit = line;							
								continue;
							}
							
							continue;
						}
						
						if(isType(line, SBMAFileFormat.FRAME_REF)) {
							line = shrink(line, SBMAFileFormat.FRAME_REF);
							line = line.replace("'", "");
							
							if(onlyContains(line, SBMAFileFormat.VALID_SEPARATORS)) {
								format.animationFrameSplit = line;							
								continue;
							}
							
							continue;
						}
						
						continue;
					}
					
					workingAnimation = new SBMAnimation(line);
					animations.put(line, workingAnimation);
					animationName = line;
					currentCommand = "storingAnimation";
					
					continue;
				}
				
				if(isType(line, SBMAFileFormat.DATA_REF)) {
					line = shrink(line, SBMAFileFormat.DATA_REF);
					
					if(isType(line, SBMAFileFormat.SPLIT_REF)) {
						line = shrink(line, SBMAFileFormat.SPLIT_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMAFileFormat.VALID_SEPARATORS)) {
							dataSplit = line;							
							continue;
						}
						
						continue;
					}
					
					if(isType(line, SBMAFileFormat.ACCESS_REF)) {
						line = shrink(line, SBMAFileFormat.ACCESS_REF);
						line = line.replace("'", "");
						
						if(onlyContains(line, SBMAFileFormat.VALID_SEPARATORS)) {
							dataAccess = line;							
							continue;
						}
						
						continue;
					}
					
					dataFormat = new SBMADataFormat(dataSplit, dataAccess, line);
					dataMap.put(dataFormat, new ArrayList<Vector4f>());
					currentCommand = "dataStore";
					
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
					
					if(isType(splits[1], SBMAFileFormat.TRANSLATION_REF)) {
						format.translationID = splits[0]; continue; }

					if(isType(splits[1], SBMAFileFormat.ROTATION_REF)) {
						format.rotationID = splits[0]; continue; }

					if(isType(splits[1], SBMAFileFormat.SCALE_REF)) {
						format.scaleID = splits[0]; continue; }

					if(isType(splits[1], SBMAFileFormat.BONE_REF)) {
						format.boneID = splits[0]; continue; }
				}
				
				if(currentCommand.equals("dataStore")) {
					String[] splits = line.split(dataFormat.split);
					for(int i = 0; i < splits.length; i++) { 
						splits[i] = splits[i].trim();
					}  
					
					float[] floats = new float[4];
					for(int i = 0; i < Math.min(floats.length, splits.length); i++) {
						if(splits[i].length() < 1) continue;
						try { floats[i] = Float.parseFloat(splits[i]); }
						catch(NumberFormatException e) { e.printStackTrace(); continue readLoop; }
					}
					
					dataMap.get(dataFormat).add(new Vector4f(floats));
				}
				
				if(currentCommand.equals("storingAnimation")) {
					String[] splits = line.split(format.animationPartSplit);
					for(int i = 0; i < splits.length; i++) { 
						splits[i] = splits[i].trim();
					}  
					
					for(String split : splits) {
						if(split.equals(format.animationFrameSplit)) {
							animations.get(animationName).addFrame(frame);
							frame = new HashMap<>();
							continue;
						}
						
						if(split.startsWith(format.boneID)) {
							String index = split.split(format.boneSplit)[1].trim();
							currentBoneIndex = Integer.parseInt(index);
							frame.put(currentBoneIndex, new Transform().reset());
							continue;
						}
						
						if(split.startsWith(format.translationID)) {
							String dataGroup = split.split(format.animationDataSplit)[1].trim();
							SBMADataFormat dataForm = getSBMAFormat(dataGroup, dataMap.keySet());
							
							Vector4f selectedData = dataMap.get(dataForm).get(Integer.parseInt(dataGroup.split(dataForm.access)[1]));
							frame.get(currentBoneIndex).translate(new Vector3f(selectedData.x, selectedData.y, selectedData.z));
							continue;
						}
						
						if(split.startsWith(format.rotationID)) {
							String dataGroup = split.split(format.animationDataSplit)[1].trim();
							SBMADataFormat dataForm = getSBMAFormat(dataGroup, dataMap.keySet());
							
							Vector4f selectedData = dataMap.get(dataForm).get(Integer.parseInt(dataGroup.split(dataForm.access)[1]));
							frame.get(currentBoneIndex).rotate(new Vector3f(selectedData.x, selectedData.y, selectedData.z));
							continue;
						}
						
						if(split.startsWith(format.scaleID)) {
							String dataGroup = split.split(format.animationDataSplit)[1].trim();
							SBMADataFormat dataForm = getSBMAFormat(dataGroup, dataMap.keySet());
							
							Vector4f selectedData = dataMap.get(dataForm).get(Integer.parseInt(dataGroup.split(dataForm.access)[1]));
							frame.get(currentBoneIndex).scale(new Vector3f(selectedData.x, selectedData.y, selectedData.z));
							continue;
						}
					}
				}
			}
		}
		
		read.close();
		return animations;
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
				
				if(commentCheck.equals(SBMAFileFormat.COMMENT))
					break;
				
				if(commentCheck.equals(SBMAFileFormat.COMMENT_OPEN))
					inComment = true;
				else if(commentCheck.equals(SBMAFileFormat.COMMENT_CLOSE))
					inComment = false;
			}
			
			if(!inComment)
				noComments += line.charAt(i);
		}
		
		return noComments;
	}
	
	private static SBMADataFormat getSBMAFormat(String dataGroup, Set<SBMADataFormat> set) {
		String dataAdd = "";
		for(int i = 0; i < dataGroup.length(); i++) {
			if(onlyContains(dataGroup.charAt(i)+"", SBMAFileFormat.VALID_SEPARATORS)) break;
			dataAdd += dataGroup.charAt(i);
		}
		
		for(SBMADataFormat dataFormat : set) {
			String section = "";
			for(char c : dataFormat.name.toCharArray()) {
				section += c;
				if(section.equals(dataAdd)) {
					return dataFormat;
				}
			}
		}
		
		return null;
	}
	
	public static class SBMAFileFormat extends SBMFileFormat {
		public static final String[] DATA_REF = {"Data"};
		public static final String[] ACCESS_REF = {"Access"};
		
		public static final String[] TRANSLATION_REF = {"Translation"};
		public static final String[] ROTATION_REF = {"Rotation"};
		public static final String[] SCALE_REF = {"Scale"};
		
		public static final String[] ANIMATION_REF = {"Animation"};
		public static final String[] PART_REF = {"Part"};
		public static final String[] FRAME_REF = {"Frame"};
		
		static {
			for(int i=0;i<DATA_REF.length;i++) DATA_REF[i] = DATA_REF[i].toLowerCase();
			for(int i=0;i<ACCESS_REF.length;i++) ACCESS_REF[i] = ACCESS_REF[i].toLowerCase();

			for(int i=0;i<TRANSLATION_REF.length;i++) TRANSLATION_REF[i] = TRANSLATION_REF[i].toLowerCase();
			for(int i=0;i<ROTATION_REF.length;i++) ROTATION_REF[i] = ROTATION_REF[i].toLowerCase();
			for(int i=0;i<SCALE_REF.length;i++) SCALE_REF[i] = SCALE_REF[i].toLowerCase();
			
			for(int i=0;i<ANIMATION_REF.length;i++) ANIMATION_REF[i] = ANIMATION_REF[i].toLowerCase();
			for(int i=0;i<PART_REF.length;i++) PART_REF[i] = PART_REF[i].toLowerCase();
			for(int i=0;i<FRAME_REF.length;i++) FRAME_REF[i] = FRAME_REF[i].toLowerCase();
		}

		public static final String DEFAULT_TRANSLATION_ID = "t";
		public static final String DEFAULT_ROTATION_ID = "r";
		public static final String DEFAULT_SCALE_ID = "s";
		public static final String DEFAULT_BONE_ID = "b";
		
		public static final String DEFAULT_ANIMATION_PART_SPLIT = " ";
		public static final String DEFAULT_ANIMATION_DATA_SPLIT = "->";
		public static final String DEFAULT_ANIMATION_FRAME_SPLIT = ";";
		
		public String translationID = DEFAULT_TRANSLATION_ID;
		public String rotationID = DEFAULT_ROTATION_ID;
		public String scaleID = DEFAULT_SCALE_ID;
		public String boneID = DEFAULT_BONE_ID;
		
		public String animationPartSplit = null;
		public String animationDataSplit = null;
		public String animationFrameSplit = null;
	}
	
	public static class SBMADataFormat {
		public static final String DEFAULT_SPLIT = " ";
		public static final String DEFAULT_ACCESS = ":";
		
		public String split = DEFAULT_SPLIT;
		public String access = DEFAULT_ACCESS;
		public String name;
		
		public SBMADataFormat() {}		
		public SBMADataFormat(String split, String access, String name) {
			this.split = split;
			this.access = access;
			this.name = name;
		}
	}
}
