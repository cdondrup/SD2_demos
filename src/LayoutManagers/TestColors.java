package LayoutManagers;
import java.awt.*;
import java.io.*;
import javax.swing.*;

class Colours extends JFrame {
	private JLabel C, T;

	public Colours() {
		C = new JLabel();
		C.setBackground(Color.white);
		C.setOpaque(true);
		T = new JLabel("", JLabel.CENTER);
		T.setFont(new Font("Serif", Font.BOLD, 36));
		T.setBackground(Color.white);
		T.setOpaque(true);
		setLayout(new GridLayout(2, 1));
		add(C);
		add(T);
	}

	public void setColour(String name) {
		Color colour = Color.white;
		if (name.equals("green"))
			colour = Color.green;
		else if (name.equals("red"))
			colour = Color.red;
		else if (name.equals("blue"))
			colour = Color.blue;
		else
			name = "?" + name + "?";
		C.setBackground(colour);
		T.setText(name);
	}
}

public class TestColors {

	public static void main(String[] args) {
		final BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		final PrintWriter screen = new PrintWriter(System.out, true);

		Colours c;
		c = new Colours();
		c.setSize(300, 320);
		c.setTitle("Border");
		c.setVisible(true);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			screen.println("Enter name of colour");
			try {
				c.setColour(keyboard.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
