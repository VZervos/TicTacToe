/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.model;

import cs252tictactoe.model.marks.EmptyMark;
import cs252tictactoe.model.marks.Mark;

public class Board {
    public static final int BOARD_WIDTH = 3;
    public static final int BOARD_HEIGHT = 3;
    private final Mark[][] marks;
    private int slotsLeft;

    public Board() {
        this.marks = new Mark[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                this.setMarkAt(i, j, new EmptyMark(i, j));
        slotsLeft = 9;
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
        return (x >= 0 && x < BOARD_WIDTH) && (y >= 0 && y < BOARD_HEIGHT);
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
