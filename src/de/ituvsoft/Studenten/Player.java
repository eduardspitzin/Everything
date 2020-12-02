package de.ituvsoft.Studenten;

public class Player extends GameObject {
	String name = "", item = "";

	  
	@Override public void setName(String name ) {
	    this.name = name;
	    
	  }

	  String getName() {
	    return name;
	  }

	  Player setItem( String item ) {
	    this.item = item;
	    return this;
	  }

	  String getItem() {
	    return item;
	  }

	  String id() {
	    return name + " hat " + item;
	  }
	
	
	
	public static void main(String[] args) {
	  Player Eduard = new Player();
	  Eduard.setName("Eduard");
	  Eduard.setItem("Lange Nase");
	  System.out.println(Eduard.id());
	  

	}

}
