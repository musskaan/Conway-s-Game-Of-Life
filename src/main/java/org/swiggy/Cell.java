package org.swiggy;


/**
 * Represents a cell in a 2D grid. Each cell has coordinates (x, y) and a state indicating whether it is alive or dead.
 * Provides methods to query and update the cell's state based on the rules of Conway's Game of Life.
 */
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

    /**
     * Updates the grid according to the following rules: <br>
     * 1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.<br>
     * 2. Any live cell with two or three live neighbors lives on to the next generation.<br>
     * 3. Any live cell with more than three live neighbors dies, as if by overpopulation.<br>
     * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * @param liveNeighbors The number of live neighbors surrounding the cell.
     */
    void evolve(int liveNeighbors) {
        if (isAlive) {
            setAlive(liveNeighbors == 2 || liveNeighbors == 3);
        } else {
            setAlive(liveNeighbors == 3);
        }
    }
}
