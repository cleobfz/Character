package model;

<<<<<<< HEAD
public class Monster {

	private int hp;
	private int dmg;
	private String name;
=======

import javax.swing.Icon;
import javax.swing.ImageIcon;



import java.io.Serializable;


public class Monster implements Serializable {

	private static final long serialVersionUID = 2474797148548216945L;
	private int hp;
	private int dmg;
	private Icon icon;

	private String name= new String();
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673

	public Monster(int hp, int dmg, String name) {
		this.hp=hp;
		this.dmg=dmg;
<<<<<<< HEAD
		this.name=name;		
	}
	
	public int attack(){
		return dmg;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String Monster) {
		name = Monster;
	}
=======
		this.name=name;	
		this.icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\monster\\" + name + ".png");
	}
	
	public String getName() {
		return name;
	}
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
<<<<<<< HEAD

=======
		if(hp < 0){
		this.hp = 0;
		} else {
			this.hp = hp;
		}
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
<<<<<<< HEAD

=======
		this.dmg = dmg;
	}


	public void setName(String Monster) {
		name = Monster;
	}
	
	public Icon getIcon(){
		return icon;
	}
	
	public void setIcon(Icon icon){
		this.icon = icon;
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Monstername: " + name + ", Damage: " + dmg + ", Healthpoints=" + hp + " ";
=======
		return " " + name  + " , HP: "+ getHp() +", DMG: " + getDmg();
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
	}
	
}
