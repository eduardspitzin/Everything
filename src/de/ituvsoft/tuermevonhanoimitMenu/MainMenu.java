package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class MainMenu extends JFrame implements ActionListener {
	
	JLabel halloText;
	PanelButton playButton;
	PanelButton playAnimation;
	PanelButton settings;
	TannenTuerme animation;
	JButton testknopf;
	int scheiben = 5;
	boolean pause = false;
	
	ArrayList<Stack<Integer>> towers;
	
	
	
	public MainMenu() {
	this.setTitle("Die Türme von Hanoi");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1000, 600);
	this.setResizable(false);
	this.getContentPane().setBackground(new Color(0xcd1c2e));
	this.setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
	this.add(Box.createRigidArea(new Dimension(0,30)));
	

	JLabel halloText = new JLabel("Willkommen zu den Türmen von Hanoi in der XMas-Edition!",SwingConstants.CENTER);
	
	halloText.setBackground(new Color(0xffffff));
	halloText.setFont(new Font("Brush Script MT",Font.PLAIN,45));
	halloText.setForeground(new Color(0xffffff));
	halloText.setAlignmentX(CENTER_ALIGNMENT);
	this.setFocusable(false);
	this.add(halloText);
	
	this.add(Box.createRigidArea(new Dimension(0,30)));

	
	testknopf = new JButton("testtest");
	testknopf.addActionListener(this);
	this.add(testknopf);
	
	playButton = new PanelButton("Hier kannst du es selbst mal versuchen!");
	playButton.getButton().addActionListener(e->meldung());
	playAnimation = new PanelButton("Hier geht's zur Animation!");
	playAnimation.getButton().addActionListener(e->animation());
	settings = new PanelButton("Einstellungen");
	this.add(playButton);
	this.add(playAnimation);
	this.add(settings);
	
	
	this.setVisible(true);
	}
	



	public void initTowers(int n) {

		towers = new ArrayList<Stack<Integer>>();
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());

		for (int i = n; i > 0; i--) {
			towers.get(0).push(i);
		}
		for (Stack<Integer> ausgabe : towers) {
			System.out.println(ausgabe);
		}
		System.out.println(" ");

	}
	public void move(int n, int fromTower, int toTower, int usingTower, boolean pause) {

		if (n >= 1) {

			move(n - 1, fromTower, usingTower, toTower, pause);

			towers.get(toTower - 1).push(towers.get(fromTower - 1).pop());
			animation.setNewTowers(towers);
			this.repaint();
			
			while(!animation.xRichtig || !animation.yRichtig || animation.paused ) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			animation.xRichtig = false;
			animation.yRichtig = false;
	
			for (Stack<Integer> ausgabe : towers) {
				System.out.println(ausgabe);
			}
			System.out.println(" ");
			move(n - 1, usingTower, toTower, fromTower, pause);
		}

	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		MainMenu test = new MainMenu();
		//test.animation();
	}

	public void animation() {
		this.getContentPane().removeAll();
		this.initTowers(5);
		animation = new TannenTuerme(towers,false);
		this.getContentPane().add(animation);
		this.revalidate();
		System.out.println("Ich bin bei Animation!");
		this.move(5, 1, 3, 2, false);

		

		
	}
	
	public void meldung() {
		JOptionPane.showMessageDialog(null,"Diese Funktion ist zur Zeit nicht verfügbar!");
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==testknopf) {
			System.out.println("Hey");
			animation();
		}
		
	}

}
