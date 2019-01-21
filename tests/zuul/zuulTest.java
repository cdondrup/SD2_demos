package zuul;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import zuulRefactored.Command;
import zuulRefactored.CommandWord;
import zuulRefactored.CommandWords;

class zuulTest {
	private static CommandWords commandWords;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		commandWords = new CommandWords();
	}

	@Test
	void isCommandTest() {
		assertTrue(commandWords.isCommand("go"));
		assertTrue(commandWords.isCommand("quit"));
		assertTrue(commandWords.isCommand("help"));
	}
	
	@Test
	void notIsCommandTest() {
		assertFalse(commandWords.isCommand("foo"));
		assertFalse(commandWords.isCommand("bar"));
	}
	
	@Test
	void isUnknownTest() {
		Command command = new Command(null, null);
		assertTrue(command.isUnknown());
	}
	
	@Test
	void notIsUnknownTest() {
		Command command = new Command(commandWords.getCommandWord("foo"), null);
		assertFalse(command.isUnknown());
	}
	
	@Test
	void getCommandWordTest() {
		Command command = new Command(commandWords.getCommandWord("go"), null);
		assertEquals(command.getCommandWord(), CommandWord.GO);
	}
	
	@Test
	void notGetCommandWordTest() {
		Command command = new Command(commandWords.getCommandWord("foo"), null);
		assertNotEquals(command.getCommandWord(), CommandWord.GO);
	}

}
