/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file PlayBoard.java
 */

package cs252tictactoe.view.frames;

import cs252tictactoe.Resources;
import cs252tictactoe.controller.Controller;
import cs252tictactoe.model.Board;
import cs252tictactoe.view.components.CenteredLabel;
import cs252tictactoe.view.components.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main frame of the game representing the game board and, more generally, the whole application
 */
public class PlayBoard extends InteractiveWindow implements ActionListener {
    private static final int BOARD_HEIGHT = Board.BOARD_HEIGHT;
    private static final int BOARD_WIDTH = Board.BOARD_WIDTH;
    private static final int LOWER_BORDER = Board.LOWER_BORDER;
    
    private final CenteredLabel playerPlayingLabel;
    private final JPanel boardLayout;
    private Tile[][] tilesBoard;

    public PlayBoard(Controller controller, int playerPlaying, int board_height, int board_width) {
        super(controller);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Resources.GAME_TITLE);
        setPreferredSize(new Dimension(Resources.WINDOW_PLAYBOARD_SIZE_WIDTH, Resources.WINDOW_PLAYBOARD_SIZE_HEIGHT)); // Set window size
        setLocation(Resources.WINDOW_PLAYBOARD_LOCATION_X, Resources.WINDOW_PLAYBOARD_LOCATION_Y); // Set window location
        setLayout(new BorderLayout());

        // Set text above game board
        this.playerPlayingLabel = createGameTitles(playerPlaying);

        // Set game board
        this.boardLayout = createGameBoard(board_height, board_width);

        pack();
        setVisible(true);
    }

    private void setPlayerPlayingLabel(String playerPLaying) {
        this.playerPlayingLabel.setLabelText(playerPLaying);
    }

    private Tile getTileAt(int x, int y) {
        return tilesBoard[x][y];
    }

    private void setTileAt(int x, int y, Tile tile) {
        tilesBoard[x][y] = tile;
    }

    private CenteredLabel createGameTitles(int playerPlaying) {
        JPanel titles = new JPanel();
        titles.setLayout(new BoxLayout(titles, BoxLayout.PAGE_AXIS));
        titles.add(new CenteredLabel(Resources.GAME_TITLE, Font.BOLD, Resources.TEXT_SIZE_LARGE));
        titles.add(new CenteredLabel(Resources.LABEL_TEXT_TITLE_SEPARATOR, Font.PLAIN, Resources.TEXT_SIZE_MEDIUM));

        titles.add(new CenteredLabel(Resources.LABEL_TEXT_PLAYER_PLAYING, Font.ITALIC, Resources.TEXT_SIZE_VERYSMALL));
        CenteredLabel playerPlayingLabel = new CenteredLabel(Integer.toString(playerPlaying), Font.BOLD, Resources.TEXT_SIZE_SMALL);
        titles.add(playerPlayingLabel);

        add(titles, BorderLayout.NORTH);
        return playerPlayingLabel;
    }

    private JPanel createGameBoard(int board_height, int board_width) {
        final JPanel boardLayout;
        boardLayout = new JPanel();
        boardLayout.setLayout(new GridLayout(board_height, board_height));

        tilesBoard = new Tile[board_height][board_width];
        for (int i = LOWER_BORDER; i < board_height; i++) {
            for (int j = LOWER_BORDER; j < board_width; j++) {
                Tile tile = new Tile(i, j);
                tile.addActionListener(this);
                setTileAt(i, j, tile);
                boardLayout.add(tile);
            }
        }

        add(boardLayout, BorderLayout.CENTER);
        return boardLayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getName();
        int x = Integer.parseInt(String.valueOf(text.charAt(0))); // Position of X in the button's name
        int y = Integer.parseInt(String.valueOf(text.charAt(1))); // Position of Y in the button's name'

        getController().makeMove(x, y);
    }

    public void updateBoard(int x, int y, String imageSource, int playerPlaying) {
        assert (x >= LOWER_BORDER && x < BOARD_WIDTH);
        assert (y >= LOWER_BORDER && y < BOARD_HEIGHT);

        getTileAt(x, y).setMarkImage(imageSource);
        setPlayerPlayingLabel(Integer.toString(playerPlaying));
    }

    public void disableBoard() {
        Component[] boardComponents = boardLayout.getComponents();
        for (Component component : boardComponents)
            component.setEnabled(false);
    }
}
