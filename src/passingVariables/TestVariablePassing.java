package passingVariables;

import java.util.ArrayList;
import java.util.List;

public class TestVariablePassing {
	private List<Integer> myInts;
	
	public TestVariablePassing() {
		myInts = new ArrayList<>();
	}
	
	public void addElement(int element) {
		myInts.add(element);
	}
	
	public List<Integer> getMyInts() {
		return myInts;
	}

	public static void main(String[] args) {
		TestVariablePassing t = new TestVariablePassing();
		t.addElement(5);
		t.addElement(1);
		t.addElement(6);
		t.addElement(2);
		
		System.out.println(t.getMyInts());
		System.out.println();
		
		List<Integer> sortedList = new SortList().sort(t.getMyInts());
		System.out.println(sortedList);
		System.out.println(sortedList == t.getMyInts());
		sortedList.add(8);
		System.out.println(t.getMyInts());

	}

}
