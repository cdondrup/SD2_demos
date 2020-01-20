package LectureX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Photo1b extends JFrame {  
	private JLabel p;
	private JScrollPane sp;

	public Photo1b() { 
		p = new JLabel("",JLabel.CENTER);
		sp = new JScrollPane();
		sp.setViewportView(p);

		add(sp);
	}

	public void setPhoto(String s) {
		p.setIcon(new ImageIcon(s));
	}
}

class TestPhoto1b { 
	public static void main(String [] args) {
		Photo1b p = new Photo1b();
		p.setSize(400,420);
		p.setVisible(true);
		p.setTitle("Photo1b");
		p.addWindowListener(
				new WindowAdapter() {  
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		p.setPhoto("images/EE5.jpg");
	}
}
