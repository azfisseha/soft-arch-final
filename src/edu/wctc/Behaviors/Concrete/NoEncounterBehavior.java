package edu.wctc.Behaviors.Concrete;

import edu.wctc.Action.EncounterActionDetail;
import edu.wctc.Behaviors.EncounterBehavior;
import edu.wctc.Enemies.Concrete.NoEnemy;
import edu.wctc.Loot.Weapon;

public class NoEncounterBehavior extends EncounterBehavior {
    public NoEncounterBehavior()
    {
        this.enemy = new NoEnemy();
        this.enemyCount = 0;
        this.points = enemy.getPoints();
    }

    @Override
    public EncounterActionDetail fight(Weapon weapon)
    {
        //Nothing to fight, no points to earn!
        return new EncounterActionDetail(this.enemy.getDetail(), 0, false);
    }

    @Override
    public boolean hasEncounter() {
        return false;
    }
}
