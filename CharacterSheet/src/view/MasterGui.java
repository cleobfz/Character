package view;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.Controller;

public class MasterGui {
	protected Controller c;
	protected JFrame frame;

	public MasterGui(Controller c) {
		this.c = c;
		
		frame = new JFrame();
		frame.setTitle("MonsterSpalter2020");
		frame.setLocation(100,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(new TopGui(this), BorderLayout.NORTH);
		frame.add(new BotGui(this), BorderLayout.SOUTH);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);		
	}
	
}
