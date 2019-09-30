package com.practica1;

import java.util.Optional;
import java.util.stream.Stream;

public enum Color {
    Red("r"), Blue("b"), Yellow("y"), Green("g"), Orange("o"), Purple("p");

    private String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static Color get(String symbol) {
        Optional<Color> color = getOptionalColor(symbol);
        if (color.isPresent())
            return getOptionalColor(symbol).get();
        throw new IllegalArgumentException("Wrong colors, they must be: " + getSymbolsColorExist());
    }

    private static String getSymbolsColorExist() {
        String colors = "";
        for (Color c : Color.values())
            colors += c.symbol;
        return colors;
    }

    private static Optional<Color> getOptionalColor(String symbol) {
        return Stream.of(Color.values()).filter(c -> c.symbol.equalsIgnoreCase(symbol)).findFirst();
    }
}