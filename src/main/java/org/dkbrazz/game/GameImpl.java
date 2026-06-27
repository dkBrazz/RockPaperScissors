package org.dkbrazz.game;

import org.dkbrazz.matcher.HandSignMatcher;

public class GameImpl implements Game {
    private final Player playerA;
    private final Player playerB;
    private final HandSignMatcher matcher;

    public GameImpl(Player playerA, Player playerB, HandSignMatcher matcher) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.matcher = matcher;
    }

    @Override
    public GameResult play() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
