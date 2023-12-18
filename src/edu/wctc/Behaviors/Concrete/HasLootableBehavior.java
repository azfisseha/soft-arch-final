package edu.wctc.Behaviors.Concrete;

import edu.wctc.Behaviors.LootableBehavior;
import edu.wctc.Loot.Loot;

public class HasLootableBehavior extends LootableBehavior {
    public HasLootableBehavior(Loot loot)
    {
        this.loot = loot;
    }
}
