package model;

import java.util.ArrayList;

import controller.Controller;

public class Character {
	
	Controller controller;
	private String name;
	private int hp;
	private int stat;
	private ArrayList<Item> inventory = new ArrayList<>();
	private ArrayList<Skill> skill = new ArrayList<>();
	private Origin origin;

	
	
	public Character(String name, int stat,int hp, ArrayList<Item> inventory, ArrayList<Skill> skill, Origin origin) {
		this.name = name;
		this.stat = stat;
		this.hp = hp;
		this.inventory = inventory;
		this.skill = skill;
		this.origin = origin;
	}
	
	// returns int attack dmg 
	public int attack(Skill skill){
		int skilldmg = skill.getDmagevalue();
		int itemdmg = getItemStatbonus();
		int totaldmg = skilldmg + itemdmg + stat; 
		
		return totaldmg;
		
	}
	// returns statbonus from itemlist
	public int getItemStatbonus(){
		
		int itemstatbonus = 0;
		for(int i =0; i < inventory.size(); i++){
			itemstatbonus += inventory.get(i).getStatbonus();
		}
		return itemstatbonus;
		
	}
	//returns hpbonus from itemlist
	public int getItemHpbonus(){
		int itemhpbonus =0;
		for(int i =0; i < inventory.size(); i++){
			itemhpbonus += inventory.get(i).getHpbonus();
		}
		return itemhpbonus;
	}
	
//	public int selectedItem(){
//		Item selectetItem = controller.getselectedItem();
//		System.out.println("es hat den dmgwert " + selectetItem.getStatbonus());
//		return 0;
//	}
	
	
	
	//bunch of getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		if(stat > 10){
			this.stat = 10;
		} else {
		this.stat = stat;
		}
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public ArrayList<Skill> getSkill() {
		return skill;
	}
	public void setSkill(ArrayList<Skill> skill) {
		this.skill = skill;
	}
	public Origin getOrigin() {
		return origin;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		
		if(hp > 100){
			hp = 100;
		}
		else {
		this.hp = hp;
		}
	}

	@Override
	public String toString() {
		return  "Charactername: "+name + ", Statbonus: " + stat + ", Healthpoints: " + hp + " ";
	}

	//equals and hash Method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
