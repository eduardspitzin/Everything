package de.ituvsoft.Studenten;

public class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		// 1 1 2 3 5 8 13 21 34 55 89 
		// 1 2 3 4 5 6  7  8 9  10 11
	
	
	
	}
		public static int fibonacci(int n) {
			
			
			if (n == 1)
				return 1;
			if(n>1)
			{	
			
			
			n--;
			return fibonacci(n-1) + fibonacci(n);
		
			}
			
			return 0;
		}
}