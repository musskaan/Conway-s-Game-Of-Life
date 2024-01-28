# Conway's Game of Life

Conway's Game of Life is a cellular automation and a zero-player game, meaning that its evolution is determined by its initial state, with no further input from humans. The game follows a set of simple rules and exhibits complex and unpredictable behavior.

## Overview

This Java implementation includes the following classes:

- **Cell:** Represents a cell in a 2D grid and provides methods for evolving its state.
- **GameEvolver:** Manages the evolution of the game grid according to the rules of Conway's Game of Life.
- **Grid:** Represents a 2D grid of cells for the game and provides methods to initialize the grid and query cell states.
- **GameController:** Manages the game logic, including starting and stopping the game loop.

## Getting Started

To run the game, follow these steps and adjust the grid dimensions and other parameters as needed:

1. **Navigate to the Project Directory**:

    ```bash
   cd src

2. **Build Pre-requisite**:

   JDK version - 21


3. **Steps to Compile and Run the Program**:

    ```bash
   javac GameOfLife.java

   java GameOfLife

4. **Provide input**:

    * Press Enter to start the game.
    * Press Enter again to stop the game.

### **Gameplay**:

    The grid updates according to the following rules: 
    1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
    2. Any live cell with two or three live neighbors lives on to the next generation.
    3. Any live cell with more than three live neighbors dies, as if by overpopulation.
    4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

### Author:

Muskaan Agrawal

muskaan.agrawal_ftc@external.swiggy.in

