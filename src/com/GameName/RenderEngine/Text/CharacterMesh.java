package com.GameName.RenderEngine.Text;

import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.Util.Vectors.Vector2f;

public class CharacterMesh {
	private Character character;
	private Vector2f textureSize;
	
	public CharacterMesh(Character character, Vector2f textureSize) {
		this.character = character;
		this.textureSize = textureSize;
	}
	
	public void stichTo(ModelData modelData, Vector2f offset) {
		
	}
}
