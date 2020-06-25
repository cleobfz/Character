package view;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;

public class CreateGUI {
	private JFrame creator;
	private JTextField monsterName;
	private JTextField monsterHp;
	private JTextField monsterDam;
	private JTextField itemName;
	private JTextField itemHp;
	private JTextField itemStat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI window = new CreateGUI();
					window.creator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateGUI() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		creator = new JFrame();
		creator.setTitle("creator");
		creator.getContentPane().setBackground(Color.LIGHT_GRAY);
		creator.setBounds(100, 100, 550, 370);
		creator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creator.getContentPane().setLayout(null);
		
		monsterName = new JTextField();
		monsterName.setToolTipText("Monster Name");
		monsterName.setText("Monster Name");
		monsterName.setBounds(21, 66, 100, 20);
		creator.getContentPane().add(monsterName);
		monsterName.setColumns(10);
		
		// mouseClicked und focusGained leert das Textfield beim Mausklick oder beim reintabben
		monsterName.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == monsterName) {
				monsterName.setText("");
			}
		}
	});
		monsterName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				monsterName.setText(""); 
			}
		public void focusLost(FocusEvent e) {
			}
		});  
		
		monsterHp = new JTextField();
		monsterHp.setToolTipText("Monster HitPoints");
		monsterHp.setText("Monster Hitpoints");
		monsterHp.setBounds(222, 66, 100, 20);
		creator.getContentPane().add(monsterHp);
		monsterHp.setColumns(10);
		monsterHp.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == monsterHp) {
				monsterHp.setText("");
			}
		}
	});
		monsterHp.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				monsterHp.setText(""); 
			}
		public void focusLost(FocusEvent e) {
			}
		});  
		
		monsterDam = new JTextField();
		monsterDam.setToolTipText("Monster Damage");
		monsterDam.setText("Monster Damage");
		monsterDam.setBounds(380, 66, 100, 20);
		creator.getContentPane().add(monsterDam);
		monsterDam.setColumns(10);
		monsterDam.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == monsterDam) {
				monsterDam.setText("");
			}
		}
	});
		monsterDam.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				monsterDam.setText(""); 
			}
		public void focusLost(FocusEvent e) {
			}
		});  
		
		itemName = new JTextField();
		itemName.setToolTipText("Item Name");
		itemName.setText("Item Name");
		itemName.setBounds(24, 185, 100, 20);
		creator.getContentPane().add(itemName);
		itemName.setColumns(10);
		itemName.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == itemName) {
				itemName.setText("");
			}
		}
	});
		itemName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				itemName.setText(""); 
			}
		public void focusLost(FocusEvent e) {
			}
		});  
		
		itemHp = new JTextField();
		itemHp.setToolTipText("Item HP Bonus");
		itemHp.setText("Item HP Bonus");
		itemHp.setBounds(222, 185, 100, 20);
		creator.getContentPane().add(itemHp);
		itemHp.setColumns(10);
		itemHp.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == itemHp) {
				itemHp.setText("");
			}
		}
	});
		itemHp.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				itemHp.setText(""); 
			}
		public void focusLost(FocusEvent e) {
			}
		});  
		
		itemStat = new JTextField();
		itemStat.setToolTipText("Item Stat Bonus");
		itemStat.setText("Item Stat Bonus");
		itemStat.setBounds(380, 185, 100, 20);
		creator.getContentPane().add(itemStat);
		itemStat.setColumns(10);
		itemStat.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == itemStat) {
				itemStat.setText("");
			}
		}
	});
		itemStat.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				itemStat.setText(""); 
			}
		public void focusLost(FocusEvent e) {
			}
		});      
		
		JCheckBox exit = new JCheckBox("Create Roomexit?");
		exit.setToolTipText("Create Roomexit?");
		exit.setBounds(212, 243, 120, 23);
		creator.getContentPane().add(exit);		
		
		JButton createItem = new JButton("Create Item");
		createItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		createItem.setToolTipText("Create Item");
		createItem.setBounds(212, 297, 125, 23);
		creator.getContentPane().add(createItem);
		 
		createItem.addActionListener(e1->{
            try	{
            	BufferedWriter bw = new BufferedWriter(new FileWriter("c:/users/grego/desktop/test.txt", true));
            	if(itemName.getText().isEmpty() || itemName.getText().contentEquals("Item Name")
					|| itemHp.getText().isEmpty() || itemHp.getText().contentEquals("Item HP Bonus")
					|| itemStat.getText().isEmpty() || itemStat.getText().contentEquals("Item Stat Bonus")) {
            		          	
            		JOptionPane.showMessageDialog(null, "Please fill the required fields!");
            } else if(monsterName.getText().isEmpty() || monsterName.getText().contentEquals("Item Name")
					|| monsterHp.getText().isEmpty() || monsterHp.getText().contentEquals("Item HP Bonus")
					|| monsterDam.getText().isEmpty() || monsterDam.getText().contentEquals("Item Stat Bonus")) {
            		
            	
            		JOptionPane.showMessageDialog(null, "Please fill the required fields!");
            } else if( monsterName.getText().isEmpty() || monsterName.getText().contentEquals("Item Name")
					|| monsterHp.getText().isEmpty() || monsterHp.getText().contentEquals("Item HP Bonus")
					|| monsterDam.getText().isEmpty() || monsterDam.getText().contentEquals("Item Stat Bonus")
					) {
            	bw.write("Monster Name: "+ monsterName.getText());
            	bw.newLine();
            	bw.write("Monster Life: "+ monsterHp.getText());
            	bw.newLine();
            	bw.write("Monster Damage: "+ monsterDam.getText());        
            	bw.newLine();
                bw.write("Item Name: "+ itemName.getText());
                bw.newLine();
                bw.write("Item HP Bonus: "+ itemHp.getText());
                bw.newLine();
                bw.write("Item Stat Bonus: "+ itemStat.getText());
                bw.newLine();
                bw.write("Exit created: "+ exit.isSelected());
                bw.newLine();
                bw.close();
            } } catch(Exception ex){
                ex.printStackTrace();
            }
        });
		
		JLabel mc = new JLabel("Monster creator");
		mc.setToolTipText("Monster creator");
		mc.setBounds(24, 41, 97, 14);
		creator.getContentPane().add(mc);
		
		JLabel ic = new JLabel("Item creator");
		ic.setToolTipText("Item creator");
		ic.setBounds(27, 159, 97, 14);
		creator.getContentPane().add(ic);				
	}
}
