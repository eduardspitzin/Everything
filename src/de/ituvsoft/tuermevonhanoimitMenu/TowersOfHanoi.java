package de.ituvsoft.tuermevonhanoimitMenu;


import java.util.*;

public class TowersOfHanoi implements Runnable {
	boolean setted;
	boolean wait;
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
	public void  setWaiting(boolean bool) {
		wait = bool;
		
	}
	
	public void move(int n, int fromTower, int toTower, int usingTower, boolean pause) {

		if (n >= 1) {

			move(n - 1, fromTower, usingTower, toTower, pause);

			towers.get(toTower - 1).push(towers.get(fromTower - 1).pop());
			
			wait = true;
			for (Stack<Integer> ausgabe : towers) {
				System.out.println(ausgabe);
			}
			System.out.println(" ");
			while(wait) {
				try {
					Thread.sleep(5);
			} catch (InterruptedException e) {				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			wait = false;
			move(n - 1, usingTower, toTower, fromTower, pause);
		}

	}
}