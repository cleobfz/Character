package model;


import javax.swing.Icon;
import javax.swing.ImageIcon;



import java.io.Serializable;


public class Monster implements Serializable {

	private static final long serialVersionUID = 2474797148548216945L;
	private int hp;
	private int dmg;
	private Icon icon;

	private String name= new String();

	public Monster(int hp, int dmg, String name) {
		this.hp=hp;
		this.dmg=dmg;
		this.name=name;	
		this.icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\monster\\" + name + ".png");
	}
	
	public String getName() {
		return name;
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


	public void setName(String Monster) {
		name = Monster;
	}
	
	public Icon getIcon(){
		return icon;
	}

	@Override
	public String toString() {
		return " Monster= " + name  + "HP: "+ getHp() +"DMG " + getDmg();
	}
	
}
