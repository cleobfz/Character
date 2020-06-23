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
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		ArrayList<Item> inv = new ArrayList<>();
		inv.add(new Item("Peng", 2,2));
		inv.add(new Item("Pow", 4,5));
		//Origin origin
		//Konstruktor für Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Pew pew", 5));
		//Konstruktor für Skill?
		controller.eins = new Character("Odlon", 3, 3, inv, skills, new Origin("Dwarf","Krieger"));
		System.out.println(controller.eins.attack(skills.get(0)));
		
		MasterGui gui = new MasterGui(controller);
	}

}
