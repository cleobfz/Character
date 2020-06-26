package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Monster {

	private int hp;
	private int dmg;
	private String name;
	private Icon icon;

	public Monster(int hp, int dmg, String name) {
		this.hp=hp;
		this.dmg=dmg;
		this.name=name;	
		this.icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\monster\\" + name + ".png");
	}
	
	public int attack(){
		return dmg;
	}
	
	public Icon getIcon(){
		return icon;
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
		if(hp < 0){
		this.hp = 0;
		} else {
			this.hp = hp;
		}
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	@Override
	public String toString() {
		return "Monstername: " + name + ", Damage: " + dmg + ", Healthpoints=" + hp + " ";
	}
	
}
