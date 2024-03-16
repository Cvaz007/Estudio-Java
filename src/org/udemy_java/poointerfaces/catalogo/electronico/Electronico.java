package org.udemy_java.poointerfaces.catalogo.electronico;

import org.udemy_java.poointerfaces.catalogo.Producto;

public abstract class Electronico extends Producto implements IElectronico {
    protected String fabricante;

    public Electronico(int precio, String fabricante) {
        super(precio);
        this.fabricante = fabricante;
    }
    public abstract String prueba();
    @Override
    public String getFabricante() {
        return fabricante;
    }
}
