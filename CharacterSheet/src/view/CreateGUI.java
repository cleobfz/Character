package view;

import model.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;

public class CreateGUI implements ActionListener {
	protected JFrame creator;
	private JTextField monsterName;
	private JTextField monsterHp;
	private JTextField monsterDam;
	private JTextField itemName;
	private JTextField itemHp;
	private JTextField itemStat;
	private JCheckBox exit;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateGUI window = new CreateGUI();
//					window.creator.setVisible(true);
//					window.creator.setLocation(700, 300);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});		
//	}

	public CreateGUI() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		
		creator = new JFrame();
		creator.setTitle("Object Creator");
		creator.getContentPane().setBackground(Color.LIGHT_GRAY);
		creator.setBounds(100, 100, 550, 370);
		creator.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		creator.getContentPane().setLayout(null);
		creator.setResizable(false);
		
		monsterName = new JTextField();		// Feld zum eintragen des Monster Namen
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
				if(monsterName.getText().equals("")) {
					monsterName.setText("Monster Name");
				}
			}
		});  
		
		monsterHp = new JTextField();		// Feld zum eintragen der Monster Hitpoints
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
				if(monsterHp.getText().equals("")) {
					monsterHp.setText("Monster Hitpoints");
				}
			}
		});  
		
		monsterDam = new JTextField();		// Feld zum eintragen des Monster Schaden
		monsterDam.setToolTipText("Monster Damage");
		monsterDam.setText("Monster Damage");
		monsterDam.setBounds(419, 66, 100, 20);
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
				if(monsterDam.getText().equals("")) {
					monsterDam.setText("Monster Damage");
				}
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
				if(itemName.getText().equals("")) {
					itemName.setText("Item Name");
				}
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
				if(itemHp.getText().equals("")) {
					itemHp.setText("Item HP Bonus");
				}
			}
		});  
		
		itemStat = new JTextField();
		itemStat.setToolTipText("Item Stat Bonus");
		itemStat.setText("Item Stat Bonus");
		itemStat.setBounds(419, 185, 100, 20);
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
				if(itemStat.getText().equals("")) {
					itemStat.setText("Item Stat Bonus");
				}
			}
		});   
		
		// Checkbox für die Auswahl, ob ein Ausgang im Raum erstellt werden soll oder nicht
		exit = new JCheckBox("Create Roomexit?");
		exit.setToolTipText("Create Roomexit?");
		exit.setBounds(205, 243, 142, 23);
		creator.getContentPane().add(exit);	
		
		// Button um die Auswahl (Monster und/oder Item und/oder Ausgang) zu erstellen
		JButton save = new JButton("Create");
		save.setToolTipText("Create");
		save.setBounds(212, 297, 125, 23);
		creator.getContentPane().add(save);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checkAll();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
	
	// check Methoden um zu prüfen, welche Einträge gemacht werden sollen
	public boolean checkItem() {
		String nameItem = itemName.getText();
		String hpItem = itemHp.getText();
		String statItem = itemStat.getText();

		if (nameItem.isEmpty() || nameItem.equals("Item Name") || !nameItem.equals("") 
			|| hpItem.isEmpty() || hpItem.equals("Item HP Bonus") || !hpItem.equals("") 
			|| statItem.isEmpty() || statItem.equals("Item Stat Bonus") || !statItem.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean checkMonster() {
		String nameMonster = monsterName.getText();
		String hpMonster = monsterHp.getText();
		String damMonster = monsterDam.getText();

		if (nameMonster.isEmpty() || nameMonster.equals("Monster Name") || nameMonster.equals("") 
			|| hpMonster.isEmpty() || hpMonster.equals("Monster HitPoints") || hpMonster.equals("") 
			|| damMonster.isEmpty() || damMonster.equals("Monster Damage") || damMonster.equals("") ) {
			return false;
		}
		return true;
	}
	
	public boolean checkExit() {
		if (!exit.isSelected()) {
			return false;
		}
		return true;
	}
	
	// Checkt die Felder & Checkbox und macht den entsprechenden Eintrag beim drücken des Buttons
	public void checkAll() throws IOException {
		if (checkExit() && checkItem() && checkMonster()) {
			writeAll();
		}		
		if (checkExit() && checkItem() && !checkMonster()) {
			writeItemExit();
		}
		if (checkExit() && !checkItem() && checkMonster()) {
			writeMonsterExit();
		}
		if (!checkExit() && checkItem() && checkMonster()) {
			writeMonsterItem();
		}		
		if (!checkExit() && checkItem() && !checkMonster()) {
			writeItem();
		}
		if (!checkExit() && !checkItem() && checkMonster()) {
			writeMonster();
		}
		if (!checkExit() && !checkItem() && !checkMonster()) {
			JOptionPane.showMessageDialog(creator,"Something went wrong. Please create at least one subject!");
		}
		writeCreation();
		bw.close();
	}
	
	// write Methoden, um die Einträge durchzuführen
	BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\cs\\Desktop\\test.room", true));

	public void writeItem() throws IOException {
		bw.write("Item Name: "+ itemName.getText());
        bw.newLine();
        bw.write("Item HP Bonus: "+ itemHp.getText());
        bw.newLine();
        bw.write("Item Stat Bonus: "+ itemStat.getText());
        bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Item was created.");
	}
	
	public void writeItemExit() throws IOException {
		bw.write("Item Name: "+ itemName.getText());
        bw.newLine();
        bw.write("Item HP Bonus: "+ itemHp.getText());
        bw.newLine();
        bw.write("Item Stat Bonus: "+ itemStat.getText());
        bw.newLine();
        bw.write("Exit created: "+ exit.isSelected());
        bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Item and roomexit were created.");
	}
	
	public void writeMonster() throws IOException {
    	bw.write("Monster Name: "+ monsterName.getText());
    	bw.newLine();
    	bw.write("Monster Life: "+ monsterHp.getText());
    	bw.newLine();
    	bw.write("Monster Damage: "+ monsterDam.getText());        
    	bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Monster was created.");
	}
	
	public void writeMonsterItem() throws IOException {
		bw.write("Item Name: "+ itemName.getText());
        bw.newLine();
        bw.write("Item HP Bonus: "+ itemHp.getText());
        bw.newLine();
        bw.write("Item Stat Bonus: "+ itemStat.getText());
        bw.newLine();
    	bw.write("Monster Name: "+ monsterName.getText());
    	bw.newLine();
    	bw.write("Monster Life: "+ monsterHp.getText());
    	bw.newLine();
    	bw.write("Monster Damage: "+ monsterDam.getText());        
    	bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Monster and item were created.");
	}
	
	public void writeMonsterExit() throws IOException {
    	bw.write("Monster Name: "+ monsterName.getText());
    	bw.newLine();
    	bw.write("Monster Life: "+ monsterHp.getText());
    	bw.newLine();
    	bw.write("Monster Damage: "+ monsterDam.getText());        
    	bw.newLine();
        bw.write("Exit created: "+ exit.isSelected());
        bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Monster and roomexit were created.");
	}
	
	public void writeExit() throws IOException {
        bw.write("Exit created: "+ exit.isSelected());
        bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Roomexit was created.");
	}
	
	public void writeAll() throws IOException {
		bw.write("Item Name: "+ itemName.getText());
        bw.newLine();
        bw.write("Item HP Bonus: "+ itemHp.getText());
        bw.newLine();
        bw.write("Item Stat Bonus: "+ itemStat.getText());
        bw.newLine();
    	bw.write("Monster Name: "+ monsterName.getText());
    	bw.newLine();
    	bw.write("Monster Life: "+ monsterHp.getText());
    	bw.newLine();
    	bw.write("Monster Damage: "+ monsterDam.getText());        
    	bw.newLine();
        bw.write("Exit created: "+ exit.isSelected());
        bw.newLine();
        bw.flush();
		JOptionPane.showMessageDialog(creator, "Monster, item and roomexit were created.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	protected void writeCreation () {
		File testFile = new File(System.getProperty("user.dir")+"\\resources\\room\\00.room");
		Monster monster = null;
		Item item = null; 
		
		try {	
			monster = new Monster(Integer.parseInt(monsterHp.getText()),		
						Integer.parseInt(monsterDam.getText()), monsterName.getText());		
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "So nicht, mein Monster!!");
			nfe.printStackTrace();
		}
		try {
			item = new Item(itemName.getText(), Integer.parseInt(itemStat.getText()), 
					Integer.parseInt(itemHp.getText()));	
			}
		
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "So nicht, mein Item!!");
			nfe.printStackTrace();
	
		}
		Raum room = new Raum(monster, item, exit.isSelected());
			try {


			FileOutputStream fs = new FileOutputStream(testFile);

			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(room);
			oos.close();			
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Error while writing!");
			ioe.printStackTrace();
		}	
	}
}

