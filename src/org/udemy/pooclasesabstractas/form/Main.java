package org.udemy.pooclasesabstractas.form;

import org.udemy.pooclasesabstractas.form.elementos.InputForm;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        // una clase anonima es aquella que se implementa atraves de una interfaz
        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave","password");
        InputForm email = new InputForm("email","email");
        InputForm edad = new InputForm("edad","number");

    }
}