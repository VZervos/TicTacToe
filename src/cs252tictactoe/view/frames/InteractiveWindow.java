/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file InteractiveWindow.java
 */

package cs252tictactoe.view.frames;

import cs252tictactoe.controller.Controller;

import javax.swing.*;

/**
 * The main frames of the application require access to the Controller for interaction.
 * Therefore, having the instance of Controller is obligatory.
 */
public abstract class InteractiveWindow extends JFrame {
    private Controller controller;

    protected InteractiveWindow(Controller controller) {
        super();
        setController(controller);
    }

    protected Controller getController() {
        return this.controller;
    }

    protected void setController(Controller controller) {
        this.controller = controller;
    }
}
