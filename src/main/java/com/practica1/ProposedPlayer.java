package com.practica1;

import java.util.*;

public class ProposedPlayer {
    private static final int MAX_ATTEMPTS = 10;

    private List<ProposedCombination> attempts;

    public ProposedPlayer() {
        attempts = new ArrayList<ProposedCombination>();
    }

    public void propose(Scanner scanner) {
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.read(scanner);
        this.attempts.add(proposedCombination);
    }

    public ProposedCombination getLastProposedCombination() {
        return attempts.get(attempts.size() - 1);
    }

    public void writeAttempts() {
        System.out.println(attempts.size() + " attempt(s):");
    }

    public void writeProposedCombinations() {
        attempts.stream().forEach(c -> c.write());
    }

    public boolean isWinner() {
        return this.getLastProposedCombination().isWinner();
    }

    public boolean isLooser() {
        return this.attempts.size() >= MAX_ATTEMPTS;
    }

    public void writeResultPlay() {
        if(this.isWinner())
            System.out.println("You've won!!! ;-)");
        else if(this.isLooser())
            System.out.println("You've lost!!! :-(");
    }

    public boolean continuePlay(Scanner scanner) {
        attempts.clear();
        System.out.print("Do you want to continue? (s/n): ");
        String response = scanner.nextLine();
        return "s".equalsIgnoreCase(response);
    }
}