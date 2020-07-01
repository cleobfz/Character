package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
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
		aktuellerRaum =new Raum(new Monster(x, y, "Wandler"), new Item("Fuß des Wandlers", x/2, y/2), false);
		return aktuellerRaum;	
	}
	
	public Raum getRaum(){
		return aktuellerRaum;	
	}
	
	
	public void setRaum(Raum raum){
		aktuellerRaum =raum;
		master.repaintRoom();
	}
	
	
public void fight(Raum raum){
		
		//Attack enemy
		if(raum.getGegner().getHp()> 0 ){
		
		int gegnerlife =raum.getGegner().getHp();
		gegnerlife = gegnerlife - eins.attack(eins.getSkill().get(0));
		raum.getGegner().setHp(gegnerlife);
		master.repaintRoom();
		System.out.println("Monsterlife" + gegnerlife);
		
		//player gets damage randomly (50%)
		//TODO add statbonus
		int random = (int)((Math.random()*10)+1);
		if(random < 5){
		eins.setHp(eins.getHp() - raum.getGegner().getDmg());
		System.out.println("Monster greift an :" +raum.getGegner().getDmg());
		master.repaintTop();
		}
		} else {
			raum.setGegner(null);
			System.out.println("Monster tot");
			if(raum.getSchatz() != null){
			eins.getInventory().add(raum.getSchatz());
			System.out.println("Added to Inventory: " + raum.getSchatz().getName());
			raum.setSchatz(null);
			}
			master.repaintBot();
			master.repaintTop();
			master.endEncounter();
		}
	}
	
 	public void flee(Raum raum){
 		int random = (int)((Math.random()*10)+1);
 		if(random < 2){
 			eins.setHp(eins.getHp()- raum.getGegner().getDmg());
 			master.repaintTop();
 			JOptionPane.showMessageDialog(null, "flee failed you received "+raum.getGegner().getDmg()+ " damage by " + raum.getGegner() +"");
 		}
 		master.endEncounter();
 	}


	public void enter(Raum room){
		/**
		 * Enemy
		 */
		if(room.getGegner() != null){
			int input = JOptionPane.showConfirmDialog(null, "Engage on "+room.getGegner()+"?", "Enemy ahead!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("resources/monster/"+room.getGegner().getName()+".png"));
			if(input == JOptionPane.YES_OPTION) {				
				master.startFight(room);				
			}else if (input == JOptionPane.NO_OPTION){
			System.out.println("RUN YOU FOOL!");	
			}			
		} else {
			System.out.println("No enemy :)");
		}
		/*
		 * Loot
		 */
		if(room.getSchatz() != null && room.getGegner() == null) {
			eins.getInventory().add(room.getSchatz());
			System.out.println("Added to Inventory: " + room.getSchatz().getName());
			room.setSchatz(null);
			master.repaintBot();
			master.repaintTop();
		} else{
			System.out.println("No Treasure -.-");
			master.repaintBot();
			master.repaintTop();
		}
		/*
		 * Exit
		 */
		if(room.getAusgang() && room.getGegner() == null){
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
		RNG rng = new RNG(controller);
		ArrayList<Item> inv = new ArrayList<>();
		
		inv.add(new Item("Bow", 0,2));
		inv.add(new Item("Sword", 2, 0));
		inv.add(new Item("Sword", 1, 0));
		inv.add(new Item("Bow", 0,6));
		inv.add(new Item("Potion",0, 3));
		inv.add(new Item("Armor", 0, 3));
		
		Item it2 = new Item("Sword", 1, 0);
		Item it3 = new Item("Armor", 1, 1);
		Item it4 = new Item("Bow", 1, 0);
		Item it5 = new Item("Crap", 0, 0);
		Item it6 = new Item("Destroyer of Worlds", 10, 10);
		
		
		inv.add(it2);
		inv.add(it3);
		inv.add(it4);
		inv.add(it5);
		//Origin origin
		//Konstruktor für Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Normal Attack", 2));
		skills.add(new Skill("Critical Strike", 3));
		skills.add(new Skill("Headshot", 4));
		skills.add(new Skill("Dirty Trick", 2));
	
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
		

		
		//Konstruktor für Skill?
		controller.eins = new Character("Odlon Greybeard the terrible", 3, 5, inv, skills, new Origin("Dwarf","Krieger"));
		System.out.println(controller.eins.attack(skills.get(0)));
		
		//enter Test
//		controller.enter(raum2);
		
		MasterGui gui = new MasterGui(controller);
		controller.master = gui;
	}

}
