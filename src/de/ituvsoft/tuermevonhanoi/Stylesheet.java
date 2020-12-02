package de.ituvsoft.tuermevonhanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Stylesheet extends JPanel {
		Image hintergrundBild = null;
		boolean firstTime = true;
		  int[] baumStammX = new int[] {200,500,800  };
		  int[] baumStammY = new int[] {450,450,450};
		  int bStammWidth = 20;
	
		  
		  
		public Stylesheet(){
			try {
				hintergrundBild = ImageIO.read(new File("C:/Users/es0072/Desktop/tvh/207200.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);

			g.drawImage(hintergrundBild,0,0, this);
			g.setColor(new Color(0x7b,0x59,0x42));
			for(int i = 200; i<850;i+=300) {
				g.fillRect(i, 450, bStammWidth, 240);	
				
			}		
		
			}
			}
		

	
	
	

