
import java.util.Scanner;

/**
 * This class executes the TicTacToe program. The user is presented with
 * a menu that loops until the option to end the program is chosen.
 * 
 * CSC 6002 – Foundations of Programming 2
 * Project #4 - Tic Tac Toe
 * 
 * @author Billy Dempsey - dempseyw@merrimack.edu
 */
public class TicTacToe {

    public static void main(String args[]) {

        Board currentBoard;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Tic Tac Toe");
            System.out.println("1. Play against human");
            System.out.println("2. Play against computer (Human: X, Computer: O)");
            System.out.println("3. Play against computer (Computer: X, Human: O)");
            System.out.println("4. End program");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // play against human here
                    currentBoard = new Board();
                    currentBoard.draw();
                    Scanner in = new Scanner(System.in);
                    // While gameboard is unfinished
                    BoardStatus status = currentBoard.determineBoardStatus();
                    // System.out.println(status);
                    while (status == BoardStatus.UNFINISHED) {
                        // Prompt user for to enter valid column for x
                        System.out.println("Enter a column (0-2) for 'X':");
                        int xColumn = in.nextInt();
                        // Check if valid column
                        while (xColumn > 2 || xColumn < 0) {
                            System.out.println("Invalid column");
                            System.out.println("Enter a column (0-2) for 'X':");
                            xColumn = in.nextInt();
                        }
                        // Prompt user to enter valid row for x
                        System.out.println("Enter a row (0-2) for 'X':");
                        int xRow = in.nextInt();
                        // Check if valid row
                        while (xRow > 2 || xRow < 0) {
                            System.out.println("Invalid row");
                            System.out.println("Enter a row (0-2) for 'X':");
                            xRow = in.nextInt();
                        }
                        // Check if the square is empty, prompt again if not
                        while (currentBoard.getSquare(xColumn, xRow) != ' ') {
                            System.out.println("Square not available, try again");
                            System.out.println("Enter a column (0-2) for 'X':");
                            xColumn = in.nextInt();
                            while (xColumn > 2 || xColumn < 0) {
                                System.out.println("Invalid column");
                                System.out.println("Enter a column (0-2) for 'X':");
                                xColumn = in.nextInt();
                            }
                            System.out.println("Enter a row (0-2) for 'X':");
                            xRow = in.nextInt();
                            while (xRow > 2 || xRow < 0) {
                                System.out.println("Invalid row");
                                System.out.println("Enter a row (0-2) for 'X':");
                                xRow = in.nextInt();
                            }

                        }
                        // If empty and valid, place the 'X'
                        if (currentBoard.getSquare(xColumn, xRow) == ' ') {
                            currentBoard.setSquare(xColumn, xRow, 'X');
                        }
                        // Draw the board
                        currentBoard.draw();

                        // Determine if the game is over, if so print out status
                        if (currentBoard.determineBoardStatus() != BoardStatus.UNFINISHED) {
                            System.out.println(currentBoard.determineBoardStatus());
                            break;
                        }

                        // If not repeat with 'O'
                        // Prompt user for to enter valid column for O
                        System.out.println("Enter a column (0-2) for 'O':");
                        int oColumn = in.nextInt();
                        // Check if valid column
                        while (oColumn > 2 || oColumn < 0) {
                            System.out.println("Invalid column");
                            System.out.println("Enter a column (0-2) for 'O':");
                            oColumn = in.nextInt();
                        }

                        // Prompt user to enter valid row for O
                        System.out.println("Enter a row (0-2) for 'O':");
                        int oRow = in.nextInt();
                        // Check if valid row
                        while (oRow > 2 || oRow < 0) {
                            System.out.println("Invalid row");
                            System.out.println("Enter a row (0-2) for 'O':");
                            oRow = in.nextInt();
                        }
                        // Check if the square is empty, prompt again if not
                        while (currentBoard.getSquare(oColumn, oRow) != ' ') {
                            System.out.println("Square not available, try again");
                            System.out.println("Enter a column (0-2) for 'O':");
                            oColumn = in.nextInt();
                            while (oColumn > 2 || oColumn < 0) {
                                System.out.println("Invalid column");
                                System.out.println("Enter a column (0-2) for 'O':");
                                oColumn = in.nextInt();
                            }
                            System.out.println("Enter a row (0-2) for 'O':");
                            oRow = in.nextInt();
                            while (oRow > 2 || oRow < 0) {
                                System.out.println("Invalid row");
                                System.out.println("Enter a row (0-2) for 'O':");
                                oRow = in.nextInt();
                            }
                        }

                        // If valid and empty, place the 'O'
                        if (currentBoard.getSquare(oColumn, oRow) == ' ') {
                            currentBoard.setSquare(oColumn, oRow, 'O');
                        }
                        // Draw the board
                        currentBoard.draw();

                        // Determine if the game is over, if so print out status
                        if (currentBoard.determineBoardStatus() != BoardStatus.UNFINISHED) {
                            System.out.println(currentBoard.determineBoardStatus());
                            break;
                        }
                    }
                    break;

                case 2:
                    // Play against computer (Human: X, Computer: O
                    currentBoard = new Board();
                    currentBoard.draw();
                    System.out.println();
                    status = currentBoard.determineBoardStatus();
                    in = new Scanner(System.in);
                    // While gameboard in unfinished
                    while (status == BoardStatus.UNFINISHED) {
                        // Prompt for X to enter a a column and row
                        // Prompt user for to enter valid column for x
                        System.out.println("Enter a column (0-2) for 'X':");
                        int xColumn = in.nextInt();
                        // Check if valid column
                        while (xColumn > 2 || xColumn < 0) {
                            System.out.println("Invalid column");
                            System.out.println("Enter a column (0-2) for 'X':");
                            xColumn = in.nextInt();
                        }
                        // Prompt user to enter valid row for x
                        System.out.println("Enter a row (0-2) for 'X':");
                        int xRow = in.nextInt();
                        // Check if valid row
                        while (xRow > 2 || xRow < 0) {
                            System.out.println("Invalid row");
                            System.out.println("Enter a row (0-2) for 'X':");
                            xRow = in.nextInt();
                        }
                        // Check if the square is empty, prompt again if not
                        while (currentBoard.getSquare(xColumn, xRow) != ' ') {
                            System.out.println("Square not available, try again");
                            System.out.println("Enter a column (0-2) for 'X':");
                            xColumn = in.nextInt();
                            while (xColumn > 2 || xColumn < 0) {
                                System.out.println("Invalid column");
                                System.out.println("Enter a column (0-2) for 'X':");
                                xColumn = in.nextInt();
                            }
                            System.out.println("Enter a row (0-2) for 'X':");
                            xRow = in.nextInt();
                            while (xRow > 2 || xRow < 0) {
                                System.out.println("Invalid row");
                                System.out.println("Enter a row (0-2) for 'X':");
                                xRow = in.nextInt();
                            }
                        }
                        // If empty and valid, place the 'X'
                        if (currentBoard.getSquare(xColumn, xRow) == ' ') {
                            currentBoard.setSquare(xColumn, xRow, 'X');
                        }
                        // Draw the board
                        currentBoard.draw();
                        System.out.println();

                        // Determine if the game is over, if so print out status
                        if (currentBoard.determineBoardStatus() != BoardStatus.UNFINISHED) {
                            System.out.println(currentBoard.determineBoardStatus());
                            break;
                        }

                        /**
                         * Now we must implement the makeAMove method for 'O'
                         * and determine the best square to choose based on the
                         * board with the 'X' that the human opponent placed.
                         */
                        Move bestMove = currentBoard.makeAMove('O');
                        int bestColumn = bestMove.getColumn();
                        int bestRow = bestMove.getRow();
                        // Place the 'O'
                        currentBoard.setSquare(bestColumn, bestRow, 'O');

                        // Draw the board
                        currentBoard.draw();
                        System.out.println();

                        // Determine if the game is over, if so print out status
                        if (currentBoard.determineBoardStatus() != BoardStatus.UNFINISHED) {
                            System.out.println(currentBoard.determineBoardStatus());
                            break;
                        }

                    }

                    break;
                case 3:
                    // Play against computer (Computer: X, Human: O
                    currentBoard = new Board();
                    currentBoard.draw();
                    System.out.println();
                    status = currentBoard.determineBoardStatus();
                    in = new Scanner(System.in);
                    while (status == BoardStatus.UNFINISHED) {
                        // Use makeAMove method for 'X' first
                        Move bestMove = currentBoard.makeAMove('X');
                        // Place 'X' on the board for move that was retunred
                        int bestColumn = bestMove.getColumn();
                        int bestRow = bestMove.getRow();
                        currentBoard.setSquare(bestColumn, bestRow, 'X');

                        // Draw the board
                        currentBoard.draw();
                        System.out.println();

                        // Determine if the game is over, if so print out status
                        if (currentBoard.determineBoardStatus() != BoardStatus.UNFINISHED) {
                            System.out.println(currentBoard.determineBoardStatus());
                            break;
                        }
                        // Prompt user for to enter valid column for O
                        System.out.println("Enter a column (0-2) for 'O':");
                        int oColumn = in.nextInt();
                        // Check if valid column
                        while (oColumn > 2 || oColumn < 0) {
                            System.out.println("Invalid column");
                            System.out.println("Enter a column (0-2) for 'O':");
                            oColumn = in.nextInt();
                        }

                        // Prompt user to enter valid row for O
                        System.out.println("Enter a row (0-2) for 'O':");
                        int oRow = in.nextInt();
                        // Check if valid row
                        while (oRow > 2 || oRow < 0) {
                            System.out.println("Invalid row");
                            System.out.println("Enter a row (0-2) for 'O':");
                            oRow = in.nextInt();
                        }
                        // Check if the square is empty, prompt again if not
                        while (currentBoard.getSquare(oColumn, oRow) != ' ') {
                            System.out.println("Square not available, try again");
                            System.out.println("Enter a column (0-2) for 'O':");
                            oColumn = in.nextInt();
                            while (oColumn > 2 || oColumn < 0) {
                                System.out.println("Invalid column");
                                System.out.println("Enter a column (0-2) for 'O':");
                                oColumn = in.nextInt();
                            }
                            System.out.println("Enter a row (0-2) for 'O':");
                            oRow = in.nextInt();
                            while (oRow > 2 || oRow < 0) {
                                System.out.println("Invalid row");
                                System.out.println("Enter a row (0-2) for 'O':");
                                oRow = in.nextInt();
                            }
                        }

                        // If valid and empty, place the 'O'
                        if (currentBoard.getSquare(oColumn, oRow) == ' ') {
                            currentBoard.setSquare(oColumn, oRow, 'O');
                        }
                        // Draw the board
                        currentBoard.draw();

                        // Determine if the game is over, if so print out status
                        if (currentBoard.determineBoardStatus() != BoardStatus.UNFINISHED) {
                            System.out.println(currentBoard.determineBoardStatus());
                            break;
                        }

                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

    }

}
