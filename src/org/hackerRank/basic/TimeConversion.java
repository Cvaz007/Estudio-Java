package org.hackerRank.basic;

import java.util.Scanner;
/*
https://www.hackerrank.com/challenges/three-month-preparation-kit-time-conversion/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
 */
public class TimeConversion {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String s = leer.next();
        String resultado = ejercicio(s);
        System.out.println(resultado);
    }

    public static String ejercicio(String s) {
        String zona = s.charAt(8) + "" + s.charAt(9);
        String hora = s.charAt(0) + "" + s.charAt(1);
        String horario = "";
        int op = Integer.parseInt(hora);

        if (zona.equalsIgnoreCase("PM")) {
            if (hora.equalsIgnoreCase("12")){
                for (int i = 0; i < (s.length()-2); i++) {
                    horario += ""+s.charAt(i);
                }
            }else{
                op += 12;
                horario = op + "";
                for (int i = 2; i < (s.length() - 2); i++) {
                    horario += "" + s.charAt(i);
                    System.out.print(s.charAt(i));
                }
            }
        }else {
            if(hora.equalsIgnoreCase("12")){
                horario="00";
                for (int i = 2; i < (s.length()-2); i++) {
                    horario +=""+s.charAt(i);
                }
            }else{
                for (int i = 0; i < (s.length()-2); i++) {
                    horario += ""+s.charAt(i);
                }
            }
        }
        return horario;
    }
}
