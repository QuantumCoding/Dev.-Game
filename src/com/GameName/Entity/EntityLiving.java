package com.GameName.Entity;

import com.GameName.RenderEngine.Models.Model;

public abstract class EntityLiving extends Entity {
	protected int maxHealth, health;	
	
	public EntityLiving(Model model, int maxHealth) {
		super(model);
	}
	
	public boolean isDead() { 
		return health > 0;
	}
	
	public abstract void damage(int amount);
	public abstract void heal(int amount);
	
	public int getHealth() { return health; }
	public int getMaxHealth() { return maxHealth; }
}
