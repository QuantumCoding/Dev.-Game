package com.GameName.Util.Vectors;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class MutableVector3f extends Vector3f {
	
	public MutableVector3f() 									 { super(); }
	public MutableVector3f(double x, double y, double z) 		 { super(x, y, z); }
	public MutableVector3f(float x, float y, float z) 			 { super(x, y, z); }
	public MutableVector3f(float value) 						 { super(value); }
	public MutableVector3f(float[] values) 						 { super(values); }
	public MutableVector3f(Vector2f clone, float z) 			 { super(clone, z); }
	public MutableVector3f(Vector2f clone) 						 { super(clone); }
	public MutableVector3f(Vector3f clone) 						 { super(clone); }
	public MutableVector3f(org.lwjgl.util.vector.Vector3f clone) { super(clone); }
	
//----------------------------------------------------- Basic Arithmetic --------------------------------------------------------\\
	
	public Vector3f add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		
		return this;
	}
	
	public Vector3f subtract(float x, float y, float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;

		return this;
	}
	public Vector3f multiply(float x, float y, float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		
		return this;
	}
	
	public Vector3f divide(float x, float y, float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		
		return this;
	}

	public Vector3f mod(float x, float y, float z) {
		this.x %= x;
		this.y %= y;
		this.z %= z;
		
		return this;
	}
	
	public Vector3f pow(float x, float y, float z) {
		this.x = (float) Math.pow(this.x, x);
		this.y = (float) Math.pow(this.y, y);
		this.z = (float) Math.pow(this.z, z);
		
		return this;
	}

	public Vector3f randomize(float x, float y, float z) {
		this.x = (float) (Math.random() * x);
		this.y = (float) (Math.random() * y);
		this.z = (float) (Math.random() * z);
		
		return this;
	}
	
//--------------------------------------------------------- Cap Values ---------------------------------------------------------\\

	public Vector3f capMin(float x, float y, float z) {
		this.x = this.x < x ? x : this.x; 
		this.y = this.y < y ? y : this.y; 
		this.z = this.z < z ? z : this.z;
		
		return this;
	}
	
	public Vector3f capMax(float x, float y, float z) {
		this.x = this.x > x ? x : this.x;
		this.y = this.y > y ? y : this.y;
		this.z = this.z > z ? z : this.z;
		
		return this;
	}
	
//------------------------------------------------- Vector Mathematical Methods -------------------------------------------------\\
	
	public Vector3f invert() {
		this.x = 1.0f / x;
		this.y = 1.0f / y;
		this.z = 1.0f / z;
		
		return this;
	}
	
	public Vector3f truncate() {
		this.x = (int) this.x;
        this.y = (int) this.y;
		this.z = (int) this.z;
		
		return this;
	}
	
	public Vector3f round() {
		this.x = Math.round(x);
		this.y = Math.round(y);
		this.z = Math.round(z);
		
		return this;
	}
	
	public Vector3f abs() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
		this.z = Math.abs(z);
		
		return this;
	}
	
	public Vector3f rotate(Vector3f rot) {
		rot = rot.toRadians();
		this.x = (float) (x * (cos(rot.y) * cos(rot.z)) + y * (cos(rot.z) * sin(rot.x) * sin(rot.y) - cos(rot.x) * sin(rot.z)) + z * ( cos(rot.x) * cos(rot.z) * sin(rot.y) + sin(rot.x) * sin(rot.z)));
		this.y = (float) (x * (cos(rot.y) * sin(rot.z)) + y * (cos(rot.x) * cos(rot.z) + sin(rot.x) * sin(rot.y) * sin(rot.z)) + z * (-cos(rot.z) * sin(rot.x) + cos(rot.x) * sin(rot.y) * sin(rot.z)));
		this.z = (float) (x * (-sin(rot.y)) + y * (cos(rot.y) * sin(rot.x)) + z * (cos(rot.x) * cos(rot.y)));
	
		return this;
	}	
	
	public Vector3f invertRotate(Vector3f rot) {
		rot = rot.toRadians();
		
		double _11 = cos(rot.y) * cos(rot.z);
		double _12 = cos(rot.z) * sin(rot.x) * sin(rot.y) - cos(rot.x) * sin(rot.z);
		double _13 = cos(rot.x) * cos(rot.z) * sin(rot.y) + sin(rot.x) * sin(rot.z);
		
		double _21 = cos(rot.y) * sin(rot.z);
		double _22 = cos(rot.x) * cos(rot.z) + sin(rot.x) * sin(rot.y) * sin(rot.z);
		double _23 = -cos(rot.z) * sin(rot.x) + cos(rot.x) * sin(rot.y) * sin(rot.z);
		
		double _31 = -sin(rot.y);
		double _32 = cos(rot.y) * sin(rot.x);
		double _33 = cos(rot.x) * cos(rot.y);
		
		this.x = (float) (x * (_22 * _33 - _23 * _32) + y * (_13 * _32 - _12 * _33) + z * (_12 * _23 - _13 * _22));
		this.y = (float) (x * (_23 * _31 - _21 * _33) + y * (_11 * _33 - _13 * _31) + z * (_13 * _21 - _11 * _23));
		this.z = (float) (x * (_21 * _32 - _22 * _31) + y * (_12 * _31 - _11 * _32) + z * (_11 * _22 - _12 * _21));

		return this;
	}	
	
	public Vector3f toDegrees() {
		this.x = (float) Math.toDegrees(x);
		this.y = (float) Math.toDegrees(y);
		this.z = (float) Math.toDegrees(z);
		
		return this;
	}
	
	public Vector3f toRadians() {
		this.x = (float) Math.toRadians(x);
		this.y = (float) Math.toRadians(y);
		this.z = (float) Math.toRadians(z);
		
		return this;
	}
}
