package com.GameName.Util;

import com.GameName.Util.Vectors.Vector3f;

public enum Side {
	LeftFace(0, new Vector3f(-1, 0, 0)), 		  // 0 -x			1				z         
	FrontFace(1, new Vector3f(0, 0, 1)),          // 1 +z		0	C	2		-x	c	x     
	RightFace(2, new Vector3f(1, 0, 0)),          // 2 +x			3			   -z         
	BackFace(3, new Vector3f(0, 0, -1)),          // 3 -z					4				+y
	TopFace(4, new Vector3f(0, 1, 0)),            // 4 +y					C				 c
	BottomFace(5, new Vector3f(0, -1, 0));        // 5 -y					5				-y
	
	private final int arrayIndex;
	private final Vector3f direction;
	Side(int arrayIndex, Vector3f direction) {
		this.arrayIndex = arrayIndex;
		this.direction = direction;
	}
	
	public int index() { 
		return arrayIndex;
	}
	
	public Vector3f getDirection() { 
		return direction;
	}
	
	public static Side getSide(int index) {
		return values()[index];
	}
	
	public Side getOpposite() {
		switch(this) {
			case BackFace: return FrontFace;
			case BottomFace: return TopFace;
			case FrontFace: return BackFace;
			case LeftFace: return RightFace;
			case RightFace: return LeftFace;
			case TopFace: return BottomFace;
			
			default: return null;
		}
	}
	
	public Side getNext() {
		return values()[(arrayIndex + 1) % values().length];
	}
	
	public Side getPrevious() {
		return values()[arrayIndex == 0 ? values().length : arrayIndex - 1];
	}
	
	public static Side getByDirection(Vector3f inner, Vector3f outer) {
		return getByDirection(inner.subtract(outer));
	}
	
	public static Side getByDirection(Vector3f direction) {
		for(Side side : values()) {
			if(side.getDirection().equalTo(direction)) {
				return side;
			}
		}
		
		return null;
	}
}