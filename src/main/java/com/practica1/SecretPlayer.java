package com.practica1;

public class SecretPlayer {
    private ProposedPlayer proposedPlayer;
    private SecretCombination secretCombination;

    public SecretPlayer(ProposedPlayer proposedPlayer) {
        if (proposedPlayer == null)
            throw new IllegalArgumentException("The proposedPlayer is not valid");
        this.proposedPlayer = proposedPlayer;
    }

    public void prepare() {
        secretCombination = new SecretCombination();
    }

    public void answer() {
        ProposedCombination proposedCombination = this.proposedPlayer.getLastProposedCombination();
        this.secretCombination.calculateResult(proposedCombination);
    }

    public void writeSecretCombination() {
        secretCombination.write();
    }
}