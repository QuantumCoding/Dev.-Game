package com.GameName.Input;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public abstract class InputEvent {
	
	public abstract InputType getInputType();
	
	public static class KeyboardInputEvent extends InputEvent {
		private char keyChar;
		private int keyCode;
		private boolean keyState;
		private long keyEventNanoseconds;
		
		public KeyboardInputEvent(char keyChar, int keyCode, boolean keyState, long keyEventNanoseconds) {
			this.keyChar = keyChar;
			this.keyCode = keyCode;
			this.keyState = keyState;
			this.keyEventNanoseconds = keyEventNanoseconds;
		}

		public char getKeyChar() { return keyChar; }
		public int getKeyCode() { return keyCode; }
		public boolean isKeyState() { return keyState; }
		public long getKeyEventNanoseconds() { return keyEventNanoseconds; }

		public InputType getInputType() {
			return InputType.Keyboard;
		}
		
		public static KeyboardInputEvent pollEvent() {
			return new KeyboardInputEvent(Keyboard.getEventCharacter(), Keyboard.getEventKey(), 
					Keyboard.getEventKeyState(), Keyboard.getEventNanoseconds());
		}
	}

	public static class MouseInputEvent extends InputEvent {
		private int buttonId;
		private boolean buttonState;
		private int dwheel, dx, dy;
		private long mouseEventNanoseconds;
		private int x, y;
		
		public MouseInputEvent(int buttonId, boolean buttonState, int dwheel, int dx, int dy, long mouseEventNanoseconds, int x, int y) {
			this.buttonId = buttonId;
			this.buttonState = buttonState;
			this.dwheel = dwheel;
			this.dx = dx;
			this.dy = dy;
			this.mouseEventNanoseconds = mouseEventNanoseconds;
			this.x = x;
			this.y = y;
		}

		public int getButtonId() { return buttonId; }
		public boolean isButtonState() { return buttonState; }
		public int getDwheel() { return dwheel; }
		public int getDx() { return dx; }
		public int getDy() { return dy; }
		public long getMouseEventNanoseconds() { return mouseEventNanoseconds; }
		public int getX() { return x; }
		public int getY() { return y; }

		public InputType getInputType() {
			return InputType.Mouse;
		}
		
		public static MouseInputEvent pollEvent() {
			return new MouseInputEvent(Mouse.getEventButton(), Mouse.getEventButtonState(), Mouse.getEventDWheel(),
					Mouse.getEventDX(), Mouse.getEventDY(), Mouse.getEventNanoseconds(), Mouse.getEventX(), Mouse.getEventY());
		}
	}
	
	public static class ControllerInputEvent extends InputEvent {
		private Controller controller;
		
		public ControllerInputEvent(Controller controller) {
			this.controller = controller;
		}
		
		public Controller getController() { return controller; }
		public boolean isButtonPressed(int index) { return controller.isButtonPressed(index); }
		public float getPovX() { return controller.getPovX(); }
		public float getPovY() { return controller.getPovY(); }
		public float getAxisValue(int index) { return controller.getAxisValue(index); }

		public InputType getInputType() {
			return InputType.Controller;
		}
		
		public static ControllerInputEvent pollEvent() {
			return new ControllerInputEvent(Controllers.getEventSource());
		}
	}
	
	public static enum InputType {
		Keyboard, Mouse, Controller;
	}
}
