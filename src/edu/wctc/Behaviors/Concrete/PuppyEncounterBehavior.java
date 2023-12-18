package edu.wctc.Behaviors.Concrete;

import edu.wctc.Action.EncounterActionDetail;
import edu.wctc.Behaviors.EncounterBehavior;
import edu.wctc.Enemies.Concrete.PuppyEnemy;
import edu.wctc.Loot.Weapon;

public class PuppyEncounterBehavior extends EncounterBehavior {

    public PuppyEncounterBehavior(int enemyCount)
    {
        this.enemyCount = enemyCount;
        this.enemy = new PuppyEnemy();
        this.points = enemy.getPoints();
    }

    @Override
    protected String getDefeatedDetail() {
        return super.getDefeatedDetail() + "... Monster.";
    }

    @Override
    public boolean hasEncounter() {
        return true;
    }

    @Override
    public EncounterActionDetail fight(Weapon weapon) {
        if(defeated)
        {
            return new EncounterActionDetail(this.getDefeatedDetail(), 0, false);
        }

        else
        {
            //Invert the enemy's power for this calculation.
            //...yes, the player can earn infinite points here.
            if(weapon == null || weapon.getPoints() < enemyCount * -enemy.getPower())
            {
                return new EncounterActionDetail(
                        "The " + this.enemy.getDetail() + " overpower you",
                        -this.getPoints(),
                        true);

            }

            //Yes, the player can never loot a room with puppies in it unless they defeat them.
            else
            {
                defeated = true;
                return new EncounterActionDetail(
                        "You defeat the " + this.enemy.getDetail(),
                        this.getPoints(),
                        true);
            }
        }
    }
}
