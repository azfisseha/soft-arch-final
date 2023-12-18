package edu.wctc.IO;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Directions;
import edu.wctc.Player;
import edu.wctc.Room;

public interface IOHandler {

    void printGameSummary(Room currentRoom, Player player);

    MainMenuOption mainMenu();

    Directions getMoveDirection(Room currentRoom);

    void printObtainedNewWeapon(Player player);

    void printAction(ActionDetail action);

    void printGameStatus(Room currentRoom, Player player);

    void printMoveDirection(Directions moveDirection);

    void printWelcome();

    void printLoot(ActionDetail action);
}
