package LayoutManagers;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;

class Lights extends JFrame {
	private final int LIGHTNO = 3;
	private JLabel[] lights = new JLabel[LIGHTNO];
	private final long DELAY = 1000;
	private Font f = new Font("Serif",Font.BOLD,24);

	public Lights() {
		// 1x2 for panel example
		setLayout(new GridLayout(3, 1));
		lights[0] = new JLabel();
		lights[0].setBackground(Color.red);
		lights[1] = new JLabel();
		lights[1].setBackground(Color.white);
		lights[2] = new JLabel();
		lights[2].setBackground(Color.white);

		for(int i = 0; i < LIGHTNO; i++) {
			lights[i].setOpaque(true);
			add(lights[i]);
		}
		
		
	}

	private void pause(long millis) {
		long start = Calendar.getInstance().getTimeInMillis();
		while (Calendar.getInstance().getTimeInMillis() - start < millis) {
		}
	}

	public void change() {
		while (true) {
			// Set light sequence: red&orange, green, orange, red
			// Panel example: change text
			pause(DELAY);
			lights[1].setBackground(Color.ORANGE);
			pause(DELAY);
			lights[0].setBackground(Color.WHITE);
			lights[1].setBackground(Color.WHITE);
			lights[2].setBackground(Color.GREEN);
			pause(DELAY);
			lights[2].setBackground(Color.WHITE);
			lights[1].setBackground(Color.ORANGE);
			pause(DELAY);
			lights[1].setBackground(Color.WHITE);
			lights[0].setBackground(Color.RED);
		}
	}
}

public class TestLights {

	public static void main(String[] args) {
		Lights l;
		l = new Lights();
		l.setSize(300, 620);
		l.setTitle("Lights");
		l.setVisible(true);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.change();
	}

}
