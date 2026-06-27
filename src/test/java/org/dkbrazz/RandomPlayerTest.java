package org.dkbrazz;

import org.dkbrazz.game.RandomPlayer;
import org.dkbrazz.matcher.HandSign;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomPlayerTest {
    @Test
    void shouldReturnRandomSign() {
        Set<HandSign> results = new HashSet<>();
        RandomPlayer player = new RandomPlayer();
        for (int i = 0; i < 100; i++) {
            HandSign sign = player.shoot();
            results.add(sign);
        }
        assertEquals(3, results.size(), "RandomPlayer should return all three HandSign values");
    }
}