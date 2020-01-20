package Lecture6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Blocks extends JFrame implements ActionListener {
	JButton[][] blocks;
	int spaceI, spaceJ;
	
	public Blocks() {
		blocks = new JButton[3][3];
		setLayout(new GridLayout(3, 3));
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				blocks[i][j] = new MyButton(""+(i*3+j+1), this, this);
			}
		}
		
		blocks[2][2].setText("");
		
		spaceI = 2;
		spaceJ = 2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i < 3; i++) {
			for(int j=0; j<3; j++) {
				if(e.getSource() == blocks[i][j]) {
					if((i==spaceI && (j==spaceJ-1 || j == spaceJ +1))
							|| j==spaceJ && (i==spaceI-1 || i==spaceI+1)) {
						blocks[spaceI][spaceJ].setText(blocks[i][j].getText());
						blocks[i][j].setText("");
						spaceI=i;
						spaceJ=j;
					}
				}
			}
		}
	}
	
}
public class TestBlocks {

	public static void main(String[] args) {
		Blocks b = new Blocks();
		b.setSize(200, 220);
		b.setTitle("Blocks");
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setVisible(true);
	}

}
