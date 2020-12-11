package de.ituvsoft.tuermevonhanoimitMenu;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class OptionPanel extends JPanel {

	JButton upButton;
	JButton downButton;
	JLabel text;
	
	
	public OptionPanel(String name,Color bgColor) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setOpaque(false);
		text = new JLabel(name);
		text.setText(name);
		text.setFont(new Font("Brush Script MT",Font.PLAIN,40));
		text.setForeground(new Color(0xffffff));		
		text.setPreferredSize(new Dimension(380,80));
		upButton = new JButton(new ImageIcon("C:\\Users\\es0072\\Downloads\\pfeil.png"));
		upButton.setBackground(bgColor);
		upButton.setFocusable(false);
		upButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		downButton = new JButton(new ImageIcon("C:\\Users\\es0072\\Downloads\\pfeilunten.png"));
		downButton.setBackground(bgColor);
		downButton.setFocusable(false);
		downButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.add(text);
		this.add(Box.createHorizontalStrut(100));
		this.add(upButton);
		
		this.add(downButton);
		System.out.println("Konstruiert");
		
	}
	public JButton getUpButton() {
		return upButton;
	}
	public JButton getDownButton() {
		return downButton;
		
	}
	
}
