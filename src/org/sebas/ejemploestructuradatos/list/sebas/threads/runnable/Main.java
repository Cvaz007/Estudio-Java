package org.sebas.ejemploestructuradatos.list.sebas.threads.runnable;

public class Main {
    public static void main(String[] args) {
        new Thread( new ViajeTarea("Isla Malaga")).start();
        new Thread( new ViajeTarea("Isla Margarita")).start();
        new Thread( new ViajeTarea("Isla Demonio")).start();

    }
}
