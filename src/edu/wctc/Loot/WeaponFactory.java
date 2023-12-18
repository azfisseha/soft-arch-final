package edu.wctc.Loot;

import edu.wctc.Loot.Concrete.*;

public class WeaponFactory {
    public Weapon getWeapon(String[] details)
    {
        Weapon newWeapon = null;
        switch (details[0]){
            case "BronzeSword"-> newWeapon = new BronzeSword(details[0], details[1], 30);
            case "SteelSword"-> newWeapon = new  SteelSword(details[0], details[1], 100);
            case "MagicWand"-> newWeapon = new  MagicWand(details[0], details[1], 200);
            case "Stick"-> newWeapon = new  Stick(details[0], details[1], 3);
        }
        return newWeapon;
    }

}
