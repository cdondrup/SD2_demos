package Lecture7;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

// An ID consists of a login name and a password
class ID {
	String login, password;

	ID(String l, String p) {
		login = l;
		password = p;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
}

class Login extends JFrame implements ActionListener {
	private JLabel prompt; // for messages to user
	private JTextField entry; // for user to enter login details
	private ID[] details; // names and passwords
	private int n = 0; // number of IDs read in
	private final int MAXID = 100;
	private int idno;
	
	private static final int LCHECK = 0;
	private static final int PCHECK = 1;
	private static final int SUCCESS = 2;
	
	private int state = LCHECK;


	public Login(String filename) throws IOException {
		setLayout(new FlowLayout());

		// label for messages to user
		prompt = new JLabel("Please enter login:        ");
		prompt.setFont(new Font("Sansserif", Font.BOLD, 18));
		add(prompt);

		// text field for user input
		entry = new JTextField(12);
		entry.setFont(new Font("Sansserif", Font.BOLD, 18));
		add(entry);
		entry.addActionListener(this);

		// load logins from file
		getDetails(filename);
	}

	void getDetails(String f) throws IOException {
		String l, p;
		BufferedReader file = new BufferedReader(new FileReader(f));
		details = new ID[MAXID];
		l = file.readLine();
		while (l != null) {
			p = file.readLine();
			details[n] = new ID(l, p);
			n++;
			l = file.readLine();
		}
		file.close();
	}

	// checks whether login name exists
	private int checkLogin(String s) {
		for(int i=0; i<n; i++) {
			if(details[i].getLogin().equals(s))
				return i;
		}
		return -1;
	}

	// checks whether password is correct for current login
	private boolean passwordCheck(String s) {
		return details[idno].getPassword().equals(s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(state) {
		case LCHECK:
			if(e.getSource() == entry) {
				idno = checkLogin(entry.getText());
				
				if(idno == -1) {
					prompt.setForeground(Color.red);
					//no transition
				} else {
					prompt.setForeground(Color.black);
					prompt.setText("Please enter password:");
					entry.setText("");
					state = PCHECK;
				}
			}
			break;
		case PCHECK:
			if(e.getSource() == entry) {
				if(!passwordCheck(entry.getText())) {
					prompt.setForeground(Color.red);
					//no transition
				} else {
					prompt.setForeground(Color.black);
					prompt.setText("Login successful");
					state = SUCCESS;
				}
			}
			break;
		case SUCCESS:
			break;
		}
	}
}

public class TestLogin {

	public static void main(String[] args) throws IOException {
		Login l = new Login("users.txt");
		l.setTitle("Login");
		l.setSize(450, 80);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setVisible(true);
	}

}
