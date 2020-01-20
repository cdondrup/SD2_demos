package StopSign;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

class Stopsign extends JFrame implements ActionListener {
	private JLabel l;
	private JButton sb;
	boolean isStopped = false;

	public Stopsign() {
		setLayout(new GridLayout(2, 1));
		Font f = new Font("Serif", Font.ITALIC, 36);
		l = new JLabel();
		l.setOpaque(true);
		l.setBackground(Color.GREEN);
		add(l);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 2));
		
		sb = new JButton("Stop");
		sb.addActionListener(this);
		sb.setFont(f);
		add(sb);
//		
//		gb = new JButton("Go");
//		gb.addActionListener(this);
//		gb.setFont(f);
//		gb.setEnabled(false);
//		p.add(gb);

//		add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sb) {
			if(isStopped) {
				l.setBackground(Color.GREEN);
				sb.setText("Stop");
				isStopped = false;
			} else {
				l.setBackground(Color.red);
				sb.setText("Go");
				isStopped = true;
			}
		}
		
//		if(e.getSource() == sb) {
//			l.setBackground(Color.red);
//			gb.setEnabled(true);
//			sb.setEnabled(false);
//		}
//		if(e.getSource() == gb) {
//			l.setBackground(Color.green);
//			gb.setEnabled(false);
//			sb.setEnabled(true);
//		}
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
