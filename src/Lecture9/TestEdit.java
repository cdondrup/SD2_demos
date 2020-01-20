package Lecture9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

// Define class: a window that contains a text area
class Edit extends JFrame implements ActionListener {

	private JTextArea ta; // text display area
	private JScrollPane sp; // the text area's scroll pane
	private JMenuBar jb; // the menu bar
	private JMenu file; // the file menu
	private JMenuItem MNew, MOpen, MClose, MExit; // the menu items
	private boolean editing; // state variable: editing or not editing?
	private JFileChooser files;


	Edit() {
		// MAC OS X
		if(System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Editor");
		}

		sp = new JScrollPane();
		// turn off the horizontal scroll bar
		// use default policy for vertical: appears as needed
		sp.setHorizontalScrollBarPolicy
		(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ta = new JTextArea("",24,80); // create
		ta.setLineWrap(true);
		sp.setViewportView(ta); // set view to be the scroll pane
		add(BorderLayout.CENTER,sp);

		jb = new JMenuBar(); // create menu bar
		file = new JMenu("File"); // create named menu
		// create menu items, specifying names
		MNew = new JMenuItem("New");
		MOpen = new JMenuItem("Open");
		MClose = new JMenuItem("Close");
		MExit = new JMenuItem("Exit");

		// add menu items to file menu
		file.add(MNew);
		file.add(MOpen);
		file.add(MClose);
		file.add(MExit);

		jb.add(file); // add file menu to menu bar

		setJMenuBar(jb); // display menu bar (in current window)

		// add action listener to menu items, as with buttons
		MNew.addActionListener(this);
		MOpen.addActionListener(this);
		MClose.addActionListener(this);
		MExit.addActionListener(this);

		editing = false; // initially not in the editing state
		ta.setEditable(false); // so disable the text area

		files = new JFileChooser(); // create the file chooser
	}

	// process action events in the same way as buttons
	// just print out selected menu item's name for now
	public void actionPerformed(ActionEvent e)
	{  
		if(!editing) { // check state before processing events
			if(e.getSource() == MNew)  
				doNew();
			else if(e.getSource() == MOpen) 
				doOpen();
			else if(e.getSource() == MExit)
				doExit();
		} else // if in editing state
			if(e.getSource() == MClose)
				doClose();
			else if(e.getSource() == MExit)
				doExit();
	}

	// respond to user selecting 'open' menu item
	public void doOpen() {
		try {
			// ask file chooser to show file open dialog
			int response = files.showOpenDialog(this);
			// check whether user pressed okay or cancel
			if(response==JFileChooser.APPROVE_OPTION) {
				// if they pressed okay, identify selected file
				File f = files.getSelectedFile();
				// then read file as usual...
				BufferedReader fin =
						new BufferedReader(new FileReader(f));

				String next = fin.readLine();
				while(next!=null)
				{  ta.append(next+"\n");
				next = fin.readLine();
				}
				fin.close();
				editing = true;
				ta.setEditable(true);
			}
		}
		catch(IOException e){};
	}

	// respond to user selecting 'close' menu item
	public void doClose() {
		try {
			// ask file chooser to show save file dialog
			int response = files.showSaveDialog(this);
			// if user pressed okay, identify chosen file
			if(response==JFileChooser.APPROVE_OPTION) {
				File f = files.getSelectedFile();
				BufferedWriter fout =
						new BufferedWriter(new FileWriter(f));
				fout.write(ta.getText());
				fout.close();
				editing = false;
				ta.setEditable(false);
			}
		}
		catch(IOException e){};
	}

	// respond to user selecting 'exit' menu item
	public void doExit() {
		// show confirm dialog
		int response = JOptionPane.showConfirmDialog(
				this,
				"Exit without Close?",
				"Exit",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		// only proceed if the user selected 'okay'
		if(response==JOptionPane.OK_OPTION)
			System.exit(0);
	}

	// respond to user selecting 'new' menu item
	public void doNew() {
		editing = true; // state transition
		ta.setEditable(true); 
		ta.setText("");
	}
}


public class TestEdit {

	public static void main(String[] args) throws IOException {
		Edit e = new Edit(); // create window with text area

		// setup window
		e.setTitle("Edit");
		e.setSize(400,200);
		e.setVisible(true);
		e.addWindowListener
		(new WindowAdapter()
		{  public void 
			windowClosing(WindowEvent e)
		{  System.exit(0); }
		});
	}

}
