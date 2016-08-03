package com.GameName.Input;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class TemporaryInputHandler {
	private HashMap<TempControl, TempAction> actionMap;
	private HashMap<TempControl, Boolean> onceMap;
	
	public TemporaryInputHandler() {
		actionMap = new HashMap<>();
		onceMap = new HashMap<>();
	}
	
	public boolean addControl(TempControl key, TempAction value, boolean onlyOnce) {
		if(onlyOnce) onceMap.put(key, false);
		return actionMap.put(key, value) != null;
	}
	
	public void checkControls() {
		for(TempControl control : actionMap.keySet()) {
			if(control.isActive()) {
				if(onceMap.containsKey(control)) {
					if(onceMap.get(control) == true) continue;
					onceMap.put(control, true);
				}
				
				actionMap.get(control).invoke();
				
			} else if(onceMap.containsKey(control)) {
				onceMap.put(control, false);
			}
		}
	}
	
	public static class TempControl {
		private static final float DEVIATION = 0.25f;
		
		private TempControlType inputSystem;
		private TempInputType inputType;
		
		private int index, extra;
		private float value;
		
		public TempControl(TempControlType inputSystem, TempInputType inputType, int index, float value) {
			this(inputSystem, inputType, index, value, 0);
		}
		
		public TempControl(TempControlType inputSystem, TempInputType inputType, int index, float value, int extra) {
			this.inputSystem = inputSystem;
			this.inputType = inputType;
			this.index = index;
			this.value = value;
			this.extra = extra;
		}
		
		public boolean isActive() {
			switch(inputSystem) {
				case Controller:
					if(inputType == TempInputType.Axis) {
						float info = Controllers.getController(extra).getAxisValue(index);
						return info * value > 0 && Math.abs(info) > Math.abs(value) - DEVIATION && 
								Math.abs(info) > Math.abs(value) + DEVIATION;
					}
					
					return Controllers.getController(extra).isButtonPressed(index) == (value > 0 ? true : false);
					
				case Keyboard:
					return Keyboard.isKeyDown(index) == (value > 0 ? true : false);
					
				case Mouse:
					if(inputType == TempInputType.Axis) {
						float info = index == 0 ? Mouse.getDX() : index == 1 ? Mouse.getDY() : Mouse.getDWheel();
						return info * value > 0 && Math.abs(info) > Math.abs(value) - DEVIATION && 
								Math.abs(info) > Math.abs(value) + DEVIATION;
					}
					
					return Mouse.isButtonDown(index) == (value > 0 ? true : false);
					
				default: 
					System.err.println("Invaled Input Platform!"); return false;
			}
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			
			result = prime * result + extra;
			result = prime * result + index;
			result = prime * result + ((inputSystem == null) ? 0 : inputSystem.hashCode());
			result = prime * result + ((inputType == null) ? 0 : inputType.hashCode());
			result = prime * result + Float.floatToIntBits(value);
			
			return result;
		}

		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(!(obj instanceof TempControl)) return false;
			
			TempControl other = (TempControl) obj;
			if(extra != other.extra) return false;
			if(index != other.index) return false;
			if(inputSystem != other.inputSystem) return false;
			if(inputType != other.inputType) return false;
			if(Float.floatToIntBits(value) != Float.floatToIntBits(other.value)) return false;
			
			return true;
		}
	}
	
	public static class TempAction {
		private Method method;
		private Object invoker;
		private Object[] parms;
		
		public TempAction(Method method, Object invoker, Object... parms) {
			this.method = method;
			this.invoker = invoker;
			this.parms = parms;
		}

		public void invoke() {
			try {
				method.invoke(invoker, parms);
			} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static enum TempControlType {
		Mouse, Keyboard, Controller;
	}
	
	public static enum TempInputType {
		Button, Axis;
	}
}
