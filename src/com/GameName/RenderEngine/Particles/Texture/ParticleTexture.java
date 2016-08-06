package com.GameName.RenderEngine.Particles.Texture;

import com.GameName.Util.Vectors.Vector2f;

public class ParticleTexture {
	private static ParticleTextureRegistry registry = new ParticleTextureRegistry();
	public static ParticleTextureRegistry getRegistry() { return registry; }
	
	private int textureIndex;
	private Vector2f textureSize;
	private int numberOfRows;
	
	private boolean additiveBlending;
	
	protected ParticleTexture(int textureIndex, Vector2f textureSize, int numberOfRows) {
		this.textureIndex = textureIndex;
		this.textureSize = textureSize;
		this.numberOfRows = numberOfRows;
	}
	
	public Vector2f getOffset(int index) {
		Vector2f offest = registry.getTexturePos(textureIndex);
		float col = index % numberOfRows, row = index / numberOfRows;		
		
		return new Vector2f(col / (float) numberOfRows, row / (float) numberOfRows)
				.multiply(textureSize).add(offest).divide(registry.getImageSize());
	}

	public void setAdditvieBlending(boolean additiveBlending) {
		this.additiveBlending = additiveBlending;
	}
	
	public boolean additiveBlending() { return additiveBlending; }
	public int getNumberOfRows() { return numberOfRows; }
	public Vector2f getSize() { return textureSize; }
	
	public int hashCode() {
		return textureIndex;
	}
	
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof ParticleTexture)) return false;
		
		ParticleTexture other = (ParticleTexture) obj;
		if(other.textureIndex != textureIndex)
			return false;
		
		return true;
	}
	
	public ParticleTexture clone() {
		return new ParticleTexture(textureIndex, textureSize, numberOfRows);
	}
}
