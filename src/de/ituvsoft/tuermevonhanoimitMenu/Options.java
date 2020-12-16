package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel implements ActionListener {
	MainMenu mainmenu;
	OptionPanel scheiben;
	OptionPanel speed;
	OptionPanel sHeight;
	OptionPanel sWidth;
	OptionPanel bsHeight;
	OptionPanel bsWidth;
	OptionPanel wallPaperPanel;
	JButton menu;
	JButton reset;
	TannenTuerme animation;
	int[] speeds = { 1, 2, 5, 10 };
	String[] wallPapers = { "WallPaper1.jpg", "WallPaper2.png", "WallPaper3.jpg", "WallPaper4.jpg", "WallPaper5.jpg",
			"WallPaper6.jpg" };
	int wallPaperNumber;
	int speedNumber;

	public Options(Color bgColor, TannenTuerme animation, MainMenu mainmenu) {
		this.mainmenu = mainmenu;
		speedNumber = mainmenu.speedNumber;
		wallPaperNumber = mainmenu.wallPaperNumber;
		this.setOpaque(false);
		this.animation = animation;
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		scheiben = new OptionPanel("Scheiben: " + animation.scheiben, bgColor);
		this.add(scheiben);
		scheiben.getUpButton().addActionListener(this);
		scheiben.getDownButton().addActionListener(this);
		speed = new OptionPanel("Geschwindigkeit: " + (1 + mainmenu.speedNumber), bgColor);
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

		bsHeight = new OptionPanel("Höhe der Baumstämme: " + (animation.bStammHeight), bgColor);
		this.add(bsHeight);
		bsHeight.getUpButton().addActionListener(this);
		bsHeight.getDownButton().addActionListener(this);

		bsWidth = new OptionPanel("Breite der Baumstämme: " + animation.bStammWidth, bgColor);
		this.add(bsWidth);
		bsWidth.getUpButton().addActionListener(this);
		bsWidth.getDownButton().addActionListener(this);

		wallPaperPanel = new OptionPanel("Hintergrundbild: " + (mainmenu.wallPaperNumber + 1), bgColor);
		this.add(wallPaperPanel);
		wallPaperPanel.getUpButton().addActionListener(this);
		wallPaperPanel.getDownButton().addActionListener(this);

		JPanel readyButtons = new JPanel();
		readyButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		readyButtons.setOpaque(false);
		menu = new JButton("Änderungen übernehmen");
		menu.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		menu.setBackground(new Color(0x135d29));
		menu.setForeground(new Color(0xffffff));
		menu.setFocusable(false);
		menu.setBorder(BorderFactory.createEtchedBorder());
		menu.setFocusPainted(false);
		menu.addActionListener(this);
		readyButtons.add(menu);
		reset = new JButton("Änderungen zurücksetzen");
		reset.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		reset.setBackground(new Color(0x135d29));
		reset.setForeground(new Color(0xffffff));
		reset.setFocusable(false);
		reset.setBorder(BorderFactory.createEtchedBorder());
		reset.setFocusPainted(false);
		reset.addActionListener(this);
		readyButtons.add(reset);

		this.add(readyButtons);

		if (animation.scheiben >= 20)
			scheiben.getUpButton().setEnabled(false);
		if (animation.scheiben <= 3)
			scheiben.getDownButton().setEnabled(false);
		if (mainmenu.speedNumber >= 3)
			speed.getUpButton().setEnabled(false);
		if (mainmenu.speedNumber <= 0)
			speed.getDownButton().setEnabled(false);
		if (animation.height >= 80)
			sHeight.getUpButton().setEnabled(false);
		if (animation.height <= 10)
			sHeight.getDownButton().setEnabled(false);
		if (animation.widthProduct >= 50)
			sWidth.getUpButton().setEnabled(false);
		if (animation.widthProduct <= 10)
			sWidth.getDownButton().setEnabled(false);
		if (animation.baumY[0] <= animation.baumY[0] - 100)
			bsHeight.getUpButton().setEnabled(false);
		if (animation.baumY[0] >= animation.baumY[0] + 100)
			bsHeight.getDownButton().setEnabled(false);
		if (animation.bStammWidth >= 50)
			bsWidth.getUpButton().setEnabled(false);
		if (animation.bStammWidth <= 10)
			bsWidth.getDownButton().setEnabled(false);
		if (mainmenu.wallPaperNumber >= 5)
			wallPaperPanel.getUpButton().setEnabled(false);
		if (mainmenu.wallPaperNumber == 0)
			wallPaperPanel.getDownButton().setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == scheiben.getUpButton()) {
			animation.scheiben++;
			if (animation.scheiben >= 20)
				scheiben.getUpButton().setEnabled(false);
			scheiben.getDownButton().setEnabled(true);
			scheiben.text.setText("Scheiben: " + animation.scheiben);
		}
		if (e.getSource() == scheiben.getDownButton()) {
			animation.scheiben--;
			if (animation.scheiben <= 3)
				scheiben.getDownButton().setEnabled(false);
			scheiben.getUpButton().setEnabled(true);
			scheiben.text.setText("Scheiben: " + animation.scheiben);
		}
		if (e.getSource() == speed.getUpButton()) {
			mainmenu.speedNumber++;
			animation.speed = speeds[mainmenu.speedNumber];
			if (mainmenu.speedNumber >= speeds.length - 1)
				speed.getUpButton().setEnabled(false);
			speed.getDownButton().setEnabled(true);
			speed.text.setText("Geschwindigkeit: " + (mainmenu.speedNumber + 1));
		}
		if (e.getSource() == speed.getDownButton()) {
			mainmenu.speedNumber--;
			animation.speed = speeds[mainmenu.speedNumber];
			if (mainmenu.speedNumber <= 0)
				speed.getDownButton().setEnabled(false);
			speed.getUpButton().setEnabled(true);
			speed.text.setText("Geschwindigkeit: " + (mainmenu.speedNumber + 1));
		}
		if (e.getSource() == sHeight.getUpButton()) {
			animation.height = animation.height + 10;
			if (animation.height >= 80)
				sHeight.getUpButton().setEnabled(false);
			sHeight.getDownButton().setEnabled(true);
			sHeight.text.setText("Höhe der Scheiben: " + animation.height);
		}
		if (e.getSource() == sHeight.getDownButton()) {
			animation.height = animation.height - 10;
			if (animation.height <= 10)
				sHeight.getDownButton().setEnabled(false);
			sHeight.getUpButton().setEnabled(true);
			sHeight.text.setText("Höhe der Scheiben: " + animation.height);
		}
		if (e.getSource() == sWidth.getUpButton()) {
			animation.widthProduct += 2;
			if (animation.widthProduct >= 50)
				sWidth.getUpButton().setEnabled(false);
			sWidth.getDownButton().setEnabled(true);
			sWidth.text.setText("Breite der Scheiben: " + animation.widthProduct);
		}
		if (e.getSource() == sWidth.getDownButton()) {
			animation.widthProduct -= 2;
			if (animation.widthProduct <= 10)
				sWidth.getDownButton().setEnabled(false);
			sWidth.getUpButton().setEnabled(true);
			sWidth.text.setText("Breite der Scheiben: " + animation.widthProduct);
		}
		if (e.getSource() == bsHeight.getUpButton()) {
			for (int i = 0; i < 3; i++)
				animation.baumY[i] -= 10;
			System.out.println(animation.baumY[0]);
			animation.bStammHeight += 10;
			if (animation.baumY[0] <= new TannenTuerme(1).baumY[0] - 100)
				bsHeight.getUpButton().setEnabled(false);
			bsHeight.getDownButton().setEnabled(true);
			bsHeight.text.setText("Höhe der Baumstämme: " + (animation.bStammHeight));
		}
		if (e.getSource() == bsHeight.getDownButton()) {
			for (int i = 0; i < 3; i++)
				animation.baumY[i] += 10;
			System.out.println(animation.baumY[0]);

			animation.bStammHeight -= 10;
			if (animation.baumY[0] >= new TannenTuerme(1).baumY[0] + 100)
				bsHeight.getDownButton().setEnabled(false);
			bsHeight.getUpButton().setEnabled(true);
			bsHeight.text.setText("Höhe der Baumstämme: " + (animation.bStammHeight));
		}
		if (e.getSource() == bsWidth.getUpButton()) {
			animation.bStammWidth += 10;
			if (animation.bStammWidth >= 50)
				bsWidth.getUpButton().setEnabled(false);
			bsWidth.getDownButton().setEnabled(true);
			bsWidth.text.setText("Breite der Baumstämme: " + animation.bStammWidth);

		}
		if (e.getSource() == bsWidth.getDownButton()) {
			animation.bStammWidth -= 10;
			if (animation.bStammWidth <= 10)
				bsWidth.getDownButton().setEnabled(false);
			bsWidth.getUpButton().setEnabled(true);
			bsWidth.text.setText("Breite der Baumstämme: " + animation.bStammWidth);
		}
		if (e.getSource() == wallPaperPanel.getUpButton()) {
			mainmenu.wallPaperNumber++;
			animation.wallPaper = wallPapers[mainmenu.wallPaperNumber];
			if (mainmenu.wallPaperNumber >= 5)
				wallPaperPanel.getUpButton().setEnabled(false);
			wallPaperPanel.getDownButton().setEnabled(true);
			wallPaperPanel.text.setText("Hintergrundbild: " + (mainmenu.wallPaperNumber + 1));
		}
		if (e.getSource() == wallPaperPanel.getDownButton()) {
			mainmenu.wallPaperNumber--;
			animation.wallPaper = wallPapers[mainmenu.wallPaperNumber];
			if (mainmenu.wallPaperNumber <= 0)
				wallPaperPanel.getDownButton().setEnabled(false);
			wallPaperPanel.getUpButton().setEnabled(true);
			wallPaperPanel.text.setText("Hintergrundbild: " + (mainmenu.wallPaperNumber + 1));
		}

		if (e.getSource() == menu) {
			this.setVisible(false);
			mainmenu.menu();
		}
		if (e.getSource() == reset) {
			reset();

		}
	}

	private void reset() {
		TannenTuerme animationReset = new TannenTuerme(mainmenu.scheiben);
		animation.scheiben = animationReset.scheiben;
		animation.height = animationReset.height;
		animation.baumY = animationReset.baumY;
		animation.widthProduct = animationReset.widthProduct;
		animation.bStammHeight = animationReset.bStammHeight;
		animation.bStammWidth = animationReset.bStammWidth;
		mainmenu.speedNumber = mainmenu.sNumberReset;
		mainmenu.wallPaperNumber = mainmenu.wpNumberReset;
		scheiben.text.setText("Scheiben: " + animation.scheiben);
		speed.text.setText("Geschwindigkeit: " + (mainmenu.sNumberReset + 1));
		sHeight.text.setText("Höhe der Scheiben: " + animation.height);
		sWidth.text.setText("Breite der Scheiben: " + animation.widthProduct);
		bsHeight.text.setText("Höhe der Baumstämme: " + (animation.bStammHeight));
		bsWidth.text.setText("Breite der Baumstämme: " + animation.bStammWidth);
		wallPaperPanel.text.setText("Hintergrundbild: " + (mainmenu.wpNumberReset + 1));
		scheiben.getUpButton().setEnabled(true);
		scheiben.getDownButton().setEnabled(true);
		speed.getUpButton().setEnabled(true);
		speed.getDownButton().setEnabled(true);
		sHeight.getUpButton().setEnabled(true);
		sHeight.getDownButton().setEnabled(true);
		sWidth.getUpButton().setEnabled(true);
		sWidth.getDownButton().setEnabled(true);
		bsHeight.getUpButton().setEnabled(true);
		bsHeight.getDownButton().setEnabled(true);
		bsWidth.getUpButton().setEnabled(true);
		bsWidth.getDownButton().setEnabled(true);
		wallPaperPanel.getUpButton().setEnabled(true);
		wallPaperPanel.getDownButton().setEnabled(false);

	
	
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(animation.stammColor);
		g.fillRect(800 - animation.bStammWidth / 2, 525 - animation.bStammHeight, animation.bStammWidth,
				animation.bStammHeight);
		g.setColor(animation.sliceColor);
		for (int i = animation.scheiben; i > 0; i--) {
			g.fillRect(800 - animation.widthProduct * i / 2,
					525 - (animation.scheiben - i + 1) * animation.height - animation.bStammHeight,
					animation.widthProduct * i, animation.height);

		}
		this.repaint();

	}

}
