package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import model.Character;
import view.MasterGui;

public class Controller {
	Character eins;
	Item selectedItem;
	Raum aktuellerRaum = new Raum(null,null,true);
	MasterGui master;
	
	
	public Character getCharacter() {
		return eins;
	}
	
	public Raum getRaum(int x, int y) {
		aktuellerRaum =new Raum(new Monster(x, y, "Wandler"), new Item("Fu� des Wandlers", x/2, y/2), false);
		return aktuellerRaum;	
	}
	
	public Raum getRaum(){
		return aktuellerRaum;	
	}
	
	
	public void setRaum(Raum raum){
		aktuellerRaum =raum;
		master.repaintRoom();
	}
	
	public void enter(Raum room){
		if(room.getGegner() != null){
			int dialogBtn = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null, "Engage on "+room.getGegner()+"?", "Enemy ahead!", dialogBtn);
			if(dialogBtn == JOptionPane.YES_OPTION) {
				master.startFight(room);				
			}else if (dialogBtn == JOptionPane.NO_OPTION){
				
			}
				
				
			System.out.println("Encountering a " + room.getGegner().getName() + " with " +room.getGegner().getHp() + " Healthpoins");
			int life =room.getGegner().getHp();
			while(room.getGegner().getHp() > 0){
			 life = life - eins.attack(eins.getSkill().get(0));
			 room.getGegner().setHp(life);
			System.out.println("Attack successful on " + room.getGegner().getName()+ "  " + room.getGegner().getHp() + " HP remain");
			}
			System.out.println(room.getGegner().getName() +" defeated");
			room.setGegner(null);
		} else {
			System.out.println("No enemy :)");
		}
		if(room.getSchatz() != null){
			eins.getInventory().add(room.getSchatz());
			System.out.println("Added to Inventory: " + room.getSchatz().getName());
			room.setSchatz(null);
			master.repaintBot();
			master.repaintTop();
		} else{
			System.out.println("No Treasure -.-");
		}
		if(room.getAusgang()){
			JOptionPane.showMessageDialog(null, "Congratulations, you won this incredibly difficult game ");
		} else{
			System.out.println("No exit");
		}	
		
	}
	
	
	public void selectItem (Item item){
		selectedItem = item;
		System.out.println("Das folgende Item wurde selektiert: " +selectedItem);
	}
	
	public Item getselectedItem(){
		return selectedItem;
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		ArrayList<Item> inv = new ArrayList<>();
		
		inv.add(new Item("Bow", 0,6));
		inv.add(new Item("Sword", 6, 0));
		inv.add(new Item("Sword", 6, 0));
		inv.add(new Item("Bow", 0,6));
		inv.add(new Item("Potion",0, 10));
		inv.add(new Item("Armor", 5, 50));
		
		Item it2 = new Item("Sword", 10, 0);
		Item it3 = new Item("Armor", 5, 50);
		Item it4 = new Item("Bow", 5, 0);
		Item it5 = new Item("Crap", 0, 0);
		Item it6 = new Item("Destroyer of Worlds", 1000, 1000);
		
		
		inv.add(it2);
		inv.add(it3);
		inv.add(it4);
		inv.add(it5);
		//Origin origin
		//Konstruktor f�r Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Normal Attack", 5));
		skills.add(new Skill("Critical Strike", 10));
		skills.add(new Skill("Headshot", 16));
		skills.add(new Skill("Dirty Trick", 8));
	
		//Monster
		Monster goblin = new Monster(2, 2, "Goblin");
		Monster orc = new Monster(5,5,"Orc");
		Monster spider = new Monster (3,2,"Spider");
		Monster dragon = new Monster (200,200,"Dragon");
		Monster ghost = new Monster (7,6,"Ghost");
		Monster zombie = new Monster (4,5,"Zombie");
		//Raum Dungeon
		
		Raum raum1 = new Raum(goblin, it6, true);
		Raum raum2 = new Raum(dragon,it5,false);
		Raum raum3 = new Raum(spider,it2,false);
		Raum raum4 = new Raum(orc,null,false);
		Raum raum5 = new Raum(ghost,it3,false);
		Raum raum6 = new Raum(zombie,null,false);
		Raum raum7 = new Raum(goblin,null,false);
		Raum raum8 = new Raum(null,null,false);
		Raum raum9 = new Raum(goblin,it3,false);
		

		
		//Konstruktor f�r Skill?
		controller.eins = new Character("Odlon Greybeard the terrible", 10, 9, inv, skills, new Origin("Dwarf","Krieger"));
		System.out.println(controller.eins.attack(skills.get(0)));
		
		//enter Test
//		controller.enter(raum2);
		
		MasterGui gui = new MasterGui(controller);
		controller.master = gui;
	}

}
