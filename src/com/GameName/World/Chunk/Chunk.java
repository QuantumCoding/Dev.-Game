package com.GameName.World.Chunk;

import java.io.IOException;
import java.util.HashSet;

import com.GameName.Cube.Cube;
import com.GameName.Engine.GameEngine;
import com.GameName.Util.Side;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.World;
import com.GameName.World.Render.ChunkRenderAccountability;

public class Chunk {
	private final float MINIMUM_LIGHT_DEFUTION = 0.5f;
	private final GameEngine ENGINE;
	
	private boolean isInitialized;
	private boolean isAccessible;
	private boolean isModified;
	private boolean hasCubes, isLoaded;
	private boolean[] loadedNeighbors;
	private int cubeCount;
	
	private final World world;
	private final int x, y, z;
	
	private ChunkRenderAccountability renderAccountability;
	private HashSet<Cube> typesOfCubes;
	
	private int[] cubeMap;
	private int[] lightMap;
	private int[] extraDataMap;
	private final int size;
	
	private float ambiantLight = (float) ((1d / (double) World.MAX_LIGHT) * World.AMBIANT_LIGHT);
	
	public Chunk(GameEngine eng, int size, World world, int x, int y, int z) { 
		ENGINE = eng;
		this.world = world;
		
		this.x = x; this.y = y; this.z = z;
		
		this.size = size;
		
		int sizeCubed = size * size * size;
		cubeMap = new int[sizeCubed];
		lightMap = new int[sizeCubed];
		extraDataMap = new int[sizeCubed];
		
		for(int i = 0; i < sizeCubed; i ++) {
			int V = colorScale(ambiantLight) << 24 & 0xFF000000;
			int R = colorScale(1.0f) << 16 & 0x00FF0000;
			int G = colorScale(1.0f) << 8  & 0x0000FF00;
			int B = colorScale(1.0f) << 0  & 0x000000FF;
			
			lightMap[i] = V | R | G | B;
		}
		
		loadedNeighbors = new boolean[]{false, false, false, false, false, false};
		
		typesOfCubes = new HashSet<Cube>();
		renderAccountability = new ChunkRenderAccountability(this);
		isInitialized = true;
	}
	
	public void update() {}	
	public void randomUpdate() {}
	
	public void updateLightMap(int x, int y, int z, float[] color, float intensity) {
		if(x < 0 || y < 0 || z < 0 || x == size || y == size || z == size) {
			Chunk chunk = world.getChunk(
					this.x + (x < 0 ? -1 : x == size ? 1 : 0), //x=5 size=3 boolean ? true : false
					this.y + (y < 0 ? -1 : y == size ? 1 : 0),
					this.z + (z < 0 ? -1 : z == size ? 1 : 0));
			
			if(chunk == null) return;			
			
			chunk.updateLightMap(
						(x < 0 ? size - 1 : x == size ? 0 : x), 
						(y < 0 ? size - 1 : y == size ? 0 : y),
						(z < 0 ? size - 1 : z == size ? 0 : z),
						color, intensity);
			return;
		}

		float lastIntensity = getLightValue(x, y, z);
		float[] lastColor = getLightColor(x, y, z);
		
		float[] newColor = {
				(lastColor[0] * lastIntensity) + (color[0] * intensity), 
				(lastColor[1] * lastIntensity) + (color[1] * intensity),
				(lastColor[2] * lastIntensity) + (color[2] * intensity)
			};
		
		float newIntensity = Math.min(intensity + lastIntensity, 1);
		
		setLightColor(x, y, z, newColor);
		setLightValue(x, y, z, newIntensity);
		
		intensity -= ((1 / intensity) * Cube.getCubeByID(getCube(x, y, z)).getOpacity(getMetadata(x, y, z))) + MINIMUM_LIGHT_DEFUTION;
		
		if(intensity <= ambiantLight) {
//			renderAccountability.requestRenderRebuild(); 
			return; 
		}
		
		updateLightMap(x - 1, y, z, color, intensity);
		updateLightMap(x + 1, y, z, color, intensity);
		updateLightMap(x, y, z - 1, color, intensity);
		updateLightMap(x, y, z + 1, color, intensity);
	}	
	
	private void setLightValue(int x, int y, int z, float value) {
		int lightColor = lightMap[x + (size * y) + (size * size * z)] & 0x00FFFFFF;
		int lightValue = colorScale(value) << 24 & 0xFF000000;
		lightMap[x + (size * y) + (size  * size * z)] = lightValue | lightColor;
	}
	
	private void setLightColor(int x, int y, int z, float[] value) {
		int lightValue = lightMap[x + (size * y) + (size * size * z)] & 0xFF000000;
		
		int R = colorScale(value[0]) << 16 & 0x00FF0000;
		int G = colorScale(value[1]) << 8  & 0x0000FF00;
		int B = colorScale(value[2]) << 0  & 0x000000FF;
		
		lightMap[x + (size * y) + (size * size * z)] = lightValue | R | G | B; 
	}
	
	public int colorScale(float in) {
		return Math.min(Math.round((in * 255)), 255);
	}
	
	public int getRawCubeMap(int x, int y, int z) {
		return cubeMap[x + (y * size) + (z * size * size)];
	}
	
	public int getRawLightMap(int x, int y, int z) {
		return cubeMap[x + (y * size) + (z * size * size)];
	}
	
	public int getRawExtraData(int x, int y, int z) {
		return cubeMap[x + (y * size) + (z * size * size)];
	}
	
	public int getDamage(int x, int y, int z) {
		return extraDataMap[x + (y * size) + (z * size * size)] >> 26 & 0x0000003F;
	}
	
	public boolean isNatural(int x, int y, int z) {
		return (extraDataMap[x + (y * size) + (z * size * size)] >> 25 & 0x00000001) == 1;
	}
	
	public int getStructureId(int x, int y, int z) {
		return extraDataMap[x + (y * size) + (z * size * size)] >> 8 & 0x0000FFFF;
	}
	
	public int getSunlight(int x, int y, int z) {
		return extraDataMap[x + (y * size) + (z * size * size)] & 0x000000FF;
	}
	
	public void makeUnnatural(int x, int y, int z) {
		extraDataMap[x + (y * size) + (z * size * size)] = 
			(extraDataMap[x + (y * size) + (z * size * size)] & 0xFFFFFEFF)
			| (1 << 25 & 0x02000000); 
	}
	
	public int getCube(int x, int y, int z) {
		return cubeMap[x + (y * size) + (z * size * size)] >> 16 & 0x0000FFFF;
	}
	
	public int getMetadata(int x, int y, int z) {
		return cubeMap[x + (y * size) + (z * size * size)] & 0x0000FFFF;
	}
	
	public void setCubeWithoutUpdate(int x, int y, int z, Cube cube) {
		cubeMap[x + (y * size) + (z * size * size)] = 
				(cube.getId() << 16 & 0xFFFF0000) | getMetadata(x, y, z);
		makeUnnatural(x, y, z); isModified = true;
		renderAccountability.addCube(x, y, z, cube, getMetadata(x, y, z));
	}
	
	public void setMetadataWithoutUpdate(int x, int y, int z, int metadata) {
		cubeMap[x + (y * size) + (z * size * size)] = metadata | 
			(cubeMap[x + (y * size) + (z * size * size)] & 0xFFFF0000);
		makeUnnatural(x, y, z); isModified = true;
		renderAccountability.addCube(x, y, z, Cube.getCubeByID(getCube(x, y, z)), metadata);
	}
	
	public void loadCube(int pos, int c, int l, int e) {
		cubeMap[pos] = c; lightMap[pos] = l;
				extraDataMap[pos] = e;
//		renderAccountability.addCube(pos); //TODO: FIX THIS! THIS IS WHY THE CHUNK LOADING FROM FILE DOESN"T WORK
	}
	
	public void setCube(int x, int y, int z, Cube cube) {
		Cube lastCube = Cube.getCubeByID(getCube(x, y, z));
		setCubeWithoutUpdate(x, y, z, cube);
		
		handelUpdate(x, y, z, lastCube, getMetadata(x, y, z));
	}
	
	public void setMetadata(int x, int y, int z, int metadata) {
		int lastMetadata = getMetadata(x, y, z);
		setMetadataWithoutUpdate(x, y, z, metadata);
		
		handelUpdate(x, y, z, Cube.getCubeByID(getCube(x, y, z)), lastMetadata);
	}
	
	public void setCubeWithMetadata(int x, int y, int z, Cube cube, int metadata) {
		Cube lastCube = Cube.getCubeByID(getCube(x, y, z));
		int lastMetadata = getMetadata(x, y, z);

		setCubeWithoutUpdate(x, y, z, cube);
		setMetadataWithoutUpdate(x, y, z, metadata);
		
		handelUpdate(x, y, z, lastCube, lastMetadata);
	}
	
	/**
	 * @param x X position in the chunk
	 * @param y Y position in the chunk
	 * @param z Z position in the chunk
	 * @param lastCube The last cube that was at the point (x, y, z)
	 * @param lastMetadata The last metadata that was at the point (x, y, z)
	 */
	private void handelUpdate(int x, int y, int z, Cube lastCube, int lastMetadata) {
		Cube cube = Cube.getCubeByID(getCube(x, y, z));
		int metadata = getMetadata(x, y, z);		
		
		if(cube != lastCube) {
			if(!doesChunkContainCube(lastCube.getId())) {
				typesOfCubes.remove(lastCube);
			}
					
			if(typesOfCubes.add(cube)) {
				
			}
		}
		
		if(cube.isOpaque(metadata)) {
			hasCubes = true;			
			if(!lastCube.isOpaque(lastMetadata)) cubeCount ++;
			
		} else {
			if(lastCube.isOpaque(lastMetadata)) cubeCount --;
			if(cubeCount <= 0) hasCubes = false;
			
		}
		
		if(cube.isLightSorce(metadata)) {
			updateLightMap(x, y, z, cube.getLightColor(metadata), cube.getLightValue(metadata));
			
		} else if(lastCube.isLightSorce(lastMetadata)) { 				
		}
			
		if(ENGINE.getGameName().isRunning() && isPosOnEdge(x, y, z)) {
			Chunk chunk;
			
			if(x == 0) {chunk = world.getChunk(this.x - 1, this.y, this.z); if(chunk != null && chunk.isAccessible()) chunk.requestRenderRebuild();}
			if(y == 0) {chunk = world.getChunk(this.x, this.y - 1, this.z); if(chunk != null && chunk.isAccessible()) chunk.requestRenderRebuild();}
			if(z == 0) {chunk = world.getChunk(this.x, this.y, this.z - 1); if(chunk != null && chunk.isAccessible()) chunk.requestRenderRebuild();}

			if(x == size - 1) {chunk = world.getChunk(this.x + 1, this.y, this.z); if(chunk != null && chunk.isAccessible()) chunk.requestRenderRebuild();}
			if(y == size - 1) {chunk = world.getChunk(this.x, this.y + 1, this.z); if(chunk != null && chunk.isAccessible()) chunk.requestRenderRebuild();}
			if(z == size - 1) {chunk = world.getChunk(this.x, this.y, this.z + 1); if(chunk != null && chunk.isAccessible()) chunk.requestRenderRebuild();}
		}
		
//		renderAccountability.requestRenderRebuild();
	}
	
	/**
	 * Updates the whole chunk this includes:
	 * 		- Lighting Updates
	 * 		- Adding Cube types to set
	 * 		- Updating render's CubeTextureMap
	 * 		- Updates render's VBO
	 */
	public void handelMassUpdate() {
		typesOfCubes.clear();
		
		for(int x = 0; x < size; x ++) {
		for(int y = 0; y < size; y ++) {
		for(int z = 0; z < size; z ++) {
			Cube cube = Cube.getCubeByID(getCube(x, y, z));
			int metadata = getMetadata(x, y, z);
			
			if(cube.isLightSorce(metadata)) {
				updateLightMap(x, y, z, cube.getLightColor(metadata), cube.getLightValue(metadata));
			}
			
			if(!hasCubes && cube.isVisable(metadata)) {
				hasCubes = true;
			}
			
			if(typesOfCubes.add(cube));
			
//			renderAccountability.changeCube(x, y, z, cube, metadata);
//			System.out.println(Vector3f.printValues(x, y, z));
		}}}
		
//		renderAccountability.requestRenderRebuild();
	}
	
	public boolean isCubeVisable(int x, int y, int z) {
		for(Cube cube : getSurroundingCubes(x, y, z)) {
			if(cube == null) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isPosOnEdge(int x, int y, int z) {
		return x == 0 || y == 0 || z == 0 ||
				x == size - 1 || y == size - 1 || z == size - 1;
	}
	
	public Cube[] getSurroundingCubes(int x, int y, int z) {
		Cube[] cubes = new Cube[Side.values().length];
//		LoadedWorldAccess access = world.getLoadedWorld().getAccess();
		
		Vector3f minPos = world.getChunkLoader().getCenter().subtract(World.CHUNK_LOAD_DISTANCE)
				.multiply(World.CHUNK_SIZE).capMin(0);		
		Vector3f maxPos = world.getChunkLoader().getCenter().add(World.CHUNK_LOAD_DISTANCE)
				.capMax(world.getChunkSizeAsVector()).multiply(World.CHUNK_SIZE).subtract(1);
		
		Vector3f position = new Vector3f(x, y, z).add(getPos().multiply(size));
		Vector3f checkPos = new Vector3f();
		for(Side side : Side.values()) {
			checkPos = position.add(side.getDirection());
			
			if(checkPos.anyGreaterThen(maxPos) || checkPos.anyLessThen(minPos)) {
				cubes[side.index()] = null;
			} else {
				cubes[side.index()] = world.getCube((int)checkPos.x, (int)checkPos.y, (int)checkPos.z);
			}
		}
		
		return cubes;
	}
	
	public int[] getSurroundingCubesMetadata(int x, int y, int z) {
		int[] metadata = new int[Side.values().length];
		Vector3f minPos = world.getChunkLoader().getCenter().subtract(World.CHUNK_LOAD_DISTANCE)
				.multiply(World.CHUNK_SIZE).capMin(0);		
		Vector3f maxPos = world.getChunkLoader().getCenter().add(World.CHUNK_LOAD_DISTANCE)
				.capMax(world.getChunkSizeAsVector()).multiply(World.CHUNK_SIZE).subtract(1);
		
		Vector3f position = new Vector3f(x, y, z).add(getPos().multiply(size));;
		Vector3f checkPos = new Vector3f();
		for(Side side : Side.values()) {
			checkPos = position.add(side.getDirection());
			
			if(checkPos.anyGreaterThenOrEqual(maxPos) || checkPos.anyLessThenOrEqual(minPos)) {
				metadata[side.index()] = -1;
			} else {
				metadata[side.index()] = world.getMetadata((int)checkPos.x, (int)checkPos.y, (int)checkPos.z);
			}
		}
		return metadata;	
	}
	
	public Chunk[] getNeighbors() {
		Chunk[] chunks = new Chunk[Side.values().length];
		boolean[] loadedNeighbors = getLoadedNeighbors();
		
		Vector3f minPos = world.getChunkLoader().getCenter().subtract(World.CHUNK_LOAD_DISTANCE).capMin(0);		
		Vector3f maxPos = world.getChunkLoader().getCenter().add(World.CHUNK_LOAD_DISTANCE)
				.capMax(world.getChunkSizeAsVector()).subtract(1);
		
		Vector3f position = new Vector3f(x, y, z);
		Vector3f checkPos = new Vector3f();
		for(Side side : Side.values()) {
			if(!loadedNeighbors[side.index()]) continue;
			checkPos = position.add(side.getDirection());
			
			if(checkPos.anyGreaterThen(maxPos) || checkPos.anyLessThen(minPos)) {
				chunks[side.index()] = null;
			} else {
				chunks[side.index()] = world.getChunk_ChunkScale((int)checkPos.x, (int)checkPos.y, (int)checkPos.z);
			}
		}
		
		return chunks;
	}
	
	public void save(String fileLoc) {
		if(!isModified) return;
		
		try {
			ChunkIO.saveChunk(this);
			isModified = false;
			
		} catch(IOException e) {
			System.err.println("Failed to save Chunk " + getPos() + " in World " + world);
			e.printStackTrace();
		}
	}
	
	public float[] getLightColor(int x, int y, int z) {
		if(!isInitialized) return new float[] {1.0f, 1.0f, 1.0f};
		int value = lightMap[x + (y * size) + (z * size * size)];
		float multiplier = (1.0f / 255.0f);
		
		return new float[] {
				(value >> 16 & 0x000000FF) * multiplier, 
				(value >> 8  & 0x000000FF) * multiplier, 
				(value >> 0  & 0x000000FF) * multiplier
			};
	}
	
	public float getLightValue(int x, int y, int z) {
		if(!isInitialized) return ambiantLight;
		return lightMap[x + (y * size) + (z * size * size)] >> 24;
	}

	public World getWorld() { return world; }

	public int getX() { return x; }
	public int getY() { return y; }
	public int getZ() { return z; }
	
	public Vector3f getPos() {
		return new Vector3f(x, y, z);
	}

	public boolean isInitialized() {
		return isInitialized;
	}
	
	public boolean isLoaded() {
		return isLoaded;
	}

	public boolean hasCubes() {
		return hasCubes;
	}

	public ChunkRenderAccountability getRenderAccountability() {
		return renderAccountability;
	}
	
	public int getSize() { return size; }
	
	public boolean doesChunkContainCube(int cube) {
		for(int cubeId : cubeMap) {
			if(cubeId >> 16 == cube) {
				return true;
			}
		}
		
		return false;
	}
	
	public void requestRenderRebuild() { //TODO: Does nothing
//		renderAccountability.requestRenderRebuild();
	}
	
	public void setIsLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}
	
	public boolean isAccessible() {
		return isAccessible;
	}
	
	public boolean isModified() {
		return isModified;
	}
	
	public boolean[] getLoadedNeighbors() {
		return loadedNeighbors;
	}
	
	public void loadNeighbor(Side side, boolean state) {
		loadedNeighbors[side.index()] = state;

		for(boolean bool : loadedNeighbors) {
			if(!bool) {
				isAccessible = false;
				return;
			}
		}
		
		isAccessible = true;
	}

	public HashSet<Cube> getTypesOfCubes() {
		return typesOfCubes;
	}

	public int getCubeCount() {
		return cubeCount;
	}
	
	public String toString() {
		return "Chunk <" + x + ", " + y + ", " + z + ">" + "[world=" + world + "]";
	}
	
	public void cleanUp() {
		
	}
}
