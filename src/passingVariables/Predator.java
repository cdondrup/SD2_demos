package passingVariables;

public abstract class Predator {
	private int foodLevel;
	
	public void eat(int foodValue) {
		foodLevel = foodValue;
	}
	
	public void incrementHunger() {
		setFoodLevel(getFoodLevel() - 1);
		if(getFoodLevel() < 0) {
			setDead();
		}
	}
	
	public int getFoodLevel() {
		return foodLevel;
	}
	
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	
	protected abstract void setDead();
}
