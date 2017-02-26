package com.GameName.Util.Math;

public class MathUtil {
	public static int max(int... nums) {
		int max = Integer.MIN_VALUE;
		for(int i : nums)
			if(i > max)
				max = i;
		return max;
	}
	
	public static int min(int... nums) {
		int min = Integer.MAX_VALUE;
		for(int i : nums)
			if(i < min)
				min = i;
		return min;
	}
	
	public static float min(float... nums) {
		float min = Float.MAX_VALUE;
		for(float i : nums)
			if(i < min)
				min = i;
		return min;
	}
		
	public static float fastInvserseSqrt(float value) {
		int bits = Float.floatToIntBits(value);
		float approx = Float.intBitsToFloat(0x5f3759df - (bits >> 1));
		
		approx *= 1.5f - (value * approx * approx * .5f); // Newton's Method
		
		return approx;	
	}
	
	public static byte cirShiftRt(byte bits, int k) {
		byte mask = (byte) ((-1 << k ^ 0xFF) << (Byte.SIZE - k) & 0xFF);
		return (byte) ((bits >>> k & ~mask | bits << (Byte.SIZE - k) & mask) & 0xFF);
	}
	
	public static float[] quadicFormula(float a, float b, float c) {
		double d = b*b - 4 * a * c;
		
		if(d < 0 || a == 0) 
			return new float[] { Float.NaN, Float.NaN };
		
		double sqrtD = Math.sqrt(d);
		
		float root1 = (float) ((-b + sqrtD) / (2 * a));
		float root2 = (float) ((-b - sqrtD) / (2 * a));
	    
	    return new float[] { root1, root2 };
	}
}
