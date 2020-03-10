package lecture5;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class Form extends JFrame implements ActionListener {
	JLabel given, family, email, comment; // fields
	JTextField gt, ft, et; // for user input
	JButton submit, more, stop; // buttons

	PrintWriter file; // for writing to a file
	
	private JLabel setupLabel(String s, int style, Container c) {
		JLabel l = new JLabel(s, JLabel.CENTER);
		l.setFont(new Font("serif", style, 18));
		c.add(l);
		return l;
	}
	
	private JButton setupButton(String s, Container c) {
		JButton b = new JButton(s);
		b.setFont(new Font("serif", Font.ITALIC, 18));
		c.add(b);
		b.addActionListener(this);
		return b;
	}
	
	private JTextField setupTextField(Container c) {
		JTextField t = new JTextField();
		t.setFont(new Font("serif", Font.PLAIN, 18));
		c.add(t);
		return t;
	}

	
	public Form() {
		setLayout(new GridLayout(4, 2)); // form grid

		// set up and add the field labels and text fields
		given = setupLabel("Given Name", Font.PLAIN, this);
		gt = setupTextField(this);
		family = setupLabel("Family Name", Font.PLAIN, this);
		ft = setupTextField(this);
		email = setupLabel("Email", Font.PLAIN, this);
		et = setupTextField(this);
		comment = setupLabel("", Font.ITALIC, this);

		// set up, add, and register listener of the button
		submit = setupButton("SUBMIT", this);
		more = new JButton("MORE");
		more.setFont(new Font("serif", Font.ITALIC, 18));
		more.addActionListener(this);
		stop = new JButton("STOP");
		stop.setFont(new Font("serif", Font.ITALIC, 18));
		stop.addActionListener(this);
		
		// also setup more and stop, but don’t yet add them!
		
	}

	// handle events from buttons
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			doSubmit();
		} else if(e.getSource() == more) {
			doMore();
		} else if(e.getSource() == stop) {
			doStop();
		}
	} // will be called when submit button is pressed

	void doSubmit() {
		// make sure valid input has been entered
		if (gt.getText().equals(""))
			comment.setText("Enter given name");
		else if (ft.getText().equals(""))
			comment.setText("Enter family name");
		else if (et.getText().equals(""))
			comment.setText("Enter email address");
		else
		// if valid, then save input to disk file
		{
			file.println(gt.getText());
			file.println(ft.getText());
			file.println(et.getText());
			// and swap comment/submit with more/stop buttons
			remove(comment);
			comment.setVisible(false);
			remove(submit);
			submit.setVisible(false);
			add(more);
			more.setVisible(true);
			add(stop);
			stop.setVisible(true);
			setVisible(true);
		}
	}

	// will be called when more button is pressed
	void doMore() {
		// reset text input fields
		comment.setText("");
		gt.setText("");
		ft.setText("");
		et.setText("");
		// replace more/stop with comment/submit 
		remove(more);
		more.setVisible(false);
		remove(stop);
		stop.setVisible(false);
		add(comment);
		comment.setVisible(true);
		add(submit);
		submit.setVisible(true);
		setVisible(true);
	}

	// will be called when stop button is pressed
	void doStop() {
		file.close();
		System.exit(0);
	} // setup the printwriter to write to a specified file

	public void setup() throws IOException {
		file = new PrintWriter(new FileWriter("register.log"), true);
	}
}

public class TestForm {

	public static void main(String[] args) throws IOException {
		Form f = new Form();
		f.setSize(500, 220);
		f.setTitle("Form");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setup();
	}

}
