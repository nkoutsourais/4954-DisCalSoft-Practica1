package com.practica1;

public class Result
{
    private static final int DEADS_WIN = 4;

    private int deads = 0;
    private int damaged = 0;

    public Result(int deads, int damaged) {
        this.deads = deads;
        this.damaged = damaged;
    }

    public void write() {
        //TODO Escribir resultado
    }

    public boolean isWinner()
    {
        return damaged == 0 && deads == DEADS_WIN;
    }
}