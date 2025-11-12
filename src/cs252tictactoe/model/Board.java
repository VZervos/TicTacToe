/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file Board.java
 */

package cs252tictactoe.model;

import cs252tictactoe.model.marks.EmptyMark;
import cs252tictactoe.model.marks.Mark;

/**
 * Board class represents the board and stores board data
 */
public class Board {
    public static final int BOARD_WIDTH = 3;
    public static final int BOARD_HEIGHT = 3;
    public static final int MARKS_TO_WIN = 3;
    
    public static final int TOP_BORDER = 2;
    public static final int LOWER_BORDER = 0;
    
    private final Mark[][] marks;
    private int slotsLeft;

    public Board() {
        this.marks = new Mark[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = LOWER_BORDER; i < BOARD_HEIGHT; i++)
            for (int j = LOWER_BORDER; j < BOARD_WIDTH; j++)
                this.setMarkAt(i, j, new EmptyMark(i, j));
        slotsLeft = BOARD_WIDTH * BOARD_HEIGHT;
    }

    public Mark getMarkAt(int x, int y) {
        assert (isSlotValid(x, y));
        return this.marks[x][y];
    }

    public void setMarkAt(int x, int y, Mark mark) {
        assert (isSlotValid(x, y));
        this.marks[x][y] = mark;
    }

    private boolean isSlotValid(int x, int y) {
        return (x >= LOWER_BORDER && x < BOARD_WIDTH) && (y >= LOWER_BORDER && y < BOARD_HEIGHT);
    }

    private boolean hasPlayerCompletedSecondDiagonalTriple(Player player) {
        int marksFound = 0;
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Player markOwner = getMarkAt(i, i).getOwner();
            if (markOwner == player)
                marksFound++;
        }
        return marksFound == Board.MARKS_TO_WIN;
    }

    private boolean hasPlayerCompletedFirstDiagonalTriple(Player player) {
        int marksFound = 0;
        for (int i = LOWER_BORDER; i < BOARD_HEIGHT; i++) {
            Player markOwner = getMarkAt(TOP_BORDER - i, i).getOwner();
            if (markOwner == player)
                marksFound++;
        }
        return marksFound == Board.MARKS_TO_WIN;
    }

    private boolean hasPlayerCompletedColumnTriple(Player player) {
        for (int j = LOWER_BORDER; j < BOARD_HEIGHT; j++) {
            int marksFound = 0;
            for (int i = LOWER_BORDER; i < BOARD_WIDTH;i++) {
                Player markOwner = getMarkAt(i, j).getOwner();
                if (markOwner == player)
                    marksFound++;
            }
            if (marksFound == Board.MARKS_TO_WIN)
                return true;
        }
        return false;
    }

    private boolean hasPlayerCompletedRowTriple(Player player) {
        for (int i = LOWER_BORDER; i < BOARD_HEIGHT; i++) {
            int marksFound = 0;
            for (int j = LOWER_BORDER; j < BOARD_WIDTH; j++) {
                Player markOwner = getMarkAt(i, j).getOwner();
                if (markOwner == player)
                    marksFound++;
            }
            if (marksFound == Board.MARKS_TO_WIN)
                return true;
        }
        return false;
    }

    public boolean hasCompletedTriple(Player player) {
            return hasPlayerCompletedRowTriple(player)
                    || hasPlayerCompletedColumnTriple(player)
                    || hasPlayerCompletedFirstDiagonalTriple(player)
                    || hasPlayerCompletedSecondDiagonalTriple(player);
    }

    public boolean hasPlayerMark(int x, int y) {
        return this.getMarkAt(x, y).getOwner() != null;
    }

    public void reduceSlotsLeft() {
        this.slotsLeft--;
    }

    public boolean hasSlotsLeft() {
        return this.slotsLeft != 0;
    }
}
