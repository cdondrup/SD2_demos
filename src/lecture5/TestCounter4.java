package lecture5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Counter4 extends JFrame implements ActionListener {
	JLabel output;
	JButton up, down, zero;
	JPanel p;
	int value = 0;
	
	public Counter4() {
		Font f = new Font("Serif", Font.ITALIC, 36);
		setLayout(new GridLayout(2, 1));
		
		output = new JLabel(""+value, JLabel.CENTER);
		output.setFont(f);
		output.setBackground(Color.WHITE);
		output.setOpaque(true);
		add(output);
		
		p = new JPanel();
		p.setLayout(new GridLayout(1, 3));
		
		up = new C4Button("+");
		up.addActionListener(this);
		p.add(up);
		
		down = new C4Button("-");
		down.addActionListener(this);
		p.add(down);
		
		zero = new C4Button("0");
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

public class TestCounter4 {

	public static void main(String[] args) {
		Counter4 c = new Counter4();
		c.setSize(200,120);
		c.setTitle("Counter");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}

}
