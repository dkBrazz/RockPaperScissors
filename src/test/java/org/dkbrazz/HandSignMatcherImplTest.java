package org.dkbrazz;

import org.dkbrazz.matcher.HandSign;
import org.dkbrazz.matcher.HandSignMatcherImpl;
import org.dkbrazz.matcher.MatchResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HandSignMatcherImplTest {

    private final HandSignMatcherImpl matcher = new HandSignMatcherImpl();

    @ParameterizedTest
    @MethodSource("rockMatchCases")
    void shouldReturnExpectedResultForRock(HandSign signA, HandSign signB, MatchResult expectedResult) {
        assertEquals(expectedResult, matcher.match(signA, signB));
    }

    private static Stream<Arguments> rockMatchCases() {
        return Stream.of(
                Arguments.of(HandSign.ROCK, HandSign.SCISSORS, MatchResult.BEAT),
                Arguments.of(HandSign.ROCK, HandSign.PAPER, MatchResult.LOSE),
                Arguments.of(HandSign.ROCK, HandSign.ROCK, MatchResult.DRAW),
                Arguments.of(HandSign.SCISSORS, HandSign.PAPER, MatchResult.BEAT),
                Arguments.of(HandSign.SCISSORS, HandSign.ROCK, MatchResult.LOSE),
                Arguments.of(HandSign.SCISSORS, HandSign.SCISSORS, MatchResult.DRAW),
                Arguments.of(HandSign.PAPER, HandSign.ROCK, MatchResult.BEAT),
                Arguments.of(HandSign.PAPER, HandSign.SCISSORS, MatchResult.LOSE),
                Arguments.of(HandSign.PAPER, HandSign.PAPER, MatchResult.DRAW)
        );
    }
}