package org.swiggy;


/**
 * Manages the game logic, including starting and stopping the game loop.
 * Coordinates interactions between the user and the game grid.
 */
public class GameController {

    private final GameSpace gameSpace;
    private static final int TIME_DELAY = 1000;
    static boolean isRunning;

    public GameController(GameSpace gameSpace) {
        this.gameSpace = gameSpace;
        isRunning = false;
    }

    /**
     * Starts the game loop asynchronously. The game will evolve continuously until stopped.
     */
    public void startGame() {
        isRunning = true;

        new Thread(() -> {
            while (isRunning) {
                gameSpace.evolveGrid();
                System.out.println(gameSpace);

                if (gameSpace.areAllCellsDead()) {
                    stopGame();
                    System.out.println("All cells are dead. Game over!");
                    break;
                }

                try {
                    Thread.sleep(TIME_DELAY);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Stops the game loop, allowing the game to exit its continuous evolution.
     */
    public void stopGame() {
        isRunning = false;
    }
}
