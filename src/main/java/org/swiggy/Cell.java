package org.swiggy;

public class Cell {

    private final int x;
    private final int y;
    private boolean isAlive;

    Cell(int x, int y) {
        this(x, y, false);
    }

    Cell(int x, int y, boolean isAlive) {
        validateCell(x, y);
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }

    private static void validateCell(final int x, final int y) throws IllegalArgumentException{
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Cell coordinates cannot be negative");
        }
    }

    boolean isAlive() {
        return isAlive;
    }

    void setAlive(final boolean isAlive) {
        this.isAlive = isAlive;
    }

    void evolve(int liveNeighbors) {
        if (isAlive) {
            setAlive(liveNeighbors == 2 || liveNeighbors == 3);
        } else {
            setAlive(liveNeighbors == 3);
        }
    }
}
