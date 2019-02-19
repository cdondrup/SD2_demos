package FoxesAndRabbits;

import java.util.List;

public abstract class Animal {
	// Whether the fox is alive or not.
    private boolean alive;
    // The fox's position.
    private Location location;
    // The field occupied.
    private Field field;
    
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Check whether the fox is alive or not.
     * @return True if the fox is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Return the fox's location.
     * @return The fox's location.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the fox at the new location in the given field.
     * @param newLocation The fox's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
    
	/**
     * Indicate that the fox is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    public abstract void act(List<Animal> newAnimals);
}
