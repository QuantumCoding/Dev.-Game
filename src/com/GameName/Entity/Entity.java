package com.GameName.Entity;

import com.GameName.RenderEngine.Models.Model;
import com.GameName.Util.Vectors.Vector3f;

public abstract class Entity {
	protected Vector3f position;
	protected Model model;

	public Entity(Model model) {
		this.model = model;
		
		this.position = new Vector3f();
	}

	public abstract boolean move(Vector3f position);
	
	public Vector3f getPosition() { return position; }
	public Model getModel() { return model; }

	public void setPosition(Vector3f position) {
		this.position = position;
	}
}