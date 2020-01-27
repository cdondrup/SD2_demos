package revision;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListSetMap {
	ArrayList<String> myList;
	
	public ListSetMap() {
		myList = new ArrayList<>(); 
	}
	
	public void addString(String string) {
		myList.add(string);
	}
	
	public int getSize() {
		return myList.size();
	}


	public static void main(String[] args) {
		ListSetMap lsm = new ListSetMap();
		lsm.addString("test");
		lsm.addString("test");
		System.out.println(lsm.getSize());
	}

}
