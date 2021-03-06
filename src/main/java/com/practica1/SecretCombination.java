package com.practica1;

import java.util.Collections;
import java.util.Random;

public class SecretCombination extends Combination {
    public SecretCombination() {
        int position = 0;
        do {
            Color color = randomColor();
            if (!super.ContainsColor(color)) {
                super.setColor(color, position);
                position++;
            }
        } while (!super.isComplete());
    }

    private Color randomColor() {
        Random ramdom = new Random();
        return Color.values()[ramdom.nextInt(Color.values().length)];
    }

    public void calculateResult(ProposedCombination proposedCombination) {
        proposedCombination.setResult(getResult(proposedCombination));
    }

    public void write() {
        System.out.println(String.join("", Collections.nCopies(super.getColors().length, "*")));
    }

    private Result getResult(ProposedCombination proposedCombination) {
        int deads = 0;
        int damaged = 0;
        for (int indexColor = 0; indexColor < super.getColors().length; indexColor++) {
            Color color = super.getColors()[indexColor];
            if (proposedCombination.getColor(indexColor) == color)
                deads++;
            else if (proposedCombination.ContainsColor(color))
                damaged++;
        }
        return new Result(deads, damaged);
    }
}