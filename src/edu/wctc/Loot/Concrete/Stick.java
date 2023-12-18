package edu.wctc.Loot.Concrete;

import edu.wctc.Loot.Weapon;

public class Stick extends Weapon {

    public Stick(String name, String description, int points) {
        super(name, description, points);
        this.power = 10;
    }
}
