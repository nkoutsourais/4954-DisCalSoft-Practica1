package com.practica1;

import java.util.Scanner;

public class Mastermind {
    private ProposedPlayer proposedPlayer;
    private SecretPlayer secretPlayer;
    private Scanner scanner;

    public Mastermind() {
        proposedPlayer = new ProposedPlayer();
        secretPlayer = new SecretPlayer(proposedPlayer);
        scanner = new Scanner(System.in);
    }

    public void play() {
        do {
            this.writeIntro();
            secretPlayer.prepare();
            secretPlayer.writeSecretCombination();
            do {
                proposedPlayer.propose(scanner);
                secretPlayer.answer();
                proposedPlayer.writeAttempts();
                secretPlayer.writeSecretCombination();
                proposedPlayer.writeProposedCombinations();
            } while (!this.isGameOver());
            proposedPlayer.writeResultPlay();
        } while (proposedPlayer.continuePlay(scanner));
    }

    private boolean isGameOver() {
        return proposedPlayer.isWinner() || proposedPlayer.isLooser();
    }

    private void writeIntro() {
        System.out.println("----- MASTERMIND -----");
    }

    @Override
    public void finalize() {
        scanner.close();
    }
}