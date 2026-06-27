package org.dkbrazz.game;

import org.dkbrazz.matcher.HandSign;
import org.dkbrazz.matcher.MatchResult;

public record MatchAttempt(HandSign signA, HandSign signB, MatchResult matchResult) {
}
