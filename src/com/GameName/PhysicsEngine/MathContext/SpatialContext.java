package com.GameName.PhysicsEngine.MathContext;

import com.GameName.Util.Vectors.Vector3f;

public class SpatialContext {
	public static final SpatialContext R3 = new SpatialContext() {
		public Vector3f convert(Vector3f vector, SpatialContext context) {
			if(context == null || context == R3) return vector;
			
			vector = vector.rotate(context.rotation);
			
			float x = vector.getX();
			float y = vector.getY();
			float z = vector.getZ();
			
			x = x * context.scale.x + context.origin.x;
			y = y * context.scale.y + context.origin.y;
			z = z * context.scale.z + context.origin.z;
			
			return new Vector3f(x, y, z);
		}
		
		public Vector3f scale(Vector3f vector, SpatialContext context) {
			return vector.multiply(context.scale);
		}
		
		public Vector3f translate(Vector3f vector, SpatialContext context) {
			return vector.add(context.origin);
		}
		
		public String toString() {
			return "SpatialContext [R3]";
		}
	};
	
	private Vector3f scale;
	private Vector3f origin;
	private Vector3f rotation;
	
	public SpatialContext() { this(null, null, null); }
	
	public SpatialContext(Vector3f scale, Vector3f origin, Vector3f rotation) {
		this.scale = scale == null ? new Vector3f(1) : scale;
		this.origin = origin == null ? new Vector3f() : origin;
		this.rotation = rotation == null ? new Vector3f() : rotation;
	}
	
	public Vector3f convert(Vector3f vector) { return convert(vector, null); }
	public Vector3f convert(Vector3f vector, SpatialContext context) {
		if(context == this) return vector;
		
		if(context != null && context != R3)
			return convert(R3.convert(vector, context), R3);
		
		float x = vector.getX();
		float y = vector.getY();
		float z = vector.getZ();
		
		// Put in Context  Re-Center 
		x = (x - origin.x) / scale.x;
		y = (y - origin.y) / scale.y;
		z = (z - origin.z) / scale.z;
		
		return new Vector3f(x, y, z).invertRotate(rotation);
	}
	
	public Vector3f scale(Vector3f vector) { return scale(vector, null); }
	public Vector3f scale(Vector3f vector, SpatialContext context) {
		if(context == this) return vector;
		
		if(context != null && context != R3)
			return scale(R3.scale(vector, context), R3);
		
		return vector.divide(scale);
	}
	
	public Vector3f translate(Vector3f vector) { return translate(vector, null); }
	public Vector3f translate(Vector3f vector, SpatialContext context) {
		if(context == this) return vector;
		
		if(context != null && context != R3)
			return translate(R3.scale(vector, context), R3);
		
		return vector.subtract(origin);
	}

	public void setScale(Vector3f scale) { this.scale = scale; }
	public void setOrigin(Vector3f origin) { this.origin = origin; }
	public void setRotation(Vector3f rotation) { this.rotation = rotation; }

	public Vector3f getScale() { return scale; }
	public Vector3f getOrigin() { return origin; }
	public Vector3f getRotation() { return rotation; }

	public String toString() {
		return "SpatialContext [scale=" + scale + ", origin=" + origin + ", rotation=" + rotation + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((rotation == null) ? 0 : rotation.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof SpatialContext)) return false;
		
		SpatialContext other = (SpatialContext) obj;
		
		if(origin == null) {
			if(other.origin != null) return false;
		} else if(!origin.equals(other.origin)) return false;
		
		if(rotation == null) {
			if(other.rotation != null) return false;
		} else if(!rotation.equals(other.rotation)) return false;
		
		if(scale == null) {
			if(other.scale != null) return false;
		} else if(!scale.equals(other.scale)) return false;
		
		return true;
	}
}
