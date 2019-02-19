package Vehicles;

public class TestVehicle {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Car();
		Vehicle v3 = new Bicycle();
		
		Car c = new Car();
		v1 = c;
	}

}
