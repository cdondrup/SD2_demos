package editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jdk.nashorn.internal.ir.JoinPredecessorExpression;

import java.io.*;

// Define class: a window that contains a text area
class Edit extends JFrame implements ActionListener {
	public JTextArea ta;
	private JScrollPane sp;
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem MNew, MOpen, MClose, MExit;
	private JFileChooser fileChooser;

	private boolean editing;

	Edit() {
		// MAC OS X
		if(System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Editor");
		}

		sp = new JScrollPane();
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ta = new JTextArea("", 24, 80);
		ta.setLineWrap(true);
		ta.setEditable(false);
		sp.setViewportView(ta);
		add(sp, BorderLayout.CENTER);

		bar = new JMenuBar();
		file = new JMenu("File");
		MNew = new JMenuItem("New");
		MOpen = new JMenuItem("Open");
		MClose = new JMenuItem("Close");
		MExit = new JMenuItem("Exit");

		bar.add(file);
		file.add(MNew);
		file.add(MOpen);
		file.add(MClose);
		file.addSeparator();
		file.add(MExit);

		setJMenuBar(bar);

		MNew.addActionListener(this);
		MOpen.addActionListener(this);
		MClose.addActionListener(this);
		MExit.addActionListener(this);

		fileChooser = new JFileChooser();

		editing = false;
	}

	public void doOpen() {
		try { 
			int response = fileChooser.showOpenDialog(this);
			if(response == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				BufferedReader fin =
						new BufferedReader(new FileReader(f));

				String next = fin.readLine();
				while(next!=null)
				{  
					ta.append(next+"\n");
					next = fin.readLine();
				}
				fin.close();
				ta.setEditable(true);
				editing = true;
				MNew.setEnabled(false);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void doClose() {
		try {
			int response  = fileChooser.showSaveDialog(this);
			if(response == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				BufferedWriter fout = new BufferedWriter(new FileWriter(f));
				fout.write(ta.getText());
				editing = false;
				ta.setEditable(false);
				fout.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	private void doNew() {
		editing = true;
		ta.setEditable(true);
	}
	
	private void doExit() {
		if(editing) {
			int response  = JOptionPane.showConfirmDialog(
					this, 
					"Exit without closing?", 
					"Exit",
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE
					);
			if(response == JOptionPane.OK_OPTION)
				System.exit(0);
		} else {
			System.exit(0);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(!editing) {
			if(e.getSource() == MNew) {
				System.out.println("New");
				doNew();
			} else if(e.getSource() == MOpen) {
				doOpen();
			} else if(e.getSource() == MExit) {
				doExit();
			}
		} else {
			if(e.getSource() == MClose) {
				System.out.println("Close");
				doClose();
			} else if(e.getSource() == MExit) {
				doExit();
			}
		}
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
