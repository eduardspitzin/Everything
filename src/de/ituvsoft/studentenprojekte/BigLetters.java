package de.ituvsoft.studentenprojekte;

public class BigLetters {
	
	public static String blMaker(String tLetters) {
		if(tLetters == null) {
			return "";
			
		}
		
		return tLetters.toUpperCase();
		
		
		
		
	}
	public static void main(String[] args) {
		
		System.out.println(blMaker("()&%"));
		
		
		
	}
	
	
}
