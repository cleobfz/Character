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
		JLabel lblCharIco = new JLabel();
		lblCharIco.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/character/char_empty.png"))); //char werte implementieren !!
		chargui.add(lblCharIco,BorderLayout.CENTER);
		
		//chargui.charstat
		charstat = new JPanel();
		chargui.add(charstat, BorderLayout.SOUTH);
		
		//chargui.charstat.HP
		txtFieldHP = new JTextField(10);
		txtFieldHP.setText("200"); //char werte implementieren !!
		txtFieldHP.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldHP.setForeground(Color.WHITE);
		txtFieldHP.setFont(new Font("Old English Text MT", Font.BOLD, 20));
		txtFieldHP.setEditable(false);
		txtFieldHP.setBackground(Color.RED);
		charstat.add(txtFieldHP);
		
		//chargui.charstat.MP
		txtFieldMP = new JTextField(10);
		txtFieldMP.setText("100"); //char werte implementieren !!
		txtFieldMP.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldMP.setForeground(Color.WHITE);
		txtFieldMP.setFont(new Font("Old English Text MT", Font.BOLD, 20));
		txtFieldMP.setEditable(false);
		txtFieldMP.setBackground(Color.BLUE);
		charstat.add(txtFieldMP);
		
		//name
		txtFieldName = new JTextField(30);
		txtFieldName.setText("Der Hackfleisch Hassende Zerhacker"); //Name oder was anderes implementieren
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
