package edu.wctc;

import edu.wctc.Action.LootActionDetail;

public interface LootableBehavior {
    boolean isLooted();
    LootActionDetail loot();
    int lootPoints();
}
