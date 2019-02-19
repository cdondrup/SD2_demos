package iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterators {
	private ArrayList<Integer> myInts;
	
	public TestIterators() {
		myInts = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			myInts.add(new Integer(i));
		}
	}
	
	public void printMyInts() {
		
		for(Iterator<Integer> it = myInts.iterator(); it.hasNext(); ) {
			Integer i = it.next();
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		TestIterators ti = new TestIterators();
		ti.printMyInts();
	}

}
