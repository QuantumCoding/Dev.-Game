package com.GameName.World.Render;

import java.util.ArrayList;
import java.util.HashMap;

import com.GameName.Cube.Cube;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.World.World;

public class WorldRender {
	private static final RenderProperties DEFAULT_RENDER_PROPERTIES = new WorldRenderProperties();
	
	private World world;
	private HashMap<Shader, ArrayList<WorldRenderSection>> renderSections;
	private HashMap<Vector3f, WorldRenderSection> renderPositions;
	private boolean bypassAccountability, blockingRebuilds;
	
	public WorldRender(World world) {
		this.world = world;
		
		renderSections = new HashMap<>();
		renderPositions = new HashMap<>();
		
		bypassAccountability = false;
	}
	
	public void render(Camera camera) {
		for(Shader shader : renderSections.keySet()) {
			for(WorldRenderSection worldRenderSection : renderSections.get(shader)) {
				worldRenderSection.render(DEFAULT_RENDER_PROPERTIES, camera);
			}
		}
	}
	
	public void blockAllRebuilds(boolean block) {
		this.blockingRebuilds = block;
		for(Shader shader : renderSections.keySet()) {
			for(WorldRenderSection worldRenderSection : renderSections.get(shader)) {
				worldRenderSection.setBufferingBlocked(block);
			}
		}
	}
	
	public void forceRebuildAll() { rebuildAll(true); }
	public void rebuildAll() { rebuildAll(false); }
	
	public boolean isBypassingAccountability() { return bypassAccountability; }
	
	public void bypassAccountability(boolean bypassAccountability) {
		this.bypassAccountability = bypassAccountability;
	}
	
	private void rebuildAll(boolean forceRebuild) {
		for(Shader shader : renderSections.keySet()) {
			for(WorldRenderSection worldRenderSection : renderSections.get(shader)) {
				if(worldRenderSection.isDataChanged() || forceRebuild) {
					System.out.println("Section: " + worldRenderSection + " needed Update");
					
					if(forceRebuild || worldRenderSection.areVertexsChanged()) 
						worldRenderSection.bufferVertexs();
					
					if(forceRebuild || worldRenderSection.areIndicesChanged()) 
						worldRenderSection.bufferIndices();
				}
			}
		}
	}
	
	public void addCube(Vector3f position, Cube cube, int metadata) {
		addCube(position, cube, metadata, true); }
	protected void addCube(Vector3f position, Cube cube, int metadata, boolean remove) {
//		System.out.println(cube + " added at " + position + " with metadata " + metadata);
		boolean hasSection = renderPositions.containsKey(position);
		if(remove && hasSection) {
			removeCube(position);
		}
		
		if(!cube.isVisable(metadata)) return;
		
		if(!remove && hasSection) {
			renderPositions.get(position).addCube(position, cube, metadata, true);
			return;
		}
		
		Shader shader = cube.getRender(metadata).getShader(metadata);	
		
		ArrayList<WorldRenderSection> sections;
		if((sections = renderSections.get(shader)) == null) {
			ArrayList<WorldRenderSection> newList = new ArrayList<>();
			renderSections.put(shader, newList);
			sections = newList;	
		}
		
		for(WorldRenderSection section : sections) {
			if(section.addCube(position, cube, metadata, false)) {				
				renderPositions.put(position, section);
				return;
			}
		}
		
		WorldRenderSection renderSection = new WorldRenderSection(shader, null, world);
		renderSection.setBufferingBlocked(blockingRebuilds); 
		renderSection.addCube(position, cube, metadata, false);			
		renderPositions.put(position, renderSection);
		sections.add(renderSection);
	}
	
	public void removeCube(Vector3f position) {
		try {
			renderPositions.get(position).removeCube(position);
		} catch(NullPointerException e) {
			System.err.println("No cube at position " + position);
		}
	}
	
//	public void updateIndices(Vector3f position) {
//		try {
//			renderPositions.get(position).updateIndices(position);
//		} catch(NullPointerException e) {
//			System.err.println("No cube at position " + position);
//		}
//	}
}
