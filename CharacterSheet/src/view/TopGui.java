package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopGui extends JPanel {
	protected MasterGui master;
	protected JPanel chargui;
	protected JPanel charstat;
	protected JTextField txtFieldHP;
	protected JTextField txtFieldMP;
	protected JTextField txtFieldName;
	protected JLabel lblMap;
	
	protected TopGui(MasterGui master) {
		this.master = master;
		
		new JPanel(new BorderLayout());
		
		chargui = new JPanel(new BorderLayout());
		chargui.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		add(chargui, BorderLayout.WEST);
		
		//chargui.charIco	
		//chargui.charIco
		JLabel lblCharIco = new JLabel();
		if(master.controller.getCharacter() == null){
		lblCharIco.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/character/char_empty.png"))); //char werte implementieren !!
		} else{lblCharIco.setIcon(master.controller.getCharacter().getOrigin().getIcon());
			
		}
		chargui.add(lblCharIco,BorderLayout.CENTER);
		
		
		
		//chargui.charstat
		charstat = new JPanel();
		chargui.add(charstat, BorderLayout.SOUTH);
		
		//chargui.charstat.HP + HPbonus(Items)
		txtFieldHP = new JTextField(10);
		if(master.controller.getCharacter() == null){
		txtFieldHP.setText("0"); 
		} else {
			
			txtFieldHP.setText(master.controller.getCharacter().getHp() + 
					master.controller.getCharacter().getItemHpbonus() + "");
		}
		txtFieldHP.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldHP.setForeground(Color.WHITE);
		txtFieldHP.setFont(new Font("Old English Text MT", Font.BOLD, 15));
		txtFieldHP.setEditable(false);
		txtFieldHP.setBackground(Color.RED);
		charstat.add(txtFieldHP);
		
		//chargui.charstat.MP -> stat + Statbonus(items)
		txtFieldMP = new JTextField(10);
		if(master.controller.getCharacter() == null){
			txtFieldMP.setText("0"); 
			} else {
				
				txtFieldMP.setText(master.controller.getCharacter().getStat() + 
						master.controller.getCharacter().getItemStatbonus()+ "");
			}
		txtFieldMP.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldMP.setForeground(Color.WHITE);
		txtFieldMP.setFont(new Font("Old English Text MT", Font.BOLD, 15));
		txtFieldMP.setEditable(false);
		txtFieldMP.setBackground(Color.BLUE);
		charstat.add(txtFieldMP);
		
		//name
		txtFieldName = new JTextField(30);
		if(master.controller.getCharacter() == null){
		txtFieldName.setText("Noname");
		} else {
			txtFieldName.setText(master.controller.getCharacter().getName());
		}
		
		txtFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldName.setEditable(false);
		txtFieldName.setFont(new Font("Onyx", Font.BOLD, 50));
		txtFieldName.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(txtFieldName, BorderLayout.CENTER);
		
		//minimap
		lblMap = new JLabel();
		lblMap.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblMap.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/map/map_empty.png"))); //MINIMAP implementieren !!
		add(lblMap,BorderLayout.EAST);
	}
}
