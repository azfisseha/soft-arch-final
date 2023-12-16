package edu.wctc.Action;

import edu.wctc.Loot.Loot;

public class LootActionDetail extends ActionDetail{
    private Loot loot;

    public LootActionDetail(String detail, int points, boolean success, Loot loot) {
        super(detail, points, success);
        this.loot = loot;
    }

    public Loot getLoot() {
        if(this.getSuccess()) return loot;
        return null;
    }
}
