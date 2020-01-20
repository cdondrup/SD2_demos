package images;

import java.awt.Dimension;
import java.awt.*;

import javax.swing.*;

class Photo extends JFrame {
	private ImageLabel l;
//	private JScrollPane sp;
	
	public Photo(String filename) {
		l = new ImageLabel(new ImageIcon(filename));
//		sp = new JScrollPane();
//		sp.setViewportView(l);
		add(l);
	}
	
	public void setPhoto(String filename ) {
		ImageIcon i = new ImageIcon(filename);
		Image i2 = i.getImage();
		Image i3 = scaleImage(l.getWidth(), l.getHeight(), i2);
		l.setIcon(new ImageIcon(i3));
	}
	
	private Dimension getScaledDimension(double iw, double ih, double mw, double mh) {
		double wRatio = mw/iw;
		double hRatio = mh/ih;
		double ratio = wRatio < hRatio ? wRatio : hRatio;
		return new Dimension((int)(iw*ratio), (int)(ih*ratio));
	}
	
	private Image scaleImage(int mw, int mh, Image i) {
		Dimension d = getScaledDimension(i.getWidth(null), i.getHeight(null), mw, mh);
		return i.getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_SMOOTH);
	}
}

class RunPhoto {

	public static void main(String[] args) {
		Photo p = new Photo("images/EE5.jpg");
		p.setSize(400, 420);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		p.setLocation((int)(d.getWidth()/2-200), (int)(d.getHeight()/2-210));
		p.setTitle("Photo");
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setVisible(true);
	}

}
