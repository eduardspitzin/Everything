package de.ituvsoft.Studenten;

import java.util.*;
import java.lang.*;

public class TowersofHanoi {
	
	ArrayList<Stack<Integer>> towers;
	
	//Konstruktor für Türme als Stack in Arrays
	TowersofHanoi (int n) {
		
		towers = new ArrayList<Stack<Integer>>();
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		
		for(int i = n; i > 0; i--) {
			towers.get(0).push(i);
		}
		for (Stack<Integer> ausgabe : towers) {
			System.out.println(ausgabe);
		}
		System.out.println(" ");
	
	}
	public void move (int n, int fromTower, int toTower, int usingTower) {
		if (n >= 1) {
			move (n-1, fromTower, usingTower, toTower);
			
			towers.get(toTower - 1).push(towers.get(fromTower - 1).pop());
			for (Stack<Integer> ausgabe : towers) {
				System.out.println(ausgabe);
			}
			System.out.println(" ");
			
			move (n-1, usingTower, toTower, fromTower);
		}

	}
	
	public static void main(String[] args) {
		TowersofHanoi test = new TowersofHanoi(5); 
		test.move(5, 1, 3, 2);
		
		
	}
	
	
	

}