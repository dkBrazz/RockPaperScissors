package org.dkbrazz.matcher;

public interface HandSignMatcher {
    /**
     * Matches two hand signs and returns the result of the match.
     * Equal signs produce a DRAW result.
     * Rock beats Scissors, Scissors beat Paper, and Paper beats Rock.
     *
     * @param signA the players A hand sign
     * @param signB the players B hand sign
     * @return the result of the match
     */
    MatchResult match(HandSign signA, HandSign signB);
}
