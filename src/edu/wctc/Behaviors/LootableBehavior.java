package edu.wctc.Behaviors;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Action.LootActionDetail;
import edu.wctc.Loot.Loot;

public abstract class LootableBehavior {
    private boolean looted;
    protected Loot loot;

    public boolean isLooted()
    {
        return looted;
    }

    public LootActionDetail loot()
    {
        if(!isLooted())
        {
            looted = true;
            return new LootActionDetail(loot.getDescription(), loot.getPoints(), true, loot);
        }
        else return new LootActionDetail();
    }

    public final LootActionDetail enemiesHere() {
        return new LootActionDetail("You can't try to loot this room without facing the creatures here first", 0, false, null);
    }
}
