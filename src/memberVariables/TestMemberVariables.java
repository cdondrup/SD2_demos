package memberVariables;

public class TestMemberVariables {
	private int index;
	
	public TestMemberVariables() {
		index = 0;
	}
	
	public int increment() {
		index++;
		return index;
	}

	public static void main(String[] args) {
		TestMemberVariables t = new TestMemberVariables();
		for(int i = 0; i < 10; i++)
			System.out.println(t.increment());

	}

}
