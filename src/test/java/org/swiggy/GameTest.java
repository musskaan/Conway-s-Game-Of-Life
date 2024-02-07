package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    @Test
    void testStartGameCreatesThread_SetsIsRunning_RunsGameLoop() {
        GameSpace mockGameSpace = mock(GameSpace.class);
        Game game = new Game(mockGameSpace);

        assertFalse(Game.isRunning);

        game.start();

        assertTrue(Game.isRunning);
        verify(mockGameSpace, atLeastOnce()).evolveGrid();
    }

    @Test
    public void testStartGameTerminatesWhenAllCellsDead() {
        GameSpace mockGameSpace = mock(GameSpace.class);
        Game game = new Game(mockGameSpace);

        when(mockGameSpace.areAllCellsDead()).thenReturn(true);

        game.start();

        verify(mockGameSpace, times(1)).evolveGrid();
    }

    @Test
    void testStopGameSetsIsRunningToFalse() {
        GameSpace mockedGameSpace = mock(GameSpace.class);
        Game game = new Game(mockedGameSpace);

        game.start();

        assertTrue(Game.isRunning);

        game.stop();

        assertFalse(Game.isRunning);
    }
}