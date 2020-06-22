package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Skill {
	String name;
	int damagevalue;
	
	private Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\skill\\open-book.png");
	
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
	
	public Icon getIcon() {
		return icon;
	}
	
	@Override
	public String toString() {
		return name + ", " + damagevalue + " ";
	}
	
	
	
}
