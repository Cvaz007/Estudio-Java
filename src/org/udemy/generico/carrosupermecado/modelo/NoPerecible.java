package org.udemy.generico.carrosupermecado.modelo;

public class NoPerecible extends Producto {
    private int contenido;
    private int calorias;

    public NoPerecible(int contenido, int calorias, String nombre, double precio) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
