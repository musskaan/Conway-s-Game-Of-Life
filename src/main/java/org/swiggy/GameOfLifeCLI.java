package org.swiggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.swiggy.Cell.ALIVE_CELL;


public class GameOfLifeCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = InputHandler.promptForInt("Enter the number of rows: ");
        int columns = InputHandler.promptForInt("Enter the number of columns: ");
        int seedingPercentage = InputHandler.promptForInt("Enter the seeding percentage (0-100): ");

        GameSpace gameSpace = new GameSpace(rows, columns);
        seedGameSpace(gameSpace, rows, columns, seedingPercentage);

        GameController gameController = new GameController(gameSpace);

        System.out.println("Press Enter to start and stop the game.");
        scanner.nextLine();

        gameController.startGame();
    }

    private static void seedGameSpace(GameSpace gameSpace, int rows, int columns, int seedingPercentage) {
        int totalCells = rows * columns;
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < totalCells; i++) {
            indices.add(i);
        }

        Collections.shuffle(indices);

        int liveCellsToSeed = (int) (totalCells * (seedingPercentage / 100.0));

        for (int i = 0; i < liveCellsToSeed; i++) {
            int index = indices.get(i);
            int randomRow = index / columns;
            int randomColumn = index % columns;
            gameSpace.setCellState(ALIVE_CELL, randomRow, randomColumn);
        }
    }
}