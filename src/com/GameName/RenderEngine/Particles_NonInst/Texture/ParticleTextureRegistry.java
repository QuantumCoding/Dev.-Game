package com.GameName.RenderEngine.Particles_NonInst.Texture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.RenderEngine.Util.Color;
import com.GameName.RenderEngine.Util.Color.ColorFormat;
import com.GameName.Util.Vectors.Vector2f;

public class ParticleTextureRegistry {							 
	private static final int CLEAR_COLOR = new Color(0, 0, 0, 0).get(ColorFormat.OPENGL_FORMAT);
	
	private ArrayList<Vector2f> locationMap;

	private int imageSize; 
	private byte sizeBit;
	private int[][] rawTextureMap;
	private Texture2D textureMap;
	
	private ColorFormat sheetColorFormat;
	
	public ParticleTextureRegistry() {
		this.sizeBit = 7;
		this.imageSize = 1 << sizeBit;
		this.rawTextureMap = new int[imageSize][imageSize];
		this.sheetColorFormat = ColorFormat.OPENGL_FORMAT;
		this.locationMap = new ArrayList<>();
		
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
		ByteBuffer buffer = BufferUtils.createByteBuffer(imageSize * imageSize * 4);

		for(int y = 0; y < imageSize; y ++) {
		for(int x = 0; x < imageSize; x ++) {
			buffer.putInt(Color.flipByteOrder(rawTextureMap[x][y]));
		}}
		
		buffer.flip();
		textureMap = new Texture2D(buffer, new Vector2f(imageSize));
		
		BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		
		for(int x = imageSize - 1; x >= 0; x --) { //0; x < imageSize; x ++
		for(int y = 0; y < imageSize; y ++) { //imageSize - 1; y >= 0; y --
			image.setRGB(x, y, Color.convert(rawTextureMap[x][y], sheetColorFormat, ColorFormat.AWT_FORMAT));
		}}
		
		try{
			ImageIO.write(image, "PNG", new File("C:\\Users\\Joshua\\Desktop\\TextureMapCompositParticle.png"));
		}catch(IOException e) {e.printStackTrace();}
	}
	
	public ParticleTexture registerTexture(int numberOfRows, File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		
		int[][] data = new int[image.getWidth()][image.getHeight()];
		for(int x = 0; x < image.getWidth(); x ++) {
		for(int y = 0; y < image.getHeight(); y ++) {
			data[x][y] = image.getRGB(x, y);
		}}
		
		return registerTexture(numberOfRows, data, ColorFormat.AWT_FORMAT);
	}
	
	/**
	 * @param numberOfRows The number of rows in a texture atlas. Note: There must be the same number of rows as columns
	 * @param textureColorData A 2D-Array of all of the colors (represented as ints) in the texture at their respective location
	 * @param colorFormat The format of the Red, Green, Blue, and Alpha, the int color Value 
	 * @return An integer location used to reference the texture on the Texture Sheet
	 * 
	 * @see com.GameName.RenderEngine.Util.Color.ColorFormat
	 */
	public ParticleTexture registerTexture(int numberOfRows, int[][] textureColorData, ColorFormat colorFormat) {
		int index = locationMap.size();
		locationMap.add(addTexture(textureColorData, colorFormat));
		return new ParticleTexture(index, new Vector2f(textureColorData.length, textureColorData[0].length), numberOfRows);
	}
	
	public Vector2f addTexture(int[][] textureColorData, ColorFormat colorFormat) {
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

	public Vector2f getTexturePos(int index) {
		return locationMap.get(index);
	}
	
	public Vector2f getTexturePos_ImageScale(int index) {
		return locationMap.get(index).divide(imageSize);
	}
	
	public int getImageSize() { return imageSize; }
	public Texture2D getTextureMap() { return textureMap; }
}
