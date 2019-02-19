package LayoutManagers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Border extends JFrame {
	public Border() {
		//Get cpane and create font.
		Container cpane = getContentPane();
		Font f = new Font("Sansserif", Font.BOLD, 18);
		
		// ---- Top ----
		// Create Label for TOP
		JLabel N = new JLabel("TOP", JLabel.CENTER);
		N.setFont(f);
		N.setBackground(Color.WHITE);
		N.setOpaque(true);
		// Add label to cpane
		cpane.add(N, BorderLayout.NORTH);
		
		// ---- Right ----
		JLabel E = new JLabel("RIGHT", JLabel.CENTER);
		E.setFont(f);
		E.setBackground(Color.green);
		E.setOpaque(true);
		// Add label to cpane
		cpane.add(E, BorderLayout.EAST);
		
		// ---- Bottom ----
		JLabel S = new JLabel("Bottom", JLabel.CENTER);
		S.setFont(f);
		S.setBackground(Color.lightGray);
		S.setOpaque(true);
		// Add label to cpane
		cpane.add(S, BorderLayout.SOUTH);
		
		// ---- Left ----
		JLabel W = new JLabel("LEFT", JLabel.CENTER);
		W.setFont(f);
		W.setBackground(Color.YELLOW);
		W.setOpaque(true);
		// Add label to cpane
		cpane.add(W, BorderLayout.WEST);
		
		// ---- Middle ----
		JLabel C = new JLabel("CENTRE", JLabel.CENTER);
		C.setFont(f);
		C.setBackground(Color.BLACK);
		C.setForeground(Color.WHITE);
		C.setOpaque(true);
		// Add label to cpane
		cpane.add(C, BorderLayout.CENTER);
	}
}

public class TestBorder {
	public static void main(String[] args) {
		Border b;
		b = new Border();
		b.setSize(300, 320);
		b.setTitle("Border");
		b.setVisible(true);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
