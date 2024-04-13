/**
 * TicTacToe Example Project
 *
 * @author Valantis Zervos - csd4878@csd.uoc.gr
 * For CS-252: Object-Oriented Programming course
 */

package cs252tictactoe.model;

public class Player {
    private static int idCounter = 0;
    private int playerId;
    private String markImageSource;
    private String playerName;

    public Player(String playerName, String markImageSource) {
        this.setPlayerId(generateUniquePlayerId());
        this.setPlayerName(playerName);
        this.setMarkImageSource(markImageSource);
    }

    public int getPlayerId() {
        return this.playerId;
    }

    private void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getMarkImageSource() {
        return this.markImageSource;
    }

    private void setMarkImageSource(String markImageSource) {
        this.markImageSource = markImageSource;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    private int generateUniquePlayerId() {
        return idCounter++;
    }
}
