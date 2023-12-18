package edu.wctc.Loot.Concrete;

import edu.wctc.Loot.Weapon;

public class SteelSword extends Weapon {
    public SteelSword(String name, String description, int points) {
        super(name, description, points);
        this.power = 30;
    }
}
