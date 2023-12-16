package edu.wctc;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Action.MoveActionDetail;
import edu.wctc.Loot.Weapon;

import java.util.HashMap;
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
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }


    public void setLootableBehavior(LootableBehavior lootableBehavior) {
        this.lootableBehavior = lootableBehavior;
    }

    public void setEncounterBehavior(EncounterBehavior encounterBehavior) {
        this.encounterBehavior = encounterBehavior;
    }

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
        return lootableBehavior.loot();
    }

    public ActionDetail move(Directions dir)
    {
        return new MoveActionDetail()
    }

    @Override
    public String toString() {
        return this.getName() + ": \n\t" + this.getDescription();
    }
}
