/**
 * CS252: Object-Oriented Programming
 * Computer Science Department, University of Crete
 * <p>
 * TicTacToe Demo Project
 * A Demo project for the purposes of the MVC Tutorial in the context of CS252: Object-Oriented Programming.
 *
 * @author Valantis Zervos (vzervos@csd.uoc.gr, csd4878@csd.uoc.gr)
 * Last Edit: 11 Nov 2025
 * @file Resources.java
 */
package cs252tictactoe;

import cs252tictactoe.model.Player;

import java.util.function.Function;

/**
 * Utility class with useful constants and application setting for easier code maintenance.
 * It is highly recommended to be used to avoid hard-coded data, settings, and vales.
 * Allows safer value changes and code control.
 */
public class Resources {
    // Text values
    public static final String GAME_TITLE = "TicTacToe";
    public static final String LABEL_TEXT_PLAYER_PLAYING = "Player Playing:";
    public static final String LABEL_TEXT_TITLE_SEPARATOR = "--< * >--";
    // Interesting line of code, huh? Take a look at https://www.baeldung.com/java-8-functional-interfaces :)
    public static final Function<String, String> LABEL_WINNER_TEXT = (winner) -> winner != null ? winner + " won!" : "Tie! No winner.";
    public static final String BUTTON_EXIT_TEXT = "Exit";

    // Premade players
    public static final Player[] players = new Player[]{
            new Player("James Bond", "/assets/x_mark.png"),
            new Player("Indiana Jones", "/assets/o_mark.png")
    };

    // System Status
    public static final int SYSTEM_EXIT_SUCCESS = 0;

    // GUI attributes
    public static final int WINDOW_GAMEEND_LOCATION_X = 600;
    public static final int WINDOW_GAMEEND_LOCATION_Y = 300;
    public static final int WINDOW_GAMEEND_SIZE_WIDTH = 300;
    public static final int WINDOW_GAMEEND_SIZE_HEIGHT = 130;

    public static final int WINDOW_PLAYBOARD_LOCATION_X = 500;
    public static final int WINDOW_PLAYBOARD_LOCATION_Y = 50;
    public static final int WINDOW_PLAYBOARD_SIZE_WIDTH = 500;
    public static final int WINDOW_PLAYBOARD_SIZE_HEIGHT = 600;

    public static final int TEXT_SIZE_VERYSMALL = 20;
    public static final int TEXT_SIZE_SMALL = 25;
    public static final int TEXT_SIZE_MEDIUM = 30;
    public static final int TEXT_SIZE_LARGE = 40;

    public static final String FONT_SERIF = "Serif";

    public static final int TILE_IMAGE_SIZE_WIDTH = 100;
    public static final int TILE_IMAGE_SIZE_HEIGHT = 100;

}
