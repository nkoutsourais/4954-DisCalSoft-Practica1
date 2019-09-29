package com.practica1;

import java.util.stream.Stream;

public abstract class Combination {
    private static final int MAX_COLORS = 4;

    private Color[] colors = new Color[MAX_COLORS];

    protected void setColor(Color color, int position) {
        positionControl(position);
        this.colors[position] = color;
    }

    protected Color getColor(int position) {
        positionControl(position);
        return this.colors[position];
    }

    private void positionControl(int position) throws IllegalArgumentException {
        if (position >= MAX_COLORS || position < 0)
            throw new IllegalArgumentException("The position is wrong");
    }

    protected boolean isComplete() {
        for (Color color : colors) {
            if (color == null)
                return false;
        }
        return true;
    }

    protected boolean ContainsColor(Color color) {
        return Stream.of(this.colors).anyMatch(color::equals);
    }

    protected Color[] getColors() {
        return colors;
    }

    protected void setColors(Color[] colors) {
        if (colors == null || colors.length != MAX_COLORS)
            throw new IllegalArgumentException("Wrong proposed combination length");
        this.colors = colors;
    }

    protected void writeColors() {
        Stream.of(colors).forEach(c -> System.out.print(c.getSymbol()));
    }
}