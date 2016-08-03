package com.GameName.RenderEngine.Textures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import com.GameName.RenderEngine.Util.Color;
import com.GameName.RenderEngine.Util.Color.ColorFormat;
import com.GameName.Util.Vectors.Vector2f;

//import static org.lwjgl.opengl.GL11.*;
//import static org.lwjgl.opengl.GL12.*;
//import static org.lwjgl.opengl.GL13.*;
//import static org.lwjgl.opengl.GL14.*;
//import static org.lwjgl.opengl.GL15.*;
//import static org.lwjgl.opengl.GL20.*;
//import static org.lwjgl.opengl.GL21.*;
//import static org.lwjgl.opengl.GL30.*;
//import static org.lwjgl.opengl.GL31.*;
//import static org.lwjgl.opengl.GL32.*;
//import static org.lwjgl.opengl.GL40.*;
//import static org.lwjgl.opengl.GL41.*;

public class TextureMap {//							 124, 23, 42
	private static final int CLEAR_COLOR = new Color(0, 0, 0, 0).get(ColorFormat.OPENGL_FORMAT);
	
	private HashMap<Object, Vector2f> locationMap;

	private int imageSize; 
	private byte sizeBit;
	private int[][] rawTextureMap;
	private Texture2D textureMap;
	
	private ColorFormat sheetColorFormat;
	private boolean blockingTextureCompression;
	
	public TextureMap() {
		this.sizeBit = 7;
		this.imageSize = 1 << sizeBit;
		this.rawTextureMap = new int[imageSize][imageSize];
		this.sheetColorFormat = ColorFormat.OPENGL_FORMAT;
		this.blockingTextureCompression = false;
		this.locationMap = new HashMap<>();
		
		for(int x = 0; x < imageSize; x ++) {
		for(int y = 0; y < imageSize; y ++) {
			rawTextureMap[x][y] = CLEAR_COLOR;
		}}
	}
	
	public void expandTexture() {
		int newSize = 1 << ++ sizeBit;
		
		int[][] newRawMap = new int[newSize][newSize];
		
		for(int x = 0; x < imageSize; x ++) {
		for(int y = 0; y < imageSize; y ++) {
			newRawMap[x][y] = rawTextureMap[x][y];
		}}
		
		for(int x = imageSize; x < newSize; x ++) {
		for(int y = imageSize; y < newSize; y ++) {
			newRawMap[x][y] = CLEAR_COLOR;
		}}
		
		rawTextureMap = newRawMap;
		imageSize = newSize;
	}
	
	public void compressTexture() {
		if(blockingTextureCompression) return;
		
		for(int x = 0; x < imageSize; x ++) {
		for(int y = 0; y < imageSize; y ++) {
			if(rawTextureMap[x][y] == CLEAR_COLOR) {
				rawTextureMap[x][y] = new Color(x * 255/imageSize, (x%10) * 25, (y%10) * 25, 255).get(ColorFormat.OPENGL_FORMAT);
			}
		}}
		
		ByteBuffer buffer = BufferUtils.createByteBuffer(imageSize * imageSize * 4);
		BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		
		for(int x = imageSize - 1; x >= 0; x --) { //0; x < imageSize; x ++
		for(int y = 0; y < imageSize; y ++) { //imageSize - 1; y >= 0; y --
			buffer.putInt(Color.flipByteOrder(rawTextureMap[x][y]));
			image.setRGB(x, y, Color.convert(rawTextureMap[x][y], sheetColorFormat, ColorFormat.AWT_FORMAT));
		}}
		
		buffer.flip();
		textureMap = new Texture2D(buffer, new Vector2f(imageSize));
		try{
			ImageIO.write(image, "PNG", new File("C:\\Users\\Joshua\\Desktop\\TextureMapComposit.png"));
		}catch(IOException e) {e.printStackTrace();}
	}
	
	/**
	 * 
	 * @param key A unique Identifier for the texture
	 * @param textureColorData A 2D-Array of all of the colors (represented as ints) in the texture at their respective location
	 * @param colorFormat The format of the Red, Green, Blue, and Alpha, the int color Value 
	 * @return True if the texture was successfully added to the Texture Sheet <p> False if the key has already been used
	 * 
	 * @see com.GameName.RenderEngine.Util.Color.ColorFormat
	 */
	public boolean addTexture(Object key, int[][] textureColorData, ColorFormat colorFormat) {
		if(locationMap.containsKey(key)) return false;
		locationMap.put(key, addTexture(textureColorData, colorFormat));
		compressTexture();
		return true;
	}
	
	private Vector2f addTexture(int[][] textureColorData, ColorFormat colorFormat) {
		Vector2f textureSize = new Vector2f(textureColorData.length, textureColorData[0].length);
		while(textureSize.max() > imageSize) expandTexture();
		
		for(int sheetX = 0; sheetX <= imageSize - textureSize.x; sheetX ++) {
			SheetYLoop:
				for(int sheetY = 0; sheetY <= imageSize - textureSize.y;) {
			
				for(int checkX = 0; checkX < textureSize.x; checkX ++) {
				for(int checkY = 0; checkY < textureSize.y; checkY ++) {
					if(rawTextureMap[sheetX + checkX][sheetY + checkY] != CLEAR_COLOR) {
						sheetY += textureSize.y;
						break SheetYLoop;
					}
				}}
				
				for(int x = 0; x < textureSize.x; x ++) { 
				for(int y = 0; y < textureSize.y; y ++) { 
					int unformatedColor = textureColorData[x][y];
					rawTextureMap[sheetX + x][sheetY + y] = colorFormat == sheetColorFormat ? unformatedColor : 
						Color.convert(unformatedColor, colorFormat, sheetColorFormat);
				}}
				
				return new Vector2f(sheetX, sheetY);
			}
		}
		
		expandTexture();
		return addTexture(textureColorData, colorFormat);
	}

	public Vector2f getTexturePos(Object key) {
		return locationMap.get(key);
	}
	
	public Vector2f getTexturePos_ImageScale(Object key) {
		return locationMap.get(key).divide(imageSize);
	}
	
	public void blockTextureCompression(boolean block) { 
		this.blockingTextureCompression = block;
	}
	
	public int getImageSize() { return imageSize; }
	public Texture2D getTextureMap() { return textureMap; }
}
