package StopSign;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

class Stopsign extends JFrame {
	private JLabel l;
	private JButton sb;

	public Stopsign() {
		setLayout(new GridLayout(2, 1));
		Font f = new Font("Serif", Font.ITALIC, 36);
		
	}

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
