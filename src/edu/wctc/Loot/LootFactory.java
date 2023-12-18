package edu.wctc.Loot;

import edu.wctc.Loot.Concrete.PileOfGold;
import edu.wctc.Loot.Concrete.ReadingGlasses;
import edu.wctc.Loot.Concrete.ShinyRock;
import edu.wctc.Loot.Concrete.ToyRobot;

public class LootFactory {
    public Loot getLoot(String[] details)
    {
        Loot newLoot = null;
        switch (details[0]){
            case "PileOfGold"-> newLoot = new PileOfGold(details[0], details[1], 100);
            case "ReadingGlasses"-> newLoot = new ReadingGlasses(details[0], details[1], 20);
            case "ShinyRock"-> newLoot = new ShinyRock(details[0], details[1], 3);
            case "ToyRobot"-> newLoot = new ToyRobot(details[0], details[1], 50);
        }
        return newLoot;
    }
}
