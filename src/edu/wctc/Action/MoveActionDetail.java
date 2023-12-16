package edu.wctc.Action;

import edu.wctc.Directions;

public class MoveActionDetail extends ActionDetail{
    private Directions dir;

    public MoveActionDetail(String detail, boolean success, Directions dir) {
        super(detail, 0, success);
        this.dir = dir;
    }

    public getMoveDirection();
}
