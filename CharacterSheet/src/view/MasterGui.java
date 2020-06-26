package view;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.Controller;

public class MasterGui {
	protected Controller controller;
	protected JFrame frame;

	public MasterGui(Controller controller) {

		this.controller = controller;
		
		JLabel centerGui = new JLabel();
		//centergui muss noch implementiert werden hier steht nur ein Platzhalter
		if(controller.getCharacter() == null){
		centerGui.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/sc_empty.png")));
		}
		else{
			centerGui.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/sc_empty.png")));
		}
		centerGui.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame = new JFrame();
		frame.setTitle("MonsterSpalter2020");
		frame.setLocation(300,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(new TopGui(this), BorderLayout.NORTH);
		frame.add(new BotGui(this), BorderLayout.SOUTH);
		frame.add(centerGui, BorderLayout.CENTER); //centergui
		
		//RoomPanel
		ImagePanel Panel = new ImagePanel(
		new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall2.png")).getImage(),this);
		frame.add(Panel, BorderLayout.EAST);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);		
	}
	
	protected void openInventory() {
		new InvGui(this);
	}
	
}
