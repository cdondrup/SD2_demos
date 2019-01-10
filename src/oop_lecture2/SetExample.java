package oop_lecture2;

import java.util.HashSet;

public class SetExample {

	public static void main(String[] args) {
		HashSet<String> mySet = new HashSet<String>();

		mySet.add("one");
		mySet.add("two");
		mySet.add("one");

		for(String element : mySet) {
		    System.out.println(element);
		}

	}

}
