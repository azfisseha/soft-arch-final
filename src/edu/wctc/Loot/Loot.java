package edu.wctc.Loot;

public abstract class Loot {
    private String name;
    private String description;
    private int points;

    public Loot(String name, String description, int points)
    {
        this.name = name;
        this.description = description;
        this.points = points;
    }

    public String getName() { return name; }
    public String getDescription()
    {
        return description;
    }
    public int getPoints()
    {
        return points;
    }

}
