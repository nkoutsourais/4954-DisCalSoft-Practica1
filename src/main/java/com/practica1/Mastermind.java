package com.practica1;

import com.practica1.interfaces.*;

public class Mastermind implements IMastermind
{
    private static final int NumeroMaximoIntentos = 10;
    private int numeroIntento = 0;
    private Intento[] intentos;
    
    @Override
    public void chequearIntento(Combinacion combinacion)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void inicio()
    {
        numeroIntento = 0;
        intentos = new Intento[NumeroMaximoIntentos];
        System.out.println( "----- MASTERMIND -----" );
    }

    @Override
    public boolean continuarPartida()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Combinacion solicitarCombinacion()
    {
        // TODO Auto-generated method stub
        return null;
    }
}