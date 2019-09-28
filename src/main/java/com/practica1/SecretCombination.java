package com.practica1;

import java.util.Collections;
import java.util.List;

public class SecretCombination extends Combination
{
    public SecretCombination() {
        //TODO Generar combinacion secreta
    }

    public void calculateResult(ProposedCombination proposedCombination) {
        proposedCombination.setResult(GetResult(proposedCombination));
    }

    public void write() {
        System.out.println(String.join("", Collections.nCopies(this.GetColors().size(), "*")));
    }

    private Result GetResult(ProposedCombination proposedCombination) {
        List<Color> colorList = this.GetColors();
        int deads = 0;
        int damaged = 0;
        for (int indexColor = 0; indexColor < colorList.size(); indexColor++) {
            Color color = colorList.get(indexColor);
            if (this.getColor(indexColor).equals(color))
                deads++;
            else if (this.Contains(color))
                damaged++;
        }
        return new Result(deads, damaged);
    }
}