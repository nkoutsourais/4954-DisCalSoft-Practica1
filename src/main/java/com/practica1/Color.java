package com.practica1;

import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public enum Color {
    Red("r"), Blue("b"), Yellow("y"), Green("g"), Orange("o"), Purple("p");

    private static final String MESSAGE_ERROR = "Wrong colors, they must be: rbygop";
    private static final String PATTERN_DUPLICATE = "(\\w)\\1+";

    private String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static Color get(String symbol) throws IllegalArgumentException {
        checkSymbol(symbol);
        return getOptionalColor(symbol).get();
    }

    public static boolean contains(String symbol) throws IllegalArgumentException {
        checkSymbol(symbol);
        Optional<Color> color = getOptionalColor(symbol);
        if (!color.isPresent())
            throw new IllegalArgumentException(MESSAGE_ERROR);
        return true;
    }

    public static Color randomColor() {
        Random ramdom = new Random();
        return Color.values()[ramdom.nextInt(Color.values().length)];
    }

    private static void checkSymbol(String symbol) throws IllegalArgumentException {
        if (isNullOrBlank(symbol))
            throw new IllegalArgumentException(MESSAGE_ERROR);
    }

    private static Optional<Color> getOptionalColor(String symbol) {
        return Stream.of(Color.values()).filter(c -> c.symbol.equalsIgnoreCase(symbol)).findFirst();
    }

    private static boolean isNullOrBlank(String param) {
        return param == null || param.trim().length() == 0;
    }

    public static Color[] getColorsBySymbols(String colorSymbolsCombination) throws IllegalArgumentException {
        checkColorsCombination(colorSymbolsCombination);
        Color[] colors = new Color[colorSymbolsCombination.length()];
        for (int position = 0; position < colorSymbolsCombination.length(); position++) {
            String symbolColor = String.valueOf(colorSymbolsCombination.charAt(position));
            if (Color.contains(symbolColor))
                colors[position] = Color.get(symbolColor);
        }
        return colors;
    }

    private static void checkColorsCombination(String colorsCombination) throws IllegalArgumentException {
        Pattern p = Pattern.compile(PATTERN_DUPLICATE);
        Matcher m = p.matcher(colorsCombination);
        if (m.find())
            throw new IllegalArgumentException("Repeated colors");
    }
}