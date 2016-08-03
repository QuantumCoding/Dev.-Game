package com.GameName.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceAccess {
	public static final String ROOT_PATH = "res";
	
	private static InputStream getStream(String path) {
		try {
			return new FileInputStream(ROOT_PATH + path);
		} catch(FileNotFoundException e) {}
		
		throw new IllegalArgumentException("File \"" + ROOT_PATH + path + "\" was not found");
//				ResourceAccess.class.getResourceAsStream(ROOT_PATH + path);
	} 
	
	public static InputStreamReader openInputStreamReader(String path) {
		return new InputStreamReader(getStream(path));
	}
	
	public static InputStream openInputStream(String path) {
		return getStream(path);
	}
}
