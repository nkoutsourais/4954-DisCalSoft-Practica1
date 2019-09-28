package com.practica1;

import java.util.*;

public class ProposedPlayer
{
    private static final int MAX_ATTEMPTS = 10;

    private List<ProposedCombination> proposedCombinationList;

    public ProposedPlayer() {
        proposedCombinationList = new ArrayList<ProposedCombination>();
    }

    public void propose() {
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.read();
        this.proposedCombinationList.add(proposedCombination);
    }

    public ProposedCombination getLastProposedCombination() {
        return proposedCombinationList.get(proposedCombinationList.size() -1);
    }

    public void writeAttempts() {
        //TODO Escrbir intentos
    }

    public void writeProposedCombinations() {
        //TODO Escrbir lista proposiciones
    }

    public boolean isWinner() {
        return this.getLastProposedCombination().isWinner();
    }

    public boolean isLooser() {
        return this.proposedCombinationList.size() >= MAX_ATTEMPTS;
    }
}