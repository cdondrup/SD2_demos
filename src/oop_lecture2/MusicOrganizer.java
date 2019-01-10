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
    
    //...
    
    public static void main(String [] args)
	{  
		MusicOrganizer m = new MusicOrganizer();
		System.out.println();
	}
}
