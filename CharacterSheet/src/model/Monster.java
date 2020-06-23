package model;

public class Monster {

	private int hp;
	private int dmg;
	private String name;

	public Monster(int hp, int dmg, String name) {
		this.hp=hp;
		this.dmg=dmg;
		this.name=name;		
	}
	
	public int attack(){
		return dmg;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String Monster) {
		name = Monster;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {

	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {

	}

	@Override
	public String toString() {
		return "Monstername: " + name + ", Damage: " + dmg + ", Healthpoints=" + hp + " ";
	}
	
}
