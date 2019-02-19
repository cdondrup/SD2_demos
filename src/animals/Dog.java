package animals;

public class Dog extends Mammal implements Pet, Pet2, ServiceAnimals {
	public void bark() {
		bark(1);
	}
	
	public void bark(int n) {
		bark(n, "Woof!");
	}
	
	public void bark(int n, String text) {
		for(int i = 0; i < n; i++) {
			System.out.println(text);
		}
	}

	@Override
	public void pet() {
		System.out.println("Wagging tail");
	}

	@Override
	public void guide() {
		System.out.println("Good boi!!!");
	}

	
}
