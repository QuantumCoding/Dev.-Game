package com.GameName.Particles;

import org.lwjgl.input.Keyboard;

import com.GameName.RenderEngine.Particles.Particle;
import com.GameName.RenderEngine.Particles.ParticleManager;
import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleEmitter {
	private Vector3f position;
	private ParticleTexture texture;
	
	private float emitionDelay;
	private float elapsedTime;
	
	private ParticleManager manager;
	private boolean other;
	
	public ParticleEmitter(ParticleManager manager, Vector3f position, ParticleTexture texture, float emitionDelay, boolean other) {
		this.manager = manager;
		
		this.position = position;
		this.texture = texture;
		this.emitionDelay = emitionDelay;
		
		this.other = other;
	}

	public void update(float delta) {
		if(delta > 2) return;
		elapsedTime += delta;
//		System.out.println(elapsedTime);
		
		while(elapsedTime >= emitionDelay) {
			if(manager.getParticleCount() < ParticleManager.PARTICLE_CREATION_CAP) {
				
				float rotRad = (float) Math.toRadians(Math.random() * 360);
				Vector3f shift = new Vector3f(Math.cos(rotRad), 0, Math.sin(rotRad)).multiply(5);
				Particle particle = new Particle(position.add(shift), (float) (Math.random() * 360),
						 Vector3f.random(1.5f), new Vector3f(),
						 shift.multiply(-1).add(0, Math.random() > 0.5 ? 10 : -10, 0), 1.55f, texture);
				manager.addParticle(particle);
				
			} else {
				elapsedTime = 0;
				break;
			}
			
			elapsedTime -= emitionDelay;
		}
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public void setTexture(ParticleTexture texture) {
		this.texture = texture;
	}

	public Vector3f getPosition() { return position; }
	public ParticleTexture getTexture() { return texture; }
}
