package oop_lecture2;

import java.util.HashMap;

public class PhoneBook {

	public static void main(String[] args) {
		HashMap <String,String> phoneBook = new HashMap<String,String>();

		phoneBook.put("Charles Nguyen", "(531) 9392 4587");
		phoneBook.put("Lisa Jones", "(402) 4536 4674");
		phoneBook.put("William H. Smith", "(998) 5488 0123");

		String phoneNumber = phoneBook.get("Lisa Jones");
		System.out.println(phoneNumber);

	}

}
