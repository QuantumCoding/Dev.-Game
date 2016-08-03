package com.GameName.World.Render;

import java.util.LinkedList;

import com.GameName.Cube.Cube;
import com.GameName.Registry.ResourceManager.Cubes;
import com.GameName.Util.MathUtil;
import com.GameName.Util.Side;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.World;
import com.GameName.World.Chunk.Chunk;

public class ChunkRenderAccountability {
	public static final int 
		CONTAINS_CUBE_BIT = 0, RENDER_UPDATED_BIT = 1,
		LEFT_FACE_BIT = 2, RIGHT_FACE_BIT = 4,
		FRONT_FACE_BIT = 3, BACK_FACE_BIT = 5,
		TOP_FACE_BIT = 6, BOTTON_FACE_BIT = 7;
	
	private Chunk chunk;
	private byte[] renderMap;
	
	private boolean addingUnadded;
	private LinkedList<Vector3f> unaddedCubes;
	private LinkedList<Vector3f> preUnaddedCubes;
	
	public ChunkRenderAccountability(Chunk chunk) {
		this.chunk = chunk;
		renderMap = new byte[chunk.getSize() * chunk.getSize() * chunk.getSize()];
		unaddedCubes = new LinkedList<>();
		preUnaddedCubes = new LinkedList<>();
	}
	
	public void addCube(int x, int y, int z, Cube cube, int metadata) {
		if(!chunk.isLoaded() || !chunk.isAccessible()) {
			if(!addingUnadded) unaddedCubes.add(new Vector3f(x, y, z));
			else preUnaddedCubes.add(new Vector3f(x, y, z));
			
			return;
		}
		
		if(chunk.getY() == 1 && x == 10 && y == 10 && z == 10 && cube == Cubes.StoneCube)
			System.out.print("");
		
		boolean isOpaque = cube.isOpaque(metadata);
		
		Cube[] neighbors = chunk.getSurroundingCubes(x, y, z);
		int[] metadatas = chunk.getSurroundingCubesMetadata(x, y, z);
		Vector3f position = new Vector3f(x, y, z);
		
		{
			int pos = (int) position.multiply(1, chunk.getSize(), chunk.getSize() * chunk.getSize()).sum();
			
			setRenderMap(pos, CONTAINS_CUBE_BIT, cube.isVisable(metadata));
			setRenderMap(pos, RENDER_UPDATED_BIT, false);
			
			for(Side side : Side.values()) {
				setRenderMap(pos, side.index() + 2, !cube.isVisable(metadata) ?  false : neighbors[side.index()] == null ? 
						true : !neighbors[side.index()].isOpaque(metadatas[side.index()]));
			}
		}

		Vector3f minPos = new Vector3f();		
		Vector3f maxPos = new Vector3f(chunk.getSize() - 1);
		Vector3f checkPos = new Vector3f();
		
		for(Side side : Side.values()) {	
			checkPos = position.add(side.getDirection());
			
			if(checkPos.anyLessThen(minPos) || checkPos.anyGreaterThen(maxPos)) {	
				Chunk workingChunk = chunk.getWorld().getChunk_WorldScale(
						checkPos.add(chunk.getPos().multiply(chunk.getSize())));
				if(workingChunk == null) continue;

				checkPos = checkPos.add(World.CHUNK_SIZE).mod(World.CHUNK_SIZE);
				int pos = (int) checkPos.multiply(1, chunk.getSize(), chunk.getSize() * chunk.getSize()).sum();
				ChunkRenderAccountability renderA = workingChunk.getRenderAccountability();
//				if(!renderA.getRenderMap(pos, CONTAINS_CUBE_BIT)) continue;
				
				renderA.setRenderMap(pos, side.getOpposite().index() + 2, !isOpaque);
				renderA.setRenderMap(pos, RENDER_UPDATED_BIT, false);
				continue;
			}
			
			int pos = (int) checkPos.multiply(1, chunk.getSize(), chunk.getSize() * chunk.getSize()).sum();
//			if(!getRenderMap(pos, CONTAINS_CUBE_BIT)) continue;
			
			setRenderMap(pos, side.getOpposite().index() + 2, !isOpaque);
			setRenderMap(pos, RENDER_UPDATED_BIT, false);
		}
		
		chunk.getWorld().getWorldRender().addCube(position.add(chunk.getPos().multiply(World.CHUNK_SIZE)), cube, metadata);
		
// TODO: Replace with denoting an update is needed
//		if(addUndaddedCount == 1) {
//			int calcX = (int) position.add(chunk.getPos().multiply(World.CHUNK_SIZE)).x;
//			int calcY = (int) position.add(chunk.getPos().multiply(World.CHUNK_SIZE)).y - 1;
//			int calcZ = (int) position.add(chunk.getPos().multiply(World.CHUNK_SIZE)).z;
//			
//			chunk.getWorld().getWorldRender().addCube(new Vector3f(calcX, calcY, calcZ), 
//					chunk.getWorld().getCube(calcX, calcY, calcZ), chunk.getWorld().getMetadata(calcX, calcY, calcZ), false);
//		}
//		for(Side side : Side.values()) {	
//			checkPos = position.add(side.getDirection());
//			if(checkPos.anyLessThen(minPos) || checkPos.anyGreaterThen(maxPos)) {	
//				Chunk workingChunk = chunk.getWorld().getChunk_WorldScale(
//					checkPos.add(chunk.getPos().multiply(chunk.getSize())));
//				if(workingChunk == null) continue;
//
//				checkPos = checkPos.add(World.CHUNK_SIZE).mod(World.CHUNK_SIZE);
//				
//				workingChunk.getWorld().getWorldRender().addCube(
//					checkPos = checkPos.add(workingChunk.getPos().multiply(World.CHUNK_SIZE)),
//					workingChunk.getWorld().getCube((int)checkPos.x, (int)checkPos.y, (int)checkPos.z), 
//					workingChunk.getWorld().getMetadata((int)checkPos.x, (int)checkPos.y, (int)checkPos.z), false);
//				
//				continue;
//			}
//			
//			
//			if(checkPos.anyLessThen(minPos) || checkPos.anyGreaterThen(maxPos)) continue;
//			int checkPosData = renderMap[(int) checkPos.multiply(1, chunk.getSize(), chunk.getSize() * chunk.getSize()).sum()];
//			chunk.getWorld().getWorldRender().addCube(
//				checkPos = checkPos.add(chunk.getPos().multiply(World.CHUNK_SIZE)),
//				chunk.getWorld().getCube((int)checkPos.x, (int)checkPos.y, (int)checkPos.z), 
//				chunk.getWorld().getMetadata((int)checkPos.x, (int)checkPos.y, (int)checkPos.z), false);
//		}
	}
	
	public void setRenderMap(int pos, int bit, boolean state) {
		byte modified = MathUtil.cirShiftRt(renderMap[pos], bit);
		modified = (byte) ((modified & 0xFE) | (state ? 1 : 0));
		renderMap[pos] = MathUtil.cirShiftRt(modified, 8 - bit);	
	}
	
	public boolean getRenderMap(int pos, int bit) {
		return (renderMap[pos] >> bit & 0x1) == 1;
	}
	
	public boolean[] getVisableFaces(Vector3f position) {
		int pos = (int) position.multiply(1, chunk.getSize(), chunk.getSize() * chunk.getSize()).sum();
		byte data = renderMap[pos];
		boolean[] visableFaces = new boolean[6];
		if((data & 0x1) == 0) return visableFaces;
		
		for(Side side : Side.values()) {
			visableFaces[side.index()] = (data >> side.index() + 2 & 0x1) == 1;
		}
		
		return visableFaces;
	}
	
	public void addUnaddedCubes() {
		addingUnadded = true;
		for(Vector3f position : unaddedCubes) {
			addCube((int) position.x, (int) position.y, (int) position.z, 
					Cube.getCubeByID(chunk.getCube((int) position.x, (int) position.y, (int) position.z)), 
					chunk.getMetadata((int) position.x, (int) position.y, (int) position.z));
		}
		
		addingUnadded = false;
		unaddedCubes.clear();
		unaddedCubes.addAll(preUnaddedCubes);
		preUnaddedCubes.clear();
	}
	
	public boolean hasUnaddedCubes() {
		return !unaddedCubes.isEmpty();
	}
}


//
//import java.util.ArrayList;
//
//import com.GameName.Cube.Cube;
//import com.GameName.Util.Side;
//import com.GameName.Util.Vectors.Vector3f;
//import com.GameName.World.World;
//import com.GameName.World.Chunk.Chunk;
//
//public class ChunkRenderAccountability {
//	private Chunk chunk;
//	private byte[] renderMap; // [ Side Visible ], IsRendered, Exists
//	private boolean renderRebuildRequested;
//	private ArrayList<Vector3f> delayedRenders;
//	
//	public ChunkRenderAccountability(Chunk chunk) {
//		this.chunk = chunk;
//		delayedRenders = new ArrayList<>();
//		renderMap = new byte[chunk.getSize() * chunk.getSize() * chunk.getSize()];	
//	}
//	
//	public void addCube(int x, int y, int z, Cube cube, int metadata) {
//		renderMap[x + (y * chunk.getSize()) + (z * chunk.getSize() * chunk.getSize())] |= 0x01;
//		boolean isSolid = cube.isSolid(metadata);
//		
//		Vector3f minPos = chunk.getWorld().getChunkLoader().getCenter().subtract(World.CHUNK_LOAD_DISTANCE).capMin(0);		
//		Vector3f maxPos = chunk.getWorld().getChunkLoader().getCenter().add(World.CHUNK_LOAD_DISTANCE)
//				.capMax(chunk.getWorld().getChunkSizeAsVector()).multiply(World.CHUNK_SIZE).subtract(1);
//		
//		Vector3f position = new Vector3f(x, y, z);
//		Vector3f checkPos = new Vector3f(), modPos = new Vector3f();
//		Cube[] neighbors = chunk.getSurroundingCubes(x, y, z);
//		int[] neighborsM = chunk.getSurroundingCubesMetadata(x, y, z);
//		
//		for(Side side : Side.values()) {
//			checkPos = position.add(side.getDirection());
//			modPos = checkPos.mod(chunk.getSize());
//			if(checkPos.anyGreaterThen(maxPos) || checkPos.anyLessThen(minPos))  continue;			
//			chunk.getWorld().getChunk_WorldScale((int) checkPos.x, (int) checkPos.y, (int) checkPos.z).getRenderAccountability().
//				setFace((int) modPos.x, (int) modPos.y, (int) modPos.z, side.getOpposite(), !isSolid); 
//			
//			if(neighbors[side.index()] == null) {
//				setFace(x, y, z, side, true);
//			} else {
//				setFace(x, y, z, side, neighbors[side.index()].isSolid(neighborsM[side.index()]));				
//			}
//		}
//		
//		chunk.getWorld().getWorldRender().addCube(position, cube, metadata);
//		chunk.getWorld().getWorldRender().updateIndices(position);
//	}
//	
//	public void removeCube(int x, int y, int z, boolean isSolid) {
//		renderMap[x + (y * chunk.getSize()) + (z * chunk.getSize() * chunk.getSize())] |= 0x00;
//		if(!isSolid) return;
//		
//		Vector3f minPos = chunk.getWorld().getChunkLoader().getCenter().subtract(World.CHUNK_LOAD_DISTANCE).capMin(0);		
//		Vector3f maxPos = chunk.getWorld().getChunkLoader().getCenter().add(World.CHUNK_LOAD_DISTANCE)
//				.capMax(chunk.getWorld().getChunkSizeAsVector()).multiply(World.CHUNK_SIZE).subtract(1);
//		
//		Vector3f position = new Vector3f(x, y, z);
//		Vector3f checkPos = new Vector3f(), modPos = new Vector3f();
//		
//		for(Side side : Side.values()) {
//			checkPos = position.add(side.getDirection());
//			modPos = checkPos.mod(chunk.getSize());
//			if(checkPos.anyGreaterThen(maxPos) || checkPos.anyLessThen(minPos))  continue;			
//			chunk.getWorld().getChunk_WorldScale((int) checkPos.x, (int) checkPos.y, (int) checkPos.z).getRenderAccountability().
//				setFace((int) modPos.x, (int) modPos.y, (int) modPos.z, side.getOpposite(), true); 
//		}
//		
//		chunk.getWorld().getWorldRender().removeCube(position);
//		chunk.getWorld().getWorldRender().updateIndices(position);
//	}
//	
//	private void setFace(int x, int y, int z, Side face, boolean visable) {
//		int pos = x + (y * chunk.getSize()) + (z * chunk.getSize() * chunk.getSize());
//		renderMap[pos] |= (visable ? 1 : 0) << (face.index() + 1); 				
//	}
//	
//	public void render(Vector3f position) {
//		delayedRenders.remove(position);
//	}
//	
//	public boolean isRendered(Vector3f position) {
//		return !delayedRenders.contains(position);
//	}
//	
//	public void delayRender(int position) {
//		renderRebuildRequested = true;
//		delayedRenders.add(new Vector3f(
//				(position % chunk.getSize()), 
//				(position / chunk.getSize()) % chunk.getSize(), 
//				(position / chunk.getSize()) / chunk.getSize())
//			); 
//	}
//
//	public void changeCube(int x, int y, int z, Cube cube, int metadata) {
//		changeCube(new Vector3f(x, y, z), cube, metadata);
//	}
//	
//	public void changeCube(Vector3f position, Cube cube, int metadata) {
//		chunk.getWorld().getWorldRender().addCube(position.add(chunk.getPos().multiply(chunk.getSize())), cube, metadata); 
//	}
//
//	public ArrayList<Vector3f> getUnrenderedPositions() {
//		return delayedRenders;
//	}
//	
//	public boolean hasUnrenderedCubes() {
//		return delayedRenders.size() > 0;
//	}
//	
//	public void requestRenderRebuild() {
//		renderRebuildRequested = true;
//	}
//	
//	public boolean isRenderRebuildRequested() {
//		return renderRebuildRequested;
//	}
//	
//	public void rebuildRender() {
//		renderRebuildRequested = false;
//	}
//}
