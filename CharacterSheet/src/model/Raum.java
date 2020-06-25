package model;

import java.io.Serializable;

public class Raum implements Serializable {

	private static final long serialVersionUID = -8754566594733954539L;
Monster Gegner;
 Item Schatz;
 boolean AUsgang;
 
 
 

public Raum(Monster gegner, Item schatz, boolean AUsgang) {
	
	
	this.Gegner = gegner;
	
	this.Schatz = schatz;
	
}
public Object getGegner() {
	return Gegner;
}
public void setGegner(Monster gegner) {
	Gegner = gegner;
}
public Object getSchatz() {
	return Schatz;
}
public void setSchatz(Item schatz) {
	Schatz = schatz;
	
	
	 
		 }

}





