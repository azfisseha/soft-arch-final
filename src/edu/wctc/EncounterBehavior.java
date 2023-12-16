package edu.wctc;

import edu.wctc.Action.EncounterActionDetail;
import edu.wctc.Loot.Weapon;

public interface EncounterBehavior {
    boolean isDefeated();
    EncounterActionDetail fight(Weapon weapon);
    int getPoints();
}
