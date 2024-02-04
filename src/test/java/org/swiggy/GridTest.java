package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void testInvalidGridCreation_whenNumberOfRowsIsNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 0));
    }

    @Test
    void testInvalidGridCreation_whenNumberOfColumnsIsNegative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(0, -1));
    }
}