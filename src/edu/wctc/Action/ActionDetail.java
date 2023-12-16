package edu.wctc.Action;

public abstract class ActionDetail {
    private String detail;
    private int points;
    private boolean success;

    public ActionDetail(String detail, int points, boolean success) {
        this.detail = detail;
        this.points = points;
        this.success = success;
    }

    public int getPoints()
    {
        return points;
    }

    public boolean getSuccess()
    {
        return success;
    }

    public String getDetail()
    {
        return detail;
    }
}
