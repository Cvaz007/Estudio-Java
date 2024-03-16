package org.udemy_java.lambdas;

import java.util.Map;
@FunctionalInterface
public interface ContarPalabras {
    Map<String,Integer> contarPalabras(String frase);
}
