package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;

import controller.Controller;
import model.Raum;

public class MasterGui {
	protected ImagePanel roomPanel;
	protected JPanel  topPanel, botPanel, fightGui;
	protected Controller controller;
	protected JFrame frame;
	protected JPanel dungeonPanel;	

	public MasterGui(Controller controller) {
		
		this.controller = controller;
		
		frame = new JFrame();
		frame.setTitle("MonsterSpalter2020");
		frame.setLocation(300,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		//TopPanel
		topPanel = new TopGui(this);
		frame.add(topPanel, BorderLayout.NORTH);
		
		botPanel = new  BotGui(this);
		frame.add(botPanel, BorderLayout.SOUTH);
		
		
		//CenterPanel
		dungeonPanel = new Dungeon(controller);
		frame.add(dungeonPanel, BorderLayout.CENTER); //centergui
		
		//RoomPanel(East)
		roomPanel = new ImagePanel(
		new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall2.png")).getImage(),this);
		frame.add(roomPanel, BorderLayout.EAST);
		
		//WestPanel
		WestPanel westPanel = new WestPanel(
		new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall2.png")).getImage(),this);
		frame.add(westPanel, BorderLayout.WEST);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);		
	}
	
	public Controller getcontroller(){
		return controller;
	}
	
	
	//open Inventory
	protected void openInventory() {
		new InvGui(this);
	}
	
	//TODO addCreateGUI
	protected void createRoom(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI window = new CreateGUI();
					window.creator.setVisible(true);
					window.creator.setLocation(700, 300);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startFight(Raum room) {
		fightGui = new fightGui(this, room);
		frame.remove(dungeonPanel);
		frame.add(fightGui, BorderLayout.CENTER);	
	}
	//end Encounter on last Location
	public void endEncounter(){
		frame.remove(fightGui);
		frame.add(dungeonPanel,BorderLayout.CENTER);
		frame.repaint();
		frame.pack();	
	}
	//repain roompanel
	public void repaintRoom(){
		frame.remove(roomPanel);
		roomPanel = new ImagePanel(
					new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall2.png")).getImage(),this); 
		frame.add (roomPanel, BorderLayout.EAST);
		frame.repaint();
		frame.pack();
	}
		//repaint TopPanel
	public void repaintTop(){
		frame.remove(topPanel);
		topPanel = new TopGui(this);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.repaint();
		frame.pack();
	}
		//repaint BottomPanel
	public void repaintBot(){
		frame.remove(botPanel);
		botPanel = new BotGui(this);
		frame.add(botPanel, BorderLayout.SOUTH);
		frame.repaint();
		frame.pack();
	}
	
	
}
