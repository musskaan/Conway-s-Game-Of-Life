package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    public void testGameControllerStartAndStop() {
        Grid game = new Grid(3, 3);
        GameController gameController = new GameController(game);
        assertFalse(GameController.isRunning);

        gameController.startGame();
        assertTrue(GameController.isRunning);

        gameController.stopGame();
        assertFalse(GameController.isRunning);
    }

}