package edu.wctc.IO;

public enum MainMenuOption {
    LOOT(1, "Loot"),
    FIGHT(2, "Fight"),
    MOVE(3, "Move to another Room"),
    EXIT(4, "Exit Game");

    private int itemNumber;
    private String prettyPrint;

    MainMenuOption(int itemNumber, String prettyPrint)
    {
        this.itemNumber = itemNumber;
        this.prettyPrint = prettyPrint;
    }



    public int getItemNumber() {
        return itemNumber;
    }

    public String getPrettyPrint() {
        return prettyPrint;
    }

    @Override
    public String toString() {
        return itemNumber + ". " + prettyPrint;
    }
}
