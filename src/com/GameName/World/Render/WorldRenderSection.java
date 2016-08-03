package com.GameName.World.Render;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.GameName.Cube.Cube;
import com.GameName.Cube.Render.ICubeRender;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.RenderStructs.Vertex;
import com.GameName.Util.Side;
//import com.GameName.Util.HashMirror;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.World;

public class WorldRenderSection extends Model {
//	private static final boolean[] ALL_SIDES = {true, true, true, true, true, true};
//	private static final boolean[] ONE_SIDES = {true, false, false, false, false, false};
	private static final int MAX_VERTEX_COUNT = 0xFFFFFF;
	private static final int VERTEX_LEEWAY = 64;
	private static int lastStructId;

	private final int structId;

	private ArrayList<Vertex> vertexs;
	private HashMap<Vertex, Integer> vertexTracker;
	private ArrayList<Byte> vertexUseCount;
	private ArrayList<Integer> indices;
	private ArrayDeque<Integer> indicesBlanks;
	private HashMap<Vector3f, int[]> positionIndices;

	private boolean bufferingBlocked;
	private boolean dataChanged, indicesChanged, vertexsChanged;

	private World world;

	/**
	 * 
	 * @param initalData
	 *            Objects in array should be as followed: Vector3f, Cube,
	 *            Integer
	 * @param world
	 *            The world in witch the Render Section is located
	 */
	public WorldRenderSection(Shader shader, Object[][] initalData, World world) {
		super(null);

		vertexs = new ArrayList<>();
		vertexTracker = new HashMap<>();
		vertexUseCount = new ArrayList<>();
		indices = new ArrayList<>();
		indicesBlanks = new ArrayDeque<>();
		positionIndices = new HashMap<>();

		super.setShader(shader);
		super.setTexture(Cube.getDefaultTextureSheet().getTextureMap());

		this.world = world;
		structId = ++lastStructId;

		vertexs.add(new Vertex(new Vector3f(Float.MIN_VALUE), new Vector2f(), new Vector3f()));
		vertexUseCount.add((byte) 3);
		indices.add(0);
		indices.add(0);
		indices.add(0);

		modelData = new ModelData(100, 100000, new Vector3f());

		if(initalData != null) {
			bufferingBlocked = true;
			for(Object[] data : initalData) {
				addCube((Vector3f) data[0], (Cube) data[1], (int) data[2], true);
			}
			bufferingBlocked = false;

			bufferVertexs();
			bufferIndices();
		}

	}

	// public boolean addCube(Vector3f position, Cube cube, int metadata) {
	// if(indices.size() > MAX_VERTEX_COUNT) return false;
	//
	// ICubeRender render = cube.getRender(metadata);
	// boolean[] visableFaces = render.getVisableFaces(position, cube, metadata,
	// world.getChunk_WorldScale(position));
	// ArrayList<Vertex> cubeVertices = render.getVertices(position, cube,
	// metadata);
	// ArrayList<Integer> cubeIndices = render.getIndecies(cube, metadata,
	// visableFaces);
	//
	// if(indices.size() + cubeIndices.size() > MAX_VERTEX_COUNT +
	// VERTEX_LEEWAY) return false;
	// int[] usedIndecies = new int[cubeIndices.size()];
	// int[] vertexLocs = new int[cubeVertices.size()];
	//
	// int i = 0;
	// for(Integer index : cubeIndices) {
	// usedIndecies[i ++] = indices.size();
	// Vertex vertex = cubeVertices.get(index);
	//
	// if(vertices.keySet().contains(vertex)) {
	// indices.add(vertices.get(vertex)); //vertices.indexOf(vertex)
	// vertexUserCount.put(vertex, vertexUserCount.get(vertex) + 1);
	// } else {
	// indices.add(vertices.size());
	// vertices.put(vertex, vertices.size());
	// vertexUserCount.put(vertex, 1);
	// }
	//
	// vertexLocs[i - 1] = indices.get(indices.size() - 1);
	// }
	//
	// positionsIndicesLoc.put(position, usedIndecies);
	// bufferData();
	//
	// return true;
	// }

	public boolean addCube(Vector3f position, Cube cube, int metadata, boolean currentMember) {
		if(!currentMember && indices.size() - indicesBlanks.size() > MAX_VERTEX_COUNT) return false;

		ChunkRenderAccountability accountability = world.getChunk_WorldScale(position).getRenderAccountability();
		boolean[] visableFaces = accountability.getVisableFaces(position.mod(World.CHUNK_SIZE));

		byte changeTracker[] = new byte[6], changeSet = 6;
		
		int[] indicePositions = positionIndices.get(position);
		boolean indicesNull = indicePositions == null;
		int currentFaceSet = indicesNull ? 1 << 31 : indicePositions[0];
		
		int finalResultFaceSet = 1 << 31;
		for(int k = 0; k < visableFaces.length; k ++) {
			finalResultFaceSet |= (visableFaces[k] ? 1 : 0) << k;
			if(!currentMember) { changeTracker[k] = (byte) (visableFaces[k] ? 1 : 0); continue; }
			
			boolean correct = !indicesNull && visableFaces[k] == ((currentFaceSet >> k & 1) == 1);
			byte val = (byte) (visableFaces[k] ? 
					((currentFaceSet >> k & 1) == 1 ? 0 : 1) :
					((currentFaceSet >> k & 1) != 1 ? 0 : 2));
					
			visableFaces[k] = correct ? false : visableFaces[k];
			
			changeSet -= correct ? 1 : 0;
			changeTracker[k] = val;
		}

		ICubeRender render = cube.getRender(metadata);
		ArrayList<Vertex> cubeVertices = render.getVertices(position, cube, metadata);
		ArrayList<Integer> cubeIndices = render.getIndecies(cube, metadata, visableFaces);

		if(!currentMember && indices.size() - indicesBlanks.size() + cubeIndices.size() > MAX_VERTEX_COUNT + VERTEX_LEEWAY) 
			return false;
		
		if(indicesNull) indicePositions = new int[6 * 2 + 1]; //cubeIndices.size() / 3 + 1
		int[] changes = new int[changeSet * 2];
		int i = -1, j = 0, indexPos = 0;
		
		for(Integer index : cubeIndices) {
			// Get location to store Face Indices
			if(++i % 3 == 0) {
				if(!indicesBlanks.isEmpty()) {
					indexPos = indicesBlanks.pop();
				} else indexPos = indices.size();

				changes[j ++] = indexPos;
				i = 0;
			}

			// Check if List already contains Vertex
			Vertex vertex = cubeVertices.get(index);
//			HashMirror mirror = new HashMirror(vertex);
			Integer vertexIndex = vertexTracker.get(vertex);

			// Add Vertex / Position
			if(vertexIndex == null) {
				if(indexPos + i >= indices.size()) indices.add(vertexs.size());
				else indices.set(indexPos + i, vertexs.size());
				
				vertexTracker.put(vertex, vertexs.size());
				vertexs.add(vertex); vertexUseCount.add((byte) 1);

			} else {
				if(indexPos + i >= indices.size()) indices.add(vertexIndex);
				else indices.set(indexPos + i, vertexIndex);

				vertexUseCount.set(vertexIndex, (byte) (vertexUseCount.get(vertexIndex) + 1));
			}
		}

		indicePositions[0] = finalResultFaceSet;
		for(int k = 0, cCount = 0; k < 6; k ++) {
			if(changeTracker[k] != 0) {
				if(changeTracker[k] == 2) removeFace(indicePositions[k*2 + 1]);
				if(changeTracker[k] == 2) removeFace(indicePositions[k*2 + 2]);
				indicePositions[k*2 + 1] = changeTracker[k] == 2 ? 0 : changes[cCount ++];
				indicePositions[k*2 + 2] = changeTracker[k] == 2 ? 0 : changes[cCount ++];
			}
		}
		
		positionIndices.put(position, indicePositions);
		accountability.setRenderMap((int) position.mod(World.CHUNK_SIZE)
			.multiply(1, World.CHUNK_SIZE, World.CHUNK_SIZE * World.CHUNK_SIZE).sum(),
			ChunkRenderAccountability.RENDER_UPDATED_BIT, true);

		bufferVertexs();
		bufferIndices();

		return true;
	}

	public void removeCube(Vector3f position) {
//		System.out.println("Ya... I don't like " + position + " eather");
		int[] toRemove = positionIndices.get(position);
		for(int index : toRemove) {
			if(index <= 0) continue;
			removeFace(index);
		}
		
		positionIndices.remove(position);
		
		Vector3f minPos = world.getChunkLoader().getCenter().subtract(World.CHUNK_LOAD_DISTANCE)
				.multiply(World.CHUNK_SIZE).capMin(0);		
		Vector3f maxPos = world.getChunkLoader().getCenter().add(World.CHUNK_LOAD_DISTANCE)
				.capMax(world.getChunkSizeAsVector()).multiply(World.CHUNK_SIZE).subtract(1);
		
		boolean lastState = bufferingBlocked;
		bufferingBlocked = true;
		for(Side side : Side.values()) {
			Vector3f newPos = position.add(side.getDirection());
			if(!newPos.anyGreaterThen(maxPos) && !newPos.anyLessThen(minPos)) {
				this.world.getWorldRender().addCube(newPos, 
					world.getCube((int) newPos.x, (int) newPos.y, (int) newPos.z), 
					world.getMetadata((int) newPos.x, (int) newPos.y, (int) newPos.z), false);
			}
		} bufferingBlocked = lastState;
		
		bufferIndices();
		bufferVertexs(false);
	}
	
	private void removeFace(int index) {
		for(int i = 0; i < 3; i ++) {
			int oldIndex = indices.set(index + i, 0);
			vertexUseCount.set(oldIndex, (byte)(vertexUseCount.get(oldIndex) - 1));
			if(vertexUseCount.get(oldIndex) == 0) {
//				System.out.println("Removing vertex");
				//XXX Do Something?
			}
		}
		
		indicesBlanks.push(index);
	}
	
	public void bufferVertexs() {
		bufferVertexs(true); }
	public void bufferVertexs(boolean needUpdate) {
		if(needUpdate) dataChanged = vertexsChanged = true;
		if(bufferingBlocked || !vertexsChanged) return;
		System.out.println("Buffering Vertexs! " + super.toString());

		float[] positions = new float[vertexs.size() * 3];
		float[] texCoords = new float[vertexs.size() * 2];
		float[] normals = new float[vertexs.size() * 3];

		int j = 0;
		for(Vertex vertex : vertexs) {
			vertex.addTo(j ++, positions, texCoords, normals);
		}

		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, positions, true);
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_TEXCOORDS, 2, texCoords, true);
		modelData.storeDataInAttributeList(Shader.ATTRIBUTE_LOC_NORMALS, 3, normals, true);

		dataChanged = (vertexsChanged = false) && indicesChanged;
	}
	
	public void bufferIndices() {
		bufferIndices(true); }
	public void bufferIndices(boolean needUpdate) {
		if(needUpdate) dataChanged = indicesChanged = true;
		if(bufferingBlocked || !indicesChanged) return;
		System.out.println("Buffering Indices! " + super.toString());

		int[] indicesArray = new int[indices.size()];
		for(int i = 0; i < indices.size(); i ++) {
			indicesArray[i] = indices.get(i);
		} // TODO: Possibly add removal for 0's to save some memory

		modelData.loadIndicies(indicesArray);
		dataChanged = (indicesChanged = false) && vertexsChanged;
	}

	public int getStructId() {
		return structId;
	}

	public boolean isDataChanged() {
		return dataChanged;
	}

	public boolean areVertexsChanged() {
		return vertexsChanged;
	}

	public boolean areIndicesChanged() {
		return indicesChanged;
	}

	public boolean isBufferingBlocked() {
		return bufferingBlocked;
	}

	public void setBufferingBlocked(boolean block) {
		bufferingBlocked = block;
	}

	public Collection<Vector3f> getPositions() {
		return positionIndices.keySet();
	}
}
