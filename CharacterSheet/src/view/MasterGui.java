package view;

import java.awt.BorderLayout;
<<<<<<< HEAD
=======
import java.awt.EventQueue;
import java.io.IOException;
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673

import javax.swing.*;

import controller.Controller;
<<<<<<< HEAD
import model.Dungeon;

public class MasterGui {
	protected Controller controller;
	protected JFrame frame;

	public MasterGui(Controller controller) {

		this.controller = controller;
		
		
		//centergui muss noch implementiert werden hier steht nur ein Platzhalter
=======

public class MasterGui {
	protected ImagePanel roomPanel;
	protected JPanel  topPanel, botPanel;
	protected Controller controller;
	protected JFrame frame;
	

	public MasterGui(Controller controller) {
		
		this.controller = controller;
		
//		JLabel centerGui = new JLabel();
//		//centergui muss noch implementiert werden hier steht nur ein Platzhalter
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
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
		
<<<<<<< HEAD
		frame.add(new TopGui(this), BorderLayout.NORTH);
		frame.add(new BotGui(this), BorderLayout.SOUTH);
		//CenterGui cen = new CenterGui(this);
		Dungeon d = new Dungeon(controller);
		JPanel helper = new JPanel();
		helper.add(d);
		frame.add(helper, BorderLayout.CENTER); //centergui
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
=======
		//TopPanel
		topPanel = new TopGui(this);
		frame.add(topPanel, BorderLayout.NORTH);
		
		botPanel = new  BotGui(this);
		frame.add(botPanel, BorderLayout.SOUTH);
		
		
		//CenterPanel
		frame.add(new Dungeon(controller), BorderLayout.CENTER); //centergui
		
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
	
	
	//TODO repain roompanel
	public void repaintRoom(){
		frame.remove(roomPanel);
		roomPanel = new ImagePanel(
				new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall2.png")).getImage(),this); 
		frame.add (roomPanel, BorderLayout.EAST);
		frame.repaint();
		frame.pack();
	}
	
	public void repaintTop(){
		frame.remove(topPanel);
		topPanel = new TopGui(this);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.repaint();
		frame.pack();
	}
	
	public void repaintBot(){
		frame.remove(botPanel);
		botPanel = new BotGui(this);
		frame.add(botPanel, BorderLayout.SOUTH);
		frame.repaint();
		frame.pack();
	}
	
	
	public Controller getcontroller(){
		return controller;
	}
	
	
	//open Inventory
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
	protected void openInventory() {
		new InvGui(this);
	}
	
<<<<<<< HEAD
=======
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
	
>>>>>>> 08cc6e2ae3bef8c6cca5bba1eece89849bad6673
}
