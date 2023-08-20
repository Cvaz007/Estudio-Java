package org.sebas.ejemploestructuradatos.list.sebas.poointerfaces.catalogo.electronico;

import org.sebas.ejemploestructuradatos.list.sebas.poointerfaces.catalogo.Producto;

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
