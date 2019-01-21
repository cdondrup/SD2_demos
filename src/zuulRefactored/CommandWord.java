package zuulRefactored;

public enum CommandWord {
	GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), TEST("test");
	
	private String command;
	
	CommandWord(String aString) {
		command = aString;
	}
	
	public String toString() {
		return command;
	}
}
