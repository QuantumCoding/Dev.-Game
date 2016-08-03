package com.GameName.Util;

public class ArrayUtil {
	public static <T> T[] expandArray(T[] original, T[] newArray) {
		if(newArray.length < original.length) 
			throw new IllegalArgumentException("NewSize of " + newArray.length + " is less then original array size of " + original.length);
	
		for(int i = 0; i < original.length; i ++) {
			newArray[i] = original[i];
		}
		
		return newArray;
	}

	public static int[] expandArray(int[] original, int[] newArray) {
		if(newArray.length < original.length) 
			throw new IllegalArgumentException("NewSize of " + newArray.length + " is less then original array size of " + original.length);
	
		for(int i = 0; i < original.length; i ++) {
			newArray[i] = original[i];
		}
		
		return newArray;
	}
}
