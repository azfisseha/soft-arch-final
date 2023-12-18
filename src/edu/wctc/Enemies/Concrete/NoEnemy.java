package edu.wctc.Enemies.Concrete;

import edu.wctc.Enemies.Enemy;

public class NoEnemy extends Enemy {

    public NoEnemy() {
        this.detail = "There is nothing to fight in this room.";
        this.power = 0;
        this.points = 0;
    }


}
