package com.GameName.PhysicsEngine.Render;

import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsRenderProperties extends RenderProperties {
	
	private Vector3f color;
	private boolean quadRender;
	private boolean solid;
	
	public PhysicsRenderProperties(Vector3f color, boolean solid) { this(new Transform(), color, solid); }
	public PhysicsRenderProperties(Transform transform, Vector3f color, boolean solid) { this(transform, color, solid, false); }
	
	public PhysicsRenderProperties(Transform transform, Vector3f color, boolean solid, boolean quadRender) {
		super(transform);
		
		this.color = color;
		this.quadRender = quadRender;
		this.solid = solid;
	}
	
	public Vector3f getColor() { return color; }
	public boolean useQuadRender() { return quadRender; }
	public boolean isSolid() { return solid; }
	
	public RenderProperties clone() {
		return new PhysicsRenderProperties(getTransform().clone(), color.clone(), solid, quadRender);
	}
}
