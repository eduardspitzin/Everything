package de.ituvsoft.studentenprojekte;

public class WholeNumber {

	public static String numberConvert(Object zahl) {
		
		if(zahl instanceof String) {
			double zahlS = Double.parseDouble((String)zahl);
			return String.valueOf(Math.round(zahlS));
				
			}
				
		if(zahl instanceof Integer) {
			return String.valueOf(zahl);
			
		}
		if(zahl instanceof Double) {
			return String.valueOf(Math.round((double)zahl));
			
		}
		if(zahl instanceof Long) {
			return String.valueOf(zahl);
			
		}
		if(zahl instanceof Short) {
			return String.valueOf(zahl);
			
		}
		if(zahl instanceof Byte) {
			return String.valueOf(zahl);
			
		}
		if(zahl instanceof Float) {
			return String.valueOf(Math.round((float) zahl));
			
		}
		else {
			throw new IllegalArgumentException("Bei dem Platzhalter n kannst du nur folgende Datentypen angeben: "
					+ " Long %n Double %n Integer %n Float %n Short %n String %n Byte ");
			
		}
		
	}

	public static void main(String[] args) {
		byte f = 10;
		System.out.println(numberConvert(f));

	}

}
