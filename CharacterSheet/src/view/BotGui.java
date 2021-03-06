package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.SkillButton;

public class BotGui extends JPanel {
	protected JButton btnAct_atk;
	protected MasterGui master;
	protected JPanel movegui;
	protected JPanel actgui;
	protected Dungeon dungeon;
	int i;
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
		btnMove_nw.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall.png")));
		btnMove_nw.setEnabled(false);
		movegui.add(btnMove_nw);
		
		JButton btnMove_n = new JButton();
		btnMove_n.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_n.png")));
		movegui.add(btnMove_n);
		
		
		JButton btnMove_ne = new JButton();
		btnMove_ne.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall.png")));
		btnMove_ne.setEnabled(false);
		movegui.add(btnMove_ne);
		
		JButton btnMove_w = new JButton();
		btnMove_w.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_w.png")));
		
		movegui.add(btnMove_w);
		
		JButton btnAct_inv = new JButton();
		btnAct_inv.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/act/act_inv.png")));
		btnAct_inv.addActionListener(e -> master.openInventory());
		movegui.add(btnAct_inv);
		
		JButton btnMove_e = new JButton();
		btnMove_e.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_e.png")));
		movegui.add(btnMove_e);
		
		JButton btnMove_sw = new JButton();
		btnMove_sw.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall.png")));
		btnMove_sw.setEnabled(false);
		movegui.add(btnMove_sw);
		
		JButton btnMove_s = new JButton();
		btnMove_s.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/move/move_s.png")));
		movegui.add(btnMove_s);
		
		JButton btnMove_se = new JButton();
		btnMove_se.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/stonewall.png")));
		btnMove_se.setEnabled(false);
		movegui.add(btnMove_se);
		
		//actgui
		actgui = new JPanel();
		actgui.setLayout(new GridLayout(1,4,2,2));
		add(actgui,BorderLayout.CENTER);
		
		if(master.controller.getCharacter() == null){
			btnAct_atk = new JButton("Empty");
			actgui.add(btnAct_atk);
		} else {
			//Add Skills created new class SkillButton
			for (int i = 0; i < master.controller.getCharacter().getSkill().size(); i++){
				btnAct_atk = new SkillButton(master.controller.getCharacter().getSkill().get(i));
				btnAct_atk.setLayout(new BorderLayout());
			
				//Skillname
				JLabel TxtSkillname = new JLabel(master.controller.getCharacter().getSkill().get(i).getName());
				TxtSkillname.setFont(new Font("Onyx", Font.BOLD, 30));
				TxtSkillname.setBackground(btnAct_atk.getBackground());
				TxtSkillname.setHorizontalAlignment(0);
				btnAct_atk.add(TxtSkillname,BorderLayout.NORTH);
				
				//damageVaule
				String damage = master.controller.getCharacter().attack(master.controller.getCharacter().getSkill().get(i)) +"";
				JLabel TxtSkilldmg = new JLabel("DMG:" + damage);
				TxtSkilldmg.setFont(new Font("Onyx", Font.BOLD, 30));
				TxtSkilldmg.setHorizontalAlignment(0);
				TxtSkilldmg.setVerticalAlignment(0);
				btnAct_atk.add(TxtSkilldmg,BorderLayout.SOUTH);
			
				//SkillIcon
				btnAct_atk.setIcon(master.controller.getCharacter().getSkill().get(i).getIcon());
				actgui.add(btnAct_atk);
				
				//TODO add Fightsystemaction
				btnAct_atk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SkillButton currentButton =(SkillButton) e.getSource(); 
						System.out.println(master.controller.getCharacter().attack(currentButton.getSkill()));	
				    }	
				});	
			}
		}
		
		
	}


}
