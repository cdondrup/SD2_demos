package lookUp;

import java.util.HashMap;

public class TestLookUp {
	private HashMap<String, String> english2german;
	private HashMap<String, String> italian2english;
	
	public TestLookUp() {
		english2german = new HashMap<>();
		italian2english = new HashMap<>();
		fillMaps();
	}
	
	private void fillMaps() {
		english2german.put("table", "tisch");
		english2german.put("chair", "stuhl");
		english2german.put("plate", "teller");
		english2german.put("mug", "becher");
		
		italian2english.put("tavolo", "table");
		italian2english.put("sedia", "chair");
		italian2english.put("piatto", "plate");
		italian2english.put("boccale", "mug");
	}
	
	public String translate(String word) {
		String english = italian2english.get(word);
		return english2german.get(english);
	}

	public static void main(String[] args) {
		TestLookUp t = new TestLookUp();
		System.out.println(t.translate("sedia"));
	}

}
