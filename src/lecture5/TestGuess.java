package lecture5;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Guess extends JFrame implements ActionListener {
	int number;
	JLabel response, prompt, play;
	JTextField input;
	JButton stop, more;
	JPanel p1, p2;
	
	public Guess() {
		number = abs(new Random().nextInt() % 100 + 1);
		
		Font f = new Font("Serif", Font.ITALIC, 18);
		response = new JLabel("I'm thinking of a number between 1 and 100", JLabel.CENTER);
		add(response, BorderLayout.NORTH);
		response.setFont(f);
		
		p1 = new JPanel();
		prompt = new JLabel("Enter a number and press return");
		prompt.setFont(f);
		p1.add(prompt);
		
		input = new JTextField(3);
		p1.add(input);
		input.addActionListener(this);
		
		add(p1, BorderLayout.CENTER);
		
		p2 = new JPanel();
		play = new JLabel("Want to play again?", JLabel.CENTER);
		p2.add(play);
		more = createButton("More");
		more.addActionListener(this);
		p2.add(more);
		stop = createButton("Stop");
		stop.addActionListener(this);
		p2.add(stop);
 	}
	
	private JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setFont(new Font("Serif", Font.ITALIC, 18));
		b.setBackground(Color.WHITE);
		b.setOpaque(true);
		return b;
	}
	
	private int abs(int x) {
		return x < 0 ? -x : x;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input) {
			int value = Integer.parseInt(input.getText());
			if(number == value) {
				response.setText("Correct");
				remove(p1); p1.setVisible(false);
				add(p2); p2.setVisible(true);
			} else if(number > value) {
				response.setText("Low");
			} else if(number < value) {
				response.setText("High");
			}
		} else if(e.getSource() == more) {
			number = abs(new Random().nextInt() % 100 + 1);
			response.setText("Enter a number and press return");
			remove(p2); p2.setVisible(false);
			add(p1); p1.setVisible(true);
		} else if(e.getSource() == stop) {
			System.exit(0);
		}
	}
}

public class TestGuess {

	public static void main(String[] args) {
		Guess c = new Guess();
		c.setSize(350,90);
		c.setTitle("Guess");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);


	}

}
