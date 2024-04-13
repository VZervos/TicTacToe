/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.view.gui;

import cs252tictactoe.controller.Controller;

import javax.swing.*;

public abstract class InteractiveWindow extends JFrame {
    private Controller controller;

    protected InteractiveWindow(Controller controller) {
        super();
        this.setController(controller);
    }

    protected Controller getController() {
        return this.controller;
    }

    protected void setController(Controller controller) {
        this.controller = controller;
    }
}
