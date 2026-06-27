package org.dkbrazz.game;

import org.dkbrazz.matcher.HandSign;

import java.util.Random;

/**
 * A player that shoots signs randomly.
 */
public class RandomPlayer implements Player {
    private final Random random = new Random();

    @Override
    public HandSign shoot() {
        int pick = random.nextInt(HandSign.values().length);
        return HandSign.values()[pick];
    }
}
