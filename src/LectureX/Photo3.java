package LectureX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Photo3 extends JFrame { 
	private ImageLabel1 l;

	public Photo3(String imageName) {
		l = new ImageLabel1(new ImageIcon(imageName));

		add(l);
	}
}

class TestPhoto3 {  
	public static void main(String [] args) {  
		Photo3 p = new Photo3("images/EE5.jpg");
		p.setSize(400,420);
		p.setVisible(true);
		p.setTitle("Photo2");
		p.addWindowListener(
				new WindowAdapter() {  
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
	}
}
