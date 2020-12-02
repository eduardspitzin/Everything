package de.ituvsoft.Studenten.Hund;

public class Konstruktor {
	
	public static void nOJagdhund() {
	Jagdhund markus = new Jagdhund();
	markus.farbe = "braun";
	markus.faehigkeitsLVL = 9000;
	markus.auge = 1;
	System.out.println("Jagdhund:" + markus.toString());
	}
	
	public static void nOSchosshund() {
	Schosshund pfiffi = new Schosshund();
	pfiffi.farbe = "weiss";
	pfiffi.schleifenFarbe = "pink";
	System.out.println("Schosshund:" + pfiffi.toString());
	
	}
	
	
	
	
	
}
