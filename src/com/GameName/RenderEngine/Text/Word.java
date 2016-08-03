package com.GameName.RenderEngine.Text;

public class Word {
	private String content;
	private FontStyle style;
	
	public Word(String word) {
		this(word, FontStyle.Plain);
	}
	
	public Word(String word, FontStyle style) {
		this.content = word;
	}
	
	public FontStyle getStyle() { return style; }
	public String getContent() { return content; }
	
	public int getLength(Font font) {
		int length = 0; 
		for(char c : content.toCharArray())
			length += font.getChatacter(style, c).getAdvanceX();
		return length;
	}
}
