package model;

import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Item implements Serializable {

	private static final long serialVersionUID = 3726183022289982996L;
	private String name;
	private int statbonus;
	private int hpbonus;
	private Icon icon;
	
	public Item(String name, int statbonus, int hpbonus) {
		this.hpbonus = hpbonus;
		this.name = name;
		this.statbonus = statbonus;
		this.icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\items\\"+name+".png");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatbonus() {
		return statbonus;
	}

	public void setStatbonus(int statbonus) {
		this.statbonus = statbonus;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	
	public int getHpbonus() {
		return hpbonus;
	}

	public void setHpbonus(int hpbonus) {
		this.hpbonus = hpbonus;
	}

	@Override
	public String toString() {
		return "Itemname: "+ name + ",Statbonus: " + statbonus + ",HPbonus: " + hpbonus + " ";
	}
	
}
