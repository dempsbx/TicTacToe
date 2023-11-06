
import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the Board object which represents the
 * Tic Tac Toe Board
 * 
 * CSC 6002 – Foundations of Programming 2
 * Project #4 - Tic Tac Toe
 * 
 * @author Billy Dempsey - dempseyw@merrimack.edu
 */
public class Board {

    // 3x3 character array that represents the 9 squares on the Tic Tac Toe board
    private char[][] square = new char[3][3];

    char blank = ' '; // Variable for blank space

    public Board() {
        // Nested for loop to intialize all array coordinates to blanks
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                square[column][row] = blank;
            }
        }
    }

    /**
     * This method draws the current state of the TicTacToe board.
     */
    public void draw() {
        StringBuilder boardBuilder = new StringBuilder();

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                // Add the square value with a space, add "|" after first and second square
                boardBuilder.append(" ").append(square[column][row]).append(" ");
                if (column < 2) {
                    boardBuilder.append("|");
                }
            }
            // Do not add the row divider after the last row
            if (row < 2) {
                boardBuilder.append("\n---+---+---\n");
            }
        }

        // Print the constructed board
        System.out.println(boardBuilder.toString());
    }

    /**
     * This method checks the state of the board and returns one of the
     * BoardStatus enum values
     *
     * @return
     */
    public BoardStatus determineBoardStatus() {
        // Check for a win in rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if (checkForWin(square[i][0], square[i][1], square[i][2])) {
                return square[i][0] == 'X' ? BoardStatus.X_WON : BoardStatus.O_WON;
            }
            if (checkForWin(square[0][i], square[1][i], square[2][i])) {
                return square[0][i] == 'X' ? BoardStatus.X_WON : BoardStatus.O_WON;
            }
        }

        // Check diagonals
        if (checkForWin(square[0][0], square[1][1], square[2][2]) ||
                checkForWin(square[0][2], square[1][1], square[2][0])) {
            return square[1][1] == 'X' ? BoardStatus.X_WON : BoardStatus.O_WON;
        }

        // Check for draw or unfinished game
        boolean isFull = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (square[col][row] == blank) {
                    isFull = false;
                    break;
                }
            }
            if (!isFull)
                break;
        }

        return isFull ? BoardStatus.DRAW : BoardStatus.UNFINISHED;
    }

    private boolean checkForWin(char c1, char c2, char c3) {
        return (c1 != blank) && (c1 == c2) && (c2 == c3);
    }

    /**
     * This method is recursively called for the computer opponent to simulate
     * all possible outcomes of the game and determine the best possible move to
     * make and returns it.
     *
     * @param currentPlayer
     * @return
     */

    public Move makeAMove(char currentPlayer) {
        // Determine if the game is over
        BoardStatus status = determineBoardStatus();

        // If the game is over, return the score without considering currentPlayer
        if (status != BoardStatus.UNFINISHED) {
            int score = evaluateScore(status);
            Move move = new Move();
            move.setScore(score);
            return move;
        }

        // List to hold all possible moves and their scores
        List<Move> moves = new ArrayList<>();

        // Loop through all squares of the board
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                // If the square is empty, it's a valid move
                if (getSquare(column, row) == blank) {
                    Move move = new Move();
                    move.setRow(row);
                    move.setColumn(column);
                    move.setBoardStatus(status);

                    // Make the move
                    setSquare(column, row, currentPlayer);

                    // Recur to evaluate this move
                    char nextPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    Move result = makeAMove(nextPlayer);
                    move.setScore(result.getScore());

                    // Undo the move
                    setSquare(column, row, blank);

                    // Add the move to our list
                    moves.add(move);
                }
            }
        }

        // Now choose the best move from the list of moves
        int bestScore = (currentPlayer == 'X') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Move bestMove = null;

        for (Move move : moves) {
            if ((currentPlayer == 'X' && move.getScore() > bestScore) ||
                    (currentPlayer == 'O' && move.getScore() < bestScore)) {
                bestScore = move.getScore();
                bestMove = move;
            }
        }

        // Return the best move for the current player
        return bestMove;
    }

    private int evaluateScore(BoardStatus status) {
        // Scores are from the AI's perspective (assume 'X' is AI)
        switch (status) {
            case X_WON:
                return 10; // AI win is positive
            case O_WON:
                return -10; // Human win is negative
            case DRAW:
                return 0; // Draw is neutral
            default:
                throw new IllegalArgumentException("BoardStatus not recognized in evaluateScore");
        }
    }

    /**
     * Get the value of square
     *
     * @param column
     * @param row
     * @return the value of square
     */
    public char getSquare(int column, int row) {
        char entry = square[column][row];
        return entry;
    }

    /**
     * Set the value of square
     *
     * @param column
     * @param row
     * @param c
     */
    public void setSquare(int column, int row, char c) {
        square[column][row] = c;

    }

}
