package de.ituvsoft.tuermevonhanoi;

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
	ArrayList<Stack<Integer>> testTuerme;
	int scheiben = 5;
	boolean pause = false;
	
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
	
	
	ArrayList<Stack<Integer>> testTuerme = new ArrayList<Stack<Integer>>();
	testTuerme.add(new Stack<Integer>());
	testTuerme.add(new Stack<Integer>());
	testTuerme.add(new Stack<Integer>());
	testTuerme.get(0).add(1);
	testTuerme.get(0).add(3);
	testTuerme.get(0).add(2);
	this.testTuerme = testTuerme;
	
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
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		MainMenu test = new MainMenu();
	}

	public void animation() {
		TowersOfHanoi algorithm = new TowersOfHanoi(scheiben,pause);
		
		animation = new TannenTuerme(testTuerme,false);
		this.getContentPane().removeAll();
		this.getContentPane().add(animation);
		this.revalidate();
		
	}
	
	public void meldung() {
		JOptionPane.showMessageDialog(null,"Diese Funktion ist zur Zeit nicht verfügbar!");
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==playButton) {
			String m = JOptionPane.showInputDialog("Dieser Modus ist zur Zeit nicht verfügbar!");
			System.out.println(m);
			System.out.println("hallo");
		}
		
	}

}
