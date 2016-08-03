package com.GameName.RenderEngine.Particles;

import java.util.ArrayList;
import java.util.Iterator;

import com.GameName.Registry.ResourceManager.Shaders;
import com.GameName.RenderEngine.Particles.Render.ParticleRender;
import com.GameName.RenderEngine.Particles.Render.ParticleRenderProperties;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleManager {
	private ArrayList<Particle> particles;
	
	public ParticleManager() {
		particles = new ArrayList<>();
	}
	
	public void addParticle(Particle particle) {
		particles.add(particle);
	}
	
	public void update(float delta, Camera camera) {
		Iterator<Particle> iterator = particles.iterator();
		while(iterator.hasNext()) {
			if(!iterator.next().update(delta, camera)) {
				iterator.remove();
			}
		}
		
		ParticleSorter.sort(particles);
	}
	
	public void renderParticles(Camera camera) {
		for(Particle particle : particles) {
			float textureIndex = particle.getTextureIndex();
			if(textureIndex < 0) {
				float normalTime = particle.getElapsedTime() / particle.getTimeAlive();
				int indexCount = particle.getTexture().getNumberOfRows() * particle.getTexture().getNumberOfRows();
				textureIndex = indexCount * normalTime;
			}

			ParticleRender render = new ParticleRender(Shaders.ParticleShader, particle.usingAdditive());
			ParticleRenderProperties renderProperties = new ParticleRenderProperties(new Transform(
					particle.getPosition(), new Vector3f(particle.getRotation()), particle.getScale()),
					particle.getTexture(), (int) textureIndex, textureIndex % 1);

			render.render(renderProperties, camera);
		}
	}
}
