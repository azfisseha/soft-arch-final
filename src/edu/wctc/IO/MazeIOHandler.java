package edu.wctc.IO;

import edu.wctc.MainMenuOption;
import edu.wctc.Room;

public class MazeIOHandler implements IOHandler{
    private static InputHandler input;
    private static OutputHandler output;

    public MazeIOHandler(InputHandler in, OutputHandler out){
        input = in;
        output = out;
    }

    @Override
    public MainMenuOption mainMenu() {
        MainMenuOption choice;

        do{
            output.println("What would you like to do?");
            for(MainMenuOption option : MainMenuOption.values())
            {
                output.println(option.toString());
            }
            choice = receiveUserInput();
        }while (choice == null);

        return choice;
    }

    private MainMenuOption receiveUserInput()
    {
        MainMenuOption choice;
        if(input.hasNextInt())
        {
            choice = getByItemNumber(input.nextInt());
        }else
        {
            output.println("Invalid input, please select an option from the menu.");
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
        return null;
    }

    @Override
    public void printRoom(Room currentRoom) {

    }
}
