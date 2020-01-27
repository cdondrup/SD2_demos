package zuulRefactor;

import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class CommandWords
{
    // a constant array that holds all valid command words
        private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("test", CommandWord.TEST);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
    	return validCommands.containsKey(aString);
    }
    
    public CommandWord getCommandWord(String string) {
    	CommandWord c = validCommands.get(string);
    	if(c == null) {
    		c = CommandWord.UNKNOWN;
    	}
    	return c;
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command: validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
