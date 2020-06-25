package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.IconView;

import controller.Controller;


public class Dungeon extends JPanel{
	private Raum[][] dungeon3x3 = new Raum[3][3];
	private int x;
	private int y;
	private int p;//position
	private int width = 800;
	private int height = (int) (width * 0.75);
	private Dimension d = new Dimension(width, height);
	private Character c;//character
	private Icon ic = new ImageIcon(System.getProperty("user.dir")+("/resources/character/erdmann.jpg"));
	private Controller con;
	
	public Dungeon(Controller c) {
		con = c;
		int i = 1;
		for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
			for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
				dungeon3x3[xIndex][yIndex] = con.getRaum(xIndex, yIndex);
				dungeon3x3[xIndex][yIndex].getGegner().setName("Monster im Raum " + i);
				i++;
			}
		}
		this.setPreferredSize(d);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				move(e.getKeyCode());
			}
		});
		
	} 
	
	
//	public Dungeon(Character character, int position) {
//		this.c = character;
//		this.p = position;
//		this.x = -1;
//		this.y = -1;
//		this.ic = this.c.getOrigin().getIcon();
//		for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
//			for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
//				if (dungeon3x3[xIndex][yIndex] == this.p) {
//					this.x = xIndex;
//					this.y = yIndex;
//				}
//			}
//		}
//		this.setPreferredSize(d);
//		addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				move(e.getKeyCode());
//			}
//		});
//	}
	
	public void addNotify() {//take over the keyboard focus
		super.addNotify();
		requestFocus();
	}
	
	public void paint(Graphics g) {
		int x = this.x * (width/3);
		int y = this.y * (height/3);
		g.clearRect(0, 0, width, height);
		ImageIcon icon = (ImageIcon) ic;
		ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(width/3, height/3, Image.SCALE_SMOOTH));
		icon2.paintIcon(this, g, x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getPosition() {
		return p;
	}
	
//	public void setPosition(int p) {
//		this.p = p;
//		for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
//			for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
//				if (dungeon3x3[xIndex][yIndex] == this.p) {
//					this.x = xIndex;
//					this.y = yIndex;
//				}
//			}
//		}
//	}
	
	public void setPosition(Raum r, int p) {
		int i = 0;
		for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
			for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
				i++;
				if (i == p) {
					this.dungeon3x3[xIndex][yIndex] = r;
				}
			}
		}
	}
	
	private void setPosition() {
		if (this.x == 0 && this.y == 0) {this.p = 1;}
		if (this.x == 0 && this.y == 1) {this.p = 2;}
		if (this.x == 0 && this.y == 2) {this.p = 3;}
		if (this.x == 1 && this.y == 0) {this.p = 4;}
		if (this.x == 1 && this.y == 1) {this.p = 5;}
		if (this.x == 1 && this.y == 2) {this.p = 6;}
		if (this.x == 2 && this.y == 0) {this.p = 7;}
		if (this.x == 2 && this.y == 1) {this.p = 8;}
		if (this.x == 2 && this.y == 2) {this.p = 9;}
	}
	
	public int[] move(int keyCode) {
		int[] xyKoordinaten = new int[2]; 
		int kc = keyCode;
		switch (kc) {
		case (39): if ( this.getX() < 2) {this.x = this.getX() + 1; repaint();}; break;
		case (37): if ( this.getX() > 0) {this.x = this.getX() - 1; repaint();}; break;
		case (40): if ( this.getY() < 2) {this.y = this.getY() + 1; repaint();}; break;
		case (38): if ( this.getY() > 0) {this.y = this.getY() - 1; repaint();}; break;
		default: break; //jede andere Taste - mach nichts
		}
		setPosition();
		//Das ist der neue Raum, den wir betreten:	
		xyKoordinaten[0] = this.getX();
		xyKoordinaten[1] = this.getY();
		System.out.print("neu x: " + xyKoordinaten[0] + ", new y: " + xyKoordinaten[1] + ", position: " + this.getPosition() + "\n");
		//con.enter(dungeon3x3[this.getX()][this.getY()]);
		//System.out.print(" " + dungeon3x3[this.getX()][this.getY()] + "\n");
		return xyKoordinaten;		
	}


	
  //TEST:
	public static void main(String[] args) {
		JFrame mf;
		mf = new JFrame();
		mf.setTitle("Dungeon");
		mf.setLocation(100,100);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout mainLayout = new BoxLayout(mf.getContentPane(), BoxLayout.Y_AXIS);
		mf.setLayout(mainLayout);

		//Character für Test
//		ArrayList<Item> inv = new ArrayList<>();
//		inv.add(new Item("Peng", 2,2));
//		inv.add(new Item("Pow", 4,5));
//		ArrayList<Skill> skills = new ArrayList<>();
//		skills.add(new Skill("Pew pew", 5));
//		Character c = new Character("Odlon", 3, 3, inv, skills, new Origin("Dwarf","Krieger"));
//	//24Jun
		Dungeon d3 = new Dungeon(new Controller());
		Raum newRaum = new Controller().getRaum(2, 2);
		System.out.println(newRaum);
		d3.setPosition(newRaum, 9);
		mf.add(d3);
		
		//Dungeon d2 = new Dungeon(c, 2);
		//int[] newPosition = d2.move(39);
//		mf.add(d2);
//		d2.setPosition(4);
//		System.out.println(d2.getPosition());
//		System.out.println(d2.getX());
//		System.out.println(d2.getY());
//		System.out.println(d2.getPosition());
//		d2.setPosition(3);
//		System.out.println(d2.getX());
//		System.out.println(d2.getY());
//		System.out.println(d2.getPosition());
				
		mf.pack();
		mf.setVisible(true);
		
	}//end of main
}