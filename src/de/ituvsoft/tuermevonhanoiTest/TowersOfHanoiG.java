package de.ituvsoft.tuermevonhanoiTest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

import de.ituvsoft.tuermevonhanoi.Slice;
public class TowersOfHanoiG extends JFrame {
	
	JFrame toh;
	TannenTuerme baeume;
	public int[] baumX;
	public int[] baumY;
	public int bStammWidth;
	int maxSlices;
	public TowersOfHanoiG() {
		toh = new JFrame("Die Türme von Hanoi");
		toh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		toh.setSize(1000, 600);
		toh.setResizable(false);
		toh.setLocationByPlatform(true);
		toh.add(new TannenTuerme());
		//baeume = new TannenTuerme(maxSlices,liste);
		//toh.add(baeume);
		
	
		toh.setVisible(true);
		
		
	}
	
		
		
	
	public static void main(String[] args) {
		JFrame test = new TowersOfHanoiG();
		test.add(new TannenTuerme());
		
	}

	

}
