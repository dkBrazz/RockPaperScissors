package org.dkbrazz.matcher;

import java.util.Map;

public class HandSignMatcherImpl implements HandSignMatcher {
    private static final Map<HandSign, HandSign> BEAT_MATRIX = Map.of(
            HandSign.ROCK, HandSign.SCISSORS,
            HandSign.PAPER, HandSign.ROCK,
            HandSign.SCISSORS, HandSign.PAPER
    );

    @Override
    public MatchResult match(HandSign signA, HandSign signB) {
        if (signA == signB) {
            return MatchResult.DRAW;
        }

        if (BEAT_MATRIX.get(signA) == signB) {
            return MatchResult.BEAT;
        }
        return MatchResult.LOSE;
    }
}
