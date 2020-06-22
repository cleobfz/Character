package model;

public class Skill {
	String name;
	int damagevalue;
	
	public Skill(String name, int damagevalue) {
		this.name = name;
		this.damagevalue = damagevalue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDmagevalue() {
		return damagevalue;
	}
	public void setDmagevalue(int damagevalue) {
		this.damagevalue = damagevalue;
	}
	
	@Override
	public String toString() {
		return name + ", " + damagevalue + " ";
	}
	
	
	
}
