package org.swiggy;

public class GameController {

    private final Grid game;
    private static final int TIME_DELAY = 1000;
    static boolean isRunning;

    public GameController(Grid game) {
        this.game = game;
        isRunning = false;
    }

    public void startGame() {
        isRunning = true;

        new Thread(() -> {
            while (isRunning) {
                game.printCurrentState();
                Grid.evolve();

                try {
                    Thread.sleep(TIME_DELAY);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stopGame() {
        isRunning = false;
    }
}
