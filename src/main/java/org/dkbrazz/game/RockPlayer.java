package org.dkbrazz.game;

import org.dkbrazz.matcher.HandSign;

/**
 * A player that always shoots ROCK.
 */
public class RockPlayer implements Player {
    @Override
    public HandSign shoot() {
        return HandSign.ROCK;
    }
}
