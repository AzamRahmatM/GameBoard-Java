# WalkingBoard Java Assignment

This Java project simulates a dynamic board game where a figure moves around a grid, altering the board's values as it progresses. It includes both a **basic exercise** and an **extended exercise** that adds complexity through player management and additional game mechanics.

## Features

### Base Exercise (9 Points)

The **WalkingBoard** class represents a board with varying dimensions and values. A figure starts at a specific position on the board and can move in multiple directions, updating board values along the way.

- **Board Initialization**:
  - Initialize the board in two ways:
    1. A `size x size` board where all positions have a default value (`BASE_TILE_SCORE`).
    2. A custom-sized board with provided dimensions and initial values.
  - Ensure non-uniform row sizes can be handled.
  - Values below `BASE_TILE_SCORE` are replaced with `BASE_TILE_SCORE`.

- **Board Operations**:
  - `getPosition`: Returns the current position (x, y) of the figure.
  - `getTile`: Returns the value at a given position. Throws `IllegalArgumentException` if the position is invalid.
  - `getTiles`: Returns a deep copy of the entire board structure, preventing access to internal data.
  - **Movement Operations**:
    - `moveAndSet`: Moves the figure and updates the new position's value. If the move is invalid (outside the board), the move is canceled, and the method returns 0.
    - `setAndMove`: Similar to `moveAndSet`, but changes the value of the current position before moving.
    - Helper methods `getXStep` and `getYStep` assist in determining movement in the x and y directions, respectively.

### Extended Exercise (6 Points)

The extended version introduces **players** into the simulation, with specific mechanics for movement and scoring.

- **Player Mechanics**:
  - Players take turns moving around the board, following specific rules for movement and direction changes.
  - One player, the **MadlyRotatingBuccaneer**, has unique movement mechanics that vary depending on how many times they've taken their turn.
  
- **Movement and Scoring**:
  - Each player follows a directional path based on a predefined array of steps.
  - A player's score increases based on the board's value at their new position after each move.
  - The `move` method ensures players move in the correct order, and their score is updated after each step.

## How to Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/YourUsername/WalkingBoard-Java.git
    cd WalkingBoard-Java
    ```

2. **Compile and run the program**:
    Use a Java IDE (e.g., **IntelliJ IDEA**, **Eclipse**) or compile the code using the command line:
    ```bash
    javac WalkingBoard.java
    java WalkingBoard
    ```

3. **JUnit 5 Testing**:
    - The project includes a suite of **JUnit 5** tests that validate the functionality of the WalkingBoard simulation.
    - Run the tests using your IDE's testing tools or from the command line:
      ```bash
      java -cp .:path/to/junit-5.8.1.jar org.junit.runner.JUnitCore WalkingBoardTest
      ```

## JUnit 5 Tests

- **Basic Tests**:
  - `testSimpleInit`: Validates board initialization for both constructors.
  - `testMoves`: Tests movement mechanics, ensuring the board updates correctly.
  
- **Extended Tests**:
  - `testCustomInit`: Ensures non-uniform rows are handled and values smaller than `BASE_TILE_SCORE` are replaced.
  - `testPlayers`: Verifies player movement, score tracking, and special player behaviors (like the **MadlyRotatingBuccaneer**).

## Example Usage

```java
WalkingBoard board = new WalkingBoard(5); // Initialize a 5x5 board
board.moveAndSet(2, 3, 5); // Move figure to (2,3) and set the tile value to 5
System.out.println(Arrays.toString(board.getPosition())); // Get current position
