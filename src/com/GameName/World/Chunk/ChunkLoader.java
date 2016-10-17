package com.GameName.World.Chunk;

import java.io.IOException;
import java.util.HashMap;

import com.GameName.Cube.Cube;
import com.GameName.Engine.GameEngine;
import com.GameName.Registry.ResourceManager.Cubes;
import com.GameName.Util.Side;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.World;

public class ChunkLoader {
	private String fileLoc;

	private HashMap<Vector3f, Chunk> unloadedChunks;
	private HashMap<Vector3f, Chunk> loadedChunks;

	private Vector3f center;
	private int loadRadius;

	private World world;
	private final GameEngine ENGINE;

	public ChunkLoader(GameEngine eng, World world, int loadRadius) {
		ENGINE = eng;

		this.world = world;
		this.loadRadius = loadRadius;

		unloadedChunks = new HashMap<>();
		loadedChunks = new HashMap<>();

		center = new Vector3f();
		fileLoc = world.getResourceLocation() + "/chunks/";
	}

	public void update() {
		if(center == null) center = new Vector3f();

		findUnloadedChunks();
		unloadChunks();
		loadChunks();

		updateRender();
	}

	public void updateRender() {
		world.getWorldRender().blockAllRebuilds(true);

		// for(Chunk chunk : getLoadedChunks()) { //TODO: Uncomment / Fix
		// if(chunk.getRenderAccountability().isRenderRebuildRequested()) {
		// for(Vector3f position :
		// chunk.getRenderAccountability().getUnrenderedPositions()) {
		// world.getWorldRender().addCube(position,
		// Cube.getCubeByID(chunk.getCube((int)position.x, (int)position.y,
		// (int)position.z)),
		// chunk.getMetadata((int)position.x, (int)position.y,
		// (int)position.z));
		// }
		// }
		// }

		world.getWorldRender().blockAllRebuilds(false);
		world.getWorldRender().rebuildAll();
	}

	public void findUnloadedChunks() {
		Vector3f minPos = center.subtract(loadRadius).capMin(0);
		Vector3f maxPos = center.add(loadRadius).capMax(world.getChunkSizeAsVector()).subtract(1);

		for(Vector3f pos : loadedChunks.keySet()) {
			Chunk chunk = loadedChunks.get(pos);
			
			if(chunk != null && chunk.isLoaded()) {
				if(chunk.getX() < minPos.getX() || chunk.getY() < minPos.getY()
						|| chunk.getZ() < minPos.getZ() || chunk.getX() > maxPos.getX()
						|| chunk.getY() > maxPos.getY() || chunk.getZ() > maxPos.getZ()) {

					unloadedChunks.put(chunk.getPos(), chunk);
					getLoadedChunks().remove(chunk);// .remove(i);
				}
			}
		}
	}

	public void unloadChunks() {
		for(Vector3f key : unloadedChunks.keySet()) {
			Chunk chunk = unloadedChunks.get(key);
			updateNeighbors(chunk, false);
			chunk.setIsLoaded(false);

			for(int pos = 0; pos < chunk.getSize() * chunk.getSize() * chunk.getSize(); pos ++) {
				world.getWorldRender() .removeCube(new Vector3f(pos % chunk.getSize(), 
						pos / chunk.getSize() % chunk.getSize(),
						pos / chunk.getSize() / chunk.getSize()));
			}

			chunk.cleanUp();
			unloadedChunks.remove(chunk.getPos());

			chunk = null;
		}
	}

	private boolean first = true;
	int firstChunk = 0;

	public void loadChunks() {
		Chunk lastChunk = null;
		world.getWorldRender().bypassAccountability(true);
		world.getWorldRender().blockAllRebuilds(true);
		
		for(int radius = 0; radius < loadRadius; radius ++) {
			
			for(int x = -radius; x < radius + 1; x ++) {
			for(int y = -radius; y < radius + 1; y ++) {
			for(int z = -radius; z < radius + 1; z ++) {
				if(x < 0 || y < 0 || z < 0) continue;
				if(x > world.getChunkSizeX() || y > world.getChunkSizeY() || z > world.getChunkSizeZ()) continue;
				
				Vector3f loadPos = new Vector3f(x, y, z).add(center).capMax(world.getChunkSizeAsVector().subtract(1)).capMin(0);
				Chunk chunk = getChunk(loadPos);
				
				if(chunk == null) {
					chunk = new Chunk(ENGINE, World.CHUNK_SIZE, world, 
							(int) loadPos.getX(), (int) loadPos.getY(), (int) loadPos.getZ()
						);
				}
				
				if(chunk.isLoaded()) continue;
				
				System.out.println("Loading Chunk: " + loadPos);
				
				try {
					chunk = ChunkIO.loadChunk(chunk);
					System.out.println("Loaded: " + Vector3f.printValues(x, y, z));
					
				} catch(IOException e) {
					System.out.println("Generateing: [" + x + ", " + y + ", " + z + "]");
//					chunk = world.getEnvironmentGen().generate(chunk);
										
					for(int x_ = 0; x_ < chunk.getSize(); x_ ++) {
					for(int y_ = 0; y_ < chunk.getSize(); y_ ++) {
					for(int z_ = 0; z_ < chunk.getSize(); z_ ++) {
						Cube cube = Cube.getCubes()[(int) (Math.random() * (Cube.getCubes().length-2)) + 1];
						
						add:
						if(y_ != 0) {
							if(x_ == 0 && z_ == 0) break add;
							if(x_ == chunk.getSize()-1 && z_ == chunk.getSize()-1) break add;
							if(x_ == 0 && z_ == chunk.getSize()-1) break add;
							if(x_ == chunk.getSize()-1 && z_ == 0) break add;

							if((x_ == chunk.getSize()-1 || z_ == chunk.getSize()-1 || 
								x_ == 0 || z_ == 0) && y_ == chunk.getSize()-1) break add;
														
							cube = Cubes.Air;
						}
						
						chunk.setCubeWithoutUpdate(x_, y_, z_, cube);
					}}}
					
					if(firstChunk++ == 5) {

//						int rad = 9; float f1, f2, f3, f4;
//						for(int r = 0; r < rad + 1; r ++){
//							for(int rotY = 0; rotY < 180; rotY ++) {
//							for(int rotX = 0; rotX < 360; rotX ++) {		
//								f1 = (float) Math.cos(Math.toRadians(rotY));
//								f2 = (float) Math.sin(Math.toRadians(rotY));
//								f3 = (float) Math.cos(Math.toRadians(rotX));                  
//								f4 = (float) Math.sin(Math.toRadians(rotX));                  
//								
//								int sx = Math.round(f2 * f3 * r) + 10;
//								int sy = Math.round(f4 * r) + 10;
//								int sz = Math.round(f1 * f3 * r) + 10;
//								
//								if(sx == 10 || sz == 10 || sy == 10) continue;
//								world.getChunk_ChunkScale(0, 0, 0).setCubeWithoutUpdate(sx, sy, sz, Cubes.GoldCube);
//							}}
//						}
//							
//						for(int r = 0; r < rad - 1; r ++) {
//							for(int rotY = 0; rotY < 180; rotY ++) {
//							for(int rotX = 0; rotX < 360; rotX ++) {						
//								f1 = (float) Math.cos(Math.toRadians(rotY));
//								f2 = (float) Math.sin(Math.toRadians(rotY));
//								f3 = (float) Math.cos(Math.toRadians(rotX));                  
//								f4 = (float) Math.sin(Math.toRadians(rotX));                  
//								
//								int sx = Math.round(f2 * f3 * r) + 10;
//								int sy = Math.round(f4 * r) + 10;
//								int sz = Math.round(f1 * f3 * r) + 10;
//	
//								if(sx == 10 || sz == 10 || sy == 10)
//									world.getChunk_ChunkScale(0, 0, 0).setCubeWithoutUpdate(sx, sy, sz, Cubes.CopperCube);
//							}}
//						}
					}
					
					chunk.setCubeWithoutUpdate(0, 0, 0, Cubes.Air);

//					for(int x_ = 0; x_ < chunk.getSize(); x_ ++) {
//					for(int z_ = x_ % 2; z_ < chunk.getSize(); z_ += 1) {
//						chunk.setCubeWithoutUpdate(x_, z_, 0, Cubes.GoldCube);	
//						chunk.setCubeWithoutUpdate(x_, z_, 5, Cubes.GoldCube);						
//					}}	
					
//					for(int x_ = 0; x_ < chunk.getSize(); x_ += 10) {
//					for(int y_ = 0; y_ < chunk.getSize(); y_ += 10) {
//					for(int z_ = 0; z_ < chunk.getSize(); z_ += 10) {
//						chunk.setCubeWithoutUpdate(x_, z_, y_, Cubes.GoldCube);	
//					}}}	
					
//					for(int x_ = 0; x_ < chunk.getSize(); x_ += 1) {
//					for(int y_ = 0; y_ < chunk.getSize(); y_ += 1) {
//					for(int z_ = 0; z_ < chunk.getSize(); z_ += 1) {
//						chunk.setCubeWithoutUpdate(x_, z_, y_, Cubes.GoldCube);	
//					}}}	
					
//					for(int i = 0; i < 50; i ++)
//						chunk.setCubeWithoutUpdate((int) (Math.random() * 20), 
//							(int) (Math.random() * 20), 
//							(int) (Math.random() * 20), Cubes.GoldCube);
					
//					chunk.setCubeWithoutUpdate(0, 0, 0, Cubes.GoldCube);
//					chunk.setCubeWithoutUpdate(1, 1, 0, Cubes.GoldCube);
//					chunk.setCubeWithoutUpdate(2, 0, 0, Cubes.GoldCube);

//					for(int x_ = 0; x_ < chunk.getSize(); x_ ++) {
//					for(int z_ = 0; z_ < chunk.getSize(); z_ ++) {
//						chunk.setCubeWithoutUpdate(x_, z_, 0, Cubes.GoldCube);
//					}}
						
////					chunk = new Chunk(ENGINE, World.CHUNK_SIZE, world.getId(), x, y, z);
//					for(int x_ = 0; x_ < chunk.getSize() / 4; x_ ++) {
//					for(int y_ = 0; y_ < chunk.getSize() / 4; y_ ++) {
//					for(int z_ = 0; z_ < chunk.getSize() / 4; z_ ++) {
////						if(x_ + x * chunk.getSize() == 90 || x_ + x * chunk.getSize() == 10) {
//////							chunk.setCubeWithoutUpdate(x_, y_, z_, y_ == 0 || z_ == 0 ? Cubes.ColorfulTestCube : Cubes.StoneCube);
////							chunk.setCubeWithoutUpdate(x_, y_, z_, Cube.getCubeByID((int) (Math.random() * Cube.getCubes().length)));
////						}
////						
////						if(y_ + y * chunk.getSize() == 90 || y_ + y * chunk.getSize() == 10) {
//////							chunk.setCubeWithoutUpdate(x_, y_, z_, x_ == 0 || z_ == 0 ? Cubes.ColorfulTestCube : Cubes.StoneCube);
////							chunk.setCubeWithoutUpdate(x_, y_, z_, Cube.getCubeByID((int) (Math.random() * Cube.getCubes().length)));
////						}
////						
////						if(z_ + z * chunk.getSize() == 90 || z_ + z * chunk.getSize() == 10) {
//////							chunk.setCubeWithoutUpdate(x_, y_, z_, y_ == 0 || x_ == 0 ? Cubes.ColorfulTestCube : Cubes.StoneCube);
////							chunk.setCubeWithoutUpdate(x_, y_, z_, Cube.getCubeByID((int) (Math.random() * Cube.getCubes().length)));
////						}
////						
//						chunk.setCubeWithoutUpdate(x_ * 4, y_ * 4, z_ * 4, Math.random() > 0.25 ? Cubes.GoldCube : Cubes.DirectionalCube);//Cube.getCubeByID((int) (Math.random() * Cube.getCubes().length)));
//					}}} //x_ % 2 == 0 ? Cubes.GoldCube : Cubes.DirectionalCube
				}
				
				chunk.setIsLoaded(true);
				getLoadedChunks().put(chunk.getPos(), chunk); 
				updateNeighbors(chunk, true);

				world.getWorldRender().blockAllRebuilds(true);
				for(Chunk neighbor : chunk.getNeighbors()) {
					if(neighbor != null && neighbor.isAccessible()) {
					if(neighbor.getRenderAccountability().hasUnaddedCubes())
						neighbor.getRenderAccountability().addUnaddedCubes();
					}
				}
				
				lastChunk = chunk;
			}}}			
		}
		
		
		if(first) {	
//			for(int x_ = 0; x_ < 20; x_ ++) {
//			for(int z_ = 0; z_ < 20; z_ ++) {
//				world.setCubeWithoutUpdate(x_*2, (int) (Math.random() * 20), z_*2, Cubes.CopperCube);
//				world.setCubeWithoutUpdate(x_*2, (int) (Math.random() * 20), z_*2, Cubes.GoldCube);
//				world.setCubeWithoutUpdate(x_, 0, z_, Cubes.StoneCube);
//			}}
//			
//			world.getWorldRender().removeCube(new Vector3f());
//			world.getWorldRender().removeCube(new Vector3f());
//			world.setCubeWithoutUpdate(0, 0, 0, Cubes.StoneCube);

			for(int x_ = 5; x_ < 15; x_ ++) {
			for(int y_ = 5; y_ < 15; y_ ++) {
			for(int z_ = 5; z_ < 15; z_ ++) {
				lastChunk.setCubeWithoutUpdate(x_, y_, z_, //false//(x_ == 14 || y_ == 14 || z_ == 14 || x_ == 5 || y_ == 5 || z_ == 5)
						/*? Cubes.StrangeCube :*/ Cube.getCubeByID( (x_ + y_ + z_) % (Cube.getCubes().length - 2) + 1) 
				);
			}}}

			first = false;
		}

		if(lastChunk != null) {
			registerChunk(lastChunk);
			if(lastChunk.isAccessible()) {
				if(lastChunk.getRenderAccountability().hasUnaddedCubes()) {
					lastChunk.getRenderAccountability().addUnaddedCubes();
				}
			}
		}
		world.getWorldRender().bypassAccountability(false);
		world.getWorldRender().blockAllRebuilds(false);
//		world.getWorldRender().rebuildAll();
		
//		final int RADIUS = 10;
//		
//		float f1, f2, f3, f4;
//		
//		for(int rotY = 0; rotY < 360; rotY ++) {
//		for(int rotX = 0; rotX < 360; rotX ++) {
//				
//			
//		for(int radius = 0; radius < RADIUS; radius ++) {			
//			
//			f1 = (float)  Math.cos(Math.toRadians(rotY));
//			f2 = (float)  Math.sin(Math.toRadians(rotY));
//			f3 = (float)  Math.cos(Math.toRadians(rotX));                  
//			f4 = (float)  Math.sin(Math.toRadians(rotX));                  
//			
//			Vector3f pos = new Vector3f(
//					Math.round(f2 * f3 * radius), 
//					Math.round(f4 * radius), 
//					Math.round(f1 * f3 * radius))
//				.add(world.getChunkSizeAsVector().multiply(World.CHUNK_SIZE).divide(2).add(0, World.CHUNK_SIZE, 0));
//				
//			if(pos.lessThenOrEqual(world.getChunkSizeAsVector().multiply(World.CHUNK_SIZE).subtract(1)) 
//					&& pos.greaterThenOrEqual(0) && world.getCube(pos).isSolid(world.getCubeMetadata(pos))) {
//				world.setCubeWithoutUpdate(pos, Cubes.WaterCube.getId());
//			}
//		}}}
		
//		for(Chunk chunk : loadedChunks) {
//			if(chunk.getY() == 1) {
//				for(int x = 0; x < chunk.getSize(); x ++) {
//				for(int y = 0; y < chunk.getSize(); y ++) {
//				for(int z = 0; z < chunk.getSize(); z ++) {
////					chunk.setCube(x, y, z, Cubes.Air);
//					
//					if(y + 1 < chunk.getSize() && !Cube.getCubeByID(chunk.getCube(x, y + 1, z)).isSolid(0)) {
//						chunk.setCube(x, y + 1, z, Cubes.WaterCube);
//					} else if(y + 1 >= chunk.getSize()) {
//						chunk.setCube(x, y, z, Cubes.WaterCube);
//					}
//				}}}
//			}
			
//			chunk.setCubeWithoutUpdate(0, 1, 0, Cubes.StoneCube);
//			chunk.setCubeWithoutUpdate(0, 0, 0, Cubes.WaterCube);
//			chunk.handelMassUpdate();
//		}
	}

	private void updateNeighbors(Chunk current, boolean state) {
		Vector3f min = center.subtract(loadRadius).capMin(0);
		Vector3f max = center.add(loadRadius).capMax(world.getChunkSizeAsVector()).subtract(1);
		Vector3f pos = current.getPos().clone();

		if(pos.anyLessThen(min) || pos.anyGreaterThen(max)) return;

		updateNeighbor(pos.subtract(1, 0, 0), current, min, max, false, Side.RightFace, state);
		updateNeighbor(pos.subtract(0, 1, 0), current, min, max, false, Side.TopFace, state);
		updateNeighbor(pos.subtract(0, 0, 1), current, min, max, false, Side.FrontFace, state);

		updateNeighbor(pos.add(1, 0, 0), current, min, max, true, Side.LeftFace, state);
		updateNeighbor(pos.add(0, 1, 0), current, min, max, true, Side.BottomFace, state);
		updateNeighbor(pos.add(0, 0, 1), current, min, max, true, Side.BackFace, state);
	}

	public void updateNeighbor(Vector3f pos, Chunk current, Vector3f min, Vector3f max, boolean greater, Side side, boolean state) {
		Side oppSide = side.getOpposite();
		if((pos.lessThenOrEqual(max) && greater) || (pos.greaterThenOrEqual(min) && !greater)) {
			Chunk chunk = getChunk(pos);

			if(chunk != null && chunk.isInitialized()) {
				if(chunk.isLoaded() && current.isLoaded()) {
					current.loadNeighbor(oppSide, state);
				}

				if(!chunk.isAccessible() && chunk.isLoaded()) {
					chunk.loadNeighbor(side, state);
					if(chunk.isAccessible()) registerChunk(chunk);
				}
			}
		} else {
			current.loadNeighbor(oppSide, state);
		}
	}

	private void registerChunk(Chunk chunk) {
		chunk.handelMassUpdate();
	}

	public void saveChunks() {
		for(Vector3f pos : loadedChunks.keySet()) {
			loadedChunks.get(pos).save(fileLoc);
		}
	}

	public boolean areAllChunkRendersCurrent() {
		// for(Chunk chunk : getLoadedChunks()) { TODO: Uncomment / Fix
		// if(chunk != null && chunk.isAccessible() &&
		// (chunk.getRenderAccountability().isRenderRebuildRequested()
		// || chunk.getRenderAccountability().hasUnrenderedCubes()))
		// return true;
		// }

		return false;
	}

	public void forceAllChunksUpdate() {
		for(Vector3f pos : loadedChunks.keySet()) {
			Chunk chunk = loadedChunks.get(pos);
			if(chunk != null && chunk.isAccessible()) {
				chunk.requestRenderRebuild();
			}
		}
	}

	public Chunk getChunk(Vector3f pos) {
		return getChunk((int) pos.x, (int) pos.y, (int) pos.z);
	}

	public Chunk getChunk(int x, int y, int z) {
		return loadedChunks.get(new Vector3f(x, y, z));
	}

	public Vector3f getCenter() {
		return center;
	}

	public int getLoadRadius() {
		return loadRadius;
	}

	public void setCenter(Vector3f center) {
		this.center = center;
	}

	public void setLoadRadius(int loadRadius) {
		this.loadRadius = loadRadius;
	}

	public void cleanUp() {
		for(Vector3f chunk : loadedChunks.keySet()) {
			if(loadedChunks.get(chunk) != null) {
				loadedChunks.get(chunk).cleanUp();
			}
		}
	}

	public synchronized HashMap<Vector3f, Chunk> getLoadedChunks() {
		return loadedChunks;
	}
}