package edu.wctc;

import edu.wctc.Behaviors.EncounterBehaviorFactory;
import edu.wctc.Behaviors.LootableBehaviorFactory;

import java.util.Random;

public class RoomBuilder {
    private Random random = new Random();
    private LootableBehaviorFactory lootableBehaviorFactory = new LootableBehaviorFactory();
    private EncounterBehaviorFactory encounterBehaviorFactory = new EncounterBehaviorFactory();
    private RandomDetailGenerator roomDetailGenerator = new RandomRoomDetailGenerator();



    public Room buildStartingRoom()
    {
        Room startingRoom = new Room("FOYER",  "You stand in the foyer of an abandoned mansion.  The walls are lined with decaying portraits of likely long dead patriarchs, and the room is dimly lit by the flicker of candlelight from an ornate chandelier overhead.");

        startingRoom.setLootableBehavior(lootableBehaviorFactory.createBehavior("UnLootable"));
        startingRoom.setEncounterBehavior(encounterBehaviorFactory.createBehavior("NoEncounter"));
        return startingRoom;
    }

    public Room buildRandomRoom()
    {
        String[] roomDetails = roomDetailGenerator.generate();
        String lootable = getRandomLootableString();
        String encounter = getRandomEncounterString();



        Room randomRoom = new Room(roomDetails[0], roomDetails[1]);
        randomRoom.setEncounterBehavior(encounterBehaviorFactory.createBehavior(encounter));
        randomRoom.setLootableBehavior(lootableBehaviorFactory.createBehavior(lootable));
        return randomRoom;
    }

    private String getRandomLootableString()
    {
        double rand = random.nextDouble();
        if(rand < 0.85){
            return  "HasLootable";
        }else{
            return "UnLootable";
        }
    }

    private String getRandomEncounterString()
    {
        double rand;
        rand = random.nextDouble();
        if(rand < 0.3)
        {
            return "NoEncounter";
        }else if(rand < 0.4)
        {
            return "PuppyEncounter";
        }else if(rand < 0.65)
        {
            return "SkeletonEncounter";
        }else if(rand < 0.9)
        {
            return "TrollEncounter";
        }else
        {
            return "ZombieEncounter";
        }
    }
}
