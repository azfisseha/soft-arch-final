package edu.wctc.Behaviors.Concrete;

import edu.wctc.Action.LootActionDetail;
import edu.wctc.Behaviors.LootableBehavior;

public class UnLootableBehavior extends LootableBehavior {
    @Override
    public boolean isLooted() {
        return false;
    }

    @Override
    public LootActionDetail loot() {
        return new LootActionDetail();
    }
}
