package com.practica1;

import com.practica1.interfaces.*;

public class Mastermind implements IMastermind 
{
    private static final int NumeroMaximoIntentos = 10;
    
    private int numeroIntento = 0;
    private Intento[] intentos;

    @Override
    public void inicio()
    {
        numeroIntento = 0;
        intentos = new Intento[NumeroMaximoIntentos];
        System.out.println("----- MASTERMIND -----");
    }

    @Override
    public Combinacion solicitarCombinacion()
    {
        String combinacionRecogida = recogerCombinacion();
        Combinacion combinacion = new Combinacion(combinacionRecogida);
        chequearIntento(combinacion);
        return combinacion;
    }
    
    private String recogerCombinacion()
    {
        //TODO Recoger resultado de pantalla
        return null;
    }

    private void chequearIntento(Combinacion combinacion)
    {
        Resultado resultado = chequearResultado(combinacion);
        intentos[numeroIntento] = new Intento(combinacion, resultado);
        numeroIntento++;
    }

    private Resultado chequearResultado(Combinacion combinacion) {
        //TODO Calcular Resultado
        return null;
    }

    @Override
    public boolean continuarJugando() {
        // TODO Preguntar si desea continuar
        return false;
    }

    @Override
    public boolean esFinalDePartida() {
        return numeroIntento == NumeroMaximoIntentos || intentos[numeroIntento-1].EsGanador();
    }
}