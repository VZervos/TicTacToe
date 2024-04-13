/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.model.marks;

import cs252tictactoe.model.Player;

import static cs252tictactoe.model.Board.BOARD_HEIGHT;
import static cs252tictactoe.model.Board.BOARD_WIDTH;

public abstract class Mark {
    private int x;
    private int y;
    private Player owner;

    protected Mark(int x, int y, Player owner) {
        if (!this.setLocation(x, y))
            this.setLocation(0, 0);
        this.setOwner(owner);
    }

    private boolean setX(int x) {
        if (x < 0 || x >= BOARD_WIDTH)
            return false;
        this.x = x;
        return true;
    }

    private boolean setY(int y) {
        if (y < 0 || y >= BOARD_HEIGHT)
            return false;
        this.y = y;
        return true;
    }

    private boolean setLocation(int x, int y) {
        return this.setX(x) && this.setY(y);
    }

    public Player getOwner() {
        return this.owner;
    }

    private void setOwner(Player owner) {
        this.owner = owner;
    }
}

