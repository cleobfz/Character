package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import model.Raum;

public class fightGui extends JPanel{
	private MasterGui master;
	private int round = 0;
	private String fightLog;
	private JTextArea txtFieldFightLog;
	private JButton fightBtn,evadeBtn;
	
	public fightGui(MasterGui master, Raum room) {
		
		this.master = master;
		System.out.println("FIGHT!!");
		setLayout(new BorderLayout());
		JLabel lblRound = new JLabel("Fight! Round: "+round);
		lblRound.setFont(new Font ("Algerian", Font.BOLD, 20));
		lblRound.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblRound, BorderLayout.NORTH);
		
		fightLog = room.getGegner().toString();
		txtFieldFightLog = new JTextArea(fightLog);
		txtFieldFightLog.setFont(new Font ("Algerian", Font.BOLD, 20));
		add(txtFieldFightLog, BorderLayout.CENTER);
		
		JButton fightBtn = new JButton("Fight");
		add(fightBtn,BorderLayout.WEST);
		fightBtn.addActionListener(e -> master.controller.fight(room));
		
		JButton evadeBtn = new JButton("Evade");
		add(evadeBtn,BorderLayout.EAST);
		
		
		
	}
	

}
