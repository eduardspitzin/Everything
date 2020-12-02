package de.ituvsoft.tuermevonhanoiTest;

import java.awt.*;
import javax.swing.*;
import javax.swing.OverlayLayout;

import de.ituvsoft.tuermevonhanoi.Slice;
public class OverlayLayoutTest extends JFrame {
   public OverlayLayoutTest() {
      setTitle("OverlayLayout Test");
      JPanel panel = new JPanel() {
         public boolean isOptimizedDrawingEnabled() {
            return false;
         }
      };
      LayoutManager overlay = new OverlayLayout(panel);
      panel.setLayout(overlay);
      JPanel tests = new Slice(5,200,200);
      panel.add(tests);
      JButton button = new JButton("Small");
      button.setMaximumSize(new Dimension(75, 50));
      button.setBackground(Color.white);
      panel.add(button);
      button = new JButton("Medium Btn");
      button.setMaximumSize(new Dimension(125, 75));
      button.setBackground(Color.lightGray);
      panel.add(button);
      button = new JButton("Large Button");
      button.setMaximumSize(new Dimension(200, 100));
      button.setBackground(Color.orange);
      panel.add(button);
      add(panel, BorderLayout.CENTER);
      setSize(400, 300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }  
   public static void main(String args[]) {
      new OverlayLayoutTest();
   }
}
