package com.GameName.Input;

import org.lwjgl.input.Keyboard;

import com.GameName.Engine.GameEngine;
import com.GameName.Entity.EntityPlayer;
import com.GameName.Input.TemporaryInputHandler.TempAction;
import com.GameName.Input.TemporaryInputHandler.TempControl;
import com.GameName.Input.TemporaryInputHandler.TempControlType;
import com.GameName.Input.TemporaryInputHandler.TempInputType;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class TemporaryControlAdder {
	public static void addControls(GameEngine engine) {
		try {
			
			// Forward
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_W, 0.5f), 
				new TempAction(EntityPlayer.class.getMethod("move", Vector3f.class), engine.getPlayer(), new Vector3f(0, 0, 0.1f)), false);
			// Backward
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_S, 0.5f), 
					new TempAction(EntityPlayer.class.getMethod("move", Vector3f.class), engine.getPlayer(), new Vector3f(0, 0, -0.1f)), false);
			// Left
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_A, 0.5f), 
					new TempAction(EntityPlayer.class.getMethod("move", Vector3f.class), engine.getPlayer(), new Vector3f(-0.1f, 0, 0)), false);
			// Right
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_D, 0.5f), 
					new TempAction(EntityPlayer.class.getMethod("move", Vector3f.class), engine.getPlayer(), new Vector3f(0.1f, 0, 0)), false);
			// Up
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_Q, 0.5f), 
					new TempAction(EntityPlayer.class.getMethod("move", Vector3f.class), engine.getPlayer(), new Vector3f(0, 0.15f, 0)), false);
			// Down
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_Z, 0.5f), 
					new TempAction(EntityPlayer.class.getMethod("move", Vector3f.class), engine.getPlayer(), new Vector3f(0, -0.15f, 0)), false);
			
			// Rot -X
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_UP, 0.5f), 
					new TempAction(Camera.class.getMethod("rotateX", float.class), engine.getPlayer().getCamera(), -0.75f), false);
			// Rot +X
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_DOWN, 0.5f), 
					new TempAction(Camera.class.getMethod("rotateX", float.class), engine.getPlayer().getCamera(), +0.75f), false);
			// Rot -Y
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_LEFT, 0.5f), 
					new TempAction(Camera.class.getMethod("rotateY", float.class), engine.getPlayer().getCamera(), -0.75f), false);
			// Rot +Y
			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_RIGHT, 0.5f), 
					new TempAction(Camera.class.getMethod("rotateY", float.class), engine.getPlayer().getCamera(), +0.75f), false);
//			// Rot -Z
//			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_LEFT, 0.5f), 
//					new TempAction(Camera.class.getMethod("rotateZ", float.class), engine.getPlayer().getCamera(), -0.1f), false);
//			// Rot +Z
//			engine.addControl(new TempControl(TempControlType.Keyboard, TempInputType.Button, Keyboard.KEY_LEFT, 0.5f), 
//					new TempAction(Camera.class.getMethod("rotateZ", float.class), engine.getPlayer().getCamera(), +0.1f), false);
		
		} catch(NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
