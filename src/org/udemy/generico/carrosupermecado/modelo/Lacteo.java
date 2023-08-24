package org.udemy.generico.carrosupermecado.modelo;

public class Lacteo extends Producto {
    private int cantida;
    private int proteinas;

    public Lacteo(int cantidad, int proteinas, String nombre, double precio) {
        super(nombre, precio);
        this.cantida = cantida;
        this.proteinas = proteinas;
    }

    public int getCantidad() {
        return cantida;
    }

    public void setCantidad(int cantidaD) {
        this.cantida = cantidaD;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }
}
