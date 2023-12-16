package edu.wctc.IO;

import edu.wctc.MainMenuOption;
import edu.wctc.Room;

public interface IOHandler {

    MainMenuOption mainMenu();
    void printRoom(Room currentRoom);
}
