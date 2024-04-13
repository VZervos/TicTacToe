/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.view.gui_utility;

import javax.swing.*;
import java.awt.*;

public class CenteredLabel extends JLabel {

    public CenteredLabel(String text, int font, int size) {
        super(text);
        this.setAlignmentX(CENTER_ALIGNMENT); // Center vertical alignment
        this.setFont(new Font("Serif", font, size));
    }

    public void setLabelText(String text) {
        this.setText(text);
    }
}
