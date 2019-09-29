package com.practica1;

import java.util.Scanner;

public class Mastermind {
    private ProposedPlayer proposedPlayer;
    private SecretPlayer secretPlayer;

    public Mastermind() {
        proposedPlayer = new ProposedPlayer();
        secretPlayer = new SecretPlayer(proposedPlayer);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----- MASTERMIND -----");
            secretPlayer.prepare();
            secretPlayer.write();
            do {
                proposedPlayer.propose(scanner);
                proposedPlayer.writeAttempts();
                secretPlayer.write();
                secretPlayer.answer();
                proposedPlayer.writeProposedCombinations();
            } while (!proposedPlayer.isWinner() && !proposedPlayer.isLooser());
        } while (proposedPlayer.continuePlay(scanner));
        scanner.close();
    }
}