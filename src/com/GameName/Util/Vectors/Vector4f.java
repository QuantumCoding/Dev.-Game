package com.GameName.Util.Vectors;


public class Vector4f {
	public float x, y, z, w;

	public Vector4f() {
		this(0, 0, 0, 0);
	}
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public Vector4f(float[] values) {
		this(values[0], values[1], values[2], values[3]);
	}
	
	public Vector4f(float value) {
		this(value, value, value, value);
	}
	
	public Vector4f(Vector2f clone) {
		this(clone, 0, 0);
	}
	
	public Vector4f(Vector2f clone, float z, float w) {
		this(clone.x, clone.y, z, w);
	}
	
	public Vector4f(Vector3f clone) {
		this(clone, 0);
	}
	
	public Vector4f(Vector3f clone, float w) {
		this(clone.x, clone.y, clone.z, w);
	}
	
	public Vector4f(Vector4f clone) {
		this(clone.x, clone.y, clone.z, clone.w);
	}
	
	public Vector4f(org.lwjgl.util.vector.Vector4f clone) {
		this(clone.x, clone.y, clone.z, clone.w);
	}

	public org.lwjgl.util.vector.Vector4f toLWJGL() {
		return new org.lwjgl.util.vector.Vector4f(x, y, z, w);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		result = prime * result + Float.floatToIntBits(w);
		
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Vector4f)) return false;
		
		Vector4f other = (Vector4f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z)) return false;
		if (Float.floatToIntBits(w) != Float.floatToIntBits(other.w)) return false;
		
		return true;
	}

//-------------------------------------------------------- Basic Arithmetic --------------------------------------------------------\\
	public Vector4f add(float add) {
		return add(add, add, add, add);}
	public Vector4f add(Vector4f add) {
		return add(add.x, add.y, add.z, add.w);}
	
	public Vector4f add(float x, float y, float z, float w) {
		return new Vector4f(
				this.x + x,
				this.y + y,
				this.z + z,
				this.w + w
			);
	}
	
	public Vector4f subtract(float subtract) {
		return subtract(subtract, subtract, subtract, subtract);}
	public Vector4f subtract(Vector4f subtract) {
		return subtract(subtract.x, subtract.y, subtract.z, subtract.w);}
	
	public Vector4f subtract(float x, float y, float z, float w) {
		return new Vector4f(
				this.x - x,
				this.y - y,
				this.z - z,
				this.w - w
			);
	}

	public Vector4f multiply(float multiply) {
		return multiply(multiply, multiply, multiply, multiply);}
	public Vector4f multiply(Vector4f multiply) {
		return multiply(multiply.x, multiply.y, multiply.z, multiply.w);}
	
	public Vector4f multiply(float x, float y, float z, float w) {
		return new Vector4f(
				this.x * x,
				this.y * y,
				this.z * z,
				this.w * w
			);
	}
	
	public Vector4f divide(float divide) {
		return divide(divide, divide, divide, divide);}
	public Vector4f divide(Vector4f divide) {
		return divide(divide.x, divide.y, divide.z, divide.w);}
	
	public Vector4f divide(float x, float y, float z, float w) {
		return new Vector4f(
				this.x / x,
				this.y / y,
				this.z / z,
				this.w / w
			);
	}

	public Vector4f mod(float mod) {
		return mod(mod, mod, mod, mod);}
	public Vector4f mod(Vector4f mod) {
		return mod(mod.x, mod.y, mod.z, mod.w);}
	
	public Vector4f mod(float x, float y, float z, float w) {
		return new Vector4f(
				this.x % x,
				this.y % y,
				this.z % z,
				this.w % w
			);
	}
	
	public Vector4f pow(float pow) {
		return pow(pow, pow, pow, pow);}
	public Vector4f pow(Vector4f pow) {
		return pow(pow.x, pow.y, pow.z, pow.w);}
	
	public Vector4f pow(float x, float y, float z, float w) {
		return new Vector4f(
				(float) Math.pow(this.x, x),
				(float) Math.pow(this.y, y),
				(float) Math.pow(this.z, z),
				(float) Math.pow(this.w, w)
			);
	}

//----------------------------------------------------------- Cap Values -----------------------------------------------------------\\
	public Vector4f capMin(float capMin) {
		return capMin(capMin, capMin, capMin, capMin);}
	public Vector4f capMin(Vector4f capMin) {
		return capMin(capMin.x, capMin.y, capMin.z, capMin.w);}

	public Vector4f capMin(float x, float y, float z, float w) {
		return new Vector4f(
				this.x > x ? x : this.x, 
				this.y > y ? y : this.y, 
				this.z > z ? z : this.z, 
				this.w > w ? w : this.w
			);
	}
	
	public Vector4f capMax(float capMax) {
		return capMax(capMax, capMax, capMax, capMax);}
	public Vector4f capMax(Vector4f capMax) {
		return capMax(capMax.x, capMax.y, capMax.z, capMax.w);}

	public Vector4f capMax(float x, float y, float z, float w) {
		return new Vector4f(
				this.x < x ? x : this.x, 
				this.y < y ? y : this.y, 
				this.z < z ? z : this.z, 
				this.w < w ? w : this.w
			);
	}
	
//--------------------------------------------------- Other Mathematical Methods ---------------------------------------------------\\
	public Vector4f direction() {
		return new Vector4f(
				x > 0 ? 1 : x < 0 ? -1 : 0, 
				y > 0 ? 1 : y < 0 ? -1 : 0,
				z > 0 ? 1 : z < 0 ? -1 : 0,
				w > 0 ? 1 : w < 0 ? -1 : 0
			);
	}
	
	public Vector4f difference(Vector4f other) {
		return subtract(other).abs();
	}

	public float distance(Vector4f distance) {
		return distance(distance.x, distance.y, distance.z, distance.w);}
	
	public float distance(float x, float y, float z, float w) {
		return (float) Math.sqrt(
				Math.pow(this.x - x, 2) +
				Math.pow(this.y - y, 2) + 
				Math.pow(this.z - z, 2) + 
				Math.pow(this.w - w, 2)
			);
	}
	
	public float length() {
		return (float) Math.sqrt( dot(this) );
	}
	
	public float dot(Vector4f other) {
		return (x * other.x) +
			   (y * other.y) +
			   (z * other.z) +
			   (w * other.w) ;
	}
	
	public float max() {
		float max = 0;
		
		if(x > max) max = x;
		if(y > max) max = y;
		if(z > max) max = z;
		if(w > max) max = w;
		
		return max;
	}
	
	public Vector4f truncate() {
		return new Vector4f( (int) x, (int) y, (int) z, (int) w );
	}
	
	public Vector4f round() {
		return new Vector4f(
				Math.round(x),
				Math.round(y),
				Math.round(z),
				Math.round(w)
			);
	}
	
	public Vector4f abs() {
		return new Vector4f(
				Math.abs(x),
				Math.abs(y),
				Math.abs(z),
				Math.abs(w)
			);
	}
	
	public Vector4f normalized() {
		return divide(length());
	}
	
	public Vector4f reflect(Vector4f normal) {
		return subtract(normal.multiply(dot(normal) * 2));
	}
	
	public boolean greaterThen(float then) {
		return greaterThen(then, then, then, then);}
	public boolean greaterThen(Vector4f then) {
		return greaterThen(then.x, then.y, then.z, then.w);}
	
	public boolean greaterThen(float x, float y, float z, float w) {
		return  this.x > x &&
				this.y > y &&
				this.z > z;
	}
	
	public boolean greaterThenOrEqual(float then) {
		return greaterThenOrEqual(then, then, then, then);}
	public boolean greaterThenOrEqual(Vector4f then) {
		return greaterThenOrEqual(then.x, then.y, then.z, then.w);}
	
	public boolean greaterThenOrEqual(float x, float y, float z, float w) {
		return  this.x >= x &&
				this.y >= y &&
				this.z >= z;
	}
	
	public boolean lessThen(float then) {
		return lessThen(then, then, then, then);}
	public boolean lessThen(Vector4f then) {
		return lessThen(then.x, then.y, then.z, then.w);}
	
	public boolean lessThen(float x, float y, float z, float w) {
		return  this.x < x &&
				this.y < y &&
				this.z < z;
	}
	
	public boolean lessThenOrEqual(float then) {
		return lessThenOrEqual(then, then, then, then);}
	public boolean lessThenOrEqual(Vector4f then) {
		return lessThenOrEqual(then.x, then.y, then.z, then.w);}
	
	public boolean lessThenOrEqual(float x, float y, float z, float w) {
		return  this.x <= x &&
				this.y <= y &&
				this.z <= z;
	}
	
	public boolean equalTo(float then) {
		return equalTo(then, then, then, then);}
	public boolean equalTo(Vector4f then) {
		return equalTo(then.x, then.y, then.z, then.w);}
	
	public boolean equalTo(float x, float y, float z, float w) {
		return  this.x == x &&
				this.y == y &&
				this.z == z;
	}
	
	public Vector4f toDegrees() {
		return new Vector4f(
				(float) Math.toDegrees(x),
				(float) Math.toDegrees(y),
				(float) Math.toDegrees(z),
				(float) Math.toDegrees(w)
			);
	}
	
	public Vector4f toRadians() {
		return new Vector4f(
				(float) Math.toRadians(x),
				(float) Math.toRadians(y),
				(float) Math.toRadians(z),
				(float) Math.toRadians(w)
			);
	}
	
	public void set(Vector4f set) {
		this.x = set.x;
		this.y = set.y;
		this.z = set.z;
	}
	
	public Vector4f clone() {
		return new Vector4f(x, y, z, w);
	}
	
	public String toString() {
		return printValues(x, y, z, w);
	}
	
	public static String printValues(float x, float y, float z, float w) {
		return "[x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + "]";
	}

	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }
	public float getW() { return w; }

	public Vector4f addX(float x) { this.x += x; return this; }
	public Vector4f addY(float y) { this.y += y; return this; }
	public Vector4f addZ(float z) { this.z += z; return this; }
	public Vector4f addW(float w) { this.w += w; return this; }

	public Vector4f setX(float x) { this.x = x; return this; }
	public Vector4f setY(float y) { this.y = y; return this; }
	public Vector4f setZ(float z) { this.z = z; return this; }
	public Vector4f setW(float w) { this.w = w; return this; }
	
	public Vector4f reset() {
		return this.setX(0).setY(0).setZ(0).setW(0);
	}
}