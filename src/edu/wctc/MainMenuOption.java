package edu.wctc;

public enum MainMenuOption {
    DESC(1, "Repeat Room Description"),
    LOOT(2, "Loot"),
    FIGHT(3, "Fight"),
    MOVE(4, "Move to another Room"),
    EXIT(5, "Exit Game");

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
