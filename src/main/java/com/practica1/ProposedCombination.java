package com.practica1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProposedCombination extends Combination {
    private static final String PATTERN_DUPLICATE = "(\\w)\\1+";
    private Result result;

    public void read(Scanner scanner) {
        do {
            try {
                System.out.print("Propose a combination: ");
                String colorSymbolsCombination = scanner.nextLine();
                Color[] colors = getColorsBySymbols(colorSymbolsCombination);
                super.setColors(colors);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!super.isComplete());
    }

    public boolean contains(Color color, int position) {
        return super.getColor(position) == color;
    }

    public boolean contains(Color color) {
        return super.ContainsColor(color);
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void write() {
        super.writeColors();
        System.out.print(" ");
        this.result.write();
    }

    public boolean isWinner() {
        return this.result.isWinner();
    }

    private Color[] getColorsBySymbols(String colorSymbolsCombination) throws IllegalArgumentException {
        checkColorsCombination(colorSymbolsCombination);
        Color[] colors = new Color[colorSymbolsCombination.length()];
        for (int position = 0; position < colorSymbolsCombination.length(); position++) {
            colors[position] = Color.get(String.valueOf(colorSymbolsCombination.charAt(position)));
        }
        return colors;
    }

    private void checkColorsCombination(String colorsCombination) throws IllegalArgumentException {
        Pattern p = Pattern.compile(PATTERN_DUPLICATE);
        Matcher m = p.matcher(colorsCombination);
        if (m.find())
            throw new IllegalArgumentException("Repeated colors");
    }
}