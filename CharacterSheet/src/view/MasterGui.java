package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

import controller.Controller;
import model.Dungeon;

public class MasterGui {
	protected Controller controller;
	protected JFrame frame;

	public MasterGui(Controller controller) {
		
		this.controller = controller;
		
//		JLabel centerGui = new JLabel();
//		//centergui muss noch implementiert werden hier steht nur ein Platzhalter
//		if(controller.getCharacter() == null){
//		centerGui.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/sc_empty.png")));
//		}
//		else{
//			centerGui.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/sc_empty.png")));
//		}
//		centerGui.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame = new JFrame();
		frame.setTitle("MonsterSpalter2020");
		frame.setLocation(300,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		
		frame.add(new TopGui(this), BorderLayout.NORTH);
		frame.add(new BotGui(this), BorderLayout.SOUTH);
		
		
		//CenterPanel
		frame.add(new Dungeon(controller), BorderLayout.CENTER); //centergui
		
		//RoomPanel(East)
		ImagePanel roomPanel = new ImagePanel(
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
	
}
