package com.GameName.Registry.Registries;

import java.util.ArrayList;

import com.GameName.Engine.GameEngine;
import com.GameName.RenderEngine.Shaders.Shader;

public class ShaderRegistry {
	private static Shader[] shaders;
	private static ArrayList<Shader> unregisteredShaders;
	
	static {
		unregisteredShaders = new ArrayList<>();
	}
	
	public static void registerShader(Shader shader) {
		unregisteredShaders.add(shader);
	}	
	
	public static void conclude(GameEngine engine) {
		shaders = unregisteredShaders.toArray(new Shader[unregisteredShaders.size()]);
		
		for(Shader shader : shaders) {
			engine.getRender().addRenderer(shader.getRenderer());
		}
		
		unregisteredShaders.clear();
		unregisteredShaders = null;
	}	
	
	public static Shader[] getShaders() {
		return shaders;
	}
	
	public static void cleanUp() {
		for(Shader shader : shaders) {
			shader.cleanUp();
		}
	}
}
