package org.sebas.ejemploestructuradatos.list.sebas.primasClases;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        arreglos a = new arreglos();
        a.iteracionInversas();

        String user = System.getProperty("user.home");
        System.out.println("user = " + user);

        Scanner x = new Scanner(System.in);
        int num1,num2;

        System.out.println("Ingrese el numero 1: ");
        num1= x.nextInt();
        System.out.println("Ingrese el numero 2: ");
        num2= x.nextInt();

        System.out.println("La suma de los dos numeros es: "+(num1+num2));

    }
}
