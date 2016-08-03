package com.GameName.Input;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class InputHandeler {
	private HashMap<Control, ArrayList<Action>> actionMap;
	
	public InputHandeler() {
		actionMap = new HashMap<>();
	}
	
	public void addAction(Action action, Control defaultControl) {
		if(!actionMap.containsKey(defaultControl))
			actionMap.put(defaultControl, new ArrayList<Action>());
		
		actionMap.get(defaultControl).add(action);
	}
	
	public void changeControl(Control newControl, Action action) {
		for(Control control : actionMap.keySet()) {
		for(Action checkAction : actionMap.get(control)) {
			if(checkAction == action) {
				actionMap.get(control).remove(action);
				addAction(action, newControl);
				return;
			}
		}}
	}
	
	public void handelInput(Control control) {
//		for(Action action : actionMap.get(control)) {
//			action.activate(control);
//		}
	}
	
	public void update() {
		Keyboard.poll();
		Mouse.poll();
		Controllers.poll();
		
		Controllers.getEventSource();
//		Keyboard.get
	}
}
