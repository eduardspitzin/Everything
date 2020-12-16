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
	TowersOfHanoi(int n,boolean pause) {

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

	public void move(int n, int fromTower, int toTower, int usingTower, boolean pause) {

		if (n >= 1) {

			move(n - 1, fromTower, usingTower, toTower, pause);

			towers.get(toTower - 1).push(towers.get(fromTower - 1).pop());
			//tGUI.refresh(towers);
			/*
			while (!tGUI.baeume.xRichtig || !tGUI.baeume.yRichtig || tGUI.baeume.paused) {

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
*/
			//tGUI.baeume.xRichtig = false;
			//tGUI.baeume.yRichtig = false;
			for (Stack<Integer> ausgabe : towers) {
				System.out.println(ausgabe);
			}
			System.out.println(" ");
			move(n - 1, usingTower, toTower, fromTower, pause);
		}

	}

	
	public static void playTowers(int n, boolean debug) {
		TowersOfHanoi toh = new TowersOfHanoi(n,debug);
		toh.move(n, 1, 3, 2, debug);

	}

	public static void main(String[] args) {
		playTowers(8, false);
	}
}