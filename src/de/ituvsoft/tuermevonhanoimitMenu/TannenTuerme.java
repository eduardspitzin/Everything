package de.ituvsoft.tuermevonhanoimitMenu;

import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TannenTuerme extends JPanel implements ActionListener {
	int x_coordinates;
	TowersOfHanoi algorithm;
	int y_coordinates;
	int xSource;
	int ySource;
	int widthAn;
	int width;
	int widthProduct;
	int height = 40;
	int bStammWidth;
	int bStammHeight;
	ArrayList<Stack<Integer>> currentTowers;
	ArrayList<Stack<Integer>> newTowers;
	int[] baumX;
	int[] baumY;
	int maxYStamm;
	Timer timer = new Timer(10, this);
	int dTowerNumber;
	int incTowerNumber;
	int maxSlices;
	boolean xWanderung;
	boolean xRichtig;
	boolean yRichtig;
	boolean isAnimated;
	int xGoal;
	int yGoal;
	boolean running;
	boolean pause = true;
	int actualSlices;
	boolean paused;
	int speed = 2;
	Thread algorithmThread;
	int scheiben;
	Image hintergrundBild;
	String wallPaper;
	MainMenu menu;
	AnimationButton cancelButton;
	AnimationButton continueButton;
	AnimationButton nStepButton;
	ImageIcon contin;
	ImageIcon continPressed;
	Color sliceColor;
	Color stammColor;

	public TannenTuerme(int scheiben) {
		wallPaper = "WallPaper1.jpg";
		this.scheiben = scheiben;
		baumX = new int[] { 320, 640, 960 };
		baumY = new int[] { 550, 550, 550 };
		bStammWidth = 30;
		bStammHeight = 140;
		widthProduct = 20;
		currentTowers = new ArrayList<Stack<Integer>>();
		for (int i = 0; i < 3; i++)
			currentTowers.add(new Stack<Integer>());

		ButtonListener bListener = new ButtonListener(this, menu);
		cancelButton = new AnimationButton("C:/Users/es0072/Desktop/tvh/Cancel.png");
		cancelButton.setPressedIcon(new ImageIcon("C:/Users/es0072/Desktop/tvh/Cancel Pressed.png"));
		cancelButton.addActionListener(bListener);
		this.add(cancelButton);

		contin = new ImageIcon("C:/Users/es0072/Desktop/tvh/Continue.png");
		continPressed = new ImageIcon("C:/Users/es0072/Desktop/tvh/Continue Pressed.png");
		continueButton = new AnimationButton("C:/Users/es0072/Desktop/tvh/Continue.png");
		continueButton.setPressedIcon(continPressed);
		continueButton.addActionListener(bListener);
		this.add(continueButton);

		nStepButton = new AnimationButton("C:/Users/es0072/Desktop/tvh/Next Step.png");
		nStepButton.setPressedIcon(new ImageIcon("C:/Users/es0072/Desktop/tvh/Next Step Pressed.png"));
		nStepButton.addActionListener(bListener);
		this.add(nStepButton);

		sliceColor = new Color(0x00, 0x71, 0x23);
		stammColor = new Color(0x7b, 0x59, 0x42);
	}

	public void start() {
		try {
			hintergrundBild = ImageIO.read(new File("C:/Users/es0072/Desktop/tvh/" + wallPaper));
		} catch (IOException e) {
			e.printStackTrace();
		}
		algorithm = new TowersOfHanoi(scheiben);
		newTowers = algorithm.towers;
		deepCopy(newTowers, currentTowers);
		maxSlices = newTowers.get(0).size();
		maxYStamm = Integer.min(Integer.min(baumY[0], baumY[1]), baumY[2]);
		algorithmThread = new Thread(algorithm);
		algorithmThread.start();

	}

	private void drawSlices(Graphics g) {
		for (int i = 0; i < 3; i++) {
			int vZahl = Integer.compare(currentTowers.get(i).size(), newTowers.get(i).size());
			if (vZahl == 1) {
				dTowerNumber = i;
			} else if (vZahl == -1) {
				incTowerNumber = i;

			}

		}

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < currentTowers.get(j).size(); i++) {
				width = widthProduct * currentTowers.get(j).get(i);
				y_coordinates = baumY[j] - (height * (1 + i));
				x_coordinates = baumX[j] - width / 2 + (bStammWidth / 2);
				g.setColor(sliceColor);
				isAnimated = i == currentTowers.get(j).size() - 1 && j == dTowerNumber; // Letzte Scheibe und Turm
																						// welcher Scheibe verliert
				if (isAnimated && !running) {
					xSource = x_coordinates;
					ySource = y_coordinates;
					widthAn = widthProduct * currentTowers.get(j).get(i);
					xGoal = baumX[incTowerNumber] - widthAn / 2 + (bStammWidth / 2);
					yGoal = baumY[incTowerNumber] - (height * (1 + currentTowers.get(incTowerNumber).size()));// Baumstamm
																												// Y -
																												// Scheiben
																												// die
																												// drauf
																												// sind

				} else if (!isAnimated) {

					g.fillRect(x_coordinates, y_coordinates, width, height);

				}

			}

		}

	}

	private void drawAnimation(Graphics g) {
		g.fillRect(xSource, ySource, widthAn, height);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hintergrundBild, 0, 0, this);
		g.setColor(stammColor);

		for (int i = 0; i < 3; i++) {
			g.fillRect(baumX[i], baumY[i], bStammWidth, bStammHeight);
		}
		drawSlices(g);
			drawAnimation(g);
		if (currentTowers.get(2).size() == maxSlices)
			timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		running = true;
		actualSlices = Integer.max(Integer.max(currentTowers.get(0).size(), currentTowers.get(1).size()),
				currentTowers.get(2).size());
		xRichtig = xGoal == xSource;
		yRichtig = ySource == yGoal;

		if (maxYStamm - height * (actualSlices + 2) < ySource) {
			ySource = ySource - speed;
		}
		if (xGoal - xSource > 0) {
			xSource += speed;

		}
		if (xGoal - xSource < 0) {
			xSource -= speed;
		}

		if (xRichtig && ySource < yGoal) {
			ySource += speed * 2;

		}
		this.repaint();
		if (xRichtig && yRichtig) {
			algorithm.setWaiting(false);
			if (pause)
				timer.stop();
			running = false;
			for (int j = 0; j < 3; j++)
				currentTowers.get(j).clear();
			deepCopy(newTowers, currentTowers);
			algorithm.wait = false;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}
	}

	private static void deepCopy(ArrayList<Stack<Integer>> copiedList, ArrayList<Stack<Integer>> inputList) {
		for (int i = 0; i < copiedList.size(); i++) {
			for (int j = 0; j < copiedList.get(i).size(); j++)
				inputList.get(i).add(j, copiedList.get(i).get(j));

		}

	}

	public void setMenu(MainMenu menu) {
		this.menu = menu;
	}
}