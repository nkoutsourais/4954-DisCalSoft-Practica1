package com.practica1;

import com.practica1.interfaces.*;

public class App 
{
    public static void main( String[] args )
    {
        IMastermind mastermind = new Mastermind();
        mastermind.inicio();
        while(mastermind.continuarPartida())
        {
            Combinacion combinacion = mastermind.solicitarCombinacion();
            mastermind.chequearIntento(combinacion);
        }
    }   
}