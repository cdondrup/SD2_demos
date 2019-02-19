package birds;

public class TestBirds {

	public static void main(String[] args) {
		Duck d = new Duck();
		Bird b = d;
		d = (Duck) b;
	}

}
