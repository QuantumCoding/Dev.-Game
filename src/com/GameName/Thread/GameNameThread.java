package com.GameName.Thread;

import com.GameName.Engine.GameEngine;
import com.GameName.Util.Time;


public abstract class GameNameThread implements Runnable {
	private double tickTime;
	private boolean isRunning, isStopRequested, isPaused;
	private int TPS;
	
	private long lastTick;
	protected float timeSinceLastTick;
	
	private int tickRate;
	private String name;
	private int id;
	
	private Thread thread;
	protected GameEngine ENGINE;
	
	public GameNameThread(int tickRate, String name) {	
		tickTime = 1.0 / (double) tickRate;	
		
		this.name = name;
		this.tickRate = tickRate;
		
		thread = new Thread(this, name);
	}

	public void start() {
		isRunning = true;
		thread.start();
	}
	
	public void pause() throws InterruptedException {
		isPaused = true;
	}
	
	public void resume() {
		isPaused = false;
	}
	
	private void stop() throws InterruptedException {
		isRunning = false;
		
		thread.interrupt();		
		thread = new Thread(this, name);
		isStopRequested = false;
	}
	
	public void restart() {
		try {
			stop();
			thread = new Thread(this, name);
			start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {	
		init();

		long lastTime = Time.getSystemTime();
		double unprocessedTime = 0;
		
		int frames = 0;
		long frameCounter = 0;
		
		while(isRunning) {			
			boolean tick = false;

			long startTime = Time.getSystemTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double) Time.SECONDS;
			frameCounter += passedTime;
			
			while(unprocessedTime > tickTime) {
				tick = true;
				
				unprocessedTime -= tickTime;
				
				if(isStopRequested)	{
					try { stop(); } 
					catch (InterruptedException e) { e.printStackTrace(); }
				}
				
				if(frameCounter >= Time.SECONDS) {
					TPS = frames;
					
					frames = 0;
					frameCounter = 0;
				}
			}
			
			if(tick) {
				timeSinceLastTick = (float) (((double) Time.getSystemTime() - (double) lastTick) / Time.SECONDS);
				lastTick = Time.getSystemTime();
				
				if(!isPaused) {
					tick();		
					frames ++;
				}
			} else {				
				try	{
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}						
		}
	}
	
	protected abstract void init();
	protected abstract void tick();

	public boolean isRunning() { return isRunning; }
	public boolean isPaused() { return isPaused; }
	public boolean isLive() { return thread.isAlive(); }
	public void requesteStop() { isStopRequested = true; }

	public int getTPS() { return TPS; }
	public int getTickRate() { return tickRate; }

	public String getName() { return name; }
	public int getId() { return id; }	
	public void setId(int id) { this.id = id; }
	
	public void setENGINE(GameEngine ENGINE) { this.ENGINE = ENGINE; }
}
