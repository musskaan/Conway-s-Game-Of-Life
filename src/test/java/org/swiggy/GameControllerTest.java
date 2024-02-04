package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameControllerTest {

    @Test
    void testStartGameCreatesThread_SetsIsRunning_RunsGameLoop() {
        GameSpace mockGameSpace = mock(GameSpace.class);
        GameController gameController = new GameController(mockGameSpace);

        assertFalse(GameController.isRunning);

        gameController.startGame();

        assertTrue(GameController.isRunning);
        verify(mockGameSpace, atLeastOnce()).evolveGrid();
    }

    @Test
    public void testStartGameTerminatesWhenAllCellsDead() {
        GameSpace mockGameSpace = mock(GameSpace.class);
        GameController gameController = new GameController(mockGameSpace);

        when(mockGameSpace.areAllCellsDead()).thenReturn(true);

        gameController.startGame();

        verify(mockGameSpace, times(1)).evolveGrid();
    }

    @Test
    void testStopGameSetsIsRunningToFalse() {
        GameSpace mockedGameSpace = mock(GameSpace.class);
        GameController gameController = new GameController(mockedGameSpace);

        gameController.startGame();

        assertTrue(GameController.isRunning);

        gameController.stopGame();

        assertFalse(GameController.isRunning);
    }
}