package LectureX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Photo4 extends JFrame { 
	private ImageLabel2 l;

	public Photo4(String imageName) {
		l = new ImageLabel2(new ImageIcon(imageName));

		add(l);
	}
}

class TestPhoto4 {  
	public static void main(String [] args) {  
		Photo4 p = new Photo4("images/EE5.jpg");
		p.setSize(400,420);
		p.setVisible(true);
		p.setTitle("Photo4");
		p.addWindowListener(
				new WindowAdapter() {  
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
	}
}
