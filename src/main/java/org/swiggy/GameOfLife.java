package org.swiggy;

import java.util.Scanner;


public class GameOfLife {
    private static final int ROWS = 50;
    private static final int COLUMNS = 60;

    public static void main(String[] args) {
        Grid gameGrid = new Grid(ROWS, COLUMNS);
        GameController gameController = new GameController(gameGrid);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter to start the game.");
        scanner.nextLine();

        gameController.startGame();

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                gameController.stopGame();
                break;
            }
        }

        System.out.println("Game over!");
    }
}