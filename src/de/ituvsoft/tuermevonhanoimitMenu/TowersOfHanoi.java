package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TowersOfHanoi extends Thread {
	static boolean pause;
	//public TowersOfHanoiG tGUI;
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
		//tGUI = new TowersOfHanoiG(towers,pause);

	}
	@Override
	public void run() {
		move(5,1,3,2,false);
		
	}
	
	
	public void move(int n, int fromTower, int toTower, int usingTower, boolean pause) {

		if (n >= 1) {

			move(n - 1, fromTower, usingTower, toTower, pause);

			towers.get(toTower - 1).push(towers.get(fromTower - 1).pop());
			
			
			

				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			
		
	
			for (Stack<Integer> ausgabe : towers) {
				System.out.println(ausgabe);
			}
			System.out.println(" ");
			move(n - 1, usingTower, toTower, fromTower, pause);
		}

	}
	public ArrayList<Stack<Integer>> getTowers(){
		return towers;
		
		
		
	}
	public static void playTowers(int n, boolean debug) {
		TowersOfHanoi toh = new TowersOfHanoi(n);
		toh.move(n, 1, 3, 2, debug);

	}

	public static void main(String[] args) {
		playTowers(5, true);
	}
}