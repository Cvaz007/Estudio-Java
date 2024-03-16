package org.udemy_java.lambdas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.*;

public class FuncionesLambdas {
    public void function() {

        Function<String,String> f1 = param -> "Hola que tal " +param;
        String resultado = f1.apply("Sebastian");
        System.out.println("Nombre = " + resultado);

        BiFunction<String,String,String> f3 = (a,b) -> a.toUpperCase().concat(b.toLowerCase());
        String r2 = f3.apply("Juan ","Jose");
        System.out.println(r2);

        //ejemplo de referencia de metodos
        Function<String,String> f2 = String::toUpperCase;
        System.out.println(f2.apply("Juancho"));

        BiFunction<String,String,String> f4 = String::concat;
        String r3 = f4.apply("Juan ","Jose Lopez");
        System.out.println(r3);
    }

    public void consumer(){

            Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("La fecha actual es: "+f.format(fecha));
        };
        consumidor.accept(new Date());
    }

    public void predicate(){
        Predicate<Integer> test = num -> num>10;
        boolean r= test.test(2);
        System.out.println("test = " + r);

        BiPredicate<String,String> t2 = (a,b)-> a.equals(b);
        boolean r2 = t2.test("Hool", "Hool");
        System.out.println("test = " + r2);
        //por referencia
        BiPredicate<String,String> t3 = String::equals;
        boolean r3 = t3.test("Hool", "Hool");
        System.out.println("test = " + r3);
    }

    public double computarCal(double a, double b, Aritmetica lambda){
        return lambda.operacion(a,b);
    }
}
