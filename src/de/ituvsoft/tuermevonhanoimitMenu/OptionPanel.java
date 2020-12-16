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

	AnimationButton upButton;
	AnimationButton downButton;
	JLabel text;

	public OptionPanel(String name, Color bgColor) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setOpaque(false);
		text = new JLabel(name);
		text.setFont(new Font("Brush Script MT", Font.PLAIN, 40));
		text.setForeground(new Color(0xffffff));
		text.setPreferredSize(new Dimension(380, 80));
		upButton = new AnimationButton("C:/Users/es0072/Desktop/tvh/pfeil.png");
		upButton.setPressedIcon(new ImageIcon("C:/Users/es0072/Desktop/tvh/pfeil Pressed.png"));
		downButton = new AnimationButton("C:/Users/es0072/Desktop/tvh/pfeilunten.png");
		downButton.setPressedIcon(new ImageIcon("C:/Users/es0072/Desktop/tvh/pfeilunten Pressed.png"));
		this.add(text);
		this.add(Box.createHorizontalStrut(100));
		this.add(upButton);
		this.add(downButton);

	}

	public JButton getUpButton() {
		return upButton;
	}

	public JButton getDownButton() {
		return downButton;

	}

}
