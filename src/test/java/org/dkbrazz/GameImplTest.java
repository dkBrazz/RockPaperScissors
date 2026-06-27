package org.dkbrazz;

import org.dkbrazz.game.GameImpl;
import org.dkbrazz.game.GameWinner;
import org.dkbrazz.game.MatchAttempt;
import org.dkbrazz.matcher.HandSign;
import org.dkbrazz.game.Player;
import org.dkbrazz.matcher.HandSignMatcher;
import org.dkbrazz.matcher.HandSignMatcherImpl;
import org.dkbrazz.matcher.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameImplTest {
    @Mock
    private Player playerA;
    @Mock
    private Player playerB;
    @Spy
    private HandSignMatcher matcher = new HandSignMatcherImpl();

    private GameImpl gameImpl;

    @BeforeEach
    void setUp() {
        gameImpl = new GameImpl(playerA, playerB, matcher);
    }

    @Test
    void playerAShouldWinImmediately() {
        when(playerA.shoot()).thenReturn(HandSign.PAPER);
        when(playerB.shoot()).thenReturn(HandSign.ROCK);

        var gameResult = gameImpl.play();

        assertEquals(GameWinner.PLAYER_A, gameResult.winner());
        assertEquals(1, gameResult.attempts().size());
        assertEquals(List.of(new MatchAttempt(HandSign.PAPER, HandSign.ROCK, MatchResult.BEAT)), gameResult.attempts());
        verify(matcher, times(1)).match(HandSign.PAPER, HandSign.ROCK);
    }

    @Test
    void playerBShouldWinImmediately() {
        when(playerA.shoot()).thenReturn(HandSign.SCISSORS);
        when(playerB.shoot()).thenReturn(HandSign.ROCK);

        var gameResult = gameImpl.play();

        assertEquals(GameWinner.PLAYER_B, gameResult.winner());
        assertEquals(1, gameResult.attempts().size());
        assertEquals(List.of(new MatchAttempt(HandSign.SCISSORS, HandSign.ROCK, MatchResult.LOSE)), gameResult.attempts());
        verify(matcher, times(1)).match(HandSign.SCISSORS, HandSign.ROCK);
    }

    @Test
    void playerAShouldWinAfterDraws() {
        when(playerA.shoot())
                .thenReturn(HandSign.SCISSORS)
                .thenReturn(HandSign.PAPER)
                .thenReturn(HandSign.ROCK);
        when(playerB.shoot())
                .thenReturn(HandSign.SCISSORS)
                .thenReturn(HandSign.PAPER)
                .thenReturn(HandSign.SCISSORS);

        var gameResult = gameImpl.play();

        assertEquals(GameWinner.PLAYER_A, gameResult.winner());
        assertEquals(3, gameResult.attempts().size());
        assertEquals(List.of(
                        new MatchAttempt(HandSign.SCISSORS, HandSign.SCISSORS, MatchResult.DRAW),
                        new MatchAttempt(HandSign.PAPER, HandSign.PAPER, MatchResult.DRAW),
                        new MatchAttempt(HandSign.ROCK, HandSign.SCISSORS, MatchResult.BEAT)
        ), gameResult.attempts());
        verify(matcher, times(3)).match(any(), any());
    }

    @Test
    void playerBShouldWinAfterDraws() {
        when(playerA.shoot())
                .thenReturn(HandSign.ROCK)
                .thenReturn(HandSign.SCISSORS)
                .thenReturn(HandSign.PAPER)
                .thenReturn(HandSign.PAPER);
        when(playerB.shoot())
                .thenReturn(HandSign.ROCK)
                .thenReturn(HandSign.SCISSORS)
                .thenReturn(HandSign.PAPER)
                .thenReturn(HandSign.SCISSORS);

        var gameResult = gameImpl.play();

        assertEquals(GameWinner.PLAYER_B, gameResult.winner());
        assertEquals(4, gameResult.attempts().size());
        assertEquals(List.of(
                new MatchAttempt(HandSign.ROCK, HandSign.ROCK, MatchResult.DRAW),
                new MatchAttempt(HandSign.SCISSORS, HandSign.SCISSORS, MatchResult.DRAW),
                new MatchAttempt(HandSign.PAPER, HandSign.PAPER, MatchResult.DRAW),
                new MatchAttempt(HandSign.PAPER, HandSign.SCISSORS, MatchResult.LOSE)
        ), gameResult.attempts());
        verify(matcher, times(4)).match(any(), any());
    }
}