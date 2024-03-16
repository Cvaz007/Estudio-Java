package org.udemy.threads.ejemplo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Juan");
        hilo.start();
       // Thread.sleep(100);
        System.out.println(hilo.getState());
    }
}
