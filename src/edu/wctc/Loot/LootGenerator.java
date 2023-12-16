package edu.wctc.Loot;

import java.util.Random;

public class LootGenerator {
    private volatile static LootGenerator uniqueInstance;
    private Random rand;


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
    public Loot getLoot(){
        //TODO: implement RNG loot generation
        return null;
    }

    public Loot getLoot(String lootName)
    {
        //TODO: implement nonrandom loot generation
        return null;
    }
}
