package com.GameName.RenderEngine.Text;

import java.util.ArrayList;

import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelData.ModelData;
import com.GameName.Util.Vectors.Vector2f;
import com.GameName.Util.Vectors.Vector3f;

public class TextMesh extends Model {

	private ArrayList<Word> words;
	private FontStyle style;
	private int lengthLimt;
	private Font font;
	
	private Vector2f cursor;
	
	public TextMesh(Font font, int lengthLimt) {
		super(new ModelData(10, 100, new Vector3f()));
		
		this.lengthLimt = lengthLimt;
		this.font = font;
		
		words = new ArrayList<>();
		style = FontStyle.Plain;
	}
	
	public void createMesh() {
		cursor = new Vector2f();
		
		for(Word word : words) {
			int length = word.getLength(font);
			if(cursor.getX() + length > lengthLimt)
				nextLine();
			
			String content = word.getContent();
			for(int i = 0; i < content.length(); i ++) {
				char rawChar = content.charAt(i);
				if(rawChar == '\n') {
					nextLine();
					continue;
				}
				
				Character character = font.getChatacter(word.getStyle(), rawChar);
				CharacterMesh charMesh = character.getMesh();
				cursor = cursor.add(charMesh.getShift());
				if(cursor.getX() > lengthLimt)
					nextLine();
				
				charMesh.stichTo(modelData, cursor);
			}
		}
	}
	
	private void nextLine() {
		cursor.setX(0);
		cursor.setY(cursor.getY() + font.getLineHeight());
	}
	
	public void append(String str, FontStyle style) {
		setStyle(style); append(str);		
	}
	
	public void append(String str) {
		words.addAll(breakText(str, style));
	}
	
	public void newLine() {
		words.add(new Word("\n"));
	}
	
	public void setStyle(FontStyle style) { this.style = style; }

	public static ArrayList<Word> breakText(String text, FontStyle style) {
		ArrayList<Word> words = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < text.length(); i ++) {
			char character = text.charAt(i);
			builder.append(character);
			
			if(character == ' ' || character == '-') {
				words.add(new Word(builder.toString(), style));
				builder = new StringBuilder();
			}
		}
	
		return words;
	}
}
