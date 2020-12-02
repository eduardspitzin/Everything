package de.ituvsoft.Studenten;

public class ZZZZZnake extends Zufall {

  public static void main( String[] args ) {
    java.awt.Point playerPosition = new java.awt.Point( Zufall.z('x'), Zufall.z('y') );
    java.awt.Point snakePosition1  = new java.awt.Point( Zufall.z('x'), Zufall.z('y') );
    java.awt.Point snakePosition2  = new java.awt.Point( Zufall.z('x'), z('y') ); 
    java.awt.Point goldPosition1   = new java.awt.Point( z('x'), z('y') );
    java.awt.Point goldPosition2   = new java.awt.Point( z('x'), z('y') );
    java.awt.Point doorPosition   = new java.awt.Point( z('x'), z('y') );
    boolean rich = false;
    boolean gefangen = false;
    int n = 0;
    int m = 0;
    
    while ( true ) {
      // Raster mit Figuren zeichnen

      for ( int y = 0; y < 10; y++ ) {
        for ( int x = 0; x < 40; x++ ) {
          java.awt.Point p = new java.awt.Point( x, y );
          if ( playerPosition.equals( p ) )
            System.out.print( '&' );
          else if ( snakePosition1.equals( p ) || snakePosition2.equals( p ) )
            System.out.print( 'S' );
          else if ( goldPosition1.equals( p ) || goldPosition2.equals( p )   )
            System.out.print( '$' );
          else if ( doorPosition.equals( p ) )
            System.out.print( '#' );
          else System.out.print( '.' );
        }
        System.out.println();
      }
      
      // Status feststellen
      
      if ( rich && playerPosition.equals( doorPosition ) ) {
        System.out.println( "Gewonnen!" );
        return;
      }
      if ( playerPosition.equals( snakePosition1 ) || playerPosition.equals( snakePosition2 )  )
    	  gefangen = true;
      
      
      if (gefangen) {
        System.out.println( "ZZZZZZZ. Die Schlange hat dich!" );
        return;
      }
      if ( playerPosition.equals( goldPosition1 ) ) {
    	  n++;
      goldPosition1.setLocation( -1, -1 );
      }
      
      if ( playerPosition.equals( goldPosition2 ) ) {
        n++;
        goldPosition2.setLocation( -1, -1 );
      }

      if(n==2) {
    	  rich = true;
    	  
      }
      
      // Konsoleneingabe und Spielerposition verändern
      if (m < 4){
      for(int j = 0; j>4; j++)
    	  m++;
      switch ( new java.util.Scanner( System.in ).next() ) {
        // Spielfeld ist im Bereich 0/0 .. 39/9
        case "w" : playerPosition.y = Math.max(  0, playerPosition.y - 1 ); break;
        case "s" : playerPosition.y = Math.min(  9, playerPosition.y + 1 ); break;
        case "a" : playerPosition.x = Math.max(  0, playerPosition.x - 1 ); break;
        case "d" : playerPosition.x = Math.min( 39, playerPosition.x + 1 ); break;
      }
      }
      else {
    	  
    	  switch ( new java.util.Scanner( System.in ).next() ) {
          // Spielfeld ist im Bereich 0/0 .. 39/9
        	
          case "h" : playerPosition.y = Math.max(  0, playerPosition.y - 1 ); break;
          case "t" : playerPosition.y = Math.min(  9, playerPosition.y + 1 ); break;
          case "l" : playerPosition.x = Math.max(  0, playerPosition.x - 1 ); break;
          case "r" : playerPosition.x = Math.min( 39, playerPosition.x + 1 ); break;
    	  
    	  
    	  
      }  
      
      
      }

      // Schlange bewegt sich in Richtung Spieler

      if ( playerPosition.x < snakePosition1.x )
        snakePosition1.x--;
      else if ( playerPosition.x > snakePosition1.x )
        snakePosition1.x++;
      if ( playerPosition.y < snakePosition1.y )
        snakePosition1.y--;
      else if ( playerPosition.y > snakePosition1.y )
        snakePosition1.y++;
      
      
      if ( playerPosition.x < snakePosition2.x )
          snakePosition2.x--;
        else if ( playerPosition.x > snakePosition2.x )
          snakePosition2.x++;
        if ( playerPosition.y < snakePosition2.y )
          snakePosition2.y--;
        else if ( playerPosition.y > snakePosition2.y )
          snakePosition2.y++;
    } // end while
  }
}
