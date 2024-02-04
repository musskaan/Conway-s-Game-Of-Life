package org.swiggy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
     * Starts the game loop asynchronously. The game will evolve continuously until stopped or all cells are dead.
     */
    public void startGame() {
        isRunning = true;

        new Thread(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (isRunning) {
                try {
                    // Check if Enter is pressed
                    if (reader.ready() && reader.readLine().isEmpty()) {
                        stopGame();
                        System.out.println("Game over!");
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

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

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Stops the game loop, allowing the game to exit.
     */
    public void stopGame() {
        isRunning = false;
    }
}
