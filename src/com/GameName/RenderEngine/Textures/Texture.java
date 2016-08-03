package com.GameName.RenderEngine.Textures;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_1D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL12.GL_TEXTURE_3D;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;

import java.awt.image.BufferedImage;

import com.GameName.Util.Vectors.Vector2f;

public abstract class Texture {
	protected int textureId;
	protected Vector2f size;
	
	/**
	 * Takes a BufferedImage and converts it into a Texture in RGBA format
	 * 
	 * @param image The BufferedImage to convert into a texture
	 */
	public Texture(BufferedImage image) {}
	
	/**
	 * Creates a Texture from a preload texture
	 * 
	 * @param textureId The texture Id
	 * @param textureName The Textures Name
	 * @param width  The width of the Texture
	 * @param height The height of the Texture
	 */
	public Texture(int textureId, Vector2f size) {
		this.textureId = textureId;
		this.size = size;
	}
	
	protected Texture() {}
	
	protected abstract void setDefaultProperties();	
	protected abstract void setupMipMaping();
	public abstract TextureType getType();
	public abstract int[][] getRawData();
	
	public int getTextureId() { return textureId; }
	
	public int getWidth() { return (int) size.x; }
	public int getHeight() { return (int) size.y; }
	public Vector2f getSize() { return size; }
	
	public void unbind() {
		glBindTexture(getType().glId, 0);
	}
	
	public static void unbindAll() {
		for(TextureType type : TextureType.values()) {
			glBindTexture(type.glType(), 0);
		}
	}
	
	public void cleanUp() {
		glDeleteBuffers(textureId);
	}
	
	public static enum TextureType {
		Texture1D(GL_TEXTURE_1D, 1), 
		Texture2D(GL_TEXTURE_2D, 2), 
		Texture3D(GL_TEXTURE_3D, 3);
		
		private int glId, coordCount;
		private TextureType(int glId, int coordCount) {
			this.glId = glId;
			this.coordCount = coordCount;
		}
		
		public int glType() { return glId; }
		public int getCoordCount() { return coordCount; }
		
	}
}
