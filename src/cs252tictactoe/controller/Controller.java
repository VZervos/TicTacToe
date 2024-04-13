/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.controller;

import cs252tictactoe.model.Board;
import cs252tictactoe.model.Player;
import cs252tictactoe.model.marks.Mark;
import cs252tictactoe.model.marks.OMark;
import cs252tictactoe.model.marks.XMark;
import cs252tictactoe.view.gui.GameEndWindow;
import cs252tictactoe.view.gui.PlayBoard;

import java.util.Arrays;

import static cs252tictactoe.model.Board.BOARD_HEIGHT;
import static cs252tictactoe.model.Board.BOARD_WIDTH;

public class Controller {
    private final Player[] players = new Player[] {
            new Player("James Bond", "/resources/x_mark.png"),
            new Player("Indiana Jones", "/resources/o_mark.png")
    };
    private Player playerPlaying;
    private Board board;
    private PlayBoard playBoard;

    public Controller() {
        this.setPlayerPlaying(getAllPlayers()[0]);
        this.setBoard(new Board());
        this.setPlayBoard(new PlayBoard(this, getPlayerPlaying().getPlayerId(), BOARD_HEIGHT, BOARD_WIDTH));
    }

    private Player[] getAllPlayers() {
        return this.players;
    }

    private Player getPlayerPlaying() {
        return this.playerPlaying;
    }

    private void setPlayerPlaying(Player player) {
        this.playerPlaying = player;
    }

    private Board getBoard() {
        return this.board;
    }

    private void setBoard(Board board) {
        this.board = board;
    }

    private PlayBoard getPlayBoard() {
        return this.playBoard;
    }

    private void setPlayBoard(PlayBoard playBoard) {
        this.playBoard = playBoard;
    }

    public void makeMove(int x, int y) {
        Mark newMark = null;
        Player playerPlaying = getPlayerPlaying();
        Player[] playersList = getAllPlayers();
        Player player1 = playersList[0];
        Player player2 = playersList[1];
        Board board = getBoard();

        // Check if player 0 can place mark
        if (playerPlaying == player1 && !board.hasPlayerMark(x, y)) {
            Player finalPlayerPlaying = playerPlaying;
            newMark = new XMark(x, y, Arrays.stream(playersList).filter(player -> player == finalPlayerPlaying).findAny().get());
            playerPlaying = player2;

            // Check if player 1 can place mark
        } else if (playerPlaying == player2 && !board.hasPlayerMark(x, y)) {
            Player finalPlayerPlaying = playerPlaying;
            newMark = new OMark(x, y, Arrays.stream(playersList).filter(player -> player == finalPlayerPlaying).findAny().get());
            playerPlaying = player1;
        }

        // If a new mark was placed
        if (newMark != null) {
            board.setMarkAt(x, y, newMark);
            board.reduceSlotsLeft();
            PlayBoard playBoard = getPlayBoard();

            // Check if the game ended with this mark's placement
            if (!this.hasGameEnded()) {
                setPlayerPlaying(playerPlaying);
                playBoard.updateBoard(x, y, newMark.getOwner().getMarkImageSource(), playerPlaying.getPlayerId());

                // Else update board and continue
            } else {
                playBoard.updateBoard(x, y, newMark.getOwner().getMarkImageSource(), getPlayerPlaying().getPlayerId());
                playBoard.disableBoard();
            }
        }

    }

    private boolean hasGameEnded() {
        return hasVictoriousPlayer() || !hasEmptySlots();
    }

    private boolean hasVictoriousPlayer() {
        Board board = getBoard();
        for (Player player : getAllPlayers()) {
            if (checkRowsForThreeMarks(player, board) || checkColumnsForThreeMarks(player, board) || checkFirstDiagonalForThreeMarks(player, board) || checkSecondDiagonalForThreeMarks(player, board)) {
                announceVictory(player);
                return true;
            }
        }
        return false;
    }

    private boolean checkSecondDiagonalForThreeMarks(Player player, Board board) {
        int marksFound = 0;
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Player markOwner = board.getMarkAt(i, i).getOwner();
            if (markOwner == player)
                marksFound++;
        }
        return marksFound == 3;
    }

    private boolean checkFirstDiagonalForThreeMarks(Player player, Board board) {
        int marksFound = 0;
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Player markOwner = board.getMarkAt(2 - i, i).getOwner();
            if (markOwner == player)
                marksFound++;
        }
        return marksFound == 3;
    }

    private boolean checkColumnsForThreeMarks(Player player, Board board) {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            int marksFound = 0;
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                Player markOwner = board.getMarkAt(j, i).getOwner();
                if (markOwner == player)
                    marksFound++;
            }
            if (marksFound == 3)
                return true;
        }
        return false;
    }

    private boolean checkRowsForThreeMarks(Player player, Board board) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            int marksFound = 0;
            for (int j = 0; j < BOARD_WIDTH; j++) {
                Player markOwner = board.getMarkAt(i, j).getOwner();
                if (markOwner == player)
                    marksFound++;
            }
            if (marksFound == 3)
                return true;
        }
        return false;
    }

    public boolean hasEmptySlots() {
        if (!getBoard().hasSlotsLeft()) {
            new GameEndWindow(this, null);
            return false;
        }
        return true;
    }

    private void announceVictory(Player player) {
        new GameEndWindow(this, player.getPlayerName());
    }

    public void endGame() {
        System.exit(0);
    }
}
