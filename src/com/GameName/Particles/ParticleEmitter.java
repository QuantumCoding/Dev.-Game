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

			
			
			if(!Keyboard.isKeyDown(Keyboard.KEY_P)) {
				if(other) {
					for(int i = 0; i < 360; i += 5) {
						Particle particle = new Particle(position, (float) (Math.random() * 360), new Vector3f(0.25f), 
								new Vector3f(Math.cos(i) * 30, 0, Math.sin(i) * 30), new Vector3f(), 1f, texture, false);
						manager.addParticle(particle);
					}
		
					float f1, f2, f3, f4;
					for(int rotY = 0; rotY < 180; rotY += 15) {
					for(int rotX = 0; rotX < 360; rotX += 15) {		
						f1 = (float) Math.cos(Math.toRadians(rotY));
						f2 = (float) Math.sin(Math.toRadians(rotY));
						f3 = (float) Math.cos(Math.toRadians(rotX));                  
						f4 = (float) Math.sin(Math.toRadians(rotX));                  
						
						float sx = f2 * f3 * 5;
						float sy = f4 * 5;
						float sz = f1 * f3 * 5;
						
						Particle particle = new Particle(position, (float) (Math.random() * 360), new Vector3f(0.25f), 
								new Vector3f(sx, sy, sz), new Vector3f(), 1f, texture, false);
						manager.addParticle(particle);
					}}
				} else {
				
					float rotRad = (float) Math.toRadians(Math.random() * 360);
					Particle particle = new Particle(position, (float) (Math.random() * 360), new Vector3f(1),//0.25f), 
							new Vector3f(Math.cos(rotRad) * 2, 10, Math.sin(rotRad) * 2), 
							new Vector3f(0, -15, 0), 2f, texture, true);
					manager.addParticle(particle);
				}
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
