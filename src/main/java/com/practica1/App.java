package com.practica1;

import com.practica1.interfaces.*;

public class App 
{
    public static void main( String[] args )
    {
        IMastermind mastermind = new Mastermind();
        do
        {
            mastermind.inicio();
            do
            {
                mastermind.solicitarCombinacion();
            }
            while(mastermind.esFinalDePartida());
        }
        while(mastermind.continuarJugando());
    }
}