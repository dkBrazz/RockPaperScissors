package org.dkbrazz.game;

import org.dkbrazz.matcher.HandSignMatcher;
import org.dkbrazz.matcher.MatchResult;

import java.util.ArrayList;

import static org.dkbrazz.matcher.MatchResult.DRAW;

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
        var matchResult = DRAW;
        var attempts = new ArrayList<MatchAttempt>();

        while (matchResult == DRAW) {
            var signA = playerA.shoot();
            var signB = playerB.shoot();
            matchResult = matcher.match(signA, signB);
            attempts.add(new MatchAttempt(signA, signB, matchResult));
        }

        var winner = matchResult == MatchResult.BEAT ? GameWinner.PLAYER_A : GameWinner.PLAYER_B;
        return new GameResult(winner, attempts);
    }
}
