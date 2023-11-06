

/**
 * The Move class represents a possible move to make.
 * (i.e. if an ‘X’ or ‘O’ is placed at the given square)
 * and the BoardStatus when that move is made.
 * 
 * CSC 6002 – Foundations of Programming 2
 * Project #4 - Tic Tac Toe
 * 
 * @author Billy Dempsey - dempseyw@merrimack.edu
 */
public class Move {

    private int column;
    private int row;
    private BoardStatus boardStatus;
    private int score;

    public Move() {

    }

    /**
     * Get the value of column
     *
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Get the value of row
     *
     * @return the value of row
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the value of boardStatus
     *
     * @return the value of boardStatus
     */
    public BoardStatus getBoardStatus() {
        return boardStatus;
    }

    /**
     * Set the value of column
     *
     * @param column new value of column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Set the value of row
     *
     * @param row new value of row
     */
    public void setRow(int row) {
        this.row = row;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Set the value of boardStatus
     *
     * @param boardStatus new value of boardStatus
     */
    public void setBoardStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }

}
