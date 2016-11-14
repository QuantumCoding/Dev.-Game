package com.GameName.PhysicsEngine.Detection;

public class IntersectionPeriod implements Comparable<IntersectionPeriod> {
	public static final IntersectionPeriod NO_INTERSECTION = new IntersectionPeriod(2, -2);
	
	private float t0;
	private float t1;
	
	public IntersectionPeriod(float startTime, float endTime) {
		this.t0 = startTime;
		this.t1 = endTime;
	}

	public float getStartTime() { return t0; }
	public float getEndTime() { return t1; }
	
	public float t0() { return t0; }
	public float t1() { return t1; }
	
	public boolean isValid() {
		return !(Float.isNaN(t0) || Float.isNaN(t1)) &&
			   !(Float.isInfinite(t0) || Float.isInfinite(t1)) &&
			   !(t0 > 1 || t1 < 0);
	}
	
	public void clamp() {
		if(t0 > 1) t0 = 1;
		if(t0 < 0) t0 = 0;
		if(t1 > 1) t1 = 1;
		if(t1 < 0) t1 = 0;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + Float.floatToIntBits(t1);
		result = prime * result + Float.floatToIntBits(t0);
		
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof IntersectionPeriod)) return false;
		
		IntersectionPeriod other = (IntersectionPeriod) obj;
		if(Float.floatToIntBits(t1) != Float.floatToIntBits(other.t1)) return false;
		if(Float.floatToIntBits(t0) != Float.floatToIntBits(other.t0)) return false;
		
		return true;
	}
	
	public String toString() {
		return "IntersectionPeriod [" + t0 + ", " + t1 + "]";
	}

	public int compareTo(IntersectionPeriod o) {
		return Float.compare(t0, o.t0);
	}
}
