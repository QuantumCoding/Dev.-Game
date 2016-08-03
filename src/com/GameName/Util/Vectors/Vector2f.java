package com.GameName.Util.Vectors;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Vector2f {
	public float x, y;
	
	public Vector2f() {
		this(0, 0);
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f(float[] values) {
		this(values[0], values[1]);
	}
	
	public Vector2f(float value) {
		this(value, value);
	}
	
	public Vector2f(Vector2f clone) {
		this(clone.x, clone.y);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Vector2f)) return false;
		
		Vector2f other = (Vector2f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) return false;
		
		return true;
	}

//-------------------------------------------------------- Basic Arithmetic --------------------------------------------------------\\
	public Vector2f add(float add) {
		return add(add, add);}
	public Vector2f add(Vector2f add) {
		return add(add.x, add.y);}
	
	public Vector2f add(float x, float y) {
		return new Vector2f(
				this.x + x,
				this.y + y
			);
	}
	
	public Vector2f subtract(float subtract) {
		return subtract(subtract, subtract);}
	public Vector2f subtract(Vector2f subtract) {
		return subtract(subtract.x, subtract.y);}
	
	public Vector2f subtract(float x, float y) {
		return new Vector2f(
				this.x - x,
				this.y - y
			);
	}

	public Vector2f multiply(float multiply) {
		return multiply(multiply, multiply);}
	public Vector2f multiply(Vector2f multiply) {
		return multiply(multiply.x, multiply.y);}
	
	public Vector2f multiply(float x, float y) {
		return new Vector2f(
				this.x * x,
				this.y * y
			);
	}
	
	public Vector2f divide(float divide) {
		return divide(divide, divide);}
	public Vector2f divide(Vector2f divide) {
		return divide(divide.x, divide.y);}
	
	public Vector2f divide(float x, float y) {
		return new Vector2f(
				this.x / x,
				this.y / y
			);
	}

	public Vector2f mod(float mod) {
		return mod(mod, mod);}
	public Vector2f mod(Vector2f mod) {
		return mod(mod.x, mod.y);}
	
	public Vector2f mod(float x, float y) {
		return new Vector2f(
				this.x % x,
				this.y % y
			);
	}
	
	public Vector2f pow(float pow) {
		return pow(pow, pow);}
	public Vector2f pow(Vector2f pow) {
		return pow(pow.x, pow.y);}
	
	public Vector2f pow(float x, float y) {
		return new Vector2f(
				(float) Math.pow(this.x, x),
				(float) Math.pow(this.y, y)
			);
	}

//----------------------------------------------------------- Cap Values -----------------------------------------------------------\\
	public Vector2f capMin(float capMin) {
		return capMin(capMin, capMin);}
	public Vector2f capMin(Vector2f capMin) {
		return capMin(capMin.x, capMin.y);}

	public Vector2f capMin(float x, float y) {
		return new Vector2f(
				this.x > x ? x : this.x, 
				this.y > y ? y : this.y
			);
	}
	
	public Vector2f capMax(float capMax) {
		return capMax(capMax, capMax);}
	public Vector2f capMax(Vector2f capMax) {
		return capMax(capMax.x, capMax.y);}

	public Vector2f capMax(float x, float y) {
		return new Vector2f(
				this.x < x ? x : this.x, 
				this.y < y ? y : this.y
			);
	}
	
//--------------------------------------------------- Other Mathematical Methods ---------------------------------------------------\\
	public Vector2f direction() {
		return new Vector2f(
				x > 0 ? 1 : x < 0 ? -1 : 0, 
				y > 0 ? 1 : y < 0 ? -1 : 0
			);
	}
	
	public Vector2f difference(Vector2f other) {
		return subtract(other).abs();
	}

	public float distance(Vector2f distance) {
		return distance(distance.x, distance.y);}
	
	public float distance(float x, float y) {
		return (float) Math.sqrt(
				Math.pow(this.x - x, 2) +
				Math.pow(this.y - y, 2) 
			);
	}
	
	public float length() {
		return (float) Math.sqrt( dot(this) );
	}
	
	public float dot(Vector2f other) {
		return (x * other.x) +
			   (y * other.y) ;
	}
	
	public float max() {
		float max = 0;
		
		if(x > max) max = x;
		if(y > max) max = y;
		
		return max;
	}
	
	public Vector2f truncate() {
		return new Vector2f( (int) x, (int) y );
	}
	
	public Vector2f round() {
		return new Vector2f(
				Math.round(x),
				Math.round(y)
			);
	}
	
	public Vector2f abs() {
		return new Vector2f(
				Math.abs(x),
				Math.abs(y)
			);
	}
	
	public Vector2f normalized() {
		return divide(length());
	}
	
	public Vector2f reflect(Vector2f normal) {
		return subtract(normal.multiply(dot(normal) * 2));
	}
	
	public Vector2f rotate(Vector2f rot) {
		rot = rot.toRadians();
		return multiply(new Vector2f(
				(float) (cos(rot.x)), 
				(float) (sin(rot.y))
			));
	}	
	
	public boolean greaterThen(float then) {
		return greaterThen(then, then);}
	public boolean greaterThen(Vector2f then) {
		return greaterThen(then.x, then.y);}
	
	public boolean greaterThen(float x, float y) {
		return  this.x > x &&
				this.y > y;
	}
	
	public boolean greaterThenOrEqual(float then) {
		return greaterThenOrEqual(then, then);}
	public boolean greaterThenOrEqual(Vector2f then) {
		return greaterThenOrEqual(then.x, then.y);}
	
	public boolean greaterThenOrEqual(float x, float y) {
		return  this.x >= x &&
				this.y >= y;
	}
	
	
	public boolean lessThen(float then) {
		return lessThen(then, then);}
	public boolean lessThen(Vector2f then) {
		return lessThen(then.x, then.y);}
	
	public boolean lessThen(float x, float y) {
		return  this.x < x &&
				this.y < y;
	}
	
	public boolean lessThenOrEqual(float then) {
		return lessThenOrEqual(then, then);}
	public boolean lessThenOrEqual(Vector2f then) {
		return lessThenOrEqual(then.x, then.y);}
	
	public boolean lessThenOrEqual(float x, float y) {
		return  this.x <= x &&
				this.y <= y;
	}
	
	public boolean equalTo(float then) {
		return equalTo(then, then);}
	public boolean equalTo(Vector2f then) {
		return equalTo(then.x, then.y);}
	
	public boolean equalTo(float x, float y) {
		return  this.x == x &&
				this.y == y;
	}
	
	public Vector2f toDegrees() {
		return new Vector2f(
				(float) Math.toDegrees(x),
				(float) Math.toDegrees(y)
			);
	}
	
	public Vector2f toRadians() {
		return new Vector2f(
				(float) Math.toRadians(x),
				(float) Math.toRadians(y)
			);
	}
	
	public void set(Vector2f set) {
		this.x = set.x;
		this.y = set.y;
	}
	
	public Vector2f clone() {
		return new Vector2f(x, y);
	}
	
	public String toString() {
		return printValues(x, y);
	}
	
	public static String printValues(float x, float y) {
		return "[x=" + x + ", y=" + y + "]";
	}

	public float getX() { return x; }
	public float getY() { return y; }

	public Vector2f addX(float x) { this.x += x; return this; }
	public Vector2f addY(float y) { this.y += y; return this; }

	public Vector2f setX(float x) { this.x = x; return this; }
	public Vector2f setY(float y) { this.y = y; return this; }
	
	public Vector2f reset() {
		return this.setX(0).setY(0);
	}
}
