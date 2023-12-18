package edu.wctc.Action;

import edu.wctc.Loot.Loot;

public class LootActionDetail extends ActionDetail{
    private Loot loot;

    public LootActionDetail(String detail, int points, boolean success, Loot loot) {
        super(detail, points, success);
        this.loot = loot;
    }

    //used for rooms that have no loot
    public LootActionDetail()
    {
        super("There is nothing to loot in this room", 0, false);
        this.loot = null;
    }

    public Loot getLoot() {
        if(this.getSuccess()) return loot;
        return null;
    }
}
