package LectureX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Photo1 extends JFrame {  
	private JLabel p;

	public Photo1() { 
		p = new JLabel("",JLabel.CENTER);

		add(p);
	}

	public void setPhoto(String s) {
		p.setIcon(new ImageIcon(s));
	}
}

class TestPhoto1 { 
	public static void main(String [] args) {
		Photo1 p = new Photo1();
		p.setSize(400,420);
		p.setVisible(true);
		p.setTitle("Photo1");
		p.addWindowListener(
				new WindowAdapter() {  
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		p.setPhoto("images/EE5.jpg");
	}
}
