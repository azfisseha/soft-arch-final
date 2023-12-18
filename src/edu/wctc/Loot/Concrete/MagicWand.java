package edu.wctc.Loot.Concrete;

import edu.wctc.Loot.Weapon;

public class MagicWand extends Weapon {
    public MagicWand(String name, String description, int points) {
        super(name, description, points);
        this.power = 45;
    }
}
