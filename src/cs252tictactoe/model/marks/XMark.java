/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file XMark.java
 */

package cs252tictactoe.model.marks;

import cs252tictactoe.model.Player;

/**
 * Mark of Player1 ('X' Mark)
 */
public class XMark extends Mark implements PlayerMark {

    public XMark(int x, int y, Player owner) {
        super(x, y, owner);
    }

    public String getMarkImageSource() {
        Player markOwner = this.getOwner();
        assert (markOwner != null);
        return markOwner.getMarkImageSource();
    }
}
