package org.udemy_java.pooclasesabstractas.zoo.animales.caninos;

import org.udemy_java.pooclasesabstractas.zoo.animales.Mamifero;

abstract public class Canino extends Mamifero {
    protected String color;
    protected float tamanoColmillos;

    public Canino() {
    }

    public Canino(String habitad, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos) {
        super(habitad, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanoColmillos = tamanoColmillos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getTamanoColmillos() {
        return tamanoColmillos;
    }

    public void setTamanoColmillos(float tamanoColmillos) {
        this.tamanoColmillos = tamanoColmillos;
    }

}
