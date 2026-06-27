package org.dkbrazz;

import org.dkbrazz.game.RockPlayer;
import org.dkbrazz.matcher.HandSign;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPlayerTest {
    @Test
    void shouldReturnRock() {
        RockPlayer player = new RockPlayer();
        assertEquals(HandSign.ROCK, player.shoot());
    }
}