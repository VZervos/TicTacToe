/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.model.marks;

import cs252tictactoe.model.Player;
import cs252tictactoe.model.PlayerMark;

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
