package com.practica1;

public class Intento
{
    Combinacion combinacion;
    Resultado resultado;
    
    public Combinacion getCombinacion() {
        return combinacion;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public boolean EsGanador() {
        return resultado.EsResultadoGanador();
    }

    public Intento(Combinacion combinacion, Resultado resultado) {

        if(combinacion == null)
            throw new IllegalArgumentException("La combinacion no puede ser nula");
        else if(resultado == null)
            throw new IllegalArgumentException("El resultado no puede ser nulo");

        this.combinacion = combinacion;
        this.resultado = resultado;
    }
}