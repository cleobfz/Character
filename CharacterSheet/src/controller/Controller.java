package controller;

import java.util.ArrayList;

import model.*;
import model.Character;
import view.MasterGui;

public class Controller {
	Character eins;
	
	
	public Character getCharacter() {
		return eins;
	}
	
	public Raum getRaum(int x, int y) {
		return new Raum(new Monster(x, y, "Wandler"), new Item("Fuß des Wandlers", x/2, y/2), false);
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		ArrayList<Item> inv = new ArrayList<>();
		inv.add(new Item("Schwert", 5,0));
		inv.add(new Item("MediKit", 0,6));
		inv.add(new Item("Bogen", 6, 0));
		//Origin origin
		//Konstruktor für Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Normal Attack", 5));
		skills.add(new Skill("Critical Strike", 10));
		skills.add(new Skill("Headshot", 16));
		skills.add(new Skill("Dirty Trick", 8));
	
		
	
		//Konstruktor für Skill?
		controller.eins = new Character("Odlon Greybeard the terrible", 10, 9, inv, skills, new Origin("Dwarf","Krieger"));
		System.out.println(controller.eins.attack(skills.get(0)));
		
		MasterGui gui = new MasterGui(controller);
	}

}
