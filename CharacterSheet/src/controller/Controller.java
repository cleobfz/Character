package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import model.Character;
import view.*;

public class Controller {
	Character eins;
	Item selectedItem;
	Raum aktuellerRaum = new Raum(null,null,true);
	MasterGui master;
	private Raum[][] aktuellerdungeon = new Raum[3][3];
	
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
		System.out.println("AKTUELLER RAUM:       " +aktuellerRaum);
		master.repaintRoom();
	}
	
	public Raum[][] getRaumArray(){
		return aktuellerdungeon;
	}
	
	public void setDungeonarray(Raum[][] aktuellerdungeon){
		this.aktuellerdungeon = aktuellerdungeon;
	}
	
	public void fight(Raum raum){
		
		//Attack enemy
		int gegnerlife =raum.getGegner().getHp();
		gegnerlife = gegnerlife - eins.attack(eins.getSkill().get(0));
		raum.getGegner().setHp(gegnerlife);
		
		//player gets damage
		Double random = Math.random();
		System.out.println(random);
		eins.setHp(eins.getHp() - raum.getGegner().getDmg());
	}
	
	public void enter(Raum raum){
		
		if(raum.getGegner() != null){
			System.out.println("Encountering a " + raum.getGegner().getName() + " with " +raum.getGegner().getHp() + " Healthpoins");
			fight(raum);
//			int life =raum.getGegner().getHp();
//			while(raum.getGegner().getHp() > 0){
//			 life = life - eins.attack(eins.getSkill().get(0));
//			 raum.getGegner().setHp(life);
			System.out.println("Attack successful on " + raum.getGegner().getName()+ "  " + raum.getGegner().getHp() + " HP remain");
//			}
//			System.out.println(raum.getGegner().getName() +" defeated");
//			raum.setGegner(null);
=======
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
>>>>>>> Encounter-System
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
		
		inv.add(new Item("Bow", 0,2));
		inv.add(new Item("Sword", 2, 0));
		inv.add(new Item("Sword", 2, 0));
		inv.add(new Item("Bow", 0,2));
		inv.add(new Item("Potion",0, 1));
		inv.add(new Item("Armor", 1, 2));
		
		Item it2 = new Item("Sword", 2, 0);
		Item it3 = new Item("Armor", 1, 1);
		Item it4 = new Item("Bow", 1, 0);
		Item it5 = new Item("Crap", 0, 0);
		Item it6 = new Item("Destroyer of Worlds", 1000, 1000);
		
		
		inv.add(it2);
		inv.add(it3);
		inv.add(it4);
		inv.add(it5);
		//Origin origin
		//Konstruktor für Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Normal Attack", 1));
		skills.add(new Skill("Critical Strike", 2));
		skills.add(new Skill("Headshot", 3));
		skills.add(new Skill("Dirty Trick", 2));
	
		//Monster
		Monster goblin = new Monster(2, 2, "Goblin");
		Monster orc = new Monster(5,5,"Orc");
		Monster spider = new Monster (3,2,"Spider");
		Monster dragon = new Monster (200,200,"Dragon");
		Monster ghost = new Monster (7,6,"Ghost");
		Monster zombie = new Monster (4,5,"Zombie");
		//Raum Dungeon
		Raum[][] dungeon = new Raum[3][3];
		
		dungeon[0][0] = new Raum(goblin, it4,false);
		dungeon[0][1] = new Raum(orc, null,false);
		dungeon[0][2] = new Raum(spider, new Item("bow", 2, 2),false);
		dungeon[1][0] = new Raum(null, new Item("crap", 0, 1),false);
		dungeon[1][1] = new Raum(new Monster(7, 8, "ghost"), new Item("armor", 2, 0),false);
		dungeon[1][2] = new Raum(new Monster(7, 11, "zombie"), null,false);
		dungeon[2][0] = new Raum(orc, new Item("sword", 7, 7),false);
		dungeon[2][1] = new Raum(goblin, new Item("crap", 2, 1),false);
		dungeon[2][2] = new Raum(new Monster(150, 150, "dragon"), new Item("destroyer of Worlds", 2, 2),true);

		
		
		controller.setDungeonarray(dungeon);
		
		//Konstruktor für Skill?
		controller.eins = new Character("Odlon Greybeard the terrible", 3, 2, inv, skills, new Origin("Dwarf","Krieger"));
		System.out.println(controller.eins.attack(skills.get(0)));
		
		//enter Test
//		controller.enter(raum2);
		
		MasterGui gui = new MasterGui(controller);
		controller.master = gui;
	}

}
