## CSCE 10204: Programming Assignment: The Vectors Game

### 1. Project Overview and Object-Oriented Requirements
For this assignment, you will develop a console-based strategy game called **Vectors**, played on an 8x8 grid where a human player (`X`) competes against a computer player (`C`). 

* **Object-Oriented Design:** The project must be implemented using proper Object-Oriented Programming (OOP) techniques with classes, objects, encapsulation, and appropriate methods.
* **Main Class:** Your primary execution class must be titled **`Vectors`**. 

### 2. Game Rules and Mechanics
* **Grid Specifications:** The game is played on a fixed 8x8 grid. Rows and columns are indexed from `0` to `7`.
* **Turn Sequence:** 
  1. At the start of the game, the player chooses the total number of rounds (default is 20).
  2. Each round, the player enters their move as a coordinate pair in the format: `row column` (e.g., `3 6`).
  3. The move must target an **unoccupied** space within bounds. If the move is invalid, display an error message and re-prompt the user until a valid move is entered.
  4. After a valid player move, the computer automatically makes its move.
* **Computer AI Behavior:** You have complete creative freedom regarding how the computer AI functions. You may implement any type of AI strategy you wish (e.g., random placement, defensive blocking, heuristic-based offensive moves, etc.).
* **Round Scoring:** At the end of each round, the game scans the board for valid vectors, calculates the points earned, and adds them to each player's cumulative total.

### 3. Scoring System and Vector Rules
Vectors are formed by continuous sequences of tokens in horizontal, vertical, or diagonal directions. Points are awarded based on the length of the vector according to the table below:

| Vector Length | Points Awarded |
| :--- | :--- |
| **3** | 4 points |
| **4** | 6 points |
| **5** | 10 points |

* **No Overlapping Vectors:** Vectors cannot overlap or nest. If a longer continuous sequence is formed, **only the longest vector is counted** (sub-segments within that sequence do not score separately).
* **Final Score:** The final game score is calculated as the difference between the Player's Total Score and the Computer's Total Score.

### 4. High Score Persistence
* The game must track and save the highest final score along with the player's name to a file.
* If no previous high score exists (e.g., on the first run), the default high score should be initialized to `0`.

### 5. Interface Requirements
Your console output for the game board, status headers, and prompts must match the layout and formatting of the example below precisely.

```text
**************************************
- V E C T O R S                      *
**************************************
- High Score: John – 123             *
**************************************
- Player Score:    15 Last Round   9 *
- Computer Score:   6 Last Round   3 *
**************************************
- Turn 7 of 20                       *
**************************************
  0   1   2   3   4   5   6   7  
---------------------------------
|   | C |   |   | C |   |   |   | 0
---------------------------------
|   |   |   | X |   |   |   |   | 1
---------------------------------
|   |   |   | X |   |   |   |   | 2
---------------------------------
| C |   |   | X | X | X |   |   | 3
---------------------------------
|   |   |   |   |   | X |   |   | 4
---------------------------------
|   |   |   |   |   |   | C |   | 5
---------------------------------
|   |   |   |   |   |   | C |   | 6
---------------------------------
|   |   |   |   |   |   | C |   | 7
---------------------------------
Player(X) Turn (Row Col): 3 6
