/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.view.gui_utility;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static java.awt.Image.SCALE_SMOOTH;

public class Tile extends JButton {

    public Tile(int x, int y) {
        super();
        this.setName(Integer.toString(x) + y);
        this.setFont(new Font("Serif", Font.BOLD, 30));
    }

    public void setMarkImage(String source) {
        assert (source != null);
        ImageIcon markIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(source))); // Load Image.
        Image markImage = markIcon.getImage().getScaledInstance(100, 100, SCALE_SMOOTH); // Resize.
        this.setIcon(new ImageIcon(markImage)); // Set in button.
        this.setFocusPainted(false); // Remove button border. In our case, image borders.
        this.setContentAreaFilled(false); // Remove default java button background.
        this.setBorderPainted(false); // Remove outer button border.
    }
}
