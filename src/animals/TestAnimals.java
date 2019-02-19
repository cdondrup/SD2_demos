package animals;

import java.util.ArrayList;
import java.util.List;


public class TestAnimals {

	public static void main(String[] args) {
		List<Animal> list = new ArrayList<>();
		list.add(new Dog());
		list.add(new Cat());
		list.add(new Duck());
		
		for(Animal a : list) {
			if(a instanceof Pet)
				((Pet)a).pet();
			if(a instanceof ServiceAnimals)
				((ServiceAnimals)a).guide();
		}
	}

}
