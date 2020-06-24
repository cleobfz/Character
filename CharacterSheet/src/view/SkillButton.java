package view;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Skill;

public class SkillButton extends JButton {
	private Skill s;
	
	public SkillButton(Skill s) {
		super(s.getName());
		this.s = s;
		setIcon(s.getIcon());
	}
	
	public Skill getSkill() {
		return s;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		SkillButton pew = new SkillButton(new Skill("PewPew",5));
		pew.addActionListener(ae -> {
			SkillButton sb = (SkillButton)ae.getSource();
			System.out.println(sb.getSkill().getName());
		});
		f.add(pew);
		f.pack();
		f.setVisible(true);
	}
}
