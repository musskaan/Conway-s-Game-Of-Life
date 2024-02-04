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

    /**
     * Constructs a new grid with the specified initial state of cells.
     *
     * @param cells The initial state of cells in the grid.
     * @throws IllegalArgumentException if the initialCells array is null or empty.
     */
    public Grid(Cell[][] cells) {
        if (cells == null || cells.length == 0 || cells[0].length == 0) {
            throw new IllegalArgumentException("Invalid initialCells");
        }
        this.rows = cells.length;
        this.columns = cells[0].length;
        this.cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            System.arraycopy(cells[row], 0, this.cells[row], 0, columns);
        }
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

    /**
     * Gets the number of live neighbors around a cell at the specified coordinates.
     *
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     * @return The number of live neighbors around the specified cell.
     */
    public int getAliveNeighboursAt(int x, int y) {
        int aliveNeighbourCount = 0;
        for (int dx = x - 1; dx <= x + 1; dx++) {
            for (int dy = y - 1; dy <= y + 1; dy++) {
                if (!isCellItself(dx, dy, x, y)) {
                    aliveNeighbourCount += isAliveInCell(dx, dy);
                }
            }
        }
        return aliveNeighbourCount;
    }

    /**
     * Checks if the given coordinates represent the same cell.
     *
     * @return true if the coordinates represent the same cell, false otherwise.
     */
    private boolean isCellItself(int x1, int y1, int x2, int y2) {
        return (x1 == x2) && (y1 == y2);
    }

    /**
     * Checks if the cell at the specified coordinates is alive.
     *
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     * @return 1 if the cell is alive, 0 if the cell is dead or the coordinates are out of bounds.
     */
    private int isAliveInCell(int x, int y) {
        if (isValidCell(x, y)) {
            return 0;
        }
        if (cells[x][y] == ALIVE_CELL) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isValidCell(int x, int y) {
        return (x < 0 || x > getRows() - 1) || (y < 0 || y > getColumns() - 1);
    }


    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public Cell[][] getCells() {
        Cell[][] contentCopy = new Cell[getRows()][getColumns()];
        for (int row = 0; row < getRows(); row++) {
            if (getColumns() >= 0) System.arraycopy(cells[row], 0, contentCopy[row], 0, getColumns());
        }
        return contentCopy;
    }

    public Cell getCellAt(int x, int y) {
        return cells[x][y];
    }

    /**
     * Sets the state of the cell at the specified coordinates.
     *
     * @param cell The new state of the cell.
     * @param x    The x-coordinate of the cell.
     * @param y    The y-coordinate of the cell.
     */
    public void setCell(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }
}
