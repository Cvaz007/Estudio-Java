package org.udemy.pooclasesabstractas.form.elementos;

public class TextareaForm extends ElementosForm{
    private int filas;
    private int columnas;

    public TextareaForm(String nombre) {
        super(nombre);
    }

    public TextareaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String dibujatHtml() {
        return "<textarea name='"+this.nombre+"' cols='"+this.columnas+"' rows='"+this.filas+"'>"+this.valor+"</textarea>";
    }
}