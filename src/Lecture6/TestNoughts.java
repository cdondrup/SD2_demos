package Lecture6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Noughts extends JFrame implements ActionListener {
	JLabel messages;
	JPanel board;
	JButton[][] squares;

	public Noughts() {
		squares = new JButton[3][3];
		board = new JPanel(new GridLayout(3,3));
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				squares[i][j] = new MyButton("", board, this);
			}
		}
		
		messages = new JLabel("Select a square to play X.", JLabel.CENTER);
		messages.setFont(new Font("Serif", Font.ITALIC, 18));
		messages.setBackground(Color.WHITE);
		messages.setOpaque(true);
		add(messages, BorderLayout.NORTH);
		add(board);
	}

	boolean checkwin(String mark) {
		boolean rwin, cwin;
		for (int i = 0; i < 3; i++) {
			rwin = true;
			cwin = true;
			for (int j = 0; j < 3; j++) {
				rwin = rwin && squares[i][j].getText().equals(mark);
				cwin = cwin && squares[j][i].getText().equals(mark);
			}
			if (rwin || cwin)
				return true;
		}
		return (squares[0][0].getText().equals(mark) && squares[1][1].getText().equals(mark)
				&& squares[2][2].getText().equals(mark))
				|| (squares[0][2].getText().equals(mark) && squares[1][1].getText().equals(mark)
						&& squares[2][0].getText().equals(mark));

	}

	boolean computerplay() {

		// iterate through buttons top-left to bottom-right
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (squares[i][j].getText().equals("")) {
					squares[i][j].setText("O");
					return true;
				}

		// returns false if no empty spaces are remaining
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(e.getSource() == squares[i][j]) {
					if(squares[i][j].getText().equals("")) {
						squares[i][j].setText("X");
						
						if(checkwin("X")) {
							messages.setText("You won!");
						} else if(!computerplay()) {
							messages.setText("Draw!");
						} else if(checkwin("O")){
							messages.setText("I won!");
						} else {
							messages.setText("Select a square to play");
							return;
						}
					}
				}
			}
		}
	}
}

public class TestNoughts {

	public static void main(String[] args) {
		Noughts n = new Noughts();
		n.setSize(200, 220);
		n.setTitle("Blocks");
		n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		n.setVisible(true);
	}

}
