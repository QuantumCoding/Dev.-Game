//package com.GameName.Font;
//
//import java.awt.Color;
//import java.awt.FontFormatException;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//
//import com.GameName.Font.Font.FontStyle;
//import com.GameName.Util.Vectors.Vector2f;
//
//public class FontLoader {
//	
//	public static void main(String[] args) {
//		try {
//			Font font = FontLoader.loadTTF(new File("res/fonts/Savor.ttf"), //(byte) 8, (byte) 16, (byte) 32, 
//					/*(byte) 48, (byte) 72, (byte) 96,*/ (byte) 127);
//			
//			byte[][][][] fontMap = (byte[][][][]) font[0];
//			float[][][] fontInfo = (float[][][]) font[1];
//			
//			String in = ""; 
//			Scanner scan = new Scanner(System.in);
//			while(true) {
//				in = scan.nextLine();
//				if(in.equals("exit"))
//					break;
//				
//				int width = 512, height = 512;
////				for(char c : in.toCharArray()) {
////					System.out.println((int) c);
////					width += fontMap[0][(int) c].length;
////					if(fontMap[0][(int) c][0].length > height) {
////						height = fontMap[0][(int) c][0].length;
////					}
////				}
////				
////				width += 20 + (in.length() * 3); height += 20; 
//				int i = 0;
//				BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//				for(int xL = 0; xL < width; xL ++) {
//				for(int yL = 0; yL < height; yL ++) {
//					canvas.setRGB(xL, yL, Color.WHITE.getRGB());
//				}}
//				
//				for(char c : in.toCharArray()) {
//					byte[][] letterMap = fontMap[0][c];
//					for(int xL = 0; xL < letterMap.length; xL ++) {
//					for(int yL = 0; yL < letterMap[xL].length; yL ++) {
//						canvas.setRGB(xL + i, (int) (yL + fontInfo[0][c][5]), letterMap[xL][yL]);
////						10 + xL + i, (height - 10)
//					}}
//					
//					i += letterMap.length + 3;
//				}
//				
//				Graphics g = canvas.createGraphics();
//				g.setFont(new java.awt.Font("", 0, 127)); 
//				g.setColor(Color.RED);
//				g.drawString(in, 0, 300);
//				
//				ImageIO.write(canvas, "PNG", new File("C:\\Users\\User\\Desktop\\Imagedsds.png"));
//				
//				System.out.println("Panel");
//				JOptionPane.showMessageDialog(null, null, "Drawing String \"" + in + "\"", JOptionPane.YES_NO_OPTION, 
//					new ImageIcon(canvas.getScaledInstance(512, 512, Image.SCALE_DEFAULT)));
//			}
//			
//			scan.close();
//		} catch(FontFormatException | IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static final int WIDTH = 200, HEIGHT = 200, START_LETTER = 0, LETTER_COUNT = 127; // 0xFFFF
//	public static Font loadTTF(File ttfFile, int... samplePoints) throws FontFormatException, IOException {
//		java.awt.Font awtFont = new java.awt.Font("", 0, 127);//java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, ttfFile);//
//		BufferedImage canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
//		Graphics g = canvas.createGraphics();
//		
//		// Size, Unicode, Map
//		byte[][][][] fontMap = new byte[samplePoints.length][LETTER_COUNT][][];
//		float[][][] infoMap = new float[samplePoints.length][LETTER_COUNT][];
//		
//		System.out.println("Starting...");
//		for(int size = 0; size < samplePoints.length; size ++) {
//			g.setFont(awtFont.deriveFont(awtFont.getStyle(), samplePoints[size]));
//			
//			for(int letter = 0; letter < LETTER_COUNT; letter ++) {
//				System.out.println("Creating Sample for letter " + (char) (letter + START_LETTER) + " at Size " + samplePoints[size]);
//				
//				g.setColor(Color.WHITE);
//				g.fillRect(0, 0, WIDTH, HEIGHT);
//				g.setColor(Color.BLACK);
//				g.drawString((char) (letter + START_LETTER) + "", WIDTH/2, HEIGHT/2);
//				
//				Vector2f minPoint = new Vector2f(WIDTH, HEIGHT);
//				Vector2f maxPoint = new Vector2f(0, 0);
//				for(int x = 0; x < WIDTH; x ++) {
//				for(int y = 0; y < HEIGHT; y ++) {
//					if(canvas.getRGB(x, y) != Color.WHITE.getRGB()) {
//						if(x < minPoint.x) minPoint.x = x;
//						if(y < minPoint.y) minPoint.y = y;
//						
//						if(x > maxPoint.x) maxPoint.x = x;
//						if(y > maxPoint.y) maxPoint.y = y;
//					}
//				}}
//				
//				maxPoint = maxPoint.add(1, 1);
//				Vector2f differance = maxPoint.difference(minPoint);
//				System.out.println("\tMax Point: " + maxPoint);
//				if(differance.x == 0 || differance.y == 0 || minPoint.x == WIDTH || 
//				minPoint.y == HEIGHT || maxPoint.x == 0 || minPoint.y == 0) {
//					fontMap[size][letter] = null;
//					continue;
//				}
//				
////				System.out.println("\tDimentions: " + differance);
////				JOptionPane.showMessageDialog(null, null, 
////						"Creating Sample for letter " + (char) (letter + START_LETTER) + " at Size " + samplePoints[size], JOptionPane.YES_NO_OPTION, 
////						new ImageIcon(canvas.getScaledInstance(512, 512, Image.SCALE_DEFAULT)));
//				
//				byte[][] drawMap = new byte[(int) differance.x][(int) differance.y];
////				System.out.println(differance.x + ", " + differance.y);
//
//				for(int y = 0; y < differance.y; y ++) {
//				for(int x = 0; x < differance.x; x ++) {
//					drawMap[x][y] = (byte) (canvas.getRGB(x + (int) minPoint.x, y + (int) minPoint.y) & 0xFF);
//				}}
//				
//				fontMap[size][letter] = drawMap;
//				infoMap[size][letter] = new float[] {
//						minPoint.x, minPoint.y, maxPoint.x, maxPoint.y,
//						(byte) (letter + START_LETTER), samplePoints[size] - differance.y
//				};
//			}
//		}
//		
//		Font font = new Font(FontStyle.getStyleFromAWT(awtFont.getStyle()), samplePoints);
//		
//		return font;
//	}
//}
