package images;

import java.awt.*;

import javax.swing.*;

public class ImageLabel extends JLabel {
	private Image myImage;
	
	public ImageLabel(ImageIcon icon) {
		super(icon);
		myImage = icon.getImage();
	}
	
	private Dimension getScaledDimension(double iw, double ih, double mw, double mh) {
		double wRatio = mw/iw;
		double hRatio = mh/ih;
		double ratio = wRatio < hRatio ? wRatio : hRatio;
		return new Dimension((int)(iw*ratio), (int)(ih*ratio));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension d = getScaledDimension(myImage.getWidth(null), myImage.getHeight(null), getWidth(), getHeight());
		int x = (int)(getWidth()/2-d.getWidth()/2);
		int y = (int)(getHeight()/2-d.getHeight()/2);
		g.drawImage(myImage, x, y, (int)d.getWidth(), (int)d.getHeight(), null);
	}

}
