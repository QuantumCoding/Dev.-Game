package com.GameName.RenderEngine.Text;

import java.util.HashMap;

import com.GameName.RenderEngine.Textures.Texture2D;

public class Font {
	private int lineHeight;
	private Texture2D fontTexture;
	private HashMap<FontStyle, HashMap<Integer, Character>> characters;
	
	public Font(Texture2D fontTexture, HashMap<FontStyle, HashMap<Integer, Character>> characters) {
		this.fontTexture = fontTexture;
		this.characters = characters;
	}
	
	public Character getChatacter(char ascii) {
		return getChatacter(FontStyle.Plain, ascii);
	}
	
	public Character getChatacter(FontStyle style, char ascii) {
		return characters.get(style).get(ascii);
	}
	
	public int getLineHeight() { return lineHeight; }
}
