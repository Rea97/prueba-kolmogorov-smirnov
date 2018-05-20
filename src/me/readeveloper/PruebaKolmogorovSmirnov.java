package me.readeveloper;

import java.util.ArrayList;
import java.util.Arrays;

public class PruebaKolmogorovSmirnov {
    private double[] numerosAleatorios;
    private int porcentajeAlfa;

    PruebaKolmogorovSmirnov(double[] numerosAleatorios, int porcentjeAlfa) {
        this.numerosAleatorios = numerosAleatorios;
        this.porcentajeAlfa = porcentjeAlfa;
        Arrays.sort(this.numerosAleatorios);
    }

    public double[] getNumerosAleatorios() {
        return this.numerosAleatorios;
    }

    public void setNumerosAleatorios(double[] numerosAleatorios) {
        this.numerosAleatorios = numerosAleatorios;
    }

    public void resolver() {

    }
}
