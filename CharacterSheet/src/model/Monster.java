package model;

import java.io.Serializable;

public class Monster implements Serializable {

	private static final long serialVersionUID = 2474797148548216945L;
	private int hp;
	private int dmg;
	String name= new String();
	private String attack;
	private int attack() {
		return 0;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public Monster(int hp, int dmg, String name) {
		this.hp=hp;
		this.dmg=dmg;
		this.name=name;
		this.attack=attack;
		}

	public String getName() {
		return name;
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

	public String getMonster() {
		return name;
	}

	public void setName(String Monster) {
		name = Monster;
	}

	@Override
	public String toString() {
		return "Monster [hp=" + hp + ", dmg=" + dmg + ", Monster=" + name  + ", attack()="
				+ attack() + ", getHp()=" + getHp() + ", getDmg()=" + getDmg() + ", getName()=" + getName()
				+ ", getAttack()=" + attack() + "]";
	}
	
}
