package model;

public class Erdmann extends Monster {

	public Erdmann() {
		super(3, 1, "Erdmann || Strategie: aus einer Krise als Gewinner hervorgehen");
		}
	

	 
public void name() {
		
		System.out.println(("ERDMANN DER GROßE")+"\n");
	
	}

public void dmg() {
	
	System.out.println(("SCHADEN: 1/10")+"\n");
}
	
	public void hp() {
		
		System.out.println(("LIFEPOINTS: 3/10")+"\n");
	}

	int attack() {
		
		return 0;
	}
		public static void main(String[] args) {
		Monster erdmann = new Erdmann();
		
	}
	
}
