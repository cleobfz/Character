package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import model.*;
import model.Character;

public class fightGui extends JPanel{
	private MasterGui master;
	private int round = 0;
	private String fightLog;
	private JTextArea txtFieldFightLog;
	private Character hero;
	
	public fightGui(MasterGui master, Raum room) {
		this.master = master;
		hero = master.controller.getCharacter();
		System.out.println("FIGHT!!");
		setLayout(new BorderLayout());
		JLabel lblRound = new JLabel("Fight! Round: "+round);
		lblRound.setFont(new Font ("Algerian", Font.BOLD, 20));
		lblRound.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblRound, BorderLayout.NORTH);
		
		fightLog = hero.getName() +"\nVS\n"+ room.getGegner().toString();
		txtFieldFightLog = new JTextArea(fightLog);
		txtFieldFightLog.setFont(new Font ("Algerian", Font.BOLD, 20));
		add(txtFieldFightLog, BorderLayout.CENTER);
		
		System.out.println("Encountering a " + room.getGegner().getName() + " with " +room.getGegner().getHp() + " Healthpoins");
		int life =room.getGegner().getHp();
		while(room.getGegner().getHp() > 0){
		 life = life - hero.attack(hero.getSkill().get(0));
		 room.getGegner().setHp(life);
		System.out.println("Attack successful on " + room.getGegner().getName()+ "  " + room.getGegner().getHp() + " HP remain");
		}
		System.out.println(room.getGegner().getName() +" defeated");
		room.setGegner(null);
		
	}
	

}
