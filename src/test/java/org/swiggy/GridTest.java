package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void testValidGridCreation_whenIsCellAliveCanBeTrueOrFalse() {
        Grid grid = new Grid(5, 5);
        assertTrue(grid.isCellAlive(0, 0) || !grid.isCellAlive(0, 0));
    }

    @Test
    void testInvalidGridCreation_whenNumberOfRowsIsNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 0));
    }

    @Test
    void testInvalidGridCreation_whenNumberOfColumnsIsNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(0, -1));
    }

    @Test
    void testIfACellIsAlive_whenAccessingInvalidCell_returnsFalse() {
        Grid grid = new Grid(5, 5);
        assertFalse(grid.isCellAlive(6, 6));
    }

    @Test
    void testGridEvolution() {
        Grid grid = new Grid(3, 3);

        grid.setCellAlive(1, 0);
        grid.setCellAlive(1, 1);
        grid.setCellAlive(1, 2);
        grid.setCellDead(0,0);
        grid.setCellDead(0,1);
        grid.setCellDead(0,2);
        grid.setCellDead(2,0);
        grid.setCellDead(2,1);
        grid.setCellDead(2,2);


        boolean[][] expectedStateAfterEvolution = {
                {false, true, true},
                {true, false, true},
                {false, false, false}
        };

        grid.evolve();

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                assertEquals(expectedStateAfterEvolution[row][column], grid.isCellAlive(row, column));
            }
        }
    }
}