package com.GameName.Registry.Registries;

import java.util.ArrayList;

import com.GameName.Cube.Cube;
import com.GameName.RenderEngine.Textures.Texture;
import com.GameName.RenderEngine.Util.Color.ColorFormat;

public class CubeRegistry {
	private static Cube[] cubes;
	private static ArrayList<Cube> unregisteredCubes;
	
	static {
		unregisteredCubes = new ArrayList<>();
	}

	public static void registerCube(Cube reg) {
		unregisteredCubes.add(reg);
	}
	
	public static void conclude() {
		Cube.getDefaultTextureSheet().blockTextureCompression(true);
		
		for(Cube cube : unregisteredCubes) {
			cube.concludeInit(); //TODO: FIX WARNING
			Texture[] textures = cube.getTextures();
			
			for(int frame = 0; frame < textures.length; frame ++) {
				Texture texture = textures[frame];
				Cube.getDefaultTextureSheet().addTexture(cube.getName() + ":" + frame, 
						texture.getRawData(), ColorFormat.OPENGL_FORMAT);
			}
		}

		Cube.getDefaultTextureSheet().blockTextureCompression(false);
		Cube.getDefaultTextureSheet().compressTexture();
		cubes = unregisteredCubes.toArray(new Cube[unregisteredCubes.size()]);
		
		unregisteredCubes.clear();
		unregisteredCubes = null;
	}
	
	public static Cube[] getCubes() {
		return cubes;
	}
}
