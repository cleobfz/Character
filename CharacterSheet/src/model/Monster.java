package model;

public abstract class Monster {

	private int hp;
	private int dmg;
	String Monster= new String();
	private int attack;
	abstract int attack();

	public Monster(int hp, int dmg, String Monster, int attack) {
		this.hp=hp;
		this.dmg=dmg;
		this.Monster=Monster;
		this.attack=attack;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public String getMonster() {
		return Monster;
	}

	public void setMonster(String monster) {
		Monster = monster;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public String toString() {
		return "Monster [hp=" + hp + ", dmg=" + dmg + ", Monster=" + Monster + ", attack=" + attack + ", attack()="
				+ attack() + ", getHp()=" + getHp() + ", getDmg()=" + getDmg() + ", getMonster()=" + getMonster()
				+ ", getAttack()=" + getAttack() + "]";
	}
	
}
