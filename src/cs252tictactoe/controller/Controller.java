/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file Controller.java
 */

package cs252tictactoe.controller;

import cs252tictactoe.Resources;
import cs252tictactoe.model.Board;
import cs252tictactoe.model.Player;
import cs252tictactoe.model.marks.Mark;
import cs252tictactoe.model.marks.OMark;
import cs252tictactoe.model.marks.XMark;
import cs252tictactoe.view.frames.GameEndWindow;
import cs252tictactoe.view.frames.PlayBoard;

import java.util.Arrays;

import static cs252tictactoe.model.Board.BOARD_HEIGHT;
import static cs252tictactoe.model.Board.BOARD_WIDTH;

/**
 * Controller class handles game logic.
 */
public class Controller {
    private Player player1;
    private Player player2;
    private Player playerPlaying;
    private Board board;
    private PlayBoard playBoard;

    public Controller() {
        setPlayer1(Resources.players[0]);
        setPlayer2(Resources.players[1]);
        setPlayerPlaying(player1);
        setBoard(new Board());
        setPlayBoard(new PlayBoard(this, getPlayerPlaying().getPlayerId(), BOARD_HEIGHT, BOARD_WIDTH));
    }

    private Player[] getAllPlayers() {
        return new Player[]{getPlayer1(), getPlayer2()};
    }

    private Player getPlayer1() {
        return player1;
    }

    private void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    private Player getPlayer2() {
        return player2;
    }

    private void setPlayer2(Player player2) {
        this.player2 = player2;
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

    private boolean hasGameEnded() {
        Board board = getBoard();
        Player victoriousPlayer = Arrays.stream(getAllPlayers()).filter(board::hasCompletedTriple).findFirst().orElse(null);
        if (victoriousPlayer != null) {
            announceVictory(victoriousPlayer);
            return true;
        }
        return !hasEmptySlots();
    }

    private boolean hasEmptySlots() {
        if (!getBoard().hasSlotsLeft()) {
            new GameEndWindow(this, null);
            return false;
        }
        return true;
    }

    private void announceVictory(Player player) {
        new GameEndWindow(this, player.getPlayerName());
    }

    public void makeMove(int x, int y) {
        Mark newMark = null;
        Player playerPlaying = getPlayerPlaying();
        Player player1 = getPlayer1();
        Player player2 = getPlayer2();
        Board board = getBoard();

        // Check if player 0 can place mark
        if (playerPlaying == player1 && !board.hasPlayerMark(x, y)) {
            newMark = new XMark(x, y, playerPlaying);
            playerPlaying = player2;

            // Check if player 1 can place mark
        } else if (playerPlaying == player2 && !board.hasPlayerMark(x, y)) {
            newMark = new OMark(x, y, playerPlaying);
            playerPlaying = player1;
        }

        // If a new mark was placed
        if (newMark != null) {
            board.setMarkAt(x, y, newMark);
            board.reduceSlotsLeft();

            PlayBoard playBoard = getPlayBoard();
            // Check if the game ended with this mark's placement
            if (!hasGameEnded()) {
                setPlayerPlaying(playerPlaying);
                playBoard.updateBoard(x, y, newMark.getOwner().getMarkImageSource(), getPlayerPlaying().getPlayerId());

                // Else update the board and continue
            } else {
                playBoard.updateBoard(x, y, newMark.getOwner().getMarkImageSource(), getPlayerPlaying().getPlayerId());
                playBoard.disableBoard();
            }
        }
    }

    public void endGame() {
        System.exit(Resources.SYSTEM_EXIT_SUCCESS);
    }
}
