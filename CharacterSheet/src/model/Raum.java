package model;

import java.io.Serializable;

public class Raum implements Serializable {

	private static final long serialVersionUID = -8754566594733954539L;
Monster Gegner;
 Item Schatz;
 boolean Ausgang;
 
 
 

public Raum(Monster gegner, Item schatz, boolean Ausgang) {
	
	this.Gegner = gegner;
	this.Schatz = schatz;	
	}

public Monster getGegner() {
	return Gegner;
	}
public void setGegner(Monster gegner) {
	Gegner = gegner;
}
public Item getSchatz() {
	return Schatz;
}
public void setSchatz(Item schatz) {
	Schatz = schatz;
	}
public boolean getAusgang(){
	return Ausgang;
}

}





