import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

class CountDown extends JFrame implements ActionListener {
	private JLabel time;
	private JTextField in;
	private JPanel timePanel, buttons;
	private JButton start, stop, reset;
	private boolean isRunning;
	int value, current;
	Timer timer;
	
	public CountDown() {
		setLayout(new GridLayout(2, 1));
		timer = new Timer(true);
		timePanel = new JPanel(new BorderLayout());
		time = new JLabel("", JLabel.CENTER);
		time.setFont(new Font("Comic Sans", Font.BOLD, 26));
		
		in = new JTextField();
		in.setFont(new Font("Comic Sans", Font.BOLD, 26));
		in.addActionListener(this);
		timePanel.add(in);
		add(timePanel);
		
		buttons = new JPanel(new GridLayout(1, 3));
		start = setupButton("Start", buttons);
		stop = setupButton("Stop", buttons);
		reset = setupButton("Reset", buttons);
		add(buttons);
		
		stop.setEnabled(false);
		reset.setEnabled(false);
		isRunning = false;
	}
	
	private JButton setupButton(String s, Container c) {
		JButton b = new JButton(s);
		b.setFont(new Font("Comic Sans", Font.BOLD, 18));
		c.add(b);
		b.addActionListener(this);
		return b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(isRunning) {
			if(e.getSource() == reset) {
				current = value;
				timer.cancel();
				startTimer();
			} else if(e.getSource() == stop) {
				start.setEnabled(true);
				stop.setEnabled(false);
				timer.cancel();
				timePanel.remove(time); time.setVisible(false);
				timePanel.add(in); in.setVisible(true);
				isRunning = false;
			}
		} else {
			if(e.getSource() == in || e.getSource() == start) {
				value = Integer.parseInt(in.getText());
				current = value;
			} else if(e.getSource() == reset) {
				current = value;
			}
			start.setEnabled(false);
			reset.setEnabled(true);
			stop.setEnabled(true);
			timePanel.remove(in); in.setVisible(false);
			timePanel.add(time); time.setVisible(true);
			isRunning = true;
			startTimer();
			setVisible(true);
		}
	}
	
	private void startTimer() {
		timer = new Timer(true);
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				current--;
				if(current >= 0)
					time.setText((current/60 >9 ? current/60 : "0" + current/60)+":"+(current%60 >9 ? current%60 : "0" + current%60));				
			}
		};
		
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
}

class RunCountDown {

	public static void main(String[] args) {
		CountDown c = new CountDown();
		c.setTitle("Final Count Down");
		c.setSize(400, 220);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		c.setLocation((int)(d.getWidth()/2)-200, (int)(d.getHeight()/2)-110);
		c.setVisible(true);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
