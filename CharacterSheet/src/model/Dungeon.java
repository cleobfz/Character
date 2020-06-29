package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Controller;


public class Dungeon extends JPanel implements ActionListener, KeyListener{
	private Raum[][] dungeon3x3 = new Raum[3][3];
	private int _x;
	private int _y;
	private int _p;//position
	private int width = 800;
	private int height = (int) (width * 0.75);
	private Dimension d = new Dimension(width, height);
	private Character c;//character
	private Icon ic = new ImageIcon(System.getProperty("user.dir")+("/resources/character/erdmann.jpg"));
	private ImageIcon icon = (ImageIcon) ic;
	private ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(width/3, height/3, Image.SCALE_SMOOTH));
	private Icon doorIcon = new ImageIcon(System.getProperty("user.dir")+("/resources/ui/screen/dungeon-door.png"));
	private ImageIcon doorImg = (ImageIcon) doorIcon; 
	private ImageIcon doorScaled = new ImageIcon(doorImg.getImage().getScaledInstance(doorImg.getIconWidth()/3, doorImg.getIconHeight()/3, Image.SCALE_SMOOTH));
	private ArrayList<JPanel> raeume = new ArrayList<>();
	private Controller con;
		private ArrayList<Integer> raumeRandearXs = new ArrayList<>();
		private ArrayList<Integer> raumeRandearYs = new ArrayList<>();
	
	private Timer tm = new Timer(5, this);
	private int heroX = 0, heroVelX_toR = 0, heroVelX_toL = 0;
	private int heroY = 0, heroVelY_up = 0, heroVelY_down = 0;
	private int heroSize = 30;

	public Dungeon(Controller c) {
		setLayout(new GridLayout(3, 3));
		con = c;
		setBackground(new Color(32, 32, 32));
		int i = 0;
		for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
			for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
				dungeon3x3[xIndex][yIndex] = con.getRaum(xIndex, yIndex);
				dungeon3x3[xIndex][yIndex].getGegner().setName("Monster " + (i+1));
				raeume.add(new JPanel());
				raeume.get(i).add(new JLabel(doorScaled));
				Dimension rDim = new Dimension(width/3 - 5, height/3 - 5);
				raeume.get(i).setPreferredSize(rDim);
				raeume.get(i).add(new JLabel(" Raum " + (i+1) + "," + dungeon3x3[xIndex][yIndex].getGegner().getName()));
				raeume.get(i).getComponent(1).setForeground(new Color(149, 149, 149));
				//System.out.println(Raeume.get(i-1).getComponent(0).getForeground());
				raeume.get(i).setBackground(new Color(0,0,0,0));
				this.add(raeume.get(i));				
				i++;
			}
		}
		this.setPreferredSize(d);
		
//		addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				move(e.getKeyCode());
//			}
//		});
		
		tm.start();
		addKeyListener(this);
		//setFocusable(true);
		setFocusTraversalKeysEnabled(false);
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
		
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		int x = this._x * (width/3);
//		int y = this._y * (height/3);
//		//g.clearRect(0, 0, width, height);
//		icon2.paintIcon(this, g, x, y);
//	}
	
	//moving square
	protected void paintComponent(Graphics g) {
//		int i = 0;
//		while (raumeRandearXs.size() < 10) {
//			raumeRandearXs.add(raeume.get(i).getX() + raeume.get(i).getComponent(0).getX());
//			raumeRandearXs.add(raeume.get(i).getX() + raeume.get(i).getComponent(0).getX() + raeume.get(i).getComponent(0).getWidth());
//			//System.out.println(raumeRandearXs);
//			raumeRandearYs.add(raeume.get(i).getY() + raeume.get(i).getComponent(0).getY());
//			raumeRandearYs.add(raeume.get(i).getY() + raeume.get(i).getComponent(0).getY() + raeume.get(i).getComponent(0).getHeight());
//			//System.out.println(raumeRandearYs);
//			i++;
//		}		
		
		super.paintComponent(g);
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		g.fillRect(heroX, heroY, heroSize, heroSize);
		//System.out.println(heroX);
		//System.out.println(Raeume.get(8).getX());
	}
	
	public void actionPerformed(ActionEvent e) {
		if (heroX < 1) {
			heroVelX_toL = 0;
			heroX = 0;
			//heroVelX = 0;
		}
		if (heroX > (width - heroSize) - 1) {
			heroX = width - heroSize;
			heroVelX_toR = 0;
		}
		//gettin' in from the left side
		if ((heroX > raeume.get(0).getComponent(0).getX() - heroSize && heroX < raeume.get(0).getComponent(0).getX() ||
				heroX > (raeume.get(1).getX() + raeume.get(1).getComponent(0).getX() - heroSize) && heroX < raeume.get(1).getX() + raeume.get(1).getComponent(0).getX() ||
				heroX > (raeume.get(2).getX() + raeume.get(2).getComponent(0).getX() - heroSize) && heroX < raeume.get(2).getX() + raeume.get(2).getComponent(0).getX())
				&& heroY < raeume.get(0).getComponent(0).getY() + raeume.get(0).getComponent(0).getHeight()) {
			heroVelX_toR = 0;
			//heroX--;
		}
		if ((heroX > raeume.get(0).getComponent(0).getX() && heroX < raeume.get(0).getComponent(0).getX() + raeume.get(0).getComponent(0).getWidth() ||
				heroX > (  raeume.get(1).getX() + raeume.get(1).getComponent(0).getX()   ) && heroX < raeume.get(1).getX() + raeume.get(1).getComponent(0).getX() + raeume.get(1).getComponent(0).getWidth() ||
				heroX >	(  raeume.get(2).getX() + raeume.get(2).getComponent(0).getX()   ) && heroX < raeume.get(2).getX() + raeume.get(2).getComponent(0).getX() + raeume.get(2).getComponent(0).getWidth()))  {
			System.out.println();
			heroVelX_toL = 0;
			//heroX--;
		}
//		if (heroX > (raeume.get(1).getX() + raeume.get(1).getComponent(0).getX() - heroSize + raeume.get(1).getComponent(0).getWidth())
//				&& heroY < raeume.get(1).getComponent(0).getY() + raeume.get(1).getComponent(0).getHeight()) {
//			heroVelX_toR = 0;
//			
//		}
//		if (heroX > (raeume.get(2).getX() + raeume.get(2).getComponent(0).getX() - heroSize) && heroX < raeume.get(2).getX() + raeume.get(2).getComponent(0).getX()
//			&& heroY < raeume.get(2).getComponent(0).getY() + raeume.get(2).getComponent(0).getHeight()) {
//			heroVelX = 0;
//			heroX--;
//		}
		//System.out.println(raeume.get(1).getX() + raeume.get(1).getComponent(1).getX());
		
		
		
		
		
		if (heroY < 1) {
			heroY = 0;
			heroVelY_up = 0;
		}
		if (heroY > (height - heroSize) - 1) {
			heroY = height - heroSize;
			heroVelY_down = 0;
		}
		
		heroX = heroX + heroVelX_toR + heroVelX_toL;
		heroY = heroY + heroVelY_down + heroVelY_up;
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT) {
			heroVelX_toR = 0;
			heroVelX_toL = -2;
		}
		if (c == KeyEvent.VK_RIGHT) {
			heroVelX_toR = 2;
			heroVelX_toL = 0;
		}
		if (c == KeyEvent.VK_UP) {
			heroVelY_up = -2;
			heroVelY_down = 0;
		}
		if (c == KeyEvent.VK_DOWN) {
			heroVelY_up = 0;
			heroVelY_down = 2;
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		heroVelX_toR = 0;
		heroVelX_toL = 0;
		heroVelY_up = 0;
		heroVelY_down = 0;
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
		for (int yIndex = 0; yIndex < dungeon3x3.length; yIndex++) {
			for (int xIndex = 0; xIndex < dungeon3x3.length; xIndex++) {
				if (i == p-1) {
					this.dungeon3x3[xIndex][yIndex] = r;
					//System.out.println(raeume.get(0).remove(0););
					//System.out.println(raeume.get(i).getComponentAt(85, 5).setText("asd"));
					raeume.get(i).remove(1);
					JLabel temp = new JLabel("Raum " + (i+1) + "," + dungeon3x3[xIndex][yIndex].getGegner().getName());
					temp.setForeground(new Color(149, 149, 149));
					raeume.get(i).add(temp);
				}
				i++;
			}
		}
	}
	
	private void set_position() {
		this._p = _y * 3 + _x + 1;
	}
		
	public int[] move(int keyCode) {
		int[] xyKoordinaten = new int[2]; 
//		int kc = keyCode;
//		switch (kc) {
//		case (39): if ( this.get_x() < 2) {this._x = this.get_x() + 1; }; break;
//		case (37): if ( this.get_x() > 0) {this._x = this.get_x() - 1; }; break;
//		case (40): if ( this.get_y() < 2) {this._y = this.get_y() + 1; }; break;
//		case (38): if ( this.get_y() > 0) {this._y = this.get_y() - 1; }; break;
//		default: break; //jede andere Taste - mach nichts
//		}
//		set_position();
//		repaint();
//		//Das ist der neue Raum, den wir betreten:	
//		xyKoordinaten[0] = this.get_x();
//		xyKoordinaten[1] = this.get_y();
//		System.out.print("neu x: " + xyKoordinaten[0] + ", new y: " + xyKoordinaten[1] + ", position: " + this.get_position() + "\n");
//	//con.enter(dungeon3x3[this.getX()][this.getY()]);
//	//System.out.print(" " + dungeon3x3[this.get_x()][this.get_y()] + "\n");
		return xyKoordinaten;		
	}


	
  //TEST:
	public static void main(String[] args) {
		JFrame mf;
		mf = new JFrame();
		mf.setTitle("Dungeon");
		mf.setLocation(1000,100);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout mainLayout = new BorderLayout();
		mf.getContentPane().setLayout(mainLayout);
		
		
		JPanel west = new JPanel();
		JLabel westLabel = new JLabel("west");
		west.add(westLabel);
		mf.add(west, BorderLayout.WEST);
		west.setBackground(Color.MAGENTA);
		
		JPanel east = new JPanel();
		JLabel eastLabel = new JLabel("east");
		east.add(eastLabel);
		mf.add(east, BorderLayout.EAST);
		east.setBackground(Color.ORANGE);
		
		
		//Character für Test
//		ArrayList<Item> inv = new ArrayList<>();
//		inv.add(new Item("Peng", 2,2));
//		inv.add(new Item("Pow", 4,5));
//		ArrayList<Skill> skills = new ArrayList<>();
//		skills.add(new Skill("Pew pew", 5));
//		Character c = new Character("Odlon", 3, 3, inv, skills, new Origin("Dwarf","Krieger"));
		Dungeon d3 = new Dungeon(new Controller());
		Raum newRaum = new Controller().getRaum(2, 2);
		//System.out.println(newRaum);
		d3.set_position(newRaum, 2);
		//JPanel helper = new JPanel();
		//helper.add(d3);
		//helper.setBackground(Color.blue);
		mf.add(d3, BorderLayout.CENTER);
		
		
		
		
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