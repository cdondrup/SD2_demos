package Lecture6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Keypad extends JFrame implements ActionListener {
	long value = 0;
	final int DISPLAYS = 10;
	final int KEYS = 10;
	JButton[] keys = new JButton[KEYS];
	JLabel[] displays = new JLabel[DISPLAYS];
	JButton CLR;
	
	public Keypad() {
		JPanel d, k;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

public class TestKeypad {

	public static void main(String[] args) {
		Keypad k = new Keypad();
		k.setSize(200, 320);
		k.setTitle("Keypad");
		k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		k.setVisible(true);
	}

}
