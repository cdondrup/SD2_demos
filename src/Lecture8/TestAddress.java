package Lecture8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Entry {
	String[] details;
	final static int MAXDETAILS = 6;

	public Entry(String[] newDetails) {
		details = new String[MAXDETAILS];
		for (int i = 0; i < MAXDETAILS; i++) {
			details[i] = newDetails[i];
		}
	}

	public void writeEntry(PrintWriter file) {
		for (int i = 0; i < MAXDETAILS; i++) {
			file.println(details[i]);
		}
	}
}

class Address extends JFrame implements ActionListener {
	Entry[] entries;
	int entryno;
	int current;
	final int MAXENTRIES = 100;

	final String addressbook = "addressbook.txt";

	final int INSPECT = 0;
	final int EXTEND = 1;
	int state = INSPECT;

	JButton[] actions;
	String[] actionText = { "New", "Add", "Change", "Delete", "Forward", "Back", "Quit" };
	final int MAXACTIONS = actionText.length;

	JLabel[] headings;
	String[] text = { "Name", "Street", "Town", "Postcode", "Telephone", "Email" };

	JTextField[] details;
	JPanel entry, controls;

	public Address() {
		entry = new JPanel(new GridLayout(Entry.MAXDETAILS, 2));
		headings = new JLabel[Entry.MAXDETAILS];
		details = new JTextField[Entry.MAXDETAILS];
		for (int i = 0; i < Entry.MAXDETAILS; i++) {
			headings[i] = setupLabel(text[i], entry);
			details[i] = setupTextField("", entry);
		}
		add(entry, BorderLayout.CENTER);

		actions = new JButton[MAXACTIONS];
		controls = new JPanel(new GridLayout(MAXACTIONS, 1));
		for (int i = 0; i < MAXACTIONS; i++) {
			actions[i] = setupButton(actionText[i], controls);
		}
		add(controls, BorderLayout.WEST);

		actions[1].setEnabled(false);
	}

	void showEntry(Entry e) {
		for (int i = 0; i < Entry.MAXDETAILS; i++)
			details[i].setText(e.details[i]);
	}

	void doQuit() {
		if (entryno == 0) {
			System.exit(0);
		} else {
			try {
				PrintWriter file = new PrintWriter(new FileWriter(addressbook));
				for (int i = 0; i < entryno; i++) {
					entries[i].writeEntry(file);
				}
				file.close();
				System.exit(0);
			} catch (IOException e) {
			}
			;
		}
	}

	void doNew() {
		if (entryno == MAXENTRIES) {
			System.out.println("More than " + MAXENTRIES + " entries.");
			return;
		}

		for (int i = 0; i < Entry.MAXDETAILS; i++) {
			details[i].setText("");
		}

		for (int i = 0; i < MAXACTIONS; i++) {
			actions[i].setEnabled(false);
		}
		actions[1].setEnabled(true);
	}

	void doAdd() {
		int i, j;

		String[] newDetails = new String[Entry.MAXDETAILS];
		for (i = 0; i < Entry.MAXDETAILS; i++) {
			newDetails[i] = details[i].getText();
		}
		Entry e = new Entry(newDetails);

		for (i = 0; i < entryno; i++) {
			if (e.details[0].compareTo(entries[i].details[0]) < 0) {
				break;
			}
		}
		for (j = entryno; j > i; j--) {
			entries[j] = entries[j - 1];
		}

		entries[i] = e;
		current = i;
		entryno++;

		for (i = 0; i < MAXACTIONS; i++) {
			actions[i].setEnabled(true);
		}
		actions[1].setEnabled(false);
	}

	// move to next entry in address book
	void doForward() {
		if (entryno == 0 || current + 1 == entryno) // end of array?
			return;
		current++;
		showEntry(entries[current]);
	}

	// move to previous entry in address book
	void doBack() {
		if (entryno == 0 || current == 0) // at beginning?
			return;
		current--;
		showEntry(entries[current]);
	}

	void doDelete() {
		if (entryno == 0) {
			return;
		}

		for (int i = current; i < entryno - 1; i++) {
			entries[i] = entries[i + 1];
		}
		entryno--;

		// if address book now empty, reset display
		if (entryno == 0) {
			for (int i = 0; i < Entry.MAXDETAILS; i++)
				details[i].setText("");
			return;
		}
		if (current == entryno) // if last entry removed
			current--;
		showEntry(entries[current]); // update display
	}

	// update current entry
	void doChange() {
		if (entryno == 0)
			return;

		// delete current entry without displaying
		for (int i = current; i < entryno - 1; i++)
			entries[i] = entries[i + 1];
		entryno--;
		// update current if last entry "deleted"
		if (current == entryno)
			current--;

		// add as new entry in alphabetical position
		doAdd();
	}

	JTextField setupTextField(String s, Container c) {
		JTextField t = new JTextField(s);
		t.setFont(new Font("Sansserif", Font.PLAIN, 18));
		t.setBackground(Color.white);
		c.add(t);
		return t;
	}

	// create button, add to container, attach listener
	JButton setupButton(String s, Container c) {
		JButton b = new JButton(s);
		b.setFont(new Font("Sansserif", Font.PLAIN, 18));
		b.setBackground(Color.white);
		c.add(b);
		b.addActionListener(this);
		return b;
	}

	// create label and add to container
	JLabel setupLabel(String s, Container c) {
		JLabel l = new JLabel(s, JLabel.CENTER);
		l.setFont(new Font("Sansserif", Font.PLAIN, 18));
		l.setBackground(Color.white);
		c.add(l);
		return l;
	}

	void readEntries() throws IOException {
		BufferedReader file;
		entries = new Entry[MAXENTRIES];
		String[] details = new String[Entry.MAXDETAILS];
		entryno = 0;

		try {
			file = new BufferedReader(new FileReader(addressbook));
		} catch (FileNotFoundException e) {
			return;
		}

		String line = file.readLine();
		while (line != null) {
			details[0] = line;
			for (int i = 1; i < Entry.MAXDETAILS; i++) {
				details[i] = file.readLine();
			}
			entries[entryno] = new Entry(details);
			entryno++;
			line = file.readLine();
		}
		file.close();
		if (entryno != 0) {
			current = 0;
			showEntry(entries[current]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (state) {
		case INSPECT:
			if (e.getSource() == actions[0]) // NEW
			{
				doNew();
				state = EXTEND;
				return;
			}
			if (e.getSource() == actions[2]) // CHANGE
			{
				doChange();
				return;
			}
			if (e.getSource() == actions[3]) // DELETE
			{
				doDelete();
				return;
			}
			if (e.getSource() == actions[4]) // UP
			{
				doForward();
				return;
			}
			if (e.getSource() == actions[5]) // DOWN
			{
				doBack();
				return;
			}
			if (e.getSource() == actions[6]) // QUIT
			{
				doQuit();
				return;
			}

		case EXTEND:
			if (e.getSource() == actions[1]) // ADD
			{
				doAdd();
				state = INSPECT;
				return;
			}
		}
	}

}

public class TestAddress {

	public static void main(String[] args) throws IOException {
		Address a;
		a = new Address();
		a.setSize(600, 280);
		a.setTitle("Address");
		a.setVisible(true);
		a.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		a.readEntries();
	}

}
