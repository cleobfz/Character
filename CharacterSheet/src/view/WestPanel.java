package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;


import javax.swing.*;
import javax.swing.border.LineBorder;

public class WestPanel extends JPanel{

private Image img;
private JButton create;

	public WestPanel(String img, MasterGui master) {
		this(new ImageIcon(img).getImage(), master);
	}

    public WestPanel(Image img, MasterGui master) {
	setBorder(new LineBorder(new Color(0, 0, 0), 5));
	this.img = img;
	Dimension size = new Dimension(250, 600);
	setPreferredSize(size);
	setMinimumSize(size);
	setMaximumSize(size);
	setSize(size);
	setLayout(new GridLayout(4, 4, 4, 4));
	
	
	//CreateGUi Button
	create = new JButton();
	create.setIcon(new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/buttoncreate.png")));
	create.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	add(create);
	create.addActionListener(e -> master.createRoom());
	
	
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this); // see javadoc for more info on the parameters            
    }

}
