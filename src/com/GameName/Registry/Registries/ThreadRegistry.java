package com.GameName.Registry.Registries;

import java.util.ArrayList;

import com.GameName.Thread.GameNameThread;

public class ThreadRegistry {
	private static GameNameThread[] threads;
	private static ArrayList<GameNameThread> unregisteredThreads;
	
	static {
		unregisteredThreads = new ArrayList<GameNameThread>();
	}
	
	public static void registerThread(GameNameThread reg) {
		unregisteredThreads.add(reg);
	}
	
	public static void conclude() {
		int index = 0;
		for(GameNameThread thread : unregisteredThreads) {
			thread.setId(index ++);
		}
		
		threads = unregisteredThreads.toArray(new GameNameThread[unregisteredThreads.size()]);
		
		unregisteredThreads.clear();
		unregisteredThreads = null;
	}
	
	public static GameNameThread[] getThreads() {
		return threads;
	}
}
