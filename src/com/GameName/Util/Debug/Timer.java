package com.GameName.Util.Debug;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Timer {
	private static HashMap<Object, Timer> timers = new HashMap<>();

	public static void create(Object key) {
		timers.put(key, new Timer());
	}
	
	public static void mark(Object key) {
		long time = System.nanoTime();
		timers.get(key).mark(time);
	}
	
	public static Timer stop(Object key) {
		return timers.remove(key);
	}
	
	private ArrayList<Long> marks;
	private long startTime;
	
	private Timer() {
		marks = new ArrayList<>();
		startTime = 0;
	}
	
	private void mark(long markTime) {
		long time = markTime - startTime;
		
		if(startTime == 0) {
			startTime = time;
			return;
		} 
		
		startTime = 0;
		marks.add(time);
	}
	
	public ArrayList<Long> getMarks() { return marks; }
	
	public void displayMarks() {
		JFrame frame = new JFrame("Timer Data");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(new JPanel() {
			private static final long serialVersionUID = -2519702040156945480L;
			
			private double maxValue = -1;
			private double avgValue = -1;
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				if(maxValue < 0 || avgValue < 0) {
					double sum = 0;
					for(Long mark : marks) {
						if(mark > maxValue) maxValue = mark;
						sum += mark;
					}
					
					avgValue = sum / marks.size();
				}
				
				int width = this.getWidth();
				int height = this.getHeight();
				
				Graphics2D g2d = (Graphics2D) g;
				int rectWidth = width / marks.size();
				
				for(int i = 0; i < marks.size(); i ++) {
					float rectHeight = (float) (height / maxValue * marks.get(i));
					
					float val = (float) (marks.get(i) / maxValue);
					g2d.setColor(Color.getHSBColor(val, 1, 1));
					g2d.draw(new Rectangle2D.Double(i * rectWidth, height - rectHeight, rectWidth, rectHeight));
				}
				
				g2d.setColor(Color.RED);
				double avgHeight = avgValue / maxValue * height;
				g2d.draw(new Line2D.Double(0, avgHeight, width, avgHeight));
			}
		}, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
