package BlackWhite;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.JFrame;

public class BlackWhiteFrame extends JFrame {
	public BlackWhiteFrame() {
		getContentPane().setBackground(Color.black);
	}

	private void pause(long millis) {
		long startTime = Calendar.getInstance().getTimeInMillis();
		while(Calendar.getInstance().getTimeInMillis() - startTime < millis);
	}

	public void flash() {
		while(true) {
			pause(500);
			getContentPane().setBackground(Color.white);
			pause(500);
			getContentPane().setBackground(Color.black);
		}
	}
}
