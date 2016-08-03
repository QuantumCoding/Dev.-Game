/**
 * 
 */
package com.GameName.Engine;

import com.GameName.RenderEngine.Window.Window;

/**
 * @author QuantumCoding
 *
 */

public class Start {
	private static GameName_New gameName;
	
	public static void main(String... args) {
		gameName = new GameName_New();
		
		gameName.preInit();
		gameName.init();
		gameName.postInit();
		
		System.out.println("OpenGL Version: " + Window.getOpenGLVersion());
		System.out.println("GLSL Version: " + Window.getGLSLVersion());
				
		try {
			gameName.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cleanUp();		
	}
	
	public GameName_New getGameName() {
		return gameName;
	}
	
	public static void cleanUp() {
		try {
			gameName.cleanUp();
			
			
		} catch(NullPointerException e) {
			e.printStackTrace();
			
		} finally {		
//			Logger.saveLog(new File());			
			System.exit(0);
		}
	}
}