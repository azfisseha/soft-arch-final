package edu.wctc.Loot;

import java.util.Random;

public class LootGenerator {
    private volatile static LootGenerator uniqueInstance;
    private Random rand;
    private WeaponFactory weaponFactory = new WeaponFactory();
    private LootFactory lootFactory = new LootFactory();

    private String[][] lootTypes = {
            {"PileOfGold","A small pile of gold coins"},
            {"ReadingGlasses","A pair of round reading glasses"},
            {"ShinyRock","A shiny rock"},
            {"ToyRobot", "A small toy robot, with rounded claws for arms.  Its missing an eye."}
    };

    private String[][] weaponTypes = {
            {"BronzeSword", "A simple bronze shortsword with a slightly rusted edge"},
            {"SteelSword", "A polished steel longsword with razor sharp edge"},
            {"MagicWand", "A slender wand that sparks when waved"},
            {"Stick", "A fearsome weapon in the right hands, surely"}
    };

    private LootGenerator(){rand = new Random();}

    public static LootGenerator getInstance()
    {
        if(uniqueInstance == null)
        {
            synchronized (LootGenerator.class) {
                if(uniqueInstance == null)
                {
                    uniqueInstance = new LootGenerator();
                }
            }
        }
        return uniqueInstance;
    }

    public Loot getLoot()
    {
        Loot newLoot = null;
        double weaponChance = rand.nextDouble();
        int randInt;
        if(weaponChance < 0.65)
        {
            randInt = rand.nextInt(weaponTypes.length);
            newLoot = weaponFactory.getWeapon(weaponTypes[randInt]);
        }else {
            randInt = rand.nextInt(lootTypes.length);
            newLoot = lootFactory.getLoot(lootTypes[randInt]);
        }
        return newLoot;
    }


}
