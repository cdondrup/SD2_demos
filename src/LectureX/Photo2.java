package LectureX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Photo2 extends JFrame { 
	private JLabel l;

	public Photo2() {
		l = new JLabel("",JLabel.CENTER);

		add(l);
	}

	public void setPhoto(String s) {
		Image i1 = (new ImageIcon(s)).getImage();
		Image i2 = scaleImage(l.getWidth(),l.getHeight(),i1);
		l.setIcon(new ImageIcon(i2));
	}
	
	private Dimension getScaledDimension(double iw, double ih, double mw, double mh) {
    	double wRatio = mw/iw;
    	double hRatio = mh/ih;
    	double ratio = wRatio < hRatio ? wRatio : hRatio;
    	return new Dimension((int)(iw*ratio), (int)(ih*ratio));
    }

	private Image scaleImage(int lw, int lh, Image i) {
		Dimension d = getScaledDimension(
				i.getWidth(null), 
				i.getHeight(null), 
				lw, 
				lh);
		return i.getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_SMOOTH);
	}
}

class TestPhoto2 {  
	public static void main(String [] args) {  
		Photo2 p = new Photo2();
		p.setSize(400,420);
		p.setVisible(true);
		p.setTitle("Photo2");
		p.addWindowListener(
				new WindowAdapter() {  
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		p.setPhoto("images/EE5.jpg");
	}
}
