package oop_lecture2;

import java.util.ArrayList;

/**
 * ...
 */
public class MusicOrganizer
{
    //Storage for an arbitrary number of file names.
    private ArrayList<String> files;
    
    /**
     * Perform any initialisation required for the
     * organizer.
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
    }
    
    public void addFile(String name) {
    	files.add(name);
    }
    
    public int getSize() {
    	return files.size();
    }
    
    
    
    //...
    
    public static void main(String [] args)
	{  
		MusicOrganizer m = new MusicOrganizer();
		m.addFile("test.mp3");
		m.addFile("test.mp3");
		m.addFile("test.mp3");
		m.addFile("test.mp3");
		System.out.println(m.getSize());
	}
}
