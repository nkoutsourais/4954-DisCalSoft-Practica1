package com.practica1;

import java.util.*;

public class ProposedPlayer {
    private static final int MAX_ATTEMPTS = 10;

    private List<ProposedCombination> proposedCombinationList;

    public ProposedPlayer() {
        proposedCombinationList = new ArrayList<ProposedCombination>();
    }

    public void propose(Scanner scanner) {
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.read(scanner);
        this.proposedCombinationList.add(proposedCombination);
    }

    public ProposedCombination getLastProposedCombination() {
        return proposedCombinationList.get(proposedCombinationList.size() - 1);
    }

    public void writeAttempts() {
        System.out.println(proposedCombinationList.size() + " attempt(s):");
    }

    public void writeProposedCombinations() {
        proposedCombinationList.stream().forEach(c -> c.write());
    }

    public boolean isWinner() {
        return this.getLastProposedCombination().isWinner();
    }

    public boolean isLooser() {
        return this.proposedCombinationList.size() >= MAX_ATTEMPTS;
    }

    public boolean continuePlay(Scanner scanner) {
        proposedCombinationList.clear();
        System.out.print("Do you want to continue? (s/n): ");
        String response = scanner.nextLine();
        return "s".equalsIgnoreCase(response);
    }
}