package com.GameName.Particles;

import java.io.File;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.GameName.Engine.GameEngine;
import com.GameName.RenderEngine.Particles.Particle;
import com.GameName.RenderEngine.Particles.ParticleManager;
import com.GameName.RenderEngine.Particles.Texture.ParticleTexture;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleTestCode {
	private Camera camera;
	
	private ParticleEmitter emitter;
	private ParticleManager manager;
	private ParticleTexture texture;
	
	private final GameEngine ENGINE;
	
	public ParticleTestCode(GameEngine eng, Camera camera) {
		ENGINE = eng;
		this.camera = camera;
		
		// particleStar
		try { texture = ParticleTexture.getRegistry().registerTexture(4, new File("res/textures/ParticleD.png")); } 
		catch(IOException e) { e.printStackTrace(); }
		texture.setAdditvieBlending(true);
		
		ParticleTexture.getRegistry().compressTexture();
		
		manager = ENGINE.getRender().getParticleManager();
		emitter = new ParticleEmitter(manager, new Vector3f(7.75f), texture, 0.00005f, false);
	}
	
	public void update(float delta) {
		if(Keyboard.isKeyDown(Keyboard.KEY_U)) {
			manager.addParticle(new Particle(new Vector3f(2), (float) (Math.random() * 360), Vector3f.random(1), 
					Vector3f.random(6).subtract(3, 0, 3), new Vector3f().randomize(2).multiply(-1), 10, texture));
		}
		
		emitter.update(delta);
		manager.update(delta, camera);
	}
}
