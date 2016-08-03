package com.GameName.Util;

public class HashMirror {
	private int hash;
	
	public HashMirror(Object obj) {
		this.hash = obj.hashCode();
	}
	
	public int hashCode() {
		return hash;
	}
	
	public boolean equals(Object other) {
		return other == null ? false : hash == other.hashCode();
	}
}
