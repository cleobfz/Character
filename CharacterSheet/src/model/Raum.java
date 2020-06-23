package model;


public class Raum {
 private Monster gegner;
 private Item schatz;
 private boolean ausgang;
 
public Raum(Monster gegner, Item schatz, boolean ausgang) {
	
	this.gegner = gegner;
	this.schatz = schatz;
	this.ausgang = ausgang;
	
	}
	public Monster getGegner() {
		return gegner;
	}
	public void setGegner(Monster gegner) {
		this.gegner = gegner;
	}
	public Item getSchatz() {
		return schatz;
	}
	
	public boolean getAusgang(){
		return ausgang;
	}
	public void setSchatz(Item schatz) {
		this.schatz = schatz;	
	}
	@Override
	public String toString() {
		return "Gegner: " + gegner + ", Schatz: " + schatz + ", Ausgang; " + ausgang + " ";
	}
	
}





