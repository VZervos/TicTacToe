/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file GameEndWindow.java
 */

package cs252tictactoe.view.frames;

import cs252tictactoe.Resources;
import cs252tictactoe.controller.Controller;
import cs252tictactoe.view.components.CenteredLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Frame that is created when the game ends and shows the result of the game
 */
public class GameEndWindow extends InteractiveWindow {

    private JButton exitButton;

    public GameEndWindow(Controller controller, String winner) {
        // Basic setup
        super(controller);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game ended");
        setPreferredSize(new Dimension(Resources.WINDOW_GAMEEND_SIZE_WIDTH, Resources.WINDOW_GAMEEND_SIZE_HEIGHT));
        setLocation(Resources.WINDOW_GAMEEND_LOCATION_X, Resources.WINDOW_GAMEEND_LOCATION_Y);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        // Add components
        add(new CenteredLabel(Resources.LABEL_WINNER_TEXT.apply(winner), Font.PLAIN, Resources.TEXT_SIZE_SMALL));
        setExitButton(new JButton(Resources.BUTTON_EXIT_TEXT));

        // Exit button
        JButton exit = getExitButton();
        exit.addActionListener(_ -> getController().endGame());
        exit.setFont(new Font(Resources.FONT_SERIF, Font.PLAIN, Resources.TEXT_SIZE_VERYSMALL));
        exit.setAlignmentX(CENTER_ALIGNMENT);
        add(exit);

        // Show window
        pack();
        setVisible(true);
    }

    private JButton getExitButton() {
        return this.exitButton;
    }

    private void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }
}
