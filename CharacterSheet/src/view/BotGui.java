package view;

import java.awt.GridLayout;

import javax.swing.*;

public class BotGui extends JPanel {
	protected MasterGui master;
	protected JPanel movegui;
	protected BotGui(MasterGui master) {
		this.master = master;		
		

		
		setLayout(new GridLayout(4, 3, 1, 1));
		JButton btnMove_nw = new JButton("nw");
		btnMove_nw.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_nw);
		
		JButton btnMove_n = new JButton("n");
		btnMove_n.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_n);
		
		JButton btnMove_ne = new JButton("ne");
		btnMove_ne.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_ne);
		
		JButton btnMove_w = new JButton("w");
		btnMove_w.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_w);
		
		JButton btnAct_inv = new JButton("inv");
		btnAct_inv.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnAct_inv);
		
		JButton btnMove_e = new JButton("e");
		btnMove_e.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_e);
		
		JButton btnMove_sw = new JButton("sw");
		btnMove_sw.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_sw);
		
		JButton btnMove_s = new JButton("s");
		btnMove_s.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_s);
		
		JButton btnMove_se = new JButton("se");
		btnMove_se.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move_ne.png")));
		add(btnMove_se);
		
	}

}
