package AddressBook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Entry {
	String[] details;
	public static final int MAXDETAILS = 6;

	public Entry(String[] newdetails) {
		details  = new String[MAXDETAILS];
		for(int i = 0; i < MAXDETAILS; i++)
			details[i] = newdetails[i];
	}

	public void writeEntry(PrintWriter file) {
		for(int i = 0; i < MAXDETAILS; i++)
			file.print(details[i]);
	}
}

class AddressBook extends JFrame implements ActionListener {
	private Entry[] entries;
	int entryno;
	int current;
	final int MAXENTRIES = 100;

	final String addressbook = "addressbook.txt";
	
	final int INSPECT = 0;
	final int MODIFY = 1;
	int state = INSPECT;
	
	JButton[] actions;
	String[] actionText = {"New", "Add", "Change", "Delete", "Forward", "Backward", "Quit"};
	final int MAXACTIONS = actionText.length;
	
	JLabel[] heading;
	String[] text = {"Name", "Street", "Town", "Postcode", "Phone", "Email"};
	
	JTextField[] details;
	JPanel entry, controls;
	
	public AddressBook() {
		entry = new JPanel(new GridLayout(Entry.MAXDETAILS, 2));
		heading = new JLabel[Entry.MAXDETAILS];
		details = new JTextField[Entry.MAXDETAILS];
		for(int i = 0; i < Entry.MAXDETAILS; i++) {
			heading[i] = setupLabel(text[i], entry);
			details[i] = setupTextField("", entry);
		}
		add(entry, BorderLayout.CENTER);
		
		actions = new JButton[MAXACTIONS];
		controls = new JPanel(new GridLayout(MAXACTIONS, 1));
		for(int i = 0; i < MAXACTIONS; i++) {
			actions[i] = setupButton(actionText[i], controls);
		}
		add(controls, BorderLayout.WEST);
		actions[1].setEnabled(false);
		
	}
	
	private void showEntry(Entry e) {
		for(int i = 0; i < Entry.MAXDETAILS; i++) {
			details[i].setText(e.details[i]);
		}
	}
	
	JTextField setupTextField(String s, Container c) {
		JTextField t = new JTextField(s);
		t.setFont(new Font("Sansserif", Font.PLAIN, 18));
		t.setBackground(Color.WHITE);
		c.add(t);
		return t;
	}
	
	JLabel setupLabel(String s, Container c) {
		JLabel t = new JLabel(s, JLabel.CENTER);
		t.setFont(new Font("Sansserif", Font.PLAIN, 18));
		t.setBackground(Color.WHITE);
		c.add(t);
		return t;
	}
	
	JButton setupButton(String s, Container c) {
		JButton t = new JButton(s);
		t.setFont(new Font("Sansserif", Font.PLAIN, 18));
		t.setBackground(Color.WHITE);
		c.add(t);
		t.addActionListener(this);
		return t;
	}

	public void readEntries() throws IOException {
		BufferedReader file;
		entries = new Entry[MAXENTRIES];
		String[] details = new String[Entry.MAXDETAILS];
		entryno = 0;

		try {
			file = new BufferedReader(new FileReader(addressbook));

			String line = file.readLine();
			while(line != null) {
				details[0] = line;
				for(int i = 1; i < Entry.MAXDETAILS; i++) {
					details[i] = file.readLine();
				}
				entries[entryno] = new Entry(details);
				entryno++;
				line  = file.readLine();
			}
			file.close();
			if(entryno != 0) {
				current = 0;
				showEntry(entries[current]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doQuit() {
		if(entryno == 0)
			System.exit(0);
		
		PrintWriter file;
		try {
			file = new PrintWriter(new FileWriter(addressbook));
			for(int i = 0; i < entryno; i++) {
				entries[i].writeEntry(file);
			}
			file.close();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void doNew() {
		if(entryno == MAXENTRIES) {
			System.out.println("No more space");
			return;
		}
		
		for(int i = 0; i < Entry.MAXDETAILS; i++) {
			details[i].setText("");
		}
		
		for(int i = 0; i < MAXACTIONS; i++) {
			actions[i].setEnabled(false);
		}
		actions[1].setEnabled(true);	
		
	}
	
	private void doAdd() {
		String[] newDetails = new String[Entry.MAXDETAILS];
		for(int i = 0; i < Entry.MAXDETAILS; i++) {
			newDetails[i] = details[i].getText();
		}
		Entry e = new Entry(newDetails);
		
		int i, j;
		for(i = 0; i < entryno; i++) {
			if(e.details[0].compareTo(entries[i].details[0]) < 0) {
				break;
			}
		}
		for(j = entryno; j > i; j--) {
			entries[j] = entries[j - 1];
		}
		
		entries[i] = e;
		current = i;
		entryno++;
		
		for(int i = 0; i < MAXACTIONS; i++) {
			actions[i].setEnabled(true);
		}
		actions[1].setEnabled(false);
		
	}
	
	private void doForward() {
		if(entryno == 0 || current + 1 == entryno)
			return;
		current++;
		showEntry(entries[current]);	
	}
	
	private void doBack() {
		if(entryno == 0 || current == 0)
			return;
		
		current--;
		showEntry(entries[current]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}


public class TestAddressBook {

	public static void main(String[] args) throws IOException {
		AddressBook a;
		a = new AddressBook();
		a.setSize(600, 280);
		a.setTitle("Address Book");
		a.setVisible(true);
		a.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
