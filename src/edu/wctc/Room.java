package edu.wctc;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Action.MoveActionDetail;
import edu.wctc.Behaviors.EncounterBehavior;
import edu.wctc.Behaviors.LootableBehavior;
import edu.wctc.Loot.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;

    private Map<Directions, Room> adjoiningRooms;

    private LootableBehavior lootableBehavior;
    private EncounterBehavior encounterBehavior;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.adjoiningRooms = new HashMap<>();
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public void setLootableBehavior(LootableBehavior lootableBehavior) {
        this.lootableBehavior = lootableBehavior;
    }

    public void setEncounterBehavior(EncounterBehavior encounterBehavior) { this.encounterBehavior = encounterBehavior; }

    public Room getAdjoiningRoom(Directions dir)
    {
        return adjoiningRooms.get(dir);
    }

    public void setAdjoiningRoom(Directions dir, Room room)
    {
        adjoiningRooms.put(dir, room);
    }

    public boolean hasAdjoiningRoom(Directions dir)
    {
        return adjoiningRooms.get(dir) != null;
    }


    public ActionDetail fight(Weapon weapon)
    {
        return encounterBehavior.fight(weapon);
    }

    public ActionDetail loot()
    {
        if(hasEncounter())
        {
            if(encounterBehavior.alreadyDone())
                return lootableBehavior.loot();
            else return lootableBehavior.enemiesHere();
        }
        return lootableBehavior.loot();
    }

    public ActionDetail move(Directions dir) {
        return hasAdjoiningRoom(dir)
                ? new MoveActionDetail("You leave the " + this.getName(), true, dir, getAdjoiningRoom(dir))
                : new MoveActionDetail("There is nothing in that direction", false, dir, this);
    }

    @Override
    public String toString() {
        return this.getName() + ": \n\t" + this.getDescription();
    }

    public List<Directions> getAvailableDirectionsToMoveTo() {
        ArrayList<Directions> validDirections = new ArrayList<>();
        for (Directions dir: Directions.values()
             ) {
            if(hasAdjoiningRoom(dir)) validDirections.add(dir);
        }
        return validDirections;
    }

    public boolean hasEncounter() {
        return encounterBehavior.hasEncounter();
    }

    public String getEncounterDetails() {
        if(hasEncounter())
            return encounterBehavior.getEncounterDetails();
        return "";
    }

    public boolean hasBeenDefeated() {
        return encounterBehavior.alreadyDone();
    }
}
