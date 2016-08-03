package com.GameName.Input;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Action {
	private Method method;
	private Object invoker;
	
	private Action(Method method, Object inkoker) {
		this.method = method;
		this.invoker = inkoker;
	}
	
	public void activate(InputEvent event) {
		try {
			method.invoke(invoker, event);
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private static Method getMethod(Class<?> clazz, String methodName) {
		try {
			return clazz.getMethod(methodName, InputEvent.class);
		} catch(NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Action loadAction(Object obj, String methodName) throws NoSuchMethodException {
		Method method = getMethod(obj.getClass(), methodName);
		
		if(method == null) {
			throw new NoSuchMethodException("Could not load Method \"" + methodName + "\"\n"
					+ "The method MUST take a InputEvent object as its ONLY parameter");
		}
		
		return new Action(method, obj);
	}
}
