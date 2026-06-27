package org.dkbrazz.matcher;

public enum MatchResult {
    BEAT(">"),
    LOSE("<"),
    DRAW("=");

    private final String symbol;

    MatchResult(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
