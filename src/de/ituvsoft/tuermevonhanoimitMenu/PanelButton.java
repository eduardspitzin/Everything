package de.ituvsoft.tuermevonhanoimitMenu;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
public class PanelButton extends JPanel {

	JButton button;
	
	public PanelButton(String name) {
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(500,0));
		
		button = new JButton(name);
		
		button.setFont(new Font("Brush Script MT",Font.PLAIN,40));
		button.setBackground(new Color(0x135d29));
		button.setForeground(new Color(0xffffff));
		button.setFocusable(false);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(600,65));
		this.add(button);
	
	}
	

	public JButton getButton() {
		return button;
		
	}
	

}
