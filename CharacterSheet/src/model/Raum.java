package model;

<<<<<<< HEAD

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
		return "Gegner: " + gegner.getName() + ", Schatz: " + schatz.getName() + ", Ausgang; " + ausgang + " ";
	}
	
=======
import java.io.Serializable;

public class Raum implements Serializable {

	private static final long serialVersionUID = -8754566594733954539L;
Monster Gegner;
 Item Schatz;
 boolean Ausgang;
 
 
 

public Raum(Monster gegner, Item schatz, boolean Ausgang) {
	this.Ausgang = Ausgang;
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

@Override
public String toString() {
	return "\n Gegner=" + Gegner + "\n Schatz: " + Schatz + "\n Ausgang: " + Ausgang + "";
}



>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
}





