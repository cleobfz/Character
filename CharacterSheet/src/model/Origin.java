package model;

import javax.swing.*;

public class Origin {

		private String name;
		private String klasse;
		
		private Icon icon = new ImageIcon(System.getProperty("user.dir")+("/character/erdmann.jpg"));
			
		public Origin(String name, String klasse, Icon icon) {
			this.name = name;
			this.klasse = klasse;
			this.icon = icon;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getKlasse() {
			return klasse;
		}

		public void setKlasse(String klasse) {
			this.klasse = klasse;
		}
		public Icon getIcon() {
			return icon;
		}

		@Override
		public String toString() {
			return  name + ", " + klasse + ", " + icon + " ";
		}
		
		
}