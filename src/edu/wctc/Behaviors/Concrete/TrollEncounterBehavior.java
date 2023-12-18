package edu.wctc.Behaviors.Concrete;

import edu.wctc.Behaviors.EncounterBehavior;
import edu.wctc.Enemies.Concrete.TrollEnemy;

public class TrollEncounterBehavior extends EncounterBehavior {
    @Override
    public boolean hasEncounter() {
        return true;
    }

    public TrollEncounterBehavior(int enemyCount)
    {
        this.enemyCount = enemyCount;
        this.enemy = new TrollEnemy();
        this.points = enemy.getPoints();
    }
}
