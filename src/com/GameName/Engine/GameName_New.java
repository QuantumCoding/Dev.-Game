package com.GameName.Engine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import com.GameName.Input.TemporaryControlAdder;
import com.GameName.Particles.ParticleEmitterNon;
import com.GameName.Registry.ResourceManager;
import com.GameName.Registry.ResourceManager.Worlds;
import com.GameName.Registry.Interfaces.ISetup;
import com.GameName.Registry.Registries.CubeRegistry;
import com.GameName.Registry.Registries.EntityRegistry;
import com.GameName.Registry.Registries.ShaderRegistry;
import com.GameName.Registry.Registries.ThreadRegistry;
import com.GameName.Registry.Registries.WorldRegistry;
import com.GameName.RenderEngine.Particles_NonInst.Particle;
import com.GameName.RenderEngine.Particles_NonInst.ParticleManager;
import com.GameName.RenderEngine.Particles_NonInst.Texture.ParticleTexture;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.Util.Vectors.Vector3f;

public class GameName_New implements ISetup {
	private static final String VERSION = "In-Dev";
	private static ArrayList<ISetup> mods = new ArrayList<>();
	
	private GameEngine engine;
	private ResourceManager res;
	private Window window;
	
	private boolean isRunning;
	
	public void preInit() {
		res = new ResourceManager();		
		window = new Window();	
		
		try {
			window.setTitle("GameName");		
			window.setIcon(ImageIO.read(new File("res/textures/icon.png"))); 
			window.initDisplay();		
			
//			File[] files = new File("res/textures/Splash Screen").listFiles();
//			File splashImage = files[(int) (Math.random() * 100) % files.length];
//			
//			window.setSplash(new Texture2D(ImageIO.read(splashImage)));
//			window.drawSplash();
		} catch(IOException | LWJGLException e) { e.printStackTrace(); }		

		ResourceManager.addCubeRegistery(res);
		ResourceManager.addWorldRegistery(res);
		ResourceManager.addThreadRegistery(res);
		ResourceManager.addEntityRegistery(res);
		ResourceManager.addCommandRegistery(res);
		ResourceManager.addShaderRegistery(res);
		
		for(ISetup mod : mods) {
			mod.preInit();
		}
	}
	
	public void init() {
		engine = new GameEngine(this);
		engine.init(Worlds.MainWorld, window);	
		
		ResourceManager.registerAll(engine);	
		
		CubeRegistry.conclude();
		WorldRegistry.conclude(engine);
		ThreadRegistry.conclude();
		EntityRegistry.conclude();
//		CommandRegistry.conclude();
		ShaderRegistry.conclude(engine);
		
//		window.setupOpenGL(engine);
		window.drawSplash();
		
		for(ISetup mod : mods) {
			mod.init();
		}
	}
	
	public void postInit() {
		
//		engine.getThreads().setEngine(engine);
		
//		engine.getPlayer().setCurrentWorld(Worlds.MainWorld);
//		engine.getPlayer().setControls(EntityPlayer.loadControls(new File("res/option/controls.dtg")));
//		engine.getPlayer().setRenderDistance(1000);
//		engine.getPlayer().resetCam();
		
//		Threads.EntityThread.addEntity(engine.getPlayer());
//		Threads.PhysicsThread.setPhysicsEngine(engine.getPhysics());
//		engine.add(engine.getPlayer());
		
//		Threads.WorldLoadThread.setWorld(Worlds.MainWorld);
		
//		try {
//			emitter = new ParticleEmitter(engine.getRender().getParticleManager(), 
//					new Vector3f(10, 2, 10).multiply(World.CUBE_SIZE), 
//					new Texture2D(ImageIO.read(new File("res/textures/ParticleTest.png"))), 0.1f);
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		TemporaryControlAdder.addControls(engine);
		
		for(ISetup mod : mods) {
			mod.postInit();
		}
	}
	
	public void run() {
		isRunning = true;
//		Worlds.MainWorld.getLoadedWorld().getAccess().getChunkLoaded().update();
		
//		engine.getThreads().addAll(engine.getConsole().getThread());
//		engine.getThreads().startAll(); FPS_Thread.start();
//		ConsoleWindow.start(engine.getConsole());
		
//		engine.getPlayer().reset();
		
//		ParticleManager manager = new ParticleManager();
//		ParticleEmitter emitter = null;
//		try {
//			emitter = new ParticleEmitter(manager, new Vector3f(5),
//					ParticleTexture.getRegistry().registerTexture(4, new File("res/textures/ParticleD.png")), 
//					5, false);
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		ParticleTexture texture = null; // particleStar
		try { texture = ParticleTexture.getRegistry().registerTexture(4, new File("res/textures/ParticleD.png")); } 
		catch(IOException e) { e.printStackTrace(); }
		texture.setAdditvieBlending(false);
		
		ParticleTexture.getRegistry().compressTexture();
		
		ParticleManager manager = new ParticleManager();
		ParticleEmitterNon emitter = new ParticleEmitterNon(manager, new Vector3f(2), texture, 0.001f, false);
		
		double frameTimeAvg = 0.0;
		int frameAvgCounter = 0;
		
		while(isRunning && !window.isCloseRequested()) {
			Camera camera = engine.getPlayer().getCamera();

//			emitter.update(1);
//			manager.update(1, camera);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_U)) {
				manager.addParticle(new Particle(new Vector3f(2), (float) (Math.random() * 360), Vector3f.random(1), 
						Vector3f.random(6).subtract(3, 0, 3), new Vector3f().randomize(2).multiply(-1), 10, texture));
			}
			
			emitter.update((float) window.getFrameTime());
			manager.update((float) window.getFrameTime(), camera);
			
			engine.getInputHandeler().checkControls();
			engine.getWorld().getChunkLoader().update();
				

			manager.render(camera);
//			engine.getWorld().render(camera);
			engine.getRender().render(camera);		
			
			window.update();
			
			if(frameAvgCounter >= 50) {
				frameTimeAvg /= (double) frameAvgCounter;
				window.setTitle(window.getTitle().split(" | ")[0] 
						+  " | FPS: " + (int)(1.0/frameTimeAvg) + "\t FrameTime: " + (float)frameTimeAvg);
				
				frameTimeAvg = 0.0;
				frameAvgCounter = 0;
			} else {
				frameTimeAvg += window.getFrameTime();
				frameAvgCounter ++;
			}		
		}		

		manager.cleanUp();
		
//		FPS_Thread.interrupt();
//		engine.getThreads().stopAll();
	}
	
	public void cleanUp() {
		engine.cleanUp();
		
		Worlds.MainWorld.cleanUp();
	}
	
	public static boolean addMod(ISetup mod) {return mods.add(mod);}
	
	public GameEngine getEngine() {return engine;}
	public ResourceManager getRes() {return res;}
	public Window getWindow() {return window;}
	
	public boolean isRunning() {return isRunning;}
	public void stop() {isRunning = false;}
	
	public String getVersion() {
		return VERSION;
	}
}
