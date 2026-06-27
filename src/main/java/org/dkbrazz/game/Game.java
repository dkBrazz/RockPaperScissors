package org.dkbrazz.game;

public interface Game {
    /**
     * Plays a match between two players.
     * Returns the winning player.
     * In the case of TIE match will be rerun until a winner is found.
     *
     * @return Returns PLAYER_A if playerA beats playerB, otherwise - PLAYER_B.
     * GameResult contains all match attempts
     */
    GameResult play();
}
