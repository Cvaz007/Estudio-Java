package org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo;

import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.Mamifero;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.caninos.Canino;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.caninos.Lobo;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.caninos.Perro;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.felinos.Felino;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.felinos.Guepardo;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.felinos.Leon;
import org.sebas.ejemploestructuradatos.list.sebas.pooclasesabstractas.zoo.animales.felinos.Tigre;

public class Main {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[2];

        Mamifero leon = new Leon("SUR AFRICA",120F,60F,100F,"lEONIDAS",10F,40,2,300F);
        Mamifero guepardo = new Guepardo("AMAERICA",50F,60F,120F,"GEOPARDIÑO",40F, 120);

        mamiferos[0]= leon;
        mamiferos[1]=guepardo;

        for (Mamifero animal: mamiferos){
            System.out.println(" =============== " + animal.getClass().getSimpleName() + " =============== ");
            System.out.println("Habitat:" + animal.getHabitad());
            System.out.println("Altura:" + animal.getAltura());
            System.out.println("Largo:" + animal.getLargo());
            System.out.println("Peso:" + animal.getPeso());

            if (animal instanceof Canino) {
                System.out.println("Clomillos:" + ((Canino) animal).getTamanoColmillos());
                System.out.println("Color:" + ((Canino) animal).getColor());

                if (animal instanceof Lobo) {
                    System.out.println("Especie Lobo:" + ((Lobo) animal).getEspecieLobo());
                    System.out.println("Número Integrantes:" + ((Lobo) animal).getNumCamada());
                }
                if (animal instanceof Perro) {
                    System.out.println("Fuerza mordida kg:" + ((Perro) animal).getFuerzaMordida());
                }
            }

            if (animal instanceof Felino) {
                System.out.println("Tamaño Garras:" + ((Felino) animal).getTamanoGarras());
                System.out.println("Velocidad:" + ((Felino) animal).getVelocidad());

                if (animal instanceof Leon) {
                    System.out.println("Potencia Rugido:" + ((Leon) animal).getPotenciaRugidoDecibel());
                    System.out.println("Número Integrantes:" + ((Leon) animal).getNumManada());
                }
                if (animal instanceof Tigre) {
                    System.out.println("especie Tigre:" + ((Tigre) animal).getEspecieTigre());
                }
            }

            System.out.println(animal.comer());
            System.out.println(animal.dormir());
            System.out.println(animal.correr());
            System.out.println(animal.comunicarse());

        }
    }
}
