package com.practica1;

import java.util.Scanner;

public class ProposedCombination extends Combination {
    private Result result;

    public void read(Scanner scanner) {
        do {
            try {
                System.out.print("Propose a combination: ");
                String colorSymbolsCombination = scanner.nextLine();
                Color[] colors = Color.getColorsBySymbols(colorSymbolsCombination);
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
        writeColors();
        System.out.print(" ");
        this.result.write();
    }

    public boolean isWinner() {
        return this.result.isWinner();
    }
}