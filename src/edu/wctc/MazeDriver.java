package edu.wctc;

import edu.wctc.Action.ActionDetail;
import edu.wctc.IO.ConsoleInputHandler;
import edu.wctc.IO.ConsoleOutputHandler;
import edu.wctc.IO.IOHandler;
import edu.wctc.IO.MazeIOHandler;

public class MazeDriver {
    public static void main(String[] args) {
        MazeDriver game = new MazeDriver();
        game.runGame();
    }

    private IOHandler ioHandler;
    private Maze maze;
    private Room currentRoom;
    private Player player;

    public MazeDriver()
    {
        this.ioHandler = new MazeIOHandler(new ConsoleInputHandler(), new ConsoleOutputHandler());

        //the size of the Maze.  This could be queried out to the user if desired.
        maze = Maze.getInstance(4, 4);

        currentRoom = maze.constructMaze();
        player = Player.getInstance();
    }

    public void runGame()
    {

        MainMenuOption choice;
        do
        {
            ActionDetail action;
            choice = ioHandler.mainMenu();
            switch(choice){
                case DESC ->
                        ioHandler.printRoom(currentRoom);
                case LOOT ->
                        action = currentRoom.loot();
                case FIGHT ->
                        action = currentRoom.fight(player.getEquippedWeapon());
                case MOVE ->
                        action = currentRoom.move(ioHandler.getMoveDirection());
            }
        }while(choice != MainMenuOption.EXIT);

        IOHandler.printGameSummary(currentRoom, player);
    }
}
