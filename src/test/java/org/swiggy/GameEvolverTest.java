package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEvolverTest {

    @Test
    void testEvolve() {
        Cell[][] grid = new Cell[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Cell(i, j, false);
            }
        }

        grid[1][0].setAlive(true);
        grid[1][1].setAlive(true);
        grid[1][2].setAlive(true);

        GameEvolver.evolve(grid);

        boolean[][] expectedStateAfterEvolution = {
                {false, true, true},
                {true, false, true},
                {false, false, false}
        };

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                assertEquals(expectedStateAfterEvolution[row][column], grid[row][column].isAlive());
            }
        }
    }
}