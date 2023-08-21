package org.sebas.ejemploestructuradatos.list.sebas.threads.hiloAlfanumerico;

public class Main {
    public static void main(String[] args) {
        AlfanumericoTarea h1 = new AlfanumericoTarea(Tipo.LETRA);
        AlfanumericoTarea h2 = new AlfanumericoTarea(Tipo.NUMERO);

        Thread T1 = new Thread(h1);
        Thread T2 = new Thread(h2);

        T1.start();
        T2.start();
    }
}
