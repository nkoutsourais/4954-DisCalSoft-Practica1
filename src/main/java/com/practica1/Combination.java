package com.practica1;

import java.util.stream.Stream;

public class Combination {
    private static final int MAX_COLORS = 4;

    private Color[] colors = new Color[MAX_COLORS];

    public void setColor(Color color, int position) {
        positionControl(position);
        this.colors[position] = color;
    }

    public Color getColor(int position) {
        positionControl(position);
        return this.colors[position];
    }

    private void positionControl(int position) throws IllegalArgumentException {
        if (position >= MAX_COLORS || position < 0)
            throw new IllegalArgumentException("The position is wrong");
    }

    public boolean isComplete() {
        for (Color color : colors) {
            if (color == null)
                return false;
        }
        return true;
    }

    public boolean ContainsColor(Color color) {
        return Stream.of(this.colors).anyMatch(color::equals);
    }

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        if (colors == null || colors.length != MAX_COLORS)
            throw new IllegalArgumentException("Wrong proposed combination length");
        this.colors = colors;
    }

    public void writeColors() {
        Stream.of(colors).forEach(c -> System.out.print(c.getSymbol()));
    }
}