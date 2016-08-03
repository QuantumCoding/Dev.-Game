package com.GameName.World.Generation;

import java.util.Random;

import com.GameName.Engine.GameEngine;
import com.GameName.Registry.ResourceManager.Cubes;
import com.GameName.World.World;
import com.GameName.World.Chunk.Chunk;
import com.GameName.World.Render.WorldRender;
import com.GameName.World.Render.WorldRenderSection;

public class EnvironmentGenerator {

	int seed;
	World world;
	private SimplexNoiseSeedable noiseGenerator;
	Random r = new Random();
	private GameEngine ENGINE;
	int ran = 0;
	
	
	public EnvironmentGenerator(GameEngine eng, int seedI, World worldI) {
		seed = seedI;
		world = worldI;
		noiseGenerator = new SimplexNoiseSeedable(seedI);
		ENGINE = eng;
	}
	
	public Chunk generate(Chunk out) {
		int x = out.getX();
		int y = out.getY();
		int z = out.getZ();
		
		double[] endTimes = new double[4];
		for(int xi = 0; xi < World.CHUNK_SIZE; xi++) {
			double startTime = System.currentTimeMillis();
			double fullTimeStart = startTime;
		for(int zi = 0; zi < World.CHUNK_SIZE; zi++) {
			
			double elevation = noiseGenerator.noise((double)(x*World.CHUNK_SIZE+xi)/World.CHUNK_SIZE/8, (double)(z*World.CHUNK_SIZE+zi)/World.CHUNK_SIZE/8);
			endTimes[0] += System.currentTimeMillis() - startTime;
			
//			double roughness = SimplexNoise.noise((double)(x*World.CHUNK_SIZE+xi)/World.CHUNK_SIZE/4, (double)(z*World.CHUNK_SIZE+zi)/World.CHUNK_SIZE/4)*2;
//			double detail = SimplexNoise.noise((double)(x*World.CHUNK_SIZE+xi)/World.CHUNK_SIZE, (double)(z*World.CHUNK_SIZE+zi)/World.CHUNK_SIZE);
			double preTime = System.currentTimeMillis();
			double checkTime = preTime;
			double h = elevation;
			h = (h / 2) * World.CHUNK_SIZE;
			for(int yi = 0; yi < World.CHUNK_SIZE; yi++) {
				
				if(y * World.CHUNK_SIZE + yi < h + world.getCubeSizeY())
					out.setCubeWithoutUpdate(xi, yi, zi, Cubes.GoldCube);
				else
					out.setCubeWithoutUpdate(xi, yi, zi, Cubes.Air);

				endTimes[1] += System.currentTimeMillis() - checkTime;
				checkTime = System.currentTimeMillis();
			}
			
			endTimes[2] += System.currentTimeMillis() - preTime;
			startTime = System.currentTimeMillis();
		}
//		float fullTime = (float) ((System.currentTimeMillis() - fullTimeStart) / 1000.0f);
//		
//		float genTime = (float) (endTimes[0] / World.CHUNK_SIZE / 1000.0f);
//		float addTime = (float) (endTimes[1] / (World.CHUNK_SIZE) / 1000.0f);
//		float fullAddTime = (float) (endTimes[2] / World.CHUNK_SIZE / 1000.0f);
//
//		float wrGSh = (float) (WorldRender.endTimes[0] / World.CHUNK_SIZE / 1000.0f);
//		float wrGSArr = (float) (WorldRender.endTimes[1] / World.CHUNK_SIZE / 1000.0f);
//		float wrAddC = (float) (WorldRender.endTimes[2] / World.CHUNK_SIZE / 1000.0f);
//
//		float wrsGInfo = (float) (WorldRenderSection.endTimes[0] / World.CHUNK_SIZE / 1000.0f);
//		float wrsAddMesh = (float) (WorldRenderSection.endTimes[1] / World.CHUNK_SIZE / 1000.0f);
//		float wrsAddV = (float) (WorldRenderSection.endTimes[2] / WorldRenderSection.endTimes[4] / World.CHUNK_SIZE / 1000.0f);
//		float wrsPutBuff = (float) (WorldRenderSection.endTimes[3] / World.CHUNK_SIZE / 1000.0f);

//		System.out.println(wrsGInfo + "\t " + wrsAddMesh + "\t " + wrsAddV + "\t " + wrsPutBuff);
//		System.out.println(wrGSh + "\t " + wrGSArr + "\t " + wrAddC);
//		System.out.println(genTime + "\t " + addTime + "\t " + fullAddTime + "\t = " + fullTime);
		
//		double[] counts = new double[] {World.CHUNK_SIZE, World.CHUNK_SIZE*World.CHUNK_SIZE, World.CHUNK_SIZE, 1};
//		for(int i = 0; i < endTimes.length; i ++) {
//			double lastTime = i == 0 ? startTime : endTimes[i-1];
//			double differance = endTimes[i] - lastTime;
//			differance /= counts[i];
//			endTimes[i] = differance;
//			System.out.print((float)(differance/1000.0f) + "\t ");
//		} System.out.println();
		
//		System.out.println("Done: " + xi + "-> " + (float)(( - startTime)/1000.0f));
		}
		
		return out;
	}
	
	
}
