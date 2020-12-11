package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Options extends JPanel implements ActionListener {
	MainMenu mainmenu;
	OptionPanel scheiben;
	OptionPanel speed;
	OptionPanel sHeight;
	OptionPanel sWidth;
	OptionPanel bsHeight;
	OptionPanel bsWidth;
	JButton menu;
	TannenTuerme animation;
	int[] speeds = { 1, 2, 5, 10 };
	int speedNumber = 1;
	
	public Options(Color bgColor, TannenTuerme animation,MainMenu mainmenu) {
		this.mainmenu = mainmenu;
		this.setOpaque(false);
		
		this.animation = animation;
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		scheiben = new OptionPanel("Scheiben: " + animation.scheiben, bgColor);
		this.add(scheiben);
		scheiben.getUpButton().addActionListener(this);
		scheiben.getDownButton().addActionListener(this);
		speed = new OptionPanel("Geschwindigkeit: " + animation.speed, bgColor);
		this.add(speed);
		speed.getUpButton().addActionListener(this);
		speed.getDownButton().addActionListener(this);

		sHeight = new OptionPanel("Höhe der Scheiben: " + animation.height, bgColor);
		this.add(sHeight);
		sHeight.getUpButton().addActionListener(this);
		sHeight.getDownButton().addActionListener(this);

		sWidth = new OptionPanel("Breite der Scheiben: " + animation.widthProduct, bgColor);
		this.add(sWidth);
		sWidth.getUpButton().addActionListener(this);
		sWidth.getDownButton().addActionListener(this);

		bsHeight = new OptionPanel("Höhe der Baumstämme: " + animation.bStammHeight, bgColor);
		this.add(bsHeight);
		bsHeight.getUpButton().addActionListener(this);
		bsHeight.getDownButton().addActionListener(this);

		bsWidth = new OptionPanel("Breite der Baumstämme: " + animation.bStammWidth, bgColor);
		this.add(bsWidth);
		bsWidth.getUpButton().addActionListener(this);
		bsWidth.getDownButton().addActionListener(this);
		
		
		JPanel readyButtons = new JPanel();
		readyButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		readyButtons.setOpaque(false);
		menu = new JButton("Änderungen übernehmen");
		menu.setFont(new Font("Brush Script MT",Font.PLAIN,25));
		menu.setBackground(new Color(0x135d29));
		menu.setForeground(new Color(0xffffff));
		menu.setFocusable(false);
		menu.setBorder(BorderFactory.createEtchedBorder());
		menu.setFocusPainted(false);
		
		this.add(menu);
		
		
		readyButtons.add(menu);
		this.add(readyButtons);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == scheiben.getUpButton()) {
			animation.scheiben++;
			if (animation.scheiben == 20)
				scheiben.getUpButton().setEnabled(false);
			scheiben.getDownButton().setEnabled(true);
			scheiben.text.setText("Scheiben: " + animation.scheiben);
		}
		if (e.getSource() == scheiben.getDownButton()) {
			animation.scheiben--;
			if (animation.scheiben == 3)
				scheiben.getDownButton().setEnabled(false);
			scheiben.getUpButton().setEnabled(true);
			scheiben.text.setText("Scheiben: " + animation.scheiben);
		}
		if (e.getSource() == speed.getUpButton()) {
			speedNumber++;
			animation.speed = speeds[speedNumber];
			if (speedNumber == speeds.length - 1)
				speed.getUpButton().setEnabled(false);
			speed.getDownButton().setEnabled(true);
			speed.text.setText("Geschwindigkeit: " + animation.speed);
		}
		if (e.getSource() == speed.getDownButton()) {
			speedNumber--;
			System.out.println("up");
			animation.speed = speeds[speedNumber];
			if (speedNumber == 0)
				speed.getDownButton().setEnabled(false);
			speed.getUpButton().setEnabled(true);
			speed.text.setText("Geschwindigkeit: " + animation.speed);
		}
		if (e.getSource() == sHeight.getUpButton()) {
			animation.height = animation.height + 10;
			if (animation.height == 80)
				sHeight.getUpButton().setEnabled(false);
			sHeight.getDownButton().setEnabled(true);
			sHeight.text.setText("Höhe der Scheiben: " + animation.height);
		}
		if (e.getSource() == sHeight.getDownButton()) {
			animation.height = animation.height - 10;
			if (animation.height == 10)
				sHeight.getDownButton().setEnabled(false);
			sHeight.getUpButton().setEnabled(true);
			sHeight.text.setText("Höhe der Scheiben: " + animation.height);
		}
		if (e.getSource() == sWidth.getUpButton()) {
			animation.widthProduct += 2;
			if (animation.widthProduct == 50)
				sWidth.getUpButton().setEnabled(false);
			sWidth.getDownButton().setEnabled(true);
			sWidth.text.setText("Breite der Scheiben: " + animation.widthProduct);
		}
		if (e.getSource() == sWidth.getDownButton()) {
			animation.widthProduct -= 2;
			if (animation.widthProduct == 10)
				sWidth.getDownButton().setEnabled(false);
			sWidth.getUpButton().setEnabled(true);
			sWidth.text.setText("Breite der Scheiben: " + animation.widthProduct);
		}
		if (e.getSource() == bsHeight.getUpButton()) {
			for (int i = 0; i < 3; i++)
				animation.baumStammY[i] -= 10;
			animation.bStammHeight += 10;
			if (animation.baumStammY[0] == 350)
				bsHeight.getUpButton().setEnabled(false);
			bsHeight.getDownButton().setEnabled(true);
			bsHeight.text.setText("Höhe der Baumstämme: " + animation.bStammHeight);
		}
		if (e.getSource() == bsHeight.getDownButton()) {
			for (int i = 0; i < 3; i++)
				animation.baumStammY[i] += 10;
			animation.bStammHeight -= 10;
			if (animation.baumStammY[0] == 550)
				bsHeight.getDownButton().setEnabled(false);
			bsHeight.getUpButton().setEnabled(true);
			bsHeight.text.setText("Höhe der Baumstämme: " + animation.bStammHeight);
		}
		if (e.getSource() == bsWidth.getUpButton()) {
			animation.bStammWidth += 10;
			if (animation.bStammWidth == 50)
				bsWidth.getUpButton().setEnabled(false);
			bsWidth.getDownButton().setEnabled(true);
			bsWidth.text.setText("Breite der Baumstämme: " + animation.bStammWidth);

		}
		if (e.getSource() == bsWidth.getDownButton()) {
			animation.bStammWidth -= 10;
			if (animation.bStammWidth == 10)
				bsWidth.getDownButton().setEnabled(false);
			bsWidth.getUpButton().setEnabled(true);
			bsWidth.text.setText("Breite der Baumstämme: " + animation.bStammWidth);
		}

		if(e.getSource()==menu) {
			mainmenu.menu();
			
			
		}
	}
}
