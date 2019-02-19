package LayoutManagers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Flow extends JFrame {
	private static final int LABNO = 6;
	private JLabel[] labels = new JLabel[LABNO];
	private Color[] colors = { Color.red, Color.blue, Color.green, Color.yellow, Color.pink, Color.orange };
	private static String[] words = { "RED", "BLUE", "GREEN", "YELLOW", "PINK", "ORANGE" };

	public Flow() {
		Font f = new Font("Sansserif", Font.BOLD, 24);
		// Set layout
		setLayout(new FlowLayout());
		
		
		// Add labels in loop (font, background, opaque)
		for(int i = 0; i < LABNO; i++) {
			labels[i] = new JLabel(words[i], JLabel.CENTER);
			add(labels[i]);
			labels[i].setFont(f);
			labels[i].setBackground(colors[i]);
			labels[i].setOpaque(true);
			
		}
	}
}

public class TestFlow {

	public static void main(String[] args) {
		Flow f;
		f = new Flow();
		f.setSize(300, 320);
		f.setTitle("Flow");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
