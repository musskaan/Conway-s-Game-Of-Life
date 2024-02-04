package org.swiggy;

import static org.swiggy.Cell.ALIVE_CELL;
import static org.swiggy.Cell.DEAD_CELL;


/**
 * The Grid class represents a 2D grid of cells for Conway's Game of Life.
 * It provides methods to initialize the grid, access and manipulate the state of cells.
 */
public class Grid {

    private final int rows;
    private final int columns;

    /**
     * Two-dimensional array representing the cells in the grid.
     */
    private final Cell[][] cells;

    /**
     * Constructs a new grid with the specified number of rows and columns,
     * initializing all cells to be dead.
     *
     * @param rows    The number of rows in the grid.
     * @param columns The number of columns in the grid.
     */
    public Grid(int rows, int columns) {
        validateGrid(rows, columns);
        this.rows = rows;
        this.columns = columns;
        this.cells = initalizeGridWithDeadCells(rows, columns);
    }

    private static void validateGrid(final int rows, final int columns) throws IllegalArgumentException {
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException("Grid dimensions cannot be negative");
        }
    }

    /**
     * Initializes the grid with dead cells.
     *
     * @param rows    The number of rows in the grid.
     * @param columns The number of columns in the grid.
     * @return A 2D array representing the grid with all cells dead.
     */
    private Cell[][] initalizeGridWithDeadCells(int rows, int columns) {
        Cell[][] cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = DEAD_CELL;
            }
        }
        return cells;
    }
}
