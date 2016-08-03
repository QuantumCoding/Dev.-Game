package com.GameName.Font;

import com.GameName.Font.Font.FontStyle;

public class FontFamily {
	private Font[] styleMap;
	private String familyName;
	
	public FontFamily(String familyName) {
		this.familyName = familyName;
		this.styleMap = new Font[FontStyle.values().length];
	}
	
	public FontFamily addFont(FontStyle style, Font font) {
		styleMap[style.getId()] = font;
		font.setFamily(this);
		return this;
	}
	
	public Font getFontFromStyle(FontStyle style) {
		return styleMap[style.getId()];
	}
	
	public String getFamilyName() {
		return familyName;
	}
}
