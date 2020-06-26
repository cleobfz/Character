package model;

<<<<<<< HEAD
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Monster {
=======
import java.io.Serializable;
>>>>>>> 35b4965ab8a1b3a4181aa05b882f87d58fd3efa1

public class Monster implements Serializable {

	private static final long serialVersionUID = 2474797148548216945L;
	private int hp;
	private int dmg;
<<<<<<< HEAD
	private String name;
	private Icon icon;
=======
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
>>>>>>> 35b4965ab8a1b3a4181aa05b882f87d58fd3efa1

	public Monster(int hp, int dmg, String name) {
		this.hp=hp;
		this.dmg=dmg;
<<<<<<< HEAD
		this.name=name;	
		this.icon = new ImageIcon(System.getProperty("user.dir") + "\\resources\\monster\\" + name + ".png");
	}
	
	public int attack(){
		return dmg;
	}
	
	public Icon getIcon(){
		return icon;
	}
=======
		this.name=name;
		this.attack=attack;
		}
>>>>>>> 35b4965ab8a1b3a4181aa05b882f87d58fd3efa1

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
