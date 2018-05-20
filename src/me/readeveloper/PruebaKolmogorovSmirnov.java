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

    private double[] calcularDistanciaAcumulada() {
        int n = this.numerosAleatorios.length;
        double[] distanciasAcumuladas = new double[n];

        for (int i = 0; i < this.numerosAleatorios.length; i++) {
            distanciasAcumuladas[i] = (double) (i + 1) / n;
            System.out.println(distanciasAcumuladas[i]);
        }

        return distanciasAcumuladas;
    }

    public void resolver() {
        this.calcularDistanciaAcumulada();
    }
}
