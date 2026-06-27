package org.dkbrazz;

import org.dkbrazz.game.GameImpl;
import org.dkbrazz.game.RandomPlayer;
import org.dkbrazz.game.RockPlayer;
import org.dkbrazz.matcher.HandSignMatcherImpl;

public class Main {
    private final static int ITERATIONS = 100;

    static void main() {
        var playerA = new RockPlayer();
        var playerB = new RandomPlayer();
        var matcher = new HandSignMatcherImpl();
        var game = new GameImpl(playerA, playerB, matcher);

        for (int i = 0; i < ITERATIONS; i++) {
            var result = game.play();
            System.out.println(i + " - attempts:");
            result.attempts()
                    .stream()
                    .map(a -> "  " + a.signA().getSymbol() + " " + a.matchResult().getSymbol() + "  " + a.signB().getSymbol())
                    .forEach(System.out::println);
            System.out.println("Winner: " + result.winner() + "\n");
        }
    }
}
