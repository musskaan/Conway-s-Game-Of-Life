package org.swiggy;

import java.util.Random;

public class Grid {

    private final int rows;
    private final int columns;
    private static Cell[][] grid;

    public Grid(int rows, int columns) {
        validateGrid(rows, columns);
        this.rows = rows;
        this.columns = columns;
        initializeGrid();
    }

    private static void validateGrid(final int rows, final int columns) throws IllegalArgumentException {
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException("Grid dimensions cannot be negative");
        }
    }

    public void initializeGrid() {
        Random random = new Random();
        grid = new Cell[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int randomValue = random.nextInt(3);

                grid[row][column] = new Cell(row, column);
                grid[row][column].setAlive(randomValue == 0);
            }
        }
    }

    public static void evolve() {
        GameEvolver.evolve(grid);
    }
}
