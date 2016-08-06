package com.GameName.RenderEngine.Particles.Render;

import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector2f;

public class ParticleRenderProperties extends RenderProperties {
	
	private boolean useAdditiveBlending;
	private ParticleTexture texture;
	
	private Vector2f offset1, offset2;
	private float textureDivisor;
	private float blend;

	public ParticleRenderProperties(Transform transform, ParticleTexture texture, boolean useAdditiveBlending, int index1, int index2, float blend) {
		this(transform, texture, useAdditiveBlending, texture.getOffset(index1), texture.getOffset(index2), blend);
	}
	
	public ParticleRenderProperties(Transform transform, ParticleTexture texture, boolean useAdditiveBlending, Vector2f offset1, Vector2f offset2, float blend) {
		super(transform);
		
		this.texture = texture;
		this.useAdditiveBlending = useAdditiveBlending;
		
		this.blend = blend;
		this.offset1 = offset1;
		this.offset2 = offset2;
		
		this.textureDivisor = texture.getNumberOfRows();// * ParticleTexture.getRegistry().getImageSize();
	}
	
	public boolean usingAdditive() { return useAdditiveBlending; }
	public ParticleTexture getTexture() { return texture; } 
	
	public float getTextureDivisor() { return textureDivisor; }
	public Vector2f getOffset1() { return offset1; }
	public Vector2f getOffset2() { return offset2; }
	public float getBlend() { return blend; }

	public ParticleRenderProperties clone() {
		return new ParticleRenderProperties(getTransform().clone(), texture.clone(), useAdditiveBlending, offset1.clone(), offset2.clone(), blend);
	}
}
