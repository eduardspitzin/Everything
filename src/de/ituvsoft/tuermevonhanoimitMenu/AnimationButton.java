package de.ituvsoft.tuermevonhanoimitMenu;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AnimationButton extends JButton {

	public AnimationButton(String bild) {
		this.setBorderPainted(false);
		this.setBorder(null);
		this.setFocusable(false);
		this.setMargin(new Insets(0, 0, 0, 0));
		this.setContentAreaFilled(false);
		this.setIcon(new ImageIcon(bild));

	}

}
