package org.dkbrazz.game;

import java.util.List;

public record GameResult(GameWinner winner, List<MatchAttempt> attempts) {
}
