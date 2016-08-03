package com.GameName.World;

import com.GameName.Cube.Cube;
import com.GameName.Engine.GameEngine;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.Chunk.Chunk;
import com.GameName.World.Chunk.ChunkLoader;
import com.GameName.World.Generation.EnvironmentGenerator;
import com.GameName.World.Render.WorldRender;

public class World {
	private static String defaultWorldRootDir = "res/worlds/";
	
	public static final float AMBIANT_LIGHT = 10;
	public static final float MAX_LIGHT = 10;
	public static final int CHUNK_SIZE = 20;
	public static final float CUBE_SIZE = 0.2f;
	
	private GameEngine ENGINE;	
	
	private int cubeSizeX, cubeSizeY, cubeSizeZ;
	private int chunkSizeX, chunkSizeY, chunkSizeZ;
	
	private String name;
	private int id, seed;
	
	public static final int CHUNK_LOAD_DISTANCE = 5;//2;//5;
	private ChunkLoader chunkLoader;
	private EnvironmentGenerator environmentGen;
	
	private WorldRender render;
		
	public World(int x, int y, int z, String name) {
		this(x, y, z, name, (int) (System.currentTimeMillis() % Integer.MAX_VALUE));
	}
	
	public World(int chunkSizeX, int chunkSizeY, int chunkSizeZ, String name, int seed) {
		cubeSizeX = chunkSizeX * CHUNK_SIZE;
		cubeSizeY = chunkSizeY * CHUNK_SIZE;
		cubeSizeZ = chunkSizeZ * CHUNK_SIZE;
		
		this.chunkSizeX = chunkSizeX;
		this.chunkSizeY = chunkSizeY;
		this.chunkSizeZ = chunkSizeZ;
		
		this.seed = seed;
		this.name = name;
		this.id = -1;
		
		chunkLoader = new ChunkLoader(ENGINE, this, CHUNK_LOAD_DISTANCE);
		environmentGen = new EnvironmentGenerator(ENGINE, seed, this);
		
		render = new WorldRender(this);
	}
	
	public void init(int worldId, GameEngine eng) {
		this.id = worldId;
		ENGINE = eng;
	}
	
	public boolean containsPos(int x, int y, int z) {
		return x >= 0 && y >= 0 && z >= 0 &&
				x < cubeSizeX && y < cubeSizeY && z < cubeSizeZ;
	}

	public static String getDefaultWorldRootDir() {
		return defaultWorldRootDir;
	}
	
	public String getResourceLocation() {
		return defaultWorldRootDir + name + "/";
	}

	public int getCubeSizeX() { return cubeSizeX; }
	public int getCubeSizeY() { return cubeSizeY; }
	public int getCubeSizeZ() { return cubeSizeZ; }
	public Vector3f getCubeSizeAsVector() {
		return new Vector3f(cubeSizeX, cubeSizeY, cubeSizeZ);
	}
	
	public int getChunkSizeX() { return chunkSizeX; }
	public int getChunkSizeY() { return chunkSizeY; }
	public int getChunkSizeZ() { return chunkSizeZ; }
	public Vector3f getChunkSizeAsVector() {
		return new Vector3f(chunkSizeX, chunkSizeY, chunkSizeZ);
	}

	public int getId() { return id; }
	public String getName() { return name; }
	public int getSeed() { return seed; }

	public ChunkLoader getChunkLoader() { return chunkLoader; }
	public EnvironmentGenerator getEnvironmentGen() { return environmentGen; }
	
	public WorldRender getWorldRender() { return render; }
	
// ----------------------------------------------------------------------------------------------------------------------------- \\
//												Port-Through Methods															 \\
// ----------------------------------------------------------------------------------------------------------------------------- \\	

	public Chunk getChunk(int x, int y, int z) { return chunkLoader.getChunk(x, y, z); }
	public Chunk getChunk_ChunkScale(int x, int y, int z) { return getChunk(x, y, z); }
	public Chunk getChunk_WorldScale(Vector3f position)   { return getChunk_WorldScale((int)position.x, (int)position.y, (int)position.z); }
	public Chunk getChunk_WorldScale(int x, int y, int z) { 
		int modX = (int) Math.floor((float) x / CHUNK_SIZE); 
		int modY = (int) Math.floor((float) y / CHUNK_SIZE); 
		int modZ = (int) Math.floor((float) z / CHUNK_SIZE); 
		return getChunk(modX, modY, modZ); 
	}
	
	public int getCubeId(int x, int y, int z) 	{ return getChunk_WorldScale(x, y, z).getCube(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public int getMetadata(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getMetadata(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public Cube getCube(int x, int y, int z) 	{ return Cube.getCubeByID(getCubeId(x, y, z)); }
	
	public Cube[] getSurroundingCubes(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getSurroundingCubes(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public int[] getSurroundingMetadata(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getSurroundingCubesMetadata(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }	
	
	public float[] getLightColor(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getLightColor(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public float getLightValue(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getLightValue(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	
	public int getDamage(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getDamage(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public boolean isNatural(int x, int y, int z) { return getChunk_WorldScale(x, y, z).isNatural(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public int getStructureId(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getStructureId(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public int getSunlight(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getSunlight(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	
	public int getRawCubeData(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getRawCubeMap(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public int getRawLightData(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getRawLightMap(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	public int getRawExtraData(int x, int y, int z) { return getChunk_WorldScale(x, y, z).getRawExtraData(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
	
	public void setCube(int x, int y, int z, Cube cube) { getChunk_WorldScale(x, y, z).setCube(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE, cube); }
	public void setMetadata(int x, int y, int z, int metadata) { getChunk_WorldScale(x, y, z).setMetadata(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE, metadata); }
	public void setCubeWithMetadata(int x, int y, int z, Cube cube, int metadata) { getChunk_WorldScale(x, y, z).setCubeWithMetadata(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE, cube, metadata); }
	
	public void setCubeWithoutUpdate(int x, int y, int z, Cube cube) { getChunk_WorldScale(x, y, z).setCubeWithoutUpdate(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE, cube); }
	public void setMetadataWithoutUpdate(int x, int y, int z, int metadata) { getChunk_WorldScale(x, y, z).setMetadataWithoutUpdate(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE, metadata); }
	
	public void makeUnnatural(int x, int y, int z) { getChunk_WorldScale(x, y, z).makeUnnatural(x % CHUNK_SIZE, y % CHUNK_SIZE, z % CHUNK_SIZE); }
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
	
	public void render(Camera camera) { render.render(camera); } 
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
	
	public void cleanUp() {
//		chunkLoader.saveChunks();
	}
}
