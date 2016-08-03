package com.GameName.RenderEngine.Text;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.Util.ResourceAccess;
import com.GameName.Util.Vectors.Vector2f;

public class FontLoader {
	public static final String BOLD_EXT = "_Bold";
	public static final String ITALIC_EXT = "_Italic";
	
	public static final String FONT_EXT = ".fnt";
	
	private static final String INTO_SEPORATOR = " ";
	private static final String DATA_SEPORATOR = "=";
	private static final String LIST_SEPORATOR = ",";
	
	// Load Characters
	// Load Image
	
	// Image Size
	
	// Font Info:
	//	 Name
	//	 Style
	
	public Font loadFont(String font) {
		return loadFont(font, font + BOLD_EXT, font + ITALIC_EXT, font + BOLD_EXT + ITALIC_EXT);
	}
	
	public Font loadFont(String... fontStyles) {
		HashMap<FontStyle, HashMap<Integer, Character>> characters = new HashMap<>();
		BufferedImage[] fontImages = new BufferedImage[FontStyle.values().length];
		int fontImageIndex = 0, imageWidth = 0, imageHeight = 0;
		
		for(String fontFile : fontStyles) {
			try(BufferedReader in = new BufferedReader(ResourceAccess.openInputStreamReader(fontFile + FONT_EXT))) {
				HashMap<String, int[]> keyPairs = null;
				
				// File Reading Info
				keyPairs = getKeyPairs(in.readLine());
				FontStyle style = FontStyle.getStyle(keyPairs.get("bold")[0] != 0, keyPairs.get("italic")[0] != 0);
				int[] padding = keyPairs.get("padding");
				
				// Image Info
				keyPairs = getKeyPairs(in.readLine());
				imageWidth  = keyPairs.get("scaleW")[0];
				imageHeight = keyPairs.get("scaleH")[0];
				Vector2f imageSize = new Vector2f(imageWidth, imageHeight);
				
				keyPairs = getKeyPairs(in.readLine());
				String imageName = constructString(keyPairs.get("file"));
				
				// Character Size
				keyPairs = getKeyPairs(in.readLine());
				int characterCount = keyPairs.get("count")[0];
				
				// Characters				
				HashMap<Integer, Character> charecterMap = new HashMap<>();
				for(int i = 0; i < characterCount; i ++) {
					keyPairs = getKeyPairs(in.readLine());
					Character character = new Character(style, 
							keyPairs.get("id")[0], 
							keyPairs.get("width")[0]  - padding[2], 
							keyPairs.get("height")[0] - padding[3], 
							keyPairs.get("x")[0] - padding[0], 
							keyPairs.get("y")[0] - padding[1], 
							keyPairs.get("xoffset")[0], 
							keyPairs.get("yoffset")[0], 
							keyPairs.get("xadvance")[0],
							imageSize
						);
					
					charecterMap.put(character.getId(), character);
				}
				
				characters.put(style, charecterMap);
				
				fontFile = fontFile.replace("\\", "/");
				fontImages[fontImageIndex ++] = ImageIO.read(ResourceAccess.openInputStream(
						fontFile.substring(0, fontFile.lastIndexOf("/")) + "/" + imageName));
				
			} catch(IOException | NullPointerException e) {
				System.err.println("Could not load \"" + ResourceAccess.ROOT_PATH + fontFile + FONT_EXT + "\"");
			}
			
		}
		
		BufferedImage compositeImage = new BufferedImage(
				(fontImageIndex > 1 ? 2 : 1) * imageWidth, 
				(fontImageIndex > 2 ? 2 : 1) * imageHeight, 
				BufferedImage.TYPE_INT_ARGB
			);
		
		Graphics g = compositeImage.getGraphics();
		
		if(fontImageIndex > 0) g.drawImage(fontImages[0], 0, 0, null);
		if(fontImageIndex > 1) g.drawImage(fontImages[0], imageWidth, 0, null);
		if(fontImageIndex > 2) g.drawImage(fontImages[0], 0, imageHeight, null);
		if(fontImageIndex > 3) g.drawImage(fontImages[0], imageWidth, imageHeight, null);
		
		g.dispose();
		
		return new Font(new Texture2D(compositeImage), characters);
	}
	
	private static HashMap<String, int[]> getKeyPairs(String line) {
		HashMap<String, int[]> map = new HashMap<>();
		
		for(String info : line.split(INTO_SEPORATOR)) {
			if(info.isEmpty()) continue;

			String[] data = info.split(DATA_SEPORATOR);
			if(data.length < 2) continue;
			
			String key = data[0];
			String[] valueParts = data[1].split(LIST_SEPORATOR);
			int[] values = new int[valueParts.length];
			
			for(int i = 0; i < valueParts.length; i ++) {
				try { values[i] = Integer.parseInt(valueParts[i]); }
				catch(NumberFormatException e) {
					values = new int[valueParts[i].length()];
					for(int j = 0; j < values.length; j ++)
						values[j] = (int) valueParts[i].charAt(j);
					break;
				}
			}
			
			map.put(key, values);
		}
		
		return map;
	}
	
	public String constructString(int[] chars) {
		StringBuilder builder = new StringBuilder(chars.length - 2);
		for(int i = 1; i < chars.length - 1; i ++)
			builder.append(chars[i]);
		return builder.toString();
	}
	
//	public static Charecter[] loadFont(FontStyle font, File file) {
//		
//	}
}
