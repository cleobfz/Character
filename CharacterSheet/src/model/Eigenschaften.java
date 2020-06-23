package model;

import model.Origin;

public class Eigenschaften {
	
	int intellect;
	int damage;
	int speed;
	int lifepoints;
	
	public int getLifepoints() {
		return lifepoints;
	}
	public void setLifepoints(int lifepoints) {
		this.lifepoints = lifepoints;
	}
	public int getIntellect() {
		return intellect;
	}
	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	Eigenschaften(int intellect,int damage,int speed,int lifepoints){
		this.damage=damage;
		this.speed=speed;
		this.intellect=intellect;
		this.lifepoints=lifepoints;
		
	}
}


