/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.view.gui;

import cs252tictactoe.controller.Controller;
import cs252tictactoe.view.gui_utility.CenteredLabel;
import cs252tictactoe.view.gui_utility.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayBoard extends InteractiveWindow implements ActionListener {

    private final CenteredLabel playerPlayingLabel;
    private final JPanel boardLayout;
    private Tile[][] clickableBoard;

    public PlayBoard(Controller controller, int playerPlaying, int board_height, int board_width) {
        // Initializations
        super(controller);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Activate X (close)
        this.setTitle("TicTacToe");
        this.setPreferredSize(new Dimension(500, 600)); // Set window size
        this.setLocation(500, 50); // Set window location
        this.setLayout(new BorderLayout()); // Set Layout

        // Set text above game board
        this.playerPlayingLabel = createGameTitles(playerPlaying);

        // Set game board
        this.boardLayout = createGameBoard(board_height, board_width);

        // Show window
        this.pack();
        this.setVisible(true);
    }

    private void setPlayerPlayingLabel(String playerPLaying) {
        this.playerPlayingLabel.setLabelText(playerPLaying);
    }

    private Tile getClickableMarkAt(int x, int y) {
        return this.clickableBoard[x][y];
    }

    private void setClickableMarkAt(int x, int y, Tile tile) {
        this.clickableBoard[x][y] = tile;
    }

    private JPanel createGameBoard(int board_height, int board_width) {
        final JPanel boardLayout;
        boardLayout = new JPanel();
        boardLayout.setLayout(new GridLayout(board_height, board_height));
        clickableBoard = new Tile[board_height][board_width];
        for (int i = 0; i < board_height; i++) {
            for (int j = 0; j < board_width; j++) {
                Tile currentTile = new Tile(i, j);
                setClickableMarkAt(i, j, currentTile);
                currentTile.addActionListener(this);
                boardLayout.add(currentTile);
            }
        }
        this.add(boardLayout, BorderLayout.CENTER);
        return boardLayout;
    }

    private CenteredLabel createGameTitles(int playerPlaying) {
        final CenteredLabel playerPlayingLabel;
        JPanel titles = new JPanel();
        titles.setLayout(new BoxLayout(titles, BoxLayout.PAGE_AXIS));
        titles.add(new CenteredLabel("TicTacToe", Font.BOLD, 40));
        titles.add(new CenteredLabel("--< * >--", Font.PLAIN, 30));
        titles.add(new CenteredLabel("Player Playing:", Font.ITALIC, 20));
        playerPlayingLabel = new CenteredLabel(Integer.toString(playerPlaying), Font.BOLD, 25);
        titles.add(playerPlayingLabel);
        this.add(titles, BorderLayout.NORTH);
        return playerPlayingLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getName();
        int x = Integer.parseInt(String.valueOf(text.charAt(0)));
        int y = Integer.parseInt(String.valueOf(text.charAt(1)));
        this.getController().makeMove(x, y);
    }

    public void updateBoard(int x, int y, String imageSource, int playerPlaying) {
        assert (x >= 0 && x < 3);
        assert (y >= 0 && y < 3);
        this.getClickableMarkAt(x, y).setMarkImage(imageSource);
        this.setPlayerPlayingLabel(Integer.toString(playerPlaying));
    }

    public void disableBoard() {
        Component[] boardComponents = boardLayout.getComponents();
        for (Component component : boardComponents)
            component.setEnabled(false);
    }
}
