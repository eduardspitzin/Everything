package de.ituvsoft.tuermevonhanoiTest;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JPanel;

public class TannenTuerme extends JPanel implements ActionListener {

	Timer timer = new Timer(1, this);
	
	int x = 14;
	int y = 15;
	int velX = 5;
	
	public TannenTuerme() {
		timer.start();
	
		
		
		
		
	
	
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0,0,0));
		g.setColor(new Color(230,210,30));
		g.fillRect(x, y, 20, 20);
		timer.start();
	}
	
	













	@Override
	public void actionPerformed(ActionEvent e) {
		x = x+velX;
		
		if(x>=980) {
			velX = -velX;
		}
		if(x<=0) {
			velX = -velX;
		}
	repaint();
	}
	

	
	public static void main (String[] args) {
		
		
		
		
	}

	
	
	}
	