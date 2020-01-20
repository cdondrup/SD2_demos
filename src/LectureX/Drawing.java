package LectureX;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

class DrawingPanel extends JPanel {
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Line2D.Double(1.0, 1.0, 400.0, 400.0));
		g2.draw(new Ellipse2D.Double(getWidth()/2-50, getHeight()/2-75,
                100,
                150));
		g2.draw(new Ellipse2D.Double(getWidth()/2-100, getHeight()/2-75,
                100,
                150));
	}
}

class Drawing extends JFrame {
	public Drawing() {
		add(new DrawingPanel());
	}
}

class TestDrawing {

	public static void main(String[] args) {
		Drawing d = new Drawing();
		d.setSize(400,420);
		d.setVisible(true);
		d.setTitle("Drawing");
		d.addWindowListener(
				new WindowAdapter() {  
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
	}

}
