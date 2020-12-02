package de.ituvsoft.tuermevonhanoi;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Slice extends JPanel {
	int number;
	int posX;
	int posY;
	
	public Slice(int number,int posX,int posY) {
		this.number = number;
		this.posX = posX;
		this.posY = posY;
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawRect(posX, posY, number*20, 40);
		
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
