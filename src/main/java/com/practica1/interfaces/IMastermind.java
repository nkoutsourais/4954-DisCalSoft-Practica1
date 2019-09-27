package com.practica1.interfaces;

import com.practica1.*;

public interface IMastermind
{
    void inicio();
    Combinacion solicitarCombinacion();
    boolean esFinalDePartida();
    boolean continuarJugando();
}