package edu.wctc.Behaviors.Concrete;

import edu.wctc.Behaviors.EncounterBehavior;
import edu.wctc.Enemies.Concrete.ZombieEnemy;

public class ZombieEncounterBehavior extends EncounterBehavior {

    @Override
    public boolean hasEncounter() {
        return true;
    }

    public ZombieEncounterBehavior(int enemyCount)
    {
        this.enemyCount = enemyCount;
        this.enemy = new ZombieEnemy();
        this.points = enemy.getPoints();
    }


}
