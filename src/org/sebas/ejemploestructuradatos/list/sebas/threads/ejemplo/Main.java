package org.sebas.ejemploestructuradatos.list.sebas.threads.ejemplo;

import org.sebas.ejemploestructuradatos.list.sebas.threads.ejemplo.NombreThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Juan");
        hilo.start();
       // Thread.sleep(100);
        System.out.println(hilo.getState());
    }
}
