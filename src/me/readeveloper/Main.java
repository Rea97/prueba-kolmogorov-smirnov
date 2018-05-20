package me.readeveloper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cantidadNumeros;
        double[] numeros;
        int porcentjeAlfa;

        System.out.println("Ingresa la cantidad de numeros aleatorios a generar: ");
        cantidadNumeros = sc.nextInt();
        System.out.println("Ingresa el porcentaje de alfa: ");
        porcentjeAlfa = sc.nextInt();

        numeros = new GeneradorNumerosAleatorios(cantidadNumeros, 5).make();
        new PruebaKolmogorovSmirnov(numeros, porcentjeAlfa).resolver();
    }
}
