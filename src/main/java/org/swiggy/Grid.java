package org.swiggy;

import java.util.Random;


/**
 * Represents a 2D grid of cells for Conway's Game of Life.
 * Provides methods to initialize the grid, evolve the game and query the state of individual cells.
 */
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

    /**
     * Initializes the grid with cells having random initial states (alive or dead).
     */
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

    /**
     * Evolves the entire grid to the next generation based on the rules of Conway's Game of Life.
     */
    public static void evolve() {
        GameEvolver.evolve(grid);
    }

    /**
     * Checks whether a cell at the specified coordinates is alive.
     *
     * @param row    The row index of the cell.
     * @param column The column index of the cell.
     * @return {@code true} if the cell is alive, {@code false} otherwise.
     */
    public boolean isCellAlive(int row, int column) {
        return isValidCell(row, column) && grid[row][column].isAlive();
    }

    public void setCellAlive(int row, int col) {
        if (isValidCell(row, col)) {
            grid[row][col].setAlive(true);
        }
    }

    public void setCellDead(int row, int col) {
        if (isValidCell(row, col)) {
            grid[row][col].setAlive(false);
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    void printCurrentState() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(isCellAlive(i, j) ? "O " : ". ");
            }
            System.out.println();
        }
    }
}
