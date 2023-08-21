package org.sebas.threads.runnable;

public class Main {
    public static void main(String[] args) {
        //una manera de hacer lo mismo que tenemos en la clase viaje con run es:
        Runnable viaje = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Me voy a: " + Thread.currentThread().getName());
            }
        };
        /*
         Para hacer con funciones landa se escribe:
         Runnable viaje = ()-<{
         for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Me voy a: " + Thread.currentThread().getName());
          }
        */

        new Thread(viaje, "Isla ").start();
        new Thread(viaje, "Isla Pichu").start();

        new Thread(new ViajeTarea("Isla Malaga")).start();
        new Thread(new ViajeTarea("Isla Margarita")).start();
        new Thread(new ViajeTarea("Isla Demonio")).start();

    }
}
