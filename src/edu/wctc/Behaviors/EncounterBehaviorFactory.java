package edu.wctc.Behaviors;

import edu.wctc.Behaviors.Concrete.*;

import java.util.Random;

public class EncounterBehaviorFactory {
    private Random rand = new Random();
    public EncounterBehaviorFactory(){}
    public EncounterBehavior createBehavior(String type) {
        EncounterBehavior behavior = null;
        switch (type)
        {
            case "NoEncounter" ->
                behavior = new NoEncounterBehavior();
            case "PuppyEncounter" ->
                behavior = new PuppyEncounterBehavior(rand.nextInt(3, 5));
            case "SkeletonEncounter" ->
                behavior = new SkeletonEncounterBehavior(rand.nextInt(5, 7));
            case "TrollEncounter" ->
                behavior = new TrollEncounterBehavior(rand.nextInt(2, 3));
            case "ZombieEncounter" ->
                behavior = new ZombieEncounterBehavior(rand.nextInt(2, 7));
        }
        return behavior;
    }
}
