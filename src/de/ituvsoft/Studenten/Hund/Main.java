package de.ituvsoft.Studenten.Hund;

public class Main extends Konstruktor {
	
	public static void main(String[] args) {
		Jagdhund markus = new Jagdhund();
		markus.farbe = "braun";
		markus.faehigkeitsLVL = 9000;
		markus.auge = 1;
		System.out.println("Jagdhund:" + markus.toString());			
		markus = null;
	 	while(markus == null) {
	 		System.out.println(1);
	 		markus = new Jagdhund();
	 		
	 		
	 		
	 		
	 	}
	
	
	}
	
	
	
		
}
	
		
		
		
		
	
	
	

