package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class SkillButton extends JButton{
	private Skill skill;

	public SkillButton(Skill skill){
		this.skill =skill;
		
	}
	
	public Skill getSkill(){
		return skill;
	}
	
	
}
