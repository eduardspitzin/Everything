package de.ituvsoft.tuermevonhanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TowersOfHanoi {
	static boolean pause;
	public TowersOfHanoiG tGUI;
	ArrayList<Stack<Integer>> towers;
	

	// Konstruktor für Türme als Stack in Arrays
	TowersOfHanoi(int n) {

		towers = new ArrayList<Stack<Integer>>();
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
	
		for (int i = n; i > 0; i--) {
			towers.get(0).push(i);
		}
		for (Stack<Integer> ausgabe : towers) {
			System.out.println(ausgabe);
		}
		System.out.println(" ");
		tGUI = new TowersOfHanoiG(towers);
		
		
	}

	public void move(int n, int fromTower, int toTower, int usingTower, boolean pause) {

		if (n >= 1) {
			
			move(n - 1, fromTower, usingTower, toTower, pause);
			
			towers.get(toTower - 1).push(towers.get(fromTower - 1).pop());
			tGUI.refresh(towers);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for (Stack<Integer> ausgabe : towers) {
				System.out.println(ausgabe);
			}
			System.out.println(" ");
				pause();
			
			move(n - 1, usingTower, toTower, fromTower, pause);
		}

	}

	public static void pause(){
		if(pause) {
		System.out.println("Weiter im Step-Mode?(J/N)");
		String s = new Scanner(System.in).nextLine();
		if (s.equalsIgnoreCase("J") || s.equalsIgnoreCase("ja")) {} 
		else if (s.equalsIgnoreCase("N") || s.equalsIgnoreCase("Nein")) {
			pause = false;
		}
		else {
			System.out.println("Bitte wählen sie (J)a oder (N)ein");
			pause();
		}
		
	}
	}
	
	public static void playTowers(int n, boolean debug) {
		TowersOfHanoi toh = new TowersOfHanoi(n);
		pause = debug;
		pause();
		toh.move(n, 1, 3, 2, debug);

	}
	
	
	
	public static void main(String[] args) {
		playTowers(5,false);
	}
}