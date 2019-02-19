package BlackWhite;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;

public class TestBlackWhite {

	public static void main(String[] args) {
		JFrame frame = new BlackWhiteFrame();
		frame.setSize(800, 400);
		frame.setTitle("BlackWhite");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		((BlackWhiteFrame)frame).flash();
	}

}
