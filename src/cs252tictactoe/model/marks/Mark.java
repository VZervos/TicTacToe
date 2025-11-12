/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file Mark.java
 */

package cs252tictactoe.model.marks;

import cs252tictactoe.model.Player;

import static cs252tictactoe.model.Board.BOARD_HEIGHT;
import static cs252tictactoe.model.Board.BOARD_WIDTH;

/**
 * General class of a mark
 */
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

