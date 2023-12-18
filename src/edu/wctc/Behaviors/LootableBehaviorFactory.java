package edu.wctc.Behaviors;

import edu.wctc.Behaviors.Concrete.HasLootableBehavior;
import edu.wctc.Behaviors.Concrete.UnLootableBehavior;
import edu.wctc.Loot.LootGenerator;

public class LootableBehaviorFactory {
    private LootGenerator lootGenerator = LootGenerator.getInstance();

    public LootableBehavior createBehavior(String type) {
        LootableBehavior behavior = null;
        switch (type)
        {
            case "UnLootable"->
                behavior = new UnLootableBehavior();
            case "HasLootable"->
                behavior = new HasLootableBehavior(lootGenerator.getLoot());
        }
        return behavior;
    }
}
