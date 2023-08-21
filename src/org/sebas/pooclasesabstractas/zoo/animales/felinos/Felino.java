package org.sebas.pooclasesabstractas.zoo.animales.felinos;

import org.sebas.pooclasesabstractas.zoo.animales.Mamifero;

abstract public class Felino extends Mamifero {
    protected float tamanoGarras;
    protected int velocidad;

    public Felino() {
    }

    public Felino(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    public float getTamanoGarras() {
        return tamanoGarras;
    }

    public void setTamanoGarras(float tamanoGarras) {
        this.tamanoGarras = tamanoGarras;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
