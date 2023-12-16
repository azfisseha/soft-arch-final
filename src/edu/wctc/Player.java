package edu.wctc;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Loot.Loot;
import edu.wctc.Loot.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Loot> inventory;
    private int score;
    private Weapon equippedWeapon;

    private volatile static Player uniqueInstance;

    private Player()
    {
        inventory = new ArrayList<Loot>();
    }

    public static Player getInstance()
    {
        if(uniqueInstance == null)
        {
            synchronized (Player.class) {
                if(uniqueInstance == null)
                {
                    uniqueInstance = new Player();
                }
            }
        }
        return uniqueInstance;
    }

    public List<Loot> getInventory()
    {
        return inventory;
    }

    public int getScore() {
        return score;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void scoreAction(ActionDetail action)
    {
        score += action.getPoints();
    }

    public void addToInventory(Loot loot)
    {
        inventory.add(loot);
    }
}
