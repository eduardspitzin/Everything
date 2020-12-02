package de.ituvsoft.Studenten;

public class Zufall {
	static int z(char c)
	
	{
		int n;
		if (c== 'x')
		{	
			n = 39;
		}
		
		else
			n = 9;
			
		return   (int) Math.round(Math.random()*n);
	}	
	
}
