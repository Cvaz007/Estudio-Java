package org.sebas.ejemploestructuradatos.list.sebas.poointerfaces.catalogo.literario;

import org.sebas.ejemploestructuradatos.list.sebas.poointerfaces.catalogo.Producto;

import java.util.Date;

public class Libro extends Producto implements ILibro {
    protected Date fechaPublicacion;
    protected String autor;
    protected  String titulo;
    protected  String editorial;

    public Libro(int precio , String autor, String titulo, String editorial) {
        super(precio);
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    @Override
    public double getPrecioVenta() {
        return getPrecio();
    }

    @Override
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getEditorial() {
        return editorial;
    }
}
