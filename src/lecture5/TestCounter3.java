package lecture5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Counter3 extends JFrame implements ActionListener {
	JLabel output;
	JButton up, down, zero;
	JPanel p;
	int value = 0;
	
	public Counter3() {
		Font f = new Font("Serif", Font.ITALIC, 36);
		setLayout(new GridLayout(2, 1));
		
		output = new JLabel(""+value, JLabel.CENTER);
		output.setFont(f);
		output.setBackground(Color.WHITE);
		output.setOpaque(true);
		add(output);
		
		p = new JPanel();
		p.setLayout(new GridLayout(1, 3));
		
		up = C3Button("+");
		up.addActionListener(this);
		p.add(up);
		
		down = C3Button("-");
		down.addActionListener(this);
		p.add(down);
		
		zero = C3Button("0");
		zero.addActionListener(this);
		p.add(zero);
		
		add(p);
		
	}
	
	private JButton C3Button(String text) {
		JButton b = new JButton(text);
		b.setFont(new Font("Serif", Font.ITALIC, 36));
		b.setBackground(Color.WHITE);
		b.setOpaque(true);
		return b;
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

public class TestCounter3 {

	public static void main(String[] args) {
		Counter3 c = new Counter3();
		c.setSize(200,120);
		c.setTitle("Counter");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}

}
