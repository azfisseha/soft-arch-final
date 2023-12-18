package edu.wctc;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Action.MoveActionDetail;
import edu.wctc.IO.*;

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
        ioHandler.printWelcome();

        MainMenuOption choice;
        do {
            ioHandler.printGameStatus(currentRoom, player);

            ActionDetail action = null;
            choice = ioHandler.mainMenu();
            switch (choice) {
                case LOOT:
                    action = currentRoom.loot();
                    handleLoot(action);
                    break;
                case FIGHT:
                    action = currentRoom.fight(player.getEquippedWeapon());
                    break;
                case MOVE:
                    action = currentRoom.move(ioHandler.getMoveDirection(currentRoom));
                    handleMove(action);
                    break;
            }
            if(action != null) {
                ioHandler.printAction(action);
                player.scoreAction(action);
            }
        }while(choice != MainMenuOption.EXIT);

        ioHandler.printGameSummary(currentRoom, player);
    }

    private void handleMove(ActionDetail action) {
        if(action.getSuccess())
        {
            MoveActionDetail moveAction = (MoveActionDetail) action;
            currentRoom = moveAction.getNewRoom();
            ioHandler.printMoveDirection(moveAction.getMoveDirection());
        }

    }

    private void handleLoot(ActionDetail action)
    {
        ioHandler.printLoot(action);
        if (player.trySetEquippedWeapon(action))
        {
             ioHandler.printObtainedNewWeapon(player);
        }
    }
}
