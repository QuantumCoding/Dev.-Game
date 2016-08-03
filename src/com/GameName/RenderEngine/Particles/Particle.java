package com.GameName.RenderEngine.Particles;

import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class Particle {
	
	private Vector3f position;
	private float rotation;
	private Vector3f scale;
	
	private Vector3f velocity;
	private Vector3f gravity;
	
	private float timeAlive;
	private float elapsedTime;
	
	private ParticleTexture texture;
	private int textureIndex;

	private float distanceFromCamera;
	private boolean additiveBlending;
	
	public Particle(Vector3f position, float rotation, Vector3f scale, Vector3f velocity, Vector3f gravity, float timeAlive, ParticleTexture texture, boolean additiveBlending) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.velocity = velocity;
		this.gravity = gravity;
		this.timeAlive = timeAlive;
		this.texture = texture;
		this.additiveBlending = additiveBlending;
		
		this.textureIndex = -1;
	}
	
	public boolean update(float delta, Camera camera) {
		position = position.add(velocity.multiply(delta));
		velocity = velocity.add(gravity.multiply(delta));
		
		distanceFromCamera = camera.getPosition().distanceSquared(position);
		
		elapsedTime += delta;
		return elapsedTime < timeAlive;
	}
	
	public void setTextureIndex(int index) {
		this.textureIndex = index;
	} 
	
	public Vector3f getPosition() { return position; }
	public float getRotation() { return rotation; }
	public Vector3f getScale() { return scale; }

	public Vector3f getVelocity() { return velocity; }
	public Vector3f getGravity() { return gravity; }

	public float getTimeAlive() { return timeAlive; }
	public float getElapsedTime() { return elapsedTime; }

	public ParticleTexture getTexture() { return texture; }
	public int getTextureIndex() { return textureIndex; }
	
	public float getDistance() { return distanceFromCamera; }
	public boolean usingAdditive() { return additiveBlending; }
}
