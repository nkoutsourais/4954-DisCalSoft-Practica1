package com.practica1;

import java.util.Arrays;
import java.util.List;
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

    public boolean Contains(Color color) {
        return Stream.of(this.colors).anyMatch(color::equals);
    }

    public List<Color> GetColors()
    {
        return Arrays.asList(colors);
    }

    private void positionControl(int position) {
        if (position >= MAX_COLORS || position < 0)
            throw new IllegalArgumentException("The position is wrong");
    }
}