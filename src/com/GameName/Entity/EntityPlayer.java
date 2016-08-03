package com.GameName.Entity;

import org.lwjgl.input.Keyboard;

import com.GameName.RenderEngine.Util.Camera;
import com.GameName.Util.Vectors.Vector3f;

public class EntityPlayer extends EntityLiving {
	private Camera camera;
	
	public EntityPlayer(Camera camera) {
		super(null, 100);
		this.camera = camera;
	}

	public void damage(int amount) {
		health -= amount;
	}

	public void heal(int amount) {
		health -= amount;
	}

	public boolean move(Vector3f amount) {
//		System.out.print("Player Move: " + amount + " -> ");
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			amount = amount.multiply(5);
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			amount = amount.multiply(.2f);
		
		camera.moveForward(amount.z);
		camera.moveRight(amount.x);
		camera.moveUp(amount.y);
		
		position.setX(camera.x).setY(camera.y).setZ(camera.z);
//		System.out.println(position + " Rotation: " + camera.getRotation());
		return true;
	}
	
	public Camera getCamera() { return camera; }
}
