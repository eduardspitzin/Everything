package de.ituvsoft.tuermevonhanoimitMenu;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JPanel;

public class TannenTuerme extends Stylesheet implements ActionListener {
	int x_coordinates;
	TowersOfHanoi algorithm;
	int y_coordinates;
	int xSource;
	int ySource;
	int widthAn;
	int width;
	int widthProduct;
	int height = 40;
	int bStammWidth;
	int bStammHeight;
	ArrayList<Stack<Integer>> currentTowers;
	ArrayList<Stack<Integer>> newTowers;
	int[] baumX;
	int[] baumY;
	int maxYStamm;
	Timer timer = new Timer(10,this);
	int dTowerNumber;
	int incTowerNumber;
	int maxSlices;
	boolean xWanderung;
	boolean xRichtig;
	boolean yRichtig;
	boolean isAnimated;
	int xGoal;
	int yGoal;
	boolean running;
	boolean pause;
	int actualSlices;
	boolean paused;
	int speed = 2;
	Thread algorithmThread;
	int scheiben;
	
	public TannenTuerme(int scheiben,boolean pause) {
		
		this.scheiben = scheiben;
		this.pause = pause;
		this.bStammWidth = super.bStammWidth;
		this.bStammHeight = super.bStammHeight;
		widthProduct = 20;
		// der Höchste Stamm
		currentTowers = new ArrayList<Stack<Integer>>();
		for(int i = 0;i<3;i++)
			currentTowers.add(new Stack<Integer>());
	
	}
	
	public void start() {
		algorithm = new TowersOfHanoi(scheiben);
		newTowers = algorithm.towers;
		deepCopy(newTowers,currentTowers);
		maxSlices = newTowers.get(0).size();
		this.baumX = super.baumStammX;
		this.baumY = super.baumStammY;
		maxYStamm = Integer.min(Integer.min(baumY[0], baumY[1]),baumY[2]);

		
		algorithmThread = new Thread(algorithm);
		algorithmThread.start();
		
	}
	
	private void drawSlices(Graphics g) {
		for(int i=0;i<3;i++) {
			int vZahl = Integer.compare(currentTowers.get(i).size(), newTowers.get(i).size());
			if(vZahl == 1) {
				dTowerNumber = i;
			}
			else if(vZahl==-1) {
				incTowerNumber = i;
				
			}
	
		}
		
		for(int j =0; j<3;j++) {	 
		for(int i = 0;i<currentTowers.get(j).size();i++) {
			width = 20*currentTowers.get(j).get(i);			
			y_coordinates = baumY[j] -(height*(1+i));
			x_coordinates = baumX[j]-width/2+(bStammWidth/2);
			g.setColor(new Color(0x00,0x71,0x23));
			isAnimated = i==currentTowers.get(j).size()-1 && j== dTowerNumber; // Letzte Scheibe und Turm welcher Scheibe verliert
			if(isAnimated && dTowerNumber!=incTowerNumber && !running)
			{
			xSource = x_coordinates;
			ySource = y_coordinates;
			widthAn = widthProduct*currentTowers.get(j).get(i);	
			xGoal = baumX[incTowerNumber] -width/2+(bStammWidth/2); 
			yGoal =baumY[incTowerNumber] -(height*(1+currentTowers.get(incTowerNumber).size()));// Baumstamm Y - Scheiben die drauf sind

			}
			else if(!isAnimated) {
				
				g.fillRect(x_coordinates, y_coordinates, width, height);
				
			}
			
			
		}

	
	}
		
	}
	
	private void drawAnimation(Graphics g) {
		g.fillRect(xSource, ySource, widthAn, height);
		timer.start();
	}
	
	
	
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSlices(g);
		if(dTowerNumber!=incTowerNumber) {
			drawAnimation(g);
		}
		if(currentTowers.get(2).size() == maxSlices)
			timer.stop();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		actualSlices = Integer.max(Integer.max(currentTowers.get(0).size(),currentTowers.get(1).size() ),currentTowers.get(2).size());
		running = true;
		xRichtig = xGoal == xSource;
		yRichtig = ySource==yGoal;
		
		if(maxYStamm-height*(actualSlices+2)<ySource) {
			ySource = ySource-speed;
		}
			if(xGoal-xSource>0) {
				xSource = xSource +speed;;
				
			}
			if(xGoal-xSource<0) {
				xSource = xSource-speed;
			}
			
		if(xRichtig && ySource<yGoal) {
			ySource = ySource+speed*2;
			
		}
		this.repaint();
		if(xRichtig && yRichtig) {
			System.out.println("Abschluss");
			this.pause();
			running = false;
			for(int j=0;j<3;j++)
				currentTowers.get(j).clear();
			deepCopy(newTowers,currentTowers);
			algorithm.wait = false;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	
	private static void deepCopy(ArrayList<Stack<Integer>> copiedList, ArrayList<Stack<Integer>> inputList) {
		for(int i = 0;i< copiedList.size();i++) {
			for(int j = 0;j<copiedList.get(i).size();j++) 
				inputList.get(i).add(j, copiedList.get(i).get(j));

		}
		
		
	}

	public void pause() {
		timer.stop();
		paused = true;
		if (pause) {
			System.out.println("Weiter im Step-Mode?(J/N)");
			String s = new Scanner(System.in).nextLine();
			if (s.equalsIgnoreCase("J") || s.equalsIgnoreCase("ja")) {
			} else if (s.equalsIgnoreCase("N") || s.equalsIgnoreCase("Nein")) {
				 pause = false;

			} else {
				System.out.println("Bitte wählen sie (J)a oder (N)ein");
				pause();
			}
		}
		paused = false;
		timer.restart();
		algorithm.setWaiting(false);
	}
}