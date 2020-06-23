package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Item {
	private String name;
	private int statbonus;
	private int hpbonus;
	private Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\ak47.png");
	
	public Item(String name, int statbonus, int hpbonus) {
		this.hpbonus = hpbonus;
		this.name = name;
		this.statbonus = statbonus;
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
