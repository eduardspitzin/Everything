package de.ituvsoft.tuermevonhanoimitMenu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;
public class TowersOfHanoiG extends JFrame {
	

	TannenTuerme baeume;
	public int[] baumX;
	public int[] baumY;
	public int bStammWidth;
	int maxSlices;
	public TowersOfHanoiG(ArrayList<Stack<Integer>> liste,boolean pause) {
		this.setTitle("Die Türme von Hanoi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setLocationByPlatform(true);
		//baeume = new TannenTuerme(liste,pause);
		this.add(baeume);
		
	
		this.setVisible(true);
		
		
	}
	public void refresh(ArrayList<Stack<Integer>> newTowers) {
		baeume.setNewTowers(newTowers);
		this.repaint();
	}
		
		
	
	public static void main(String[] args) {
		TowersOfHanoi.playTowers(5, false);

	}

	

}
