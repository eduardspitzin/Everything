package de.ituvsoft.Studenten.Hund;

public class Hund {
	public Hund() {
		
	}
	String farbe;
	String name;
	int beineAnzahl = 4;
	int auge = 2;
	
	
	public void belle() {
		System.out.println("Wuff");	
		
	}
	public void wedel() {
		System.out.println("*wedel*");
		
	

	}
	public String toString() {
		
		return farbe + "\n" + beineAnzahl + "\n" + auge;
	}
	
	
		
	}

