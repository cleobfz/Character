package model;


public class Raum {
 Object Gegner;
 Object Schatz;
 
 

public Raum(Object gegner, Object schatz) {
	
	Gegner = gegner;
	
	Schatz = schatz;
	
}
public Object getGegner() {
	return Gegner;
}
public void setGegner(Object gegner) {
	Gegner = gegner;
}
public Object getSchatz() {
	return Schatz;
}
public void setSchatz(Object schatz) {
	Schatz = schatz;
	
	 boolean AUsgang;
	 
	if ( AUsgang = true) {
		 System.out.println("it's Schatz");
		 }
		 else {
		 System.out.println("it's Monster");
		 }

}

}



