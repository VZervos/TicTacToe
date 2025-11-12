/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file CenteredLabel.java
 */

package cs252tictactoe.view.components;

import cs252tictactoe.Resources;

import javax.swing.*;
import java.awt.*;

/**
 * Utility component of a label that is always centered
 */
public class CenteredLabel extends JLabel {

    public CenteredLabel(String text, int font, int size) {
        super(text);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(new Font(Resources.FONT_SERIF, font, size));
    }

    public void setLabelText(String text) {
        this.setText(text);
    }
}
