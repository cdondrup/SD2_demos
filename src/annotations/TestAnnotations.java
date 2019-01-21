package annotations;

@Author(
		name="Christian Dondrup",
		date="12/1/19"
)
public class TestAnnotations {
	
	@Deprecated
	public static void myMethod(String text) {
		System.out.println(text);
	}
	
	public static void newPrint(String text) {
		TestAnnotations.myMethod(text);
	}

	public static void main(String[] args) {
		TestAnnotations.newPrint("Print this");
	}

}
