package com.GameName.RenderEngine.Textures;

import static org.lwjgl.opengl.GL11.GL_LINEAR_MIPMAP_LINEAR;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_REPEAT;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glGetTexImage;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameterf;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL14.GL_TEXTURE_LOD_BIAS;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import com.GameName.RenderEngine.Util.Color;
import com.GameName.RenderEngine.Util.Color.ColorFormat;
import com.GameName.Util.Vectors.Vector2f;

public class Texture2D extends Texture {
	private int numberOfRows;
	private BufferedImage image;
	
	public Texture2D(BufferedImage image) {
		this.image = image;
		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4); // 4 Because of RGBA

		for(int y = 0; y < image.getHeight(); y ++) {
	    for(int x = 0; x < image.getWidth(); x ++) {
	        buffer.putInt(Color.flipByteOrder(Color.convert(image.getRGB(x, y), ColorFormat.AWT_FORMAT, ColorFormat.OPENGL_FORMAT)));
	    }}

		buffer.flip();		
		textureId = glGenTextures();	    		

		bind();
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
			size = new Vector2f(image.getWidth(), image.getHeight());
			
			setDefaultProperties();
			setupMipMaping();
		unbind();

		numberOfRows = 1;
	}
	
	public Texture2D(ByteBuffer buffer, Vector2f size) {
		textureId = glGenTextures();	    		
		bind();
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, (int) size.getX(), (int) size.getY(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
			setDefaultProperties();
			setupMipMaping();
		unbind();
		
		this.image = pullTexture(textureId, size);
		super.size = size;
	}
	
	public Texture2D(int textureId, Vector2f size) {
		super(textureId, size);
		this.image = pullTexture(textureId, size);
		numberOfRows = 1;
	}

	public static BufferedImage pullTexture(int textureId, Vector2f size) {
		BufferedImage image = new BufferedImage((int)size.x, (int)size.y, BufferedImage.TYPE_INT_ARGB);
		ByteBuffer buffer = BufferUtils.createByteBuffer((int) (size.x * size.y) * 4);
		
		glBindTexture(GL_TEXTURE_2D, textureId);
		glGetTexImage(GL_TEXTURE_2D, 0, GL_UNSIGNED_BYTE, GL_RGBA, buffer);
		
		for(int x = 0; x < image.getWidth(); x ++) {
		for(int y = 0; y < image.getHeight(); y ++) {
			image.setRGB(x, y, Color.convert(Color.flipByteOrder(buffer.getInt(x + (y * image.getWidth()))), 
					ColorFormat.OPENGL_FORMAT, ColorFormat.AWT_FORMAT));
		}}
		
		return image;
	}
	
	protected void setDefaultProperties() {
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	}
	
	protected void setupMipMaping() {
		glGenerateMipmap(GL_TEXTURE_2D);		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR_MIPMAP_LINEAR);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_LOD_BIAS, -0.6f);
	}
	
	public void bind() {
		glEnable(GL_TEXTURE_2D);
		glBindTexture(GL_TEXTURE_2D, textureId);
	}
	
	public void bind(int texurePos) {
		glActiveTexture(GL_TEXTURE0 + texurePos);
		glBindTexture(GL_TEXTURE_2D, textureId);
	}
	
	public void unbind() {
		glBindTexture(GL_TEXTURE_2D, 0);
		glDisable(GL_TEXTURE_2D);
	}
	
	public void unbind(int texurePos) {
		glActiveTexture(GL_TEXTURE0 + texurePos);
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
	
	public Vector2f getOffset(int index) {
		float col = index % numberOfRows, row = index / numberOfRows;		
		return new Vector2f(col / (float)numberOfRows, row / (float)numberOfRows);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getNumberOfRows() {
		return numberOfRows;
	}

	public TextureType getType() {
		return TextureType.Texture2D;
	}

	public int[][] getRawData() {
		int[][] data = new int[(int) size.x][(int) size.y];
		
		for(int x = 0; x < size.x; x ++) {
		for(int y = 0; y < size.y; y ++) { 
			data[x][y] = Color.convert(image.getRGB(x, y), ColorFormat.AWT_FORMAT, ColorFormat.OPENGL_FORMAT);
		}}
		
		return data;
	}
	
	public int hashCode() {
		return super.textureId;
	}
	
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof Texture2D)) return false;
		
		Texture2D other = (Texture2D) obj;
		if(other.textureId != super.textureId)
			return false;
		
		return true;
	}
}
