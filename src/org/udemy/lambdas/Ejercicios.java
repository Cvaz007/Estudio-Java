package org.udemy.lambdas;


import java.util.Collections;
import java.util.function.Function;

public class Ejercicios {
    public void eliminarCaracter(){
        Function<String,String> f1 = a -> a.replaceAll("[.+,+ ]","").toLowerCase();
        String cadena = f1.apply(" Ju,..anc h..o");
        System.out.println(cadena);
    }

    public void contarPalabras(){
        ContarPalabras contador = frase -> {
            String[] arreglo = frase.replace(".", "")
                    .replace(",", "")
                    .toLowerCase()
                    .split(" ");

            int max = 0;
            String palabra = null;
            for (int i = 0; i < arreglo.length; i++) {
                int cantidad = 0;
                for (int j = 0; j < arreglo.length; j++) {
                    if (arreglo[i].equalsIgnoreCase(arreglo[j])) {
                        cantidad++;
                    }
                }

                if(cantidad > max){
                    max = cantidad;
                    palabra = arreglo[i];
                }
            }
            return Collections.singletonMap(palabra, max);
        };
        contador.contarPalabras("Yo ni te conozco, ni te he visto, ni se tu nombre, ni te hablaré, ni me interesas.")
                .forEach( (k, v) -> System.out.println("la palabra " + k + " se repite " + v + " veces. "));
    }
}
