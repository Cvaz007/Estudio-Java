package org.udemy_java.generico.carrosupermecado.modelo;

public class Fruta extends Producto {
    private double peso;
    private String color;

    public Fruta(double peso, String color, String nombre, double precio) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
