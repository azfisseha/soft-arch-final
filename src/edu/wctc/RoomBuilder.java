package edu.wctc;

import java.util.Random;

public class RoomBuilder {
    private Random random;
    private LootableBehaviorFactory lootableBehaviorFactory;
    private EncounterBehaviorFactory encounterBehaviorFactory;
    public Room buildStartingRoom()
    {
        Room startingRoom = new Room("basic", "Foyer", "You stand in the foyer of an abandoned mansion.  The walls are lined with decaying portraits of likely long dead patriarchs, and the room is dimly lit by the flicker of candlelight from an ornate chandelier overhead.  There is a large set of double doors in front of you.")

        startingRoom.setLootableBehavior(lootableBehaviorFactory.createBehavior("Unlootable"));
        startingRoom.setEncounterBehavior(encounterBehaviorFactory.createBehavior("NoEncounter"));
        return startingRoom;
    }

    public Room buildRandomRoom()
    {
        String[] roomDetails = randomRoomDetailLib.generate();
        String lootable;
        String encounter;
        double rand = random.nextDouble();
        if(rand < 0.3){
            lootable = "Lootable";
        }else{
            lootable = "Unlootable";
        }
        rand = random.nextDouble();
        if(rand < 0.6)
        {
            encounter = "NoEncounter";
        }else if(rand < 0.7)
        {
            encounter = "PuppyEncounter";
        }else if(rand < 0.8)
        {
            encounter = "SkeletonEncounter";
        }else if(rand < 0.9)
        {
            encounter = "TrollEncounter";
        }else
        {
            encounter = "ZombieEncounter";
        }

        Room randomRoom = new Room(roomDetails[0], roomDetails[1]);
        randomRoom.setEncounterBehavior(EncounterBehaviorFactory.createBehavior(encounter));
        randomRoom.setLootableBehavior(LootableBehaviorFactory.createBehavior(lootable));
        return randomRoom;
    }

    public Room buildEndingRoom()
    {
        Room endingRoom = new Room();//Boss fight
        return endingRoom;
    }
}
