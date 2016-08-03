package com.GameName.Engine;

import com.GameName.Entity.EntityPlayer;
import com.GameName.Input.TemporaryInputHandler;
import com.GameName.Input.TemporaryInputHandler.TempAction;
import com.GameName.Input.TemporaryInputHandler.TempControl;
import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.World.World;

public class GameEngine {
	private GameName_New gameName;
	
//	private Console console;
//	private GLContextThread glContextThread;
//	private ThreadGroup threads;
	
//	private PhysicsEngine physics;
	private RenderEngine render;
//	private SoundEngine sound;
	
	private World currentWorld;
	private EntityPlayer player;
	private TemporaryInputHandler inputHandler;
	
//	private Server server;
//	private Client client;
	
	public GameEngine(GameName_New gameName) {
		this.gameName = gameName;
	}
	
	public GameEngine init(World world, Window window) {
//		console = new Console(this);
//		glContextThread = new GLContextThread();
//		threads = new ThreadGroup();		

		currentWorld = world;
		player = new EntityPlayer(new Camera(70, (float) window.getWidth() / (float) window.getHeight(), 0.3f, 1000));
		inputHandler = new TemporaryInputHandler();
		
//		physics = new PhysicsEngine(new AABBCollisionDispacher());
		render = new RenderEngine();
//		sound = new SoundEngine(this);
		
//		server = new Server(this);
//		client = new Client(this);
		
		return this;
	}
	
//	public Console getConsole() {return console;}
//	public GLContextThread getGLContext() {return glContextThread;}	
//	public ThreadGroup getThreads() {return threads;}
//	public void addThread(GameThread thread) {threads.addThread(thread);}
	
//	public void add(PhysicsObject obj) {physics.add(obj);}
//	public void add(IRenderable obj) {render.add(obj);}
//	public void add(SoundEvent obj) {sound.add(obj);}
	
	public void addControl(TempControl key, TempAction value, boolean onlyOnce) {
		inputHandler.addControl(key, value, onlyOnce);
	}

//	public PhysicsEngine getPhysics() {return physics;}	
	public RenderEngine getRender() {return render;}	
//	public SoundEngine getSound() {return sound;}

	public TemporaryInputHandler getInputHandeler() { return inputHandler; }
	public EntityPlayer getPlayer() {return player;}
	public World getWorld() {return currentWorld;}
	
//	public Server getServer() {return server;}
//	public Client getClient() {return client;}
	
	public boolean isRunning() {return true;}
	public GameName_New getGameName() {return gameName;}
	
	public void cleanUp() {
//		threads.stopAll();
		
//		physics.cleanUp();
//		render.cleanUp();
//		sound.cleanUp();
	}
}
