package edu.wctc.Loot.Concrete;

import edu.wctc.Loot.Weapon;

public class BronzeSword extends Weapon {
    public BronzeSword(String name, String description, int points) {
        super(name, description, points);
        this.power = 15;
    }
}
