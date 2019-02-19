package LayoutManagers;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class Grid extends JFrame {
	private static final int LABNO = 6;
	private JLabel[] labels = new JLabel[LABNO];
	private Color[] colors = { Color.red, Color.blue, Color.green, Color.yellow, Color.white, Color.lightGray };

	public Grid() {
		Font f = new Font("Sansserif", Font.BOLD, 18);
		// Set layout 3x2
		setLayout(new GridLayout(3, 2));
		// Create labels and add them in loop (background, font, opaque)
		for(int i = 0; i < LABNO; i++) {
			labels[i] = new JLabel(""+i, JLabel.CENTER);
			add(labels[i]);
			labels[i].setFont(f);
			labels[i].setBackground(colors[i]);
			labels[i].setOpaque(true);
			
		}
	}
}

public class GridTest {

	public static void main(String[] args) {
		Grid g;
		g = new Grid();
		g.setSize(300, 320);
		g.setTitle("Grid");
		g.setVisible(true);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
