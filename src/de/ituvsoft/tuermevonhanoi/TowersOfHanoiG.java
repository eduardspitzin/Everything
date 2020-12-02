package de.ituvsoft.tuermevonhanoi;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;
public class TowersOfHanoiG extends JFrame {
	
	JFrame toh;
	TannenTuerme baeume;
	public int[] baumX;
	public int[] baumY;
	public int bStammWidth;
	int maxSlices;
	public TowersOfHanoiG(ArrayList<Stack<Integer>> liste) {
		Stylesheet background = new Stylesheet();
		baumX = background.baumStammX;
		baumY = background.baumStammY;
		bStammWidth = background.bStammWidth;
		maxSlices = liste.get(0).size();
		this.setTitle("Die Türme von Hanoi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setLocationByPlatform(true);
		baeume = new TannenTuerme(maxSlices,liste);
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
