package com.GameName.Font;

public class Font {
	private FontStyle style;
	
	private int[] sizeMap;
	private byte[][][][] fontMap;
	private float[][][] infoMap;
	
	private FontFamily family;
	
	public Font(FontStyle style, int... sizeMap) {
		this.style = style;
		this.sizeMap = sizeMap;
		
		fontMap = new byte[sizeMap.length][128][][];
		infoMap = new float[sizeMap.length][128][];
	}
	
	public void addLetter(char letter, int size, byte[][] drawMap, float... info) {
		int sizeIndex = getSizeIndex(size);
		fontMap[sizeIndex][letter] = drawMap;
		infoMap[sizeIndex][letter] = info;
	}
	
	public int getSizeIndex(int size) {
		for(int i = 0; i < sizeMap.length; i ++) {
			if(sizeMap[i] == size) {
				return i;
			}
		}
		
		return -1;
	}
	
	public FontFamily getFamily() { return family; }
	protected void setFamily(FontFamily family) {
		this.family = family;
	}
	
	public String toString() {
		return family.getFamilyName() + " " + style;
	}
	
	public static enum FontStyle {
		Plain(0, java.awt.Font.PLAIN), Bold(1, java.awt.Font.BOLD), 
		Italics(2, java.awt.Font.ITALIC), Bold_Italics(3, java.awt.Font.BOLD | java.awt.Font.ITALIC);
		
		private int idenitifer;
		private int awtStyle;
		
		private FontStyle(int idenitifer, int awtStyle) {
			this.idenitifer = idenitifer;
			this.awtStyle = awtStyle;
		}
		
		public int getId() { return idenitifer; }
		public int getAWTStyle() { return awtStyle; }
		
		public static FontStyle getStyleFromAWT(int awtStyle) {
			for(FontStyle style : values()) {
				if(style.getAWTStyle() == awtStyle) {
					return style;
				}
			}
			
			return null;
		}
	}
}
