package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class ButtonListener implements ActionListener {
	TannenTuerme animation;
	MainMenu menu;
	int n = 0;

	public ButtonListener(TannenTuerme animation, MainMenu menu) {
		this.animation = animation;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == animation.nStepButton) {
			animation.timer.restart();

		}
		if (e.getSource() == animation.continueButton) {
			n++;
			if (n % 2 == 1) {
				animation.pause = false;
				animation.timer.restart();
				animation.continueButton.setPressedIcon(animation.contin);
				animation.continueButton.setIcon(animation.continPressed);
			} else {
				animation.pause = true;
				animation.continueButton.setIcon(animation.contin);
				animation.continueButton.setPressedIcon(animation.continPressed);

			}
		}
		if (e.getSource() == animation.cancelButton) {
			animation.timer.stop();
			animation.setVisible(false);
			animation.menu.resetAnimation();
			animation.menu.menu();
		}
	}

}
