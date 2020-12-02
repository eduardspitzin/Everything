package de.ituvsoft.studentenprojekte;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue; 
class FormatterTest extends Formatter {

	@Test
	void test() {
		
		Point p = new Point(5,2);
		formatter("Hallo ich bin /%s und bin /%n Jahre %S","Eduard",18,"jung","und du?");
		formatter("Hallo ich bin /%s und bin /%n Jahre %S","Eduard","18");
		formatter("Hallo ich bin /%x und bin /%n Jahre %S","Eduard",18.);
		formatter("Hallo ich bin /%x und bin /%f2 Jahre %S","Eduard","Eduard",18.6,"JUNG");
		formatter("Hallo ich bin am /%D und bin /%f2 Jahre %S","456323","Eduard",18.6,"JUNG");
		formatter(null,"Eduard","Lucy");
		formatter("Hallo wie geht es deinem %s welchen du dir %D geholt hast und der %f2 wiegt",null,null,null);
		formatter("Das hier ist ein Test,gib mir dein %s",p);
		formatter("Das hier ist ein Test,gib mir dein %s",p);
	
	}
	
	@Test 
	void toLessArguments() {
		String ws = "Hallo ich bin Eduard und bin 18 Jahre";
		assertTrue(formatter("Hallo ich bin /%s und bin /%n Jahre %S","Eduard",18).equals(ws)); 
	}
	
	
	void toMuchArguments() {
		
		
		
	}
	
	
	
}
