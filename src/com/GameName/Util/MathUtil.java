package com.GameName.Util;

public class MathUtil {
	public static int max(int... nums) {
		int max = 0;
		for(int i : nums)
			if(i > max)
				max = i;
		return max;
	}
	
	public static int min(int... nums) {
		int min = Integer.MAX_VALUE - 1;
		for(int i : nums)
			if(i < min)
				min = i;
		return min;
	}
		
	public static byte cirShiftRt(byte bits, int k) {
		byte mask = (byte) ((-1 << k ^ 0xFF) << (Byte.SIZE - k) & 0xFF);
		return (byte) ((bits >>> k & ~mask | bits << (Byte.SIZE - k) & mask) & 0xFF);
	}
}
