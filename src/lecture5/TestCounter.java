package lecture5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Counter extends JFrame implements ActionListener {
	JLabel output;
	JButton up, down, zero;
	JPanel p;
	int value = 0;
	
	public Counter() {
		Font f = new Font("Serif", Font.ITALIC, 36);
		setLayout(new GridLayout(2, 1));
		
		output = new JLabel(""+value, JLabel.CENTER);
		output.setFont(f);
		output.setBackground(Color.WHITE);
		output.setOpaque(true);
		add(output);
		
		p = new JPanel();
		p.setLayout(new GridLayout(1, 3));
		
		up = new JButton("+");
		up.setFont(f);
		up.setBackground(Color.WHITE);
		up.setOpaque(true);
		up.addActionListener(this);
		p.add(up);
		
		down = new JButton("-");
		down.setFont(f);
		down.setBackground(Color.WHITE);
		down.setOpaque(true);
		down.addActionListener(this);
		p.add(down);
		
		zero = new JButton("0");
		zero.setFont(f);
		zero.setBackground(Color.WHITE);
		zero.setOpaque(true);
		zero.addActionListener(this);
		p.add(zero);
		
		add(p);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == up) {
			value++;
		} else if (e.getSource() == down) {
			value--;
		} else if(e.getSource() == zero) {
			value = 0;
		}
		output.setText(""+value);
	}
}

public class TestCounter {

	public static void main(String[] args) {
		Counter c = new Counter();
		c.setSize(200,120);
		c.setTitle("Counter");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}

}
