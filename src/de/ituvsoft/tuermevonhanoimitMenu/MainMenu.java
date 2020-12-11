package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener {

	JLabel halloText;
	PanelButton playButton;
	PanelButton playAnimation;
	PanelButton settings;
	TannenTuerme animation;
	int scheiben = 5;
	boolean pause = false;
	Color bgColor = new Color(0xcd1c2e);
	ArrayList<Stack<Integer>> towers;

	public MainMenu() {

		this.setTitle("Die Türme von Hanoi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.getContentPane().setBackground(bgColor);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		menu();
		animation = new TannenTuerme(scheiben, pause);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		MainMenu test = new MainMenu();
	}

	public void menu() {
		this.getContentPane().removeAll();
		JLabel halloText = new JLabel("Willkommen zu den Türmen von Hanoi in der XMas-Edition!", SwingConstants.CENTER);

		halloText.setBackground(new Color(0xffffff));
		halloText.setFont(new Font("Brush Script MT", Font.PLAIN, 45));
		halloText.setForeground(new Color(0xffffff));
		halloText.setAlignmentX(CENTER_ALIGNMENT);
		this.add(halloText);

		this.add(Box.createRigidArea(new Dimension(0, 30)));

		playButton = new PanelButton("Hier kannst du es selbst mal versuchen!");
		playButton.getButton().addActionListener(e -> meldung());
		playAnimation = new PanelButton("Hier geht's zur Animation!");
		playAnimation.getButton().addActionListener(this);
		settings = new PanelButton("Einstellungen");
		settings.getButton().addActionListener(this);
		this.add(playButton);
		this.add(playAnimation);
		this.add(settings);

	}

	public void animation() {
		this.getContentPane().removeAll();
		this.getContentPane().add(animation);
		animation.start();
		this.revalidate();

	}

	public void options() {
		this.getContentPane().removeAll();
		Options options = new Options(bgColor, animation,this);
		this.getContentPane().add(options);
		this.revalidate();
	}

	public void meldung() {
		JOptionPane.showMessageDialog(null, "Diese Funktion ist zur Zeit nicht verfügbar!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playAnimation.getButton()) {
			animation();
		}
		if (e.getSource() == settings.getButton()) {
			options();
		}
	}

}
