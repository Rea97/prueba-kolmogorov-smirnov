package me.readeveloper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
        }

        return distanciasAcumuladas;
    }

    private double[] calcularEstadistico(double[] distanciaAcumulada) {
        double[] estadisticosCalculados = new double[this.numerosAleatorios.length];

        for (int i = 0; i < this.numerosAleatorios.length; i++) {
            estadisticosCalculados[i] = Math.abs(distanciaAcumulada[i] - this.numerosAleatorios[i]);
        }

        return estadisticosCalculados;
    }

    private double getEstadisticoTabla() {
        System.out.println(
                String.format("Ingresa el estadistico de tabla de d %d%%,%d", this.porcentajeAlfa, this.numerosAleatorios.length)
        );

        return new Scanner(System.in).nextDouble();
    }

    private double findMaxEstadisticoCalculado(double[] estadisticosCalculados) {
        ArrayList<Double> list = new ArrayList<>(estadisticosCalculados.length);

        for (double estadistico : estadisticosCalculados) {
            list.add(estadistico);
        }

        return Collections.max(list);
    }

    public void resolver() {
        double[] distanciaAcumulada = this.calcularDistanciaAcumulada();
        double[] estadisticosCalculados = this.calcularEstadistico(distanciaAcumulada);
        double estadisticoTabla = this.getEstadisticoTabla();
        double mayorEstadisticoCalculado = this.findMaxEstadisticoCalculado(estadisticosCalculados);

        System.out.println("-------------Numeros aleatorios---------------");
        for(double number : this.numerosAleatorios) {
            System.out.println(number);
        }
        System.out.println("----------------------------------");

        System.out.println(String.format("Dn < d alfa N"));
        if (mayorEstadisticoCalculado < estadisticoTabla) {
            System.out.println(
                String.format("%.5f < %.5f | verdadero", mayorEstadisticoCalculado, estadisticoTabla)
            );
            System.out.println("Los numeros son aceptados.");
        } else {
            System.out.println(
                String.format("%.5f < %.5f | falso", mayorEstadisticoCalculado, estadisticoTabla)
            );
            System.out.println("Los numeros son rechazados.");
        }
    }
}
