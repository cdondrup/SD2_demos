package passingVariables;

public class Human extends Predator {
	public static final int PIZZA_FOOD_VALUE = 5;
	
	private boolean alive;
	
	public Human() {
		setFoodLevel(PIZZA_FOOD_VALUE);
		alive = true;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setDead() {
		alive = false;
	}
	
	public String toString() {
		String text = "Human: " + (alive ? "alive": "dead") + '\n';
		text += "Hunger: " + getFoodLevel();
		return text;
	}

	public static void main(String[] args) {
		Human human = new Human();
		for(int i = 6; i >= 0; i--) {
			System.out.println(human);
			human.incrementHunger();
			human.eat(PIZZA_FOOD_VALUE);
		}
	}

}
