package com.practica1;

public class ProposedCombination extends Combination {
    private Result result;

    public void read() {
        //TODO Leer nueva proposicion
    }

    public boolean contains(Color color, int position) {
        return this.getColor(position).equals(color);
    }

    public boolean contains(Color color) {
        return super.Contains(color);
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void write() {
        //TODO Escribir proposicion
    }

    public boolean isWinner() {
        return this.result.isWinner();
    }
}