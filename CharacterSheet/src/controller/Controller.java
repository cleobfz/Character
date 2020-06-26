package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import model.Character;
import view.MasterGui;

public class Controller {
	Character eins;
	Item selectedItem;
	Raum aktuellerRaum = new Raum(new Monster(10, 10, "Spider"), new Item("Sword", 5, 5), false);
	
	
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
	
	public void enter(Raum raum){
		
		if(raum.getGegner() != null){
			System.out.println("Encountering a " + raum.getGegner().getName() + " with " +raum.getGegner().getHp() + " Healthpoins");
			int life =raum.getGegner().getHp();
			while(raum.getGegner().getHp() > 0){
			 life = life - eins.attack(eins.getSkill().get(0));
			 raum.getGegner().setHp(life);
			System.out.println("Attack successful on " + raum.getGegner().getName()+ "  " + raum.getGegner().getHp() + " HP remain");
			}
			System.out.println(raum.getGegner().getName() +" defeated");
			raum.setGegner(null);
		} else {
			System.out.println("No enemy :)");
		}
		if(raum.getSchatz() != null){
			eins.getInventory().add(raum.getSchatz());
			System.out.println("Added to Inventory: " + raum.getSchatz().getName());
			raum.setSchatz(null);
		} else{
			System.out.println("No Treasure -.-");
		}
		if(raum.getAusgang()){
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
		//Konstruktor für Origin?
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
		//
		Raum raum1 = new Raum(goblin, it6, true);
		Raum raum2 = new Raum(dragon,it5,false);
		Raum raum3 = new Raum(null,null,false);
	
		
		//Konstruktor für Skill?
		controller.eins = new Character("Odlon Greybeard the terrible", 10, 9, inv, skills, new Origin("Dwarf","Krieger"));
		System.out.println(controller.eins.attack(skills.get(0)));
		
		//enter Test
//		controller.enter(raum2);
		
		MasterGui gui = new MasterGui(controller);
	}

}
