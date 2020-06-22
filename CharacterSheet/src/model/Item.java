package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Item {
	private String name;
	private int statbonus;
	private Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\ak47.png");
	
	public Item(String name, int statbonus, Icon icon) {
		this.name = name;
		this.statbonus = statbonus;
		this.icon = icon;
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

	public static void main(String[] args) {
		String name = "AK47";
		int statbonus = 20;
		Icon icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\item\\ak47.png");

		System.out.println(name);
		System.out.println(statbonus);
		System.out.println(icon);
		JFrame f = new JFrame();
		JButton b = new JButton();
		b.setIcon(icon);
		f.add(b);
		f.setVisible(true);
		Item i = new Item(name, statbonus, icon);
		System.out.println(i);
	}
	
	@Override
	public String toString() {
		return name + ", " + statbonus + ", " + icon + " ";
	}
	
	
	
}
