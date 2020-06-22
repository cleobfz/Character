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
		Controller c = new Controller();
		ArrayList<Item> inv = new ArrayList<>();
		inv.add(new Item("Peng", 2, null));
		//Origin origin
		//Konstruktor für Origin?
		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Pew pew", 5));
		//Konstruktor für Skill?
		c.eins = new Character("Odlon", 3, inv, skills, new Origin("Dwarf","Krieger",null));
	
		MasterGui gui = new MasterGui();
	}

}
