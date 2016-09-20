package com.GameName.Registry;

import java.util.ArrayList;

import com.GameName.Cube.Cube;
import com.GameName.Cube.Cubes.AirCube;
import com.GameName.Cube.Cubes.ColorfulTestCube;
import com.GameName.Cube.Cubes.CopperCube;
import com.GameName.Cube.Cubes.DirectionalCube;
import com.GameName.Cube.Cubes.GoldCube;
import com.GameName.Cube.Cubes.StoneCube;
import com.GameName.Cube.Cubes.StrangeCube;
import com.GameName.Cube.Cubes.TestCube;
import com.GameName.Engine.GameEngine;
import com.GameName.Registry.Interfaces.ICommandRegister;
import com.GameName.Registry.Interfaces.ICubeRegister;
import com.GameName.Registry.Interfaces.IEntityRegister;
import com.GameName.Registry.Interfaces.IShaderRegister;
import com.GameName.Registry.Interfaces.IThreadRegister;
import com.GameName.Registry.Interfaces.IWorldRegister;
import com.GameName.Registry.Registries.CubeRegistry;
import com.GameName.Registry.Registries.ShaderRegistry;
import com.GameName.Registry.Registries.WorldRegistry;
import com.GameName.RenderEngine.Particles.Render.ParticleShader;
import com.GameName.RenderEngine.Shaders.DefaultShader;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.World.World;
import com.GameName.World.Render.WorldShader;

public class ResourceManager implements ICubeRegister, ICommandRegister,
		IEntityRegister, IWorldRegister, IThreadRegister, IShaderRegister {

	public void registerCubes() {
		CubeRegistry.registerCube(Cubes.Air);
//		CubeRegistry.registerCube(Cubes.TestCube);
//		CubeRegistry.registerCube(Cubes.ColorfulTestCube);
		CubeRegistry.registerCube(Cubes.StoneCube);
		CubeRegistry.registerCube(Cubes.GoldCube);
		CubeRegistry.registerCube(Cubes.CopperCube);
		CubeRegistry.registerCube(Cubes.DirectionalCube);
		CubeRegistry.registerCube(Cubes.StrangeCube);
	}

	public void registerWorlds() {
		WorldRegistry.registryWorld(Worlds.MainWorld);
	}

	public void registerThreads() {
		
	}

	public void registerEntities() {

	}

	public void registerCommands(GameEngine eng) {
//		CommandRegistry.registerCommand(new HelpCommand(eng));
//		CommandRegistry.registerCommand(new TeleportPlayerCommand(eng));
//		CommandRegistry.registerCommand(new SetPlayerPropertyCommand(eng));
//		CommandRegistry.registerCommand(new SaveCommand(eng));
	}
	
	public void registerShaders() {
		ShaderRegistry.registerShader(Shaders.DefaultShader);
		ShaderRegistry.registerShader(Shaders.WorldShader);
		ShaderRegistry.registerShader(Shaders.ParticleShader);
	}

	public static final class Cubes {
		public static final Cube Air = new AirCube();
		public static final Cube TestCube = new TestCube();
		public static final Cube ColorfulTestCube = new ColorfulTestCube();
		public static final Cube StoneCube = new StoneCube();
		public static final Cube GoldCube = new GoldCube();
		public static final Cube CopperCube = new CopperCube();
		
		public static final Cube DirectionalCube = new DirectionalCube();		
		public static final Cube StrangeCube = new StrangeCube();
	}

	public static final class Materials {
		// 0.72f
//		public static final Material Stone = new Material(2.3f, 1.5f, Phase.Solid, "Stone");
//		public static final Material Air = new Material(1.225f / 100, 0.0f, Phase.Gas, "Air");
//		public static final Material Water = new Material(1.00f, 0.0f, Phase.Liquid, "Water");
//		public static final Material Human = new Material(1.17f, 1000.0f, Phase.Solid, "Human");
		// 1.0f
	}

//														3, 2, 3
	public static final class Worlds {//                5, 2, 5
		public static final World MainWorld = new World(2, 2, 2, "MainWorld");
	}

	public static final class Threads {
		
	}

	public static final class Shaders {
		public static final Shader DefaultShader = new DefaultShader();
		public static final Shader ParticleShader = new ParticleShader();
		public static final Shader WorldShader = new WorldShader();
	}
	
//----------------------------------------------------------------------------------------------------------------------------------\\
//													Registry Handling																\\
//----------------------------------------------------------------------------------------------------------------------------------\\
	
	private static ArrayList<ICubeRegister> cubeRegs = new ArrayList<>();
	private static ArrayList<IWorldRegister> worldRegs = new ArrayList<>();
	private static ArrayList<IThreadRegister> threadRegs = new ArrayList<>();
	private static ArrayList<IEntityRegister> entityRegs = new ArrayList<>();
	private static ArrayList<ICommandRegister> commandRegs = new ArrayList<>();
	private static ArrayList<IShaderRegister> shaderRegs = new ArrayList<>();

	public static boolean addCubeRegistery(ICubeRegister e) {
		return cubeRegs.add(e);
	}

	public static boolean addWorldRegistery(IWorldRegister e) {
		return worldRegs.add(e);
	}

	public static boolean addThreadRegistery(IThreadRegister e) {
		return threadRegs.add(e);
	}

	public static boolean addEntityRegistery(IEntityRegister e) {
		return entityRegs.add(e);
	}

	public static boolean addCommandRegistery(ICommandRegister e) {
		return commandRegs.add(e);
	}

	public static boolean addShaderRegistery(IShaderRegister e) {
		return shaderRegs.add(e);
	}

	public static void registerAll(GameEngine eng) {
		for (ICubeRegister reg : cubeRegs)
			reg.registerCubes();
		
		for (IWorldRegister reg : worldRegs)
			reg.registerWorlds();
		
		for (IThreadRegister reg : threadRegs)
			reg.registerThreads();
		
		for (IEntityRegister reg : entityRegs)
			reg.registerEntities();
		
		for (ICommandRegister reg : commandRegs)
			reg.registerCommands(eng);
		
		for (IShaderRegister reg : shaderRegs)
			reg.registerShaders();
	}
}
