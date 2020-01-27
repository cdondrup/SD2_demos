package junit;

public class Calculator {
	private int c;
	
	public Calculator() {
		c=5;
	}
	
	public static int sum(int a, int b) {
		return a + b + c;
	}

}
