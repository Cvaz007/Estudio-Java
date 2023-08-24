package org.udemy.lambdas;

public class Main {
    public static void main(String[] args) {
        FuncionesLambdas fl = new FuncionesLambdas();
        Aritmetica suma = Double::sum;
        Aritmetica resta = (a,b)-> a-b;
        Aritmetica multiplicacion = (a,b)-> a*b;
        Aritmetica division = (a,b)-> a/b;

        System.out.println(fl.computarCal(10,5,resta));

        Ejercicios e1 = new Ejercicios();
        e1.eliminarCaracter();
        e1.contarPalabras();
    }
}
