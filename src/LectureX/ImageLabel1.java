package LectureX;

import java.awt.*;
import javax.swing.*;

public class ImageLabel1 extends JLabel{
    private Image myImage;

    public ImageLabel1(ImageIcon icon){
    	super(icon);
        myImage = icon.getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
