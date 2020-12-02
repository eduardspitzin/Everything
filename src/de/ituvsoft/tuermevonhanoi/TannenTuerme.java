package de.ituvsoft.tuermevonhanoi;
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

public class TannenTuerme extends Stylesheet implements ActionListener {
	int x_coordinates;
	
	int y_coordinates;
	int xSource;
	int ySource;
	int width;
	int height = 40;
	int bStammWidth;
	ArrayList<Stack<Integer>> oldTowers;
	ArrayList<Stack<Integer>> newTowers;
	int[] baumX;
	int[] baumY;
	int maxYStamm;
	Timer timer = new Timer(500,this);
	int dTowerNumber;
	int incTowerNumber;
	boolean firstTime = true;
	int maxSlices;
	int xDif;
	boolean xWanderung;
	boolean xRichtig;
	boolean yRichtig;
	boolean animatedSlice;
	boolean isAnimated;
	boolean animatedTower;
	int xGoal;
	int yGoal;
	public TannenTuerme(int maxSlices,ArrayList<Stack<Integer>> fTowers) {
		newTowers = fTowers;
		this.baumX = super.baumStammX;
		this.baumY = super.baumStammY;
		this.bStammWidth = super.bStammWidth;
		this.maxSlices = maxSlices;
		maxYStamm = Integer.max(Integer.max(baumY[0], baumY[1]),baumY[2]); // der Höchste Stamm
		
		oldTowers = new ArrayList<Stack<Integer>>();
		for(int i = 0;i<3;i++)
			oldTowers.add(new Stack<Integer>());
		deepCopy(newTowers,oldTowers);
	}
	
	
	
	
	private void drawSlices(Graphics g) {
		for(int i=0;i<3;i++) {
			int vZahl = Integer.compare(oldTowers.get(i).size(), newTowers.get(i).size());
			if(vZahl == 1) {
				dTowerNumber = i;
			}
			else if(vZahl==-1) {
				incTowerNumber = i;
				
			}
	
		}
		
		for(int j =0; j<3;j++) {
		animatedTower = j== dTowerNumber;	 
		for(int i = 0;i<oldTowers.get(j).size();i++) {
			width = 20*oldTowers.get(j).get(i);			
			y_coordinates = baumY[j] -(height*(1+i));
			x_coordinates = baumX[j]-width/2+(bStammWidth/2);
			g.setColor(new Color(0x00,0x71,0x23));
			animatedSlice = i==oldTowers.get(j).size()-1;
			isAnimated = animatedSlice && animatedTower;
			if(isAnimated && dTowerNumber!=incTowerNumber)
			{
			xSource = x_coordinates;
			ySource = y_coordinates;
			xGoal = baumX[incTowerNumber] -width/2+(bStammWidth/2);
			yGoal =baumY[incTowerNumber] -(height*(1+oldTowers.get(incTowerNumber).size()));
			System.out.println(xGoal);
			System.out.println(yGoal);
			}
			else {
				
				g.fillRect(x_coordinates, y_coordinates, width, height);
				
			}
			
			
		}

	
	}
	
		
	}
	
	
	
	
	
	private void drawAnimation(Graphics g) {
		g.fillRect(x_coordinates, y_coordinates, width, height);
		timer.start();
	}
	
	
	
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!isAnimated)
			drawSlices(g);
		if(isAnimated && dTowerNumber!=incTowerNumber) {
			drawAnimation(g);
		}
		
			
		
		
		
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Ich bin da");
		xDif = xGoal-xSource;
		System.out.println(xGoal);
		System.out.println(xSource);
		xRichtig = xGoal == xSource;
		yRichtig = ySource==yGoal;
		xSource++;
		ySource--;
		if(ySource-maxYStamm+height*(maxSlices+1)<Math.abs(xDif)) // Wenn Differenz zwischen YZiel und YPos größer ist als bei X dann 
			xWanderung = true;									// darf sich das Rect nur in Y-Richtung bewegen
		if(maxYStamm+height*(maxSlices+1)<= ySource) {
			ySource--;
		}
		if(xWanderung && x_coordinates != xSource) {
			if(x_coordinates-xSource>0) {
				xSource++;
				
			}
			if(x_coordinates-xSource<0) {
				xSource--;
			}
			
			
		}
		else if(xRichtig && ySource!=y_coordinates) {
			ySource++;
			
		}
		this.repaint();
		if(xRichtig && yRichtig) {
			timer.stop();
			isAnimated = false;
			for(int j=0;j<3;j++)
				oldTowers.get(j).clear();
			deepCopy(newTowers,oldTowers);
		}
	}
	
	public void setNewTowers(ArrayList<Stack<Integer>> newTowers) {
		this.newTowers = newTowers;
		
		
	}
	
	public static void deepCopy(ArrayList<Stack<Integer>> copiedList, ArrayList<Stack<Integer>> inputList) {
		for(int i = 0;i< copiedList.size();i++) {
			for(int j = 0;j<copiedList.get(i).size();j++) 
				inputList.get(i).add(j, copiedList.get(i).get(j));
		}
		
		
	}
	
	public static void main (String[] args) {
		TowersOfHanoi.playTowers(5, false);
		
		
		
	}

	
	
	
	
	}
	