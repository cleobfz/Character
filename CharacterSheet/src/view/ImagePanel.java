package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ImagePanel extends JPanel {
private Image img;
JTextField gegnername, itemname;

	public ImagePanel(String img, MasterGui master) {
		this(new ImageIcon(img).getImage(), master);
	}

	public ImagePanel(Image img, MasterGui master) {
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		this.img = img;
		Dimension size = new Dimension(250, 600);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(new GridLayout(4, 4, 4, 4));

		// RoomTextField
		JTextField roomname = new JTextField();
		roomname.setText("Dungeonroom");
		roomname.setHorizontalAlignment(SwingConstants.CENTER);
		roomname.setForeground(Color.BLACK);
		roomname.setOpaque(false);
		roomname.setFont(new Font("Onyx", Font.BOLD, 40));
		roomname.setEditable(false);
		add(roomname);

		// ItemLabel
		JLabel itemlabel = new JLabel();
		itemlabel.setOpaque(false);
		if(master.controller.getRaum().getSchatz() != null){
		itemlabel.setIcon(master.controller.getRaum().getSchatz().getIcon());
		String itemtext = master.controller.getRaum().getSchatz().getName() + ": HP ("
				+ master.controller.getRaum().getSchatz().getHpbonus() + ") DMG ("
				+ master.controller.getRaum().getSchatz().getStatbonus() + ")";
		itemlabel.setText(itemtext);
		} else {
			itemlabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\resources\\items\\open-chest.png"));
			itemlabel.setText("No Treasures");
		}
		add(itemlabel);

		// Monsterlabel
		JLabel monsterlabel = new JLabel();
		monsterlabel.setOpaque(false);
		if(master.controller.getRaum().getGegner() != null){
		monsterlabel.setIcon(master.controller.getRaum().getGegner().getIcon());
		String gegnertext = master.controller.getRaum().getGegner().getName() + ": HP ("
				+ master.controller.getRaum().getGegner().getHp() + ") DMG ("
				+ master.controller.getRaum().getGegner().getDmg() + ")";
		monsterlabel.setText(gegnertext);
		} else {
			monsterlabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\resources\\items\\tentacle.png"));
			monsterlabel.setText("No Monsters");
		}
		add(monsterlabel);

		// Exitlabel
		JLabel exitlabel = new JLabel();
		exitlabel.setOpaque(false);
		if (master.controller.getRaum().getAusgang()) {
			exitlabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\resources\\ui\\screen\\doorway.png"));
			exitlabel.setText("Exit");
		} else {
			exitlabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\resources\\ui\\screen\\stonewall.png"));
			exitlabel.setText("No Exit");
		}
		add(exitlabel);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

}
