package edu.wctc;

public enum Directions {
    NORTH(1, "North"),
    EAST(2, "East"),
    SOUTH(3, "South"),
    WEST(4, "West");

    private int indexOf;
    private String prettyPrint;

    Directions(int indexOf, String pretty){
        this.indexOf = indexOf;
        this.prettyPrint = pretty;
    }

    public int getIndexOf() {
        return indexOf;
    }


    @Override
    public String toString() {
        return this.prettyPrint;
    }
}
