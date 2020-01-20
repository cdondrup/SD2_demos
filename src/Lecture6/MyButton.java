package Lecture6;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton {
	public MyButton(String s, Container c, ActionListener l) {
		super(s);
		setFont(new Font("sansserif", Font.PLAIN, 18));
		setBackground(Color.WHITE);
		setOpaque(true);
		c.add(this);
		addActionListener(l);
	}
}
