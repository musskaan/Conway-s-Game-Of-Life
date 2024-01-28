package org.swiggy;

/**
 * Manages the evolution of the game grid according to Conway's Game of Life rules.
 * Provides methods to evolve the grid, count live neighbors and manage the game state.
 */
public class GameEvolver {

    /**
     * Evolves the given grid to the next generation based on the rules of Conway's Game of Life.
     *
     * @param grid The 2D array representing the current state of the game.
     */
    public static void evolve(Cell[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Cell[][] newGrid = new Cell[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int liveNeighbors = countLiveNeighbors(grid, row, column);
                grid[row][column].evolve(liveNeighbors);

                newGrid[row][column] = new Cell(row, column, grid[row][column].isAlive());
            }
        }

        // Swap the new grid with the current grid
        for (int i = 0; i < rows; i++) {
            System.arraycopy(newGrid[i], 0, grid[i], 0, columns);
        }
    }

    private static int countLiveNeighbors(Cell[][] grid, int row, int column) {
        int liveNeighbors = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {

                // Skip the cell itself
                if(x == row && y == column) {
                    continue;
                }

                int neighborRow = row + x;
                int neighborColumn = column + y;

                // Check if the neighboring cell is within the grid boundaries and it is alive
                if (isValidCell(grid, neighborRow, neighborColumn) && grid[neighborRow][neighborColumn].isAlive()) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }

    private static boolean isValidCell(Cell[][] grid, int row, int col) {
        int rows = grid.length;
        int columns = grid[0].length;

        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}
