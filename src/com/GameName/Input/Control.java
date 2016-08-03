package com.GameName.Input;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.GameName.Util.Vectors.Vector2f;

public class Control {
	
	private Controller[] controllerMap;
	
// --------------- INPUT INFO --------------- \\
	private boolean[] keyboardMap;
	private boolean[] mouseButtonMap;
	private boolean[][] controllerButtonMap;
	
	private Vector2f mousePosition;
	private Vector2f mouseAcceleration;
	
	private float[][] controllerAxis;
	private Vector2f[] controllerPOV;
	
// --------------- ERROR INFO --------------- \\
	private Vector2f mousePosError;
	private Vector2f mouseAccelerationError;
	
	private float[][] controllerAxisError;
	private Vector2f[] controllerPOVError;
	
// ------------------------------------------------ Builder ------------------------------------------------------------------ \\
	public static class ControlBuilder {
		private Controller[] controllerMap;
		
	// --------------- INPUT INFO --------------- \\
		private boolean[] keyboardMap = new boolean[Keyboard.getKeyCount()];
		private boolean[] mouseButtonMap = new boolean[Mouse.getButtonCount()];
		private boolean[][] controllerButtonMap;
		
		private Vector2f mousePosition;
		private Vector2f mouseAcceleration;
		
		private float[][] controllerAxis;
		private Vector2f[] controllerPOV;
		
	// --------------- ERROR INFO --------------- \\
		private Vector2f mousePosError;
		private Vector2f mouseAccelerationError;
		
		private float[][] controllerAxisError;
		private Vector2f[] controllerPOVError;
				
		public Control build() {
			Control control = new Control();

			control.controllerMap = controllerMap;
			
			control.keyboardMap = keyboardMap;           
			control.mouseButtonMap = mouseButtonMap;        
			control.controllerButtonMap = controllerButtonMap;   

			control.mousePosition = mousePosition;        
			control.mouseAcceleration = mouseAcceleration;    

			control.controllerAxis = controllerAxis;
			control.controllerPOV = controllerPOV;       

			control.mousePosError = mousePosError;    
			control.mouseAccelerationError = mouseAccelerationError;

			control.controllerAxisError = controllerAxisError;
			control.controllerPOVError = controllerPOVError; 
					 
			return control;
		}
		
		public ControlBuilder addKey(int keyCode) {
			this.keyboardMap[keyCode] = true;
			return this;
		}
		
		public ControlBuilder setMouseButtonMap(boolean[] mouseButtonMap) {
			this.mouseButtonMap = mouseButtonMap;
			return this;
		}
		
		public ControlBuilder setControllerButtonMap(boolean[][] controllerButtonMap) {
			this.controllerButtonMap = controllerButtonMap;
			return this;
		}
		
		public ControlBuilder setMousePosition(Vector2f mousePosition) {
			this.mousePosition = mousePosition;
			return this;
		}
		
		public ControlBuilder setMouseAcceleration(Vector2f mouseAcceleration) {
			this.mouseAcceleration = mouseAcceleration;
			return this;
		}
		
		public ControlBuilder setControllerAxis(float[][] controllerAxis) {
			this.controllerAxis = controllerAxis;
			return this;
		}
		
		public ControlBuilder setControllerPOV(Vector2f[] controllerPOV) {
			this.controllerPOV = controllerPOV;
			return this;
		}
		
		public ControlBuilder setMousePosError(Vector2f mousePosError) {
			this.mousePosError = mousePosError;
			return this;
		}
		
		public ControlBuilder setMouseAccelerationError(Vector2f mouseAccelerationError) {
			this.mouseAccelerationError = mouseAccelerationError;
			return this;
		}
		
		public ControlBuilder setControllerAxisError(float[][] controllerAxisError) {
			this.controllerAxisError = controllerAxisError;
			return this;
		}
		
		public ControlBuilder setControllerPOVError(Vector2f[] controllerPOVError) {
			this.controllerPOVError = controllerPOVError;
			return this;
		}
	}
		
// ----------------------------------------------- Accessors ----------------------------------------------------------------- \\
	public Controller[] getControllerMap() { return controllerMap; }
	public boolean[] getKeyboardMap() { return keyboardMap; }
	public boolean[] getMouseButtonMap() { return mouseButtonMap; }
	public boolean[][] getControllerButtonMap() { return controllerButtonMap; }
		
	public Vector2f getMousePosition() { return mousePosition; }
	public Vector2f getMouseAcceleration() { return mouseAcceleration; }
	public float[][] getControllerAxis() { return controllerAxis; }	
	public Vector2f[] getControllerPOV() { return controllerPOV; }
	
	public Vector2f getMousePosError() { return mousePosError; }
	public Vector2f getMouseAccelerationError() { return mouseAccelerationError; }
	public float[][] getControllerAxisError() { return controllerAxisError; }
	public Vector2f[] getControllerPOVError() { return controllerPOVError; }

	public boolean[] getButtonMap(Controller controller) { return controllerButtonMap[getControllerIndex(controller)]; }
	
	public float[] getAxis(Controller controller) { return controllerAxis[getControllerIndex(controller)]; }
	public Vector2f getPOV(Controller controller) { return controllerPOV[getControllerIndex(controller)]; }
	
	public float[] getAxisError(Controller controller) { return controllerAxisError[getControllerIndex(controller)]; }
	public Vector2f getPOVError(Controller controller) { return controllerPOVError[getControllerIndex(controller)]; }
	
	public int getControllerIndex(Controller controller) {
		for(int i = 0; i < controllerMap.length; i ++) {
			if(controllerMap[i] == controller) {
				return i;
			}
		}
		
		return -1;
	}
}
