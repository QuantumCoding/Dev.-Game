package com.GameName.PhysicsEngine.Detection.Intersection;

import com.GameName.Util.Vectors.Vector3f;

public class Intersection implements Comparable<Intersection> {
	public final IntersectionPeriod period;
	
	public Intersection(float t0, float t1) {
		this(new IntersectionPeriod(t0, t1));
	}
	
	public Intersection(IntersectionPeriod period) {
		this.period = period;
	}
	
	public int compareTo(Intersection o) {
		if(o == null) return -1;
		return period.compareTo(o.period);
	}
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	public static class LineIntersection extends Intersection {
		public final Vector3f p0, p1;
		
		public LineIntersection(float t0, float t1, Vector3f p0, Vector3f p1) {
			super(t0, t1);
			this.p0 = p0;
			this.p1 = p1;
		}
		
		public LineIntersection(IntersectionPeriod period, Vector3f p0, Vector3f p1) {
			super(period);
			this.p0 = p0;
			this.p1 = p1;
		}
	}
	
//	-------------------------------------------------------------------------------------------------------- \\
	
	public static class IntersectionLocation extends Intersection {
		public final Vector3f instersectionPoint;
		
		public IntersectionLocation(IntersectionPeriod period, Vector3f instersectionPoint) {
			super(period);
			this.instersectionPoint = instersectionPoint;
		}
		
		public IntersectionLocation(float t0, float t1, Vector3f instersectionPoint) {
			super(t0, t1);
			this.instersectionPoint = instersectionPoint;
		}
	}
}
