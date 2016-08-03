package com.GameName.RenderEngine.Shaders;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;

public class DefaultRenderProperties extends RenderProperties {
	private float shineDamper;
	private float reflectivity;
	
	private int textureAtlasIndex;

	public DefaultRenderProperties() { this(new Transform()); }
	
	public DefaultRenderProperties(Transform transform, float shineDamper, float reflectivity, int textureAtlasIndex) {
		super(transform);
		
		this.shineDamper = shineDamper;
		this.reflectivity = reflectivity;
		this.textureAtlasIndex = textureAtlasIndex;
	}

	public DefaultRenderProperties(int textureAtlasIndex) {
		this.textureAtlasIndex = textureAtlasIndex;
	}

	public DefaultRenderProperties(float shineDamper, float reflectivity) {
		this.shineDamper = shineDamper;
		this.reflectivity = reflectivity;
	}

	public DefaultRenderProperties(Transform transform) {
		super(transform);
	}

	public float getShineDamper() { return shineDamper; }
	public float getReflectivity() { return reflectivity; }
	
	public int getTextureAtlasIndex() { return textureAtlasIndex; }
	
	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}

	public void setTextureAtlasIndex(int textureAtlasIndex) {
		this.textureAtlasIndex = textureAtlasIndex;
	}

	public DefaultRenderProperties clone() {
		return new DefaultRenderProperties(getTransform().clone(), shineDamper, reflectivity, textureAtlasIndex);
	}
}
