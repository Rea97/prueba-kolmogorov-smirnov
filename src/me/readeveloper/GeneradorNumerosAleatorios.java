package me.readeveloper;

import java.text.DecimalFormat;

public class GeneradorNumerosAleatorios {
    private int cantidad;
    private int cantidadDecimales;

    public GeneradorNumerosAleatorios() throws Exception {
        this.setCantidad(10);
        this.setCantidadDecimales(5);
    }

    public GeneradorNumerosAleatorios(int cantidad, int cantidadDecimales) throws Exception {
        this.setCantidad(cantidad);
        this.setCantidadDecimales(cantidadDecimales);
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) throws Exception {
        if (cantidad < 1) {
            throw new Exception("Cantidad debe ser mayor a 0.");
        }
        this.cantidad = cantidad;
    }

    public int getCantidadDecimales() {
        return this.cantidadDecimales;
    }

    public void setCantidadDecimales(int cantidadDecimales) throws Exception {
        if (cantidad < 1) {
            throw new Exception("cantidad de Decimales debe ser mayor a 0.");
        }
        this.cantidadDecimales = cantidadDecimales;
    }

    private String getDecimalFormatPattern() {
        int i;
        int cantidadDecimales = this.getCantidadDecimales();
        StringBuilder patronDecimales = new StringBuilder(".");
        for (i = 0; i < cantidadDecimales; i++) {
            patronDecimales.append("#");
        }
        return patronDecimales.toString();
    }

    public double[] make() {
        int i;
        double[] numerosAleatorios = new double [this.getCantidad()];
        DecimalFormat decimalFormat = new DecimalFormat(this.getDecimalFormatPattern());

        for (i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = Double.parseDouble(decimalFormat.format(Math.random()));
        }

        return numerosAleatorios;
    }
}
