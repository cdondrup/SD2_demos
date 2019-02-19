package StopSign;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Stopsign extends JFrame {
	JLabel l;
	JButton sb, gb;
	boolean isStopped = false;
	// For stop go: add panel 1x2

	public Stopsign() {
		setLayout(new GridLayout(2, 1));
		Font f = new Font("Serif", Font.ITALIC, 36);

		// add label (green, opaque)
		
		// add STOP button (font, white, opaque)

		// add action listener


	}

	// Add actionPerformed that sets color to red

}

public class TestStopsign {

	public static void main(String[] args) {
		Stopsign s = new Stopsign();
		s.setSize(200,120);
		s.setTitle("Stopsign");
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
