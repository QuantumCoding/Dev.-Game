package com.GameName.RenderEngine.Text;

public enum FontStyle {
	Plain, Bold, Italic, Bold_Italic;
	
	public static FontStyle getStyle(boolean bold, boolean italic) {
		return bold && italic ? FontStyle.Bold_Italic : bold ? Bold : Italic;
	}
}
