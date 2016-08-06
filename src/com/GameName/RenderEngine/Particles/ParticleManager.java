package com.GameName.RenderEngine.Particles;

import java.util.ArrayList;
import java.util.Iterator;

import com.GameName.Registry.ResourceManager.Shaders;
import com.GameName.RenderEngine.Particles.Render.ParticleInstanceRender;
import com.GameName.RenderEngine.Particles.Render.ParticleRenderProperties;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;

public class ParticleManager {
	public static final int PARTICLE_CREATION_CAP = 10000;
	
	private ArrayList<Particle> particles;
	private ParticleInstanceRender model;
	
	public ParticleManager() {
		particles = new ArrayList<>();
		model = new ParticleInstanceRender(Shaders.ParticleShader);
	}
	
	public int getParticleCount() { return particles.size(); }
	
	public void addParticle(Particle particle) { 
		if(getParticleCount() < PARTICLE_CREATION_CAP)
			particles.add(particle); 
	}
	
	public void update(float delta, Camera camera) {
		Iterator<Particle> iterator = particles.iterator();
		while(iterator.hasNext()) {
			if(!iterator.next().update(delta, camera)) {
				iterator.remove();
			}
		}
		
//		ParticleSorter.sort(particles);
	}
	
	public void render(Camera camera) {
		for(Particle particle : particles) {
			float normalTime = particle.getElapsedTime() / particle.getTimeAlive();
			int indexCount = particle.getTexture().getNumberOfRows() * particle.getTexture().getNumberOfRows();
			float textureIndex = indexCount * normalTime;
			
			int index1 = (int) Math.floor(textureIndex);
			int index2 = index1 < indexCount - 1 ? index1 + 1 : index1;
			float blend = textureIndex % 1;
			
			ParticleRenderProperties properties = new ParticleRenderProperties(
					new Transform(particle.getPosition(), new Vector3f(0, 0, particle.getRotation()), particle.getScale()),
					particle.getTexture(), particle.usingAdditive(), index1, index2, blend
				);
			
			model.render(properties, camera);
		}
	}
}
