package edu.wctc.IO;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Action.LootActionDetail;
import edu.wctc.Directions;
import edu.wctc.Player;
import edu.wctc.Room;

import java.util.List;

public class MazeIOHandler implements IOHandler{
    private static InputHandler input;
    private static OutputHandler output;

    private static final String INVALID_MENU_INPUT = "Invalid input, please select a listed option.";

    public MazeIOHandler(InputHandler in, OutputHandler out){
        input = in;
        output = out;
    }

    @Override
    public void printGameSummary(Room currentRoom, Player player) {
        output.println("You gather yourself and leave the way you came.");
        output.println("Game Over.");
        output.println("\tYou ended your attempt in " + currentRoom.getName());
        output.println("\tFinal Score: " + player.getScore());
        output.println("\t\tThanks for playing!");
    }

    @Override
    public MainMenuOption mainMenu() {
        MainMenuOption choice;

        do{
            output.println("What would you like to do?  Enter the corresponding number");
            for(MainMenuOption option : MainMenuOption.values())
            {
                output.println(option.toString());
            }
            choice = receiveMenuUserInput();
        }while (choice == null);

        return choice;
    }


    @Override
    public Directions getMoveDirection(Room currentRoom) {
        Directions choice;
        output.println("Enter the number of the direction you would like to move in");

        List<Directions> validDirections = currentRoom.getAvailableDirectionsToMoveTo();
        do {
            for (Directions dir : validDirections
            ) {
                output.println(dir.getIndexOf() + ". " + dir);
            }
            choice = getUserDirectionInput();
        }while(choice == null);
        return choice;
    }


    @Override
    public void printObtainedNewWeapon(Player player) {
        output.println("You have now equipped the " + player.getEquippedWeapon().getName());
    }

    @Override
    public void printAction(ActionDetail action) {
        output.println("\n" + action.getDetail());
    }

    @Override
    public void printGameStatus(Room currentRoom, Player player) {
        output.println("\nYou are in the " + currentRoom.toString());
        if(currentRoom.hasEncounter() && !currentRoom.hasBeenDefeated())
        {
            output.println("\nENEMIES: " +currentRoom.getEncounterDetails());
        }
        output.println("Current Score: " + player.getScore() + "\n");
    }

    @Override
    public void printMoveDirection(Directions moveDirection) {
        output.println("You move to the " + moveDirection.toString());
    }

    @Override
    public void printWelcome() {
        output.println("\nWelcome to the MANSION");
        output.println("Your goal is to obtain as many points as possible");
        output.println("You can do so by:");
        output.println("\tLooting Items");
        output.println("\tDefeating Enemies");
        output.println("Be warned!:");
        output.println("\tYou may want to find a Weapon before tackling tough Enemy encounters");
        output.println("\tThere is no Map to reference.  Can you remember where you've been?");
        output.println("You may exit the game at any time.  GOOD LUCK.");
    }

    @Override
    public void printLoot(ActionDetail action) {
        if(action.getSuccess())
            output.println("You find a " + ((LootActionDetail)action).getLoot().getName());
    }

    private Directions getUserDirectionInput() {

        Directions choice;
        if(input.hasNextInt())
        {
            choice = getByDirectionNumber(input.nextInt());
        }else
        {
            output.println(INVALID_MENU_INPUT);
            input.next();
            choice = null;
        }
        return choice;
    }


    private MainMenuOption receiveMenuUserInput()
    {
        MainMenuOption choice;
        if(input.hasNextInt())
        {
            choice = getByItemNumber(input.nextInt());
        }else
        {
            output.println(INVALID_MENU_INPUT);
            input.next();
            choice = null;
        }
        return choice;
    }

    private MainMenuOption getByItemNumber(int itemNumber)
    {
        for(MainMenuOption option : MainMenuOption.values()) {
            if(option.getItemNumber() == itemNumber)
                return option;
        }
        output.println(INVALID_MENU_INPUT);
        return null;
    }

    private Directions getByDirectionNumber(int directionNumber)
    {
        for(Directions option : Directions.values()) {
            if(option.getIndexOf() == directionNumber)
                return option;
        }
        output.println(INVALID_MENU_INPUT);
        return null;
    }
}
