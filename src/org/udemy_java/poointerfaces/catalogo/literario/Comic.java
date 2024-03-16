package org.udemy_java.poointerfaces.catalogo.literario;

public class Comic extends Libro{
    private String personaje;

    public Comic(int precio, String autor, String titulo, String editorial, String personaje) {
        super(precio, autor, titulo, editorial);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    @Override
    public double getPrecioVenta() {
        return super.getPrecioVenta();
    }
}
