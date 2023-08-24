package org.hackerRank.basic;

import java.util.Scanner;
/*
Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example
Return '12:01:00'.
Return '00:01:00'.

Function Description
Complete the timeConversion function in the editor below. It should return a new string representing the
input time in 24 hour format.

timeConversion has the following parameter(s):
string s: a time in  hour format
Returns
string: the time in  hour format
Input Format

A single string  that represents a time in -hour clock format (i.e.:  or ).

Constraints
All input times are valid

Sample Input
07:05:45PM

Sample Output
19:05:45
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
