package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.*;

public class InvGui extends JFrame {
	private MasterGui master;
	private JPanel panelItem;
	private JPanel panelBtn;
	private String font = "Algerian";
	private JTextArea txtAInfo;
	private JTextField invCap;
	private Item selectedItem;
	private JButton selectedBtn = new JButton();
	private JButton btnUse = new JButton("Use");
	
	private ArrayList <Item> ial;
	
	private JPanel panelPickItem = new JPanel(new GridLayout(4,5,1,1));
		
	public InvGui(MasterGui master) {
		this.master = master;
		setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		/*
		 * BtnPanel
		 */
		panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnClose = new JButton("close");
		btnClose.setFont(new Font(font, Font.PLAIN, 20));
		btnClose.addActionListener(e -> close());
		panelBtn.add(btnClose);
		
		btnUse.setFont(new Font(font, Font.PLAIN, 20));
		btnUse.addActionListener(e -> useItem(panelPickItem, selectedBtn, ial));
		btnUse.setEnabled(false);
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
		
		//fill arraylist
		
		ial = master.controller.getCharacter().getInventory();
		
		createBtnItemList(panelItem,ial);
		
		invCap = new JTextField();
		invCap.setHorizontalAlignment(SwingConstants.CENTER);
		invCap.setText(ial.size()+"/20 Items");
		invCap.setFont(new Font(font, Font.PLAIN, 20));
		
		add(invCap, BorderLayout.NORTH);
		
		setLocationRelativeTo(master.frame);
		setResizable(false);
		pack();
		setVisible(true);	
	}
	
	private void useItem(JPanel panel, JButton btn, ArrayList <Item> ial) {
		
		panel.remove(btn);
		btnUse.setEnabled(false);
		System.out.println(selectedItem+" used");
		
		JButton newBtn = new JButton("empty");
		panelPickItem.add(newBtn);
		
		int index = 0;
		for (Item i : ial) {
				if (selectedItem == i) {
					System.out.println("equalIndex: "+index);
					master.controller.selectItem(i);
					continue;
				}
				index++;
		}
		ial.remove(index);
		invCap.setText(this.ial.size()+"/20 Items");
		
		
		
		panel.repaint();
		panel.revalidate();
	}

	private void close() {
		this.dispose();
	}
	
	/**
	 * @param panel - panel which got filled with buttons
	 * @param ial 	- itemList for creating the buttons
	 */
	private void createBtnItemList(JPanel panel, ArrayList <Item> ial) {
	
	for (Item i : ial) {
		JButton btn = new JButton(i.getIcon());
    	panelPickItem.add(btn);
    	btn.setPreferredSize(new Dimension(64,64));
    	btn.setMaximumSize(new Dimension(64,64));
    	btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedBtn = btn;
				itemInfo(i,txtAInfo);
			}
		});
	}
	System.out.println("Items: "+ial.size());
	if (ial.size()<20) {
		for (int i=ial.size();i<20;i++) {
			JButton btn = new JButton("empty");
			btn.addActionListener(e -> itemInfo(null, txtAInfo));
			panelPickItem.add(btn);
		}
	}
    panel.add(panelPickItem, BorderLayout.WEST);   
	}
	
    private void itemInfo(Item i, JTextArea txta) {
    	this.selectedItem = i;
    	if (i != null) {
		btnUse.setEnabled(true);
    	txta.setText("Name: \t"+i.getName()
    				+"\nHP-Bonus: \t"+i.getHpbonus()
    				+"\nStat-Bonus: \t"+i.getStatbonus());
	    }else {
	    	txta.setText("no item");
			btnUse.setEnabled(false);
	    }
    }
	    
}
