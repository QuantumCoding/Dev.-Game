package com.GameName.RenderEngine.Particles.Render;

import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;

public class ParticleRenderProperties extends RenderProperties {

	private ParticleTexture texture;
	private int textureIndex;
	private float blendValue;
	
	public ParticleRenderProperties(ParticleTexture texture) { 
		this(new Transform(), texture, 0, 0);
	}
	
	public ParticleRenderProperties(ParticleTexture texture, int textureIndex, float blendValue) { 
		this(new Transform(), texture, textureIndex, blendValue);
	}
	
	public ParticleRenderProperties(Transform transform, ParticleTexture texture) { 
		this(transform, texture, 0, 0);
	}
	
	public ParticleRenderProperties(Transform transform, ParticleTexture texture, int textureIndex, float blendValue) {
		super(transform); 
		this.texture = texture;
		this.textureIndex = textureIndex;
		this.blendValue = blendValue;
	}
	
	public ParticleTexture getTexture() { return texture; }
	public int getTextureAtlasIndex() { return textureIndex; }
	public float getBlendValue() { return blendValue; }
	
	public RenderProperties clone() {
		return new ParticleRenderProperties(getTransform().clone(), texture.clone(), textureIndex, blendValue);
	}
}
