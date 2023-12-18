package edu.wctc.Action;

import edu.wctc.Directions;
import edu.wctc.Room;

public class MoveActionDetail extends ActionDetail{
    private Directions dir;
    private Room newRoom;

    public MoveActionDetail(String detail, boolean success, Directions dir, Room newRoom) {
        super(detail, 0, success);
        this.dir = dir;
        this.newRoom = newRoom;
    }

    public Directions getMoveDirection()
    {
        return dir;
    }
    public Room getNewRoom()
    {
        return newRoom;
    }
}
