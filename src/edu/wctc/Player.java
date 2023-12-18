package edu.wctc;

import edu.wctc.Action.ActionDetail;
import edu.wctc.Action.LootActionDetail;
import edu.wctc.Loot.Loot;
import edu.wctc.Loot.Weapon;

import javax.swing.*;
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
    public boolean trySetEquippedWeapon(ActionDetail weaponAction){
        Weapon newWeapon = (canEquipBetterWeapon(weaponAction));
        if (newWeapon == null)
        {
            return false;
        }else
        {
            this.equippedWeapon = newWeapon;
            return true;
        }
    }

    public void scoreAction(ActionDetail action)
    {
        score += action.getPoints();
    }

    public void addToInventory(Loot loot)
    {
        inventory.add(loot);
    }

    //This is ugly.
    private Weapon canEquipBetterWeapon(ActionDetail action) {
        if(action instanceof LootActionDetail)
        {
            Loot loot = ((LootActionDetail) action).getLoot();
            if(loot instanceof Weapon)
            {

                Weapon newWeapon = (Weapon) loot;
                if(this.equippedWeapon == null) return newWeapon;
                return (newWeapon.getPower() > this.equippedWeapon.getPower()) ? newWeapon : null;
            }
        }
        return null;
    }

}
