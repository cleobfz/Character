package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class BotGui extends JPanel {
	protected MasterGui master;
	protected JPanel movegui;
	protected JPanel actgui;
	protected BotGui(MasterGui master) {
		this.master = master;		
		setLayout(new BorderLayout());
		
		//movegui
		
		movegui = new JPanel();
		movegui.setLayout(new GridLayout(3, 3, 1, 1));
		movegui.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		add(movegui,BorderLayout.WEST);
		
		//movegui.buttons	
		JButton btnMove_nw = new JButton();
		btnMove_nw.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_nw.png")));
		movegui.add(btnMove_nw);
		
		JButton btnMove_n = new JButton();
		btnMove_n.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_n.png")));
		movegui.add(btnMove_n);
		
		JButton btnMove_ne = new JButton();
		btnMove_ne.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_ne.png")));
		movegui.add(btnMove_ne);
		
		JButton btnMove_w = new JButton();
		btnMove_w.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_w.png")));
		movegui.add(btnMove_w);
		
		JButton btnAct_inv = new JButton();
		btnAct_inv.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/act/act_inv.png")));
		movegui.add(btnAct_inv);
		
		JButton btnMove_e = new JButton();
		btnMove_e.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_e.png")));
		movegui.add(btnMove_e);
		
		JButton btnMove_sw = new JButton();
		btnMove_sw.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_sw.png")));
		movegui.add(btnMove_sw);
		
		JButton btnMove_s = new JButton();
		btnMove_s.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_s.png")));
		movegui.add(btnMove_s);
		
		JButton btnMove_se = new JButton();
		btnMove_se.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_se.png")));
		movegui.add(btnMove_se);
		
		//actgui
		actgui = new JPanel();
		actgui.setLayout(new GridLayout());
		add(actgui,BorderLayout.CENTER);
		
		JButton btnAct_atk = new JButton();
		btnAct_atk.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\resources\\skill\\open-book.png"));
		actgui.add(btnAct_atk);
		
		JButton btnAct_def = new JButton();
		btnAct_def.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/act/act_def.png")));
		actgui.add(btnAct_def);
		
		JButton btnAct_esc = new JButton();
		btnAct_esc.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/act/act_esc.png")));
		actgui.add(btnAct_esc);
		
		

	}

}
