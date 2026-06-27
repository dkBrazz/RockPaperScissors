package org.dkbrazz.matcher;

public enum HandSign {
    ROCK("✊"),
    PAPER("✋"),
    SCISSORS("✌️");

    private final String symbol;

    HandSign(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
