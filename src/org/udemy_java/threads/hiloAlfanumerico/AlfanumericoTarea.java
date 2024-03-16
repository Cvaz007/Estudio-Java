package org.udemy_java.threads.hiloAlfanumerico;

import java.util.concurrent.TimeUnit;

public class AlfanumericoTarea implements Runnable{
    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            switch (tipo){
                case NUMERO -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Num = " + i);
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                }
                case LETRA -> {
                    for (char c='A';c<='Z';c++){
                        System.out.println("Letra = " + c);
                        TimeUnit.MILLISECONDS.sleep(1000);
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println("exeption = " + e);
        }

    }
}
