package edu.wctc;

public enum Directions {
    NORTH(0, "North"),
    EAST(1, "East"),
    SOUTH(2, "South"),
    WEST(3, "West");

    private int indexOf;
    private String prettyPrint;

    Directions(int indexOf, String pretty){
        this.indexOf = indexOf;
        this.prettyPrint = pretty;
    }

    public int getIndexOf() {
        return indexOf;
    }

    public Directions getOpposite()
    {
        return switch (indexOf) {
            case 0 -> SOUTH;
            case 1 -> WEST;
            case 2 -> NORTH;
            case 3 -> EAST;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return this.prettyPrint;
    }
}
