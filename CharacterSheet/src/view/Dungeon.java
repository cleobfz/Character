package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Character;
import model.Item;
import model.Monster;
import model.Raum;


public class Dungeon extends JPanel{
	private Raum[][] dungeon3x3 = new Raum[3][3];
	private int _x;
	private int _y;
	private int _p;//position
	private int width = 800;
	private int height = (int) (width * 0.75);
	private Dimension d = new Dimension(width, height);
	private Character c;//character
	private Icon ic = new ImageIcon(System.getProperty("user.dir")+("/resources/character/player.png"));
	private ImageIcon icon = (ImageIcon) ic;
	private ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(width/3, height/3, Image.SCALE_SMOOTH));
	private Controller con;

	public Dungeon(Controller c) {
		
		
		dungeon3x3 = c.getRaumArray();
		
		
		con = c;
		int i = 1;
		setBackground(Color.PINK);
//		for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
//			for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
//				dungeon3x3[xIndex][yIndex] = con.getRaum(xIndex, yIndex);
//				dungeon3x3[xIndex][yIndex].getGegner().setName("Monster im Raum " + i);
//				i++;
//			}
//		}
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
		
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = this._x * (width/3);
		int y = this._y * (height/3);
		g.clearRect(0, 0, width, height);
		icon2.paintIcon(this, g, x, y);
	}
		
	public int get_x() {
		return _x;
	}

	public void set_x(int x) {
		this._x = x;
	}
	
	public int get_y() {
		return _y;
	}
	
	public void set_y(int y) {
		this._y = y;
	}

	public int get_position() {
		return _p;
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
	
	public void set_position(Raum r, int p) {
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
		this._p = this._x * 3 + _y + 1;
	}
	
	public int[] move(int keyCode) {
		int[] xyKoordinaten = new int[2]; 
		int kc = keyCode;
		switch (kc) {
		case (39): if ( this.get_x() < 2) {this._x = this.get_x() + 1; }; break;
		case (37): if ( this.get_x() > 0) {this._x = this.get_x() - 1; }; break;
		case (40): if ( this.get_y() < 2) {this._y = this.get_y() + 1; }; break;
		case (38): if ( this.get_y() > 0) {this._y = this.get_y() - 1; }; break;
		default: break; //jede andere Taste - mach nichts
		}
		setPosition();
		repaint();
		//Das ist der neue Raum, den wir betreten:	
		xyKoordinaten[0] = this.get_x();
		xyKoordinaten[1] = this.get_y();
		//System.out.print("neu x: " + xyKoordinaten[0] + ", new y: " + xyKoordinaten[1] + ", position: " + this.get_position() + "\n");
		
		con.setRaum(dungeon3x3[this.get_x()][this.get_y()]);
		con.enter(dungeon3x3[this.get_x()][this.get_y()]);
		System.out.print("this get_x: " + this.get_x() + "this get_y: " + this.get_y() + "\n");
		

		return xyKoordinaten;		
	}

}