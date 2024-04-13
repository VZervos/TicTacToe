/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.view.gui;

import cs252tictactoe.controller.Controller;
import cs252tictactoe.view.gui_utility.CenteredLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameEndWindow extends InteractiveWindow implements ActionListener {

    private JButton exitButton;

    public GameEndWindow(Controller controller, String winner) {
        // Basic setup
        super(controller);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Activate X (close)
        this.setTitle("Game ended");
        this.setPreferredSize(new Dimension(300, 130)); // Set window size
        this.setLocation(600, 300); // Set window location
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)); // Set Layout

        // Add components
        this.add(new CenteredLabel(winner != null ? winner + " won!" : "Tie! No winner.", Font.PLAIN, 25));
        this.setExitButton(new JButton("Exit"));

        // Exit button
        JButton exit = getExitButton();
        exit.addActionListener(this);
        exit.setFont(new Font("Serif", Font.PLAIN, 20));
        exit.setAlignmentX(CENTER_ALIGNMENT);
        this.add(exit);

        // Show window
        this.pack();
        this.setVisible(true);
    }

    private JButton getExitButton() {
        return this.exitButton;
    }

    private void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.getController().endGame();
    }
}
