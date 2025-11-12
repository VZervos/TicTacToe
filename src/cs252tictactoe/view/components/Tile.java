/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file Tile.java
 */

package cs252tictactoe.view.components;

import cs252tictactoe.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static java.awt.Image.SCALE_SMOOTH;

/**
 * Tile is a button on a board representing the slots (cells) where a player can place their mark
 */
public class Tile extends JButton {

    public Tile(int x, int y) {
        super();
        this.setName(Integer.toString(x) + y);
        this.setFont(new Font(Resources.FONT_SERIF, Font.BOLD, Resources.TEXT_SIZE_MEDIUM));
    }

    public void setMarkImage(String source) {
        assert (source != null);
        ImageIcon markIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(source))); // Load Image.
        Image markImage = markIcon.getImage().getScaledInstance(Resources.TILE_IMAGE_SIZE_WIDTH, Resources.TILE_IMAGE_SIZE_HEIGHT, SCALE_SMOOTH); // Resize.
        this.setIcon(new ImageIcon(markImage)); // Set in button.
        this.setFocusPainted(false); // Remove button border. In our case, image borders.
        this.setContentAreaFilled(false); // Remove default java button background.
        this.setBorderPainted(false); // Remove outer button border.
    }
}
