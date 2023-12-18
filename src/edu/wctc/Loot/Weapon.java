package edu.wctc.Loot;

public abstract class Weapon extends Loot {
    protected int power;

    public Weapon(String name, String description, int points) {
        super(name, description, points);
    }

    public int getPower()
    {
        return power;
    }


}
