package de.ituvsoft.tuermevonhanoi;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainMenu extends JFrame {
	
	JPanel look;
	JLabel halloText;
	
	
	public MainMenu() {
	this.setTitle("Die Türme von Hanoi");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1000, 600);
	this.setResizable(false);
	this.getContentPane().setBackground(new Color(0xcd1c2e));
	this.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		MainMenu test = new MainMenu();
	}

}
