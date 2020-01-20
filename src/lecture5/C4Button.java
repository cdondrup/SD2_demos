package lecture5;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class C4Button extends JButton {
	public C4Button(String text) {
		super(text);
		setFont(new Font("Serif", Font.ITALIC, 36));
		setBackground(Color.WHITE);
		setOpaque(true);
	}
}
