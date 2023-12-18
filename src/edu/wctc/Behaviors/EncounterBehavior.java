package edu.wctc.Behaviors;

import edu.wctc.Action.EncounterActionDetail;
import edu.wctc.Enemies.Enemy;
import edu.wctc.Loot.Weapon;

public abstract class EncounterBehavior extends InteractionBehavior {
    protected Enemy enemy;
    protected int enemyCount;
    protected boolean defeated;

    public EncounterActionDetail fight(Weapon weapon)
    {

        //The player has already defeated them
        if(defeated)
        {
            return new EncounterActionDetail(this.getDefeatedDetail(), 0, false);
        }

        else
        {

            if( weapon == null || weapon.getPoints() < enemyCount * enemy.getPower())
            {
                return new EncounterActionDetail(
                        "The " + this.enemy.getDetail() + " overpower you",
                        -this.getPoints(),
                        true);

            }else
            {
                defeated = true;
                return new EncounterActionDetail(
                        "You defeat the " + this.enemy.getDetail(),
                        this.getPoints(),
                        true);
            }
        }
    }
    
    

    protected String getDefeatedDetail()
    {
        return this.enemy.getDetail() + " , dead";
    }

    public String getEncounterDetails() {
        return defeated ?  String.format("%d %s", enemyCount, getDefeatedDetail()) : String.format("%d %s", enemyCount, this.enemy.getDetail())  ;
    }

    public abstract boolean hasEncounter();

    public boolean alreadyDone() {
        return defeated;
    }
}
