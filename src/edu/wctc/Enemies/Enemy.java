package edu.wctc.Enemies;

public abstract class Enemy {
    protected String detail;
    protected int power;
    protected int points;

    public final String getDetail()
    {
        return detail;
    }

    public final int getPower()
    {
        return power;
    }

    public final int getPoints() { return points; }
}
