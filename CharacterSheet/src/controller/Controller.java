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
		inv.add(new Item("Peng", 2));
		//Origin origin
		//Konstruktor f�r Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Pew pew", 5));
		//Konstruktor f�r Skill?
		controller.eins = new Character("Odlon", 3, inv, skills, new Origin("Dwarf","Krieger"));
	
		MasterGui gui = new MasterGui(controller);
	}

}
