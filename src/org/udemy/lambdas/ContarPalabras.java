package org.udemy.lambdas;

import java.util.Map;
@FunctionalInterface
public interface ContarPalabras {
    Map<String,Integer> contarPalabras(String frase);
}