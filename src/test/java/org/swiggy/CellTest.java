package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testValidCellCreation_whenCellIsAlive() {
        Cell cell = new Cell(1, 2, true);
        assertTrue(cell.isAlive());
    }

    @Test
    void testValidCellCreation_whenCellIsNotAlive() {
        Cell cell = new Cell(1, 2);
        assertFalse(cell.isAlive());
    }

    @Test
    void testInvalidCellCreation_whenXIsNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 0, false));
    }

    @Test
    void testInvalidCellCreation_whenYIsNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(0, -1, false));
    }

    @Test
    void testCellEvolution_whenIsALiveTrueLiveNeighbours2_setsIsAliveTrue() {
        Cell cell = new Cell(0, 0, true);
        cell.evolve(2);
        assertTrue(cell.isAlive());
    }

    @Test
    void testCellEvolution_whenIsALiveTrueLiveNeighbours3_setsIsAliveTrue() {
        Cell cell = new Cell(0, 0, true);
        cell.evolve(3);
        assertTrue(cell.isAlive());
    }

    @Test
    void testCellEvolution_whenIsALiveTrueLiveNeighbours1_setsIsAliveFalse() {
        Cell cell = new Cell(0, 0, true);
        cell.evolve(1);
        assertFalse(cell.isAlive());
    }

    @Test
    void testCellEvolution_whenIssALiveFalseLiveNeighbours3_setsIsAliveTrue() {
        Cell cell = new Cell(0, 0, false);
        cell.evolve(3);
        assertTrue(cell.isAlive());
    }
}