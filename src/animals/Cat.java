package animals;

public class Cat extends Mammal implements Pet {
	public void purr() {
		System.out.println("Purr!");
	}

	@Override
	public void pet() {
		System.out.println("Meow");
	}
}
