package edu.wctc.Behaviors.Concrete;

import edu.wctc.Behaviors.EncounterBehavior;
import edu.wctc.Enemies.Concrete.SkeletonEnemy;

public class SkeletonEncounterBehavior extends EncounterBehavior {

    @Override
    public boolean hasEncounter() {
        return true;
    }

    public SkeletonEncounterBehavior(int enemyCount)
    {
        this.enemy = new SkeletonEnemy();
        this.enemyCount = enemyCount;
        this.points = enemy.getPoints();
    }
}
