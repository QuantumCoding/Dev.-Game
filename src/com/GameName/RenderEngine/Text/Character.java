package com.GameName.RenderEngine.Text;

import com.GameName.Util.Vectors.Vector2f;

public class Character {
	private FontStyle style;
	
	private int id;
	private int sizeX, sizeY;
	private int sheetX, sheetY;
	private int offsetX, offsetY;
	private int advanceX;
	
	private Vector2f imageSize;
	
	public Character(FontStyle style, int id, int sizeX, int sizeY, int sheetX, int sheetY, int offsetX, int offsetY, int advanceX, Vector2f imageSize) {
		this.style = style;
		
		this.id = id;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sheetX = sheetX;
		this.sheetY = sheetY;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.advanceX = advanceX;
		
		this.imageSize = imageSize;
	}
	
	public CharacterMesh getMesh() {
		
	}

	public int getId() { return id; }

	public int getSizeX() { return sizeX; }
	public int getSizeY() { return sizeY; }

	public int getSheetX() { return sheetX; }
	public int getSheetY() { return sheetY; }

	public int getOffsetX() { return offsetX; }
	public int getOffsetY() { return offsetY; }

	public int getAdvanceX() { return advanceX; }
	public FontStyle getStyle() { return style; }
	
	public Vector2f getImageSize() { return imageSize; }
}
