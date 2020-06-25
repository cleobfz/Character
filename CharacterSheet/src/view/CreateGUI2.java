package view;

import model.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;

public class CreateGUI2 implements ActionListener {
	private JFrame creator;
	private JTextField monsterName;
	private JTextField monsterHp;
	private JTextField monsterDam;
	private JTextField itemName;
	private JTextField itemHp;
	private JTextField itemStat;
	private JCheckBox exit;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI2 window = new CreateGUI2();
					window.creator.setVisible(true);
					window.creator.setLocation(700, 300);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	public CreateGUI2() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		creator = new JFrame();
		creator.setTitle("Object Creator");
		creator.getContentPane().setBackground(Color.LIGHT_GRAY);
		creator.setBounds(100, 100, 550, 370);
		creator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			}
		});  
		
		monsterDam = new JTextField();		// Feld zum eintragen des Monster Schaden
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
		
		// Checkbox für die Auswahl, ob ein Ausgang im Raum erstellt werden soll oder nicht
		exit = new JCheckBox("Create Roomexit?");
		exit.setToolTipText("Create Roomexit?");
		exit.setBounds(212, 243, 120, 23);
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

		if (nameItem.isEmpty() || nameItem.equals("Item Name") 
			|| hpItem.isEmpty() || hpItem.equals("Item HP Bonus") 
			|| statItem.isEmpty() || statItem.equals("Item Stat Bonus")) {
			return false;
		}
		return true;
	}
	
	public boolean checkMonster() {
		String nameMonster = monsterName.getText();
		String hpMonster = monsterHp.getText();
		String damMonster = monsterDam.getText();

		if (nameMonster.isEmpty() || nameMonster.equals("Monster Name") 
			|| hpMonster.isEmpty() || hpMonster.equals("Monster HitPoints") 
			|| damMonster.isEmpty() || damMonster.equals("Monster Damage")) {
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
	BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\grego\\Desktop\\test.txt", true));

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
		File testFile = new File("C:\\Users\\grego\\Desktop\\room00.room");
		Monster monster = new Monster(Integer.parseInt(monsterHp.getText()), 
						Integer.parseInt(monsterDam.getText()), monsterName.getText(), null);
		Item item = new Item(itemName.getText(), Integer.parseInt(itemStat.getText()), 
						Integer.parseInt(itemHp.getText()));
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

// To-Do
// - erstes Textfield
// - Standart Text wieder reinfüllen
// - Position ändern