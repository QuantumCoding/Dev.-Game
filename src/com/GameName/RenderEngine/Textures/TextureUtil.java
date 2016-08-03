package com.GameName.RenderEngine.Textures;

import java.awt.image.BufferedImage;

import com.GameName.Util.Vectors.Vector2f;

public class TextureUtil {
	public static CombindTexture combindTextures(Texture2D... textures) {
		BufferedImage[] images = new BufferedImage[textures.length];
		for(int i = 0; i < textures.length; i ++)
			images[i] = textures[i].getImage();
		
		Vector2f largestSideTracker = new Vector2f();
		for(BufferedImage image : images) {
			if(image.getWidth() > largestSideTracker.x) 
				largestSideTracker.setX(image.getWidth());
			if(image.getHeight() > largestSideTracker.y) 
				largestSideTracker.setY(image.getHeight());
		}
		
		int largestSide = (int) Math.ceil(largestSideTracker.max());
		while((largestSide & (largestSide -1)) == 0) 
			largestSide ++;
		
		BufferedImage fullImage = new BufferedImage(largestSide, largestSide, BufferedImage.TYPE_INT_ARGB);
		boolean[][] usedSpaces = new boolean[largestSide][largestSide]; 
		Vector2f[] textureCoords = new Vector2f[textures.length];
		
		int i = 0; imageLoop:
		for(BufferedImage image : images) {
			for(int x = 0; x < largestSide; x ++) {
				if(x + image.getWidth() > largestSide) {
					System.err.println("Failed to add image!");
					continue imageLoop;
				}
				
			for(int y = 0; y < largestSide; y ++) {
				if(y + image.getHeight() > largestSide)
					break;				
				boolean placed = true;
				
				checkLoop:
				for(int xCheck = 0; xCheck < image.getWidth(); xCheck ++) {
				for(int yCheck = 0; yCheck < image.getHeight(); yCheck ++) {
					if(usedSpaces[x + xCheck][y + yCheck]) {
						placed = false;
						break checkLoop;
					}
				}}
				
				if(placed) {
					textureCoords[i] = new Vector2f(x, y);
					
					for(int xCheck = 0; xCheck < image.getWidth(); xCheck ++) {
					for(int yCheck = 0; yCheck < image.getHeight(); yCheck ++) {
						usedSpaces[x + xCheck][y + yCheck] = true;
						fullImage.setRGB(x + xCheck, y + yCheck, image.getRGB(xCheck, yCheck));
					}}
				}
			}}
			
			i ++;
		}
		
		return new CombindTexture(textures, textureCoords, new Texture2D(fullImage));
	}
	
	public static class CombindTexture {
		private Texture2D[] textures;
		private Vector2f[] textureCoords;
		
		private Texture2D fullTexture;
		private int size;
		
		public CombindTexture(Texture2D[] textures, Vector2f[] textureCoords, Texture2D fullTexture) {
			this.textures = textures;
			this.textureCoords = textureCoords;
			this.fullTexture = fullTexture;
			
			size = (int) fullTexture.getWidth();
		}

		public Vector2f getTextureCoord(Vector2f originalTexCoord, Texture2D originalTexture) {
			for(int i = 0; i < textures.length; i ++) {
				if(textures[i].getTextureId() == originalTexture.getTextureId()) {
					return originalTexCoord.multiply(originalTexture.getSize()).add(textureCoords[i]).divide(size);
				}
			}
			
			throw new IllegalArgumentException("Texture Sheet does not contain texture " + originalTexture.getTextureId());
		}

		public Texture2D[] getTextures() { return textures; }
		public Vector2f[] getTextureCoords() { return textureCoords; }
		public Texture2D getFullTexture() { return fullTexture; }
		public int getSize() { return size; }
	}
}
