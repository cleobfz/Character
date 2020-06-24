package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import model.*;

public class InvGui extends JFrame {
	private MasterGui master;
	private JList itemList;
	private DefaultListModel listModel = new DefaultListModel();
	private JPanel panelItem;
	private JPanel panelBtn;
	private String font = "Algerian";
	private JTextArea txtAInfo;
	
		
	public InvGui(MasterGui master) {
		this.master = master;
		setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		/*
		 * BtnPanel
		 */
		panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font(font, Font.PLAIN, 20));
		btnBack.addActionListener(e -> close());
		panelBtn.add(btnBack);
		
		JButton btnUse = new JButton("Use");
		btnUse.setFont(new Font(font, Font.PLAIN, 20));
		panelBtn.add(btnUse);
		
		/*
		 * Itempanel
		 */		
		panelItem = new JPanel();
		txtAInfo = new JTextArea();
		txtAInfo.setColumns(20);
		txtAInfo.setEditable(false);
		add(txtAInfo, BorderLayout.EAST);
		panelItem.setLayout(new BorderLayout(0, 0));
		add(panelItem, BorderLayout.WEST);		
		/**
		 * Testing Items
		 */
		Item it1 = new Item("Potion",0, 10);
		Item it2 = new Item("Sword", 10, 0);
		Item it3 = new Item("Armor", 5, 50);
		Item it4 = new Item("Bow", 5, 0);
		Item it5 = new Item("Crap", 0, 0);
		Item it6 = new Item("Destroyer of Worlds", 1000, 1000);
		ArrayList <Item> ial = new ArrayList<Item>();
		ial.add(it1);
		ial.add(it2);
		ial.add(it3);
		ial.add(it4);
		ial.add(it5);
		ial.add(it6);
		
		createBtnItemList(panelItem,ial);		
		
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
		setVisible(true);	
	}
	
	private void close() {
		this.dispose();
	}
	
	/*
	 * BtnArray itemList
	 */
	private void createBtnItemList(JPanel panel, ArrayList <Item> ial) {
	JPanel panelPickItem = new JPanel(new GridLayout(1,5,1,1));
	for (Item i : ial) {
		JButton btn = new JButton(i.getIcon());
    	panelPickItem.add(btn);
    	btn.setPreferredSize(new Dimension(64,64));
    	btn.setMaximumSize(new Dimension(64,64));
    	btn.addActionListener(e -> itemInfo(i,txtAInfo));
		
	}
	System.out.println("Items: "+ial.size());
    panel.add(panelPickItem, BorderLayout.WEST);
	}
	
    private void itemInfo(Item i, JTextArea txta) {
    	txta.setText("Name: \t"+i.getName()
    				+"\nHP-Bonus: \t"+i.getHpbonus()
    				+"\nStat-Bonus: \t"+i.getStatbonus());
    }
    
}
