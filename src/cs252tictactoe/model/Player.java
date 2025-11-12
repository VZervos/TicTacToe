/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file Player.java
 */

package cs252tictactoe.model;

/**
 * Player class represents the player and stores player data
 */
public class Player {
    private int playerId;
    private String markImageSource;
    private String playerName;
    public Player(String playerName, String markImageSource) {
        this.setPlayerId(generatePlayerId());
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

    private int generatePlayerId() {
        return IDGenerator.generateID();
    }

    /**
     * ID Generator utility class
     */
    static class IDGenerator {
        private static int idCounter = 0;

        public static int generateID() {
            return idCounter++;
        }
    }
}
