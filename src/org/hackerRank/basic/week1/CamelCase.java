package org.hackerRank.basic.week1;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
//el truco esta en que queda un ciclo infinito
public class CamelCase {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String vec;
        int f = 0;

        while (leer.hasNextLine()){
            vec=leer.nextLine();
            list.add(vec);

            String text = list.get(f) ;

            String first = text.charAt(0)+"";
            String second = text.charAt(2)+"";
            String resultado="";
            int letra;
            String textL;

            if (first.equalsIgnoreCase("S")){
                if (second.equalsIgnoreCase("M")){
                    for (int i = 4; i < text.length()-2; i++) {
                        letra=text.charAt(i);
                        if (letra < 123 && letra > 96){
                            resultado+=text.charAt(i);
                        }else resultado+=" "+text.charAt(i);
                    }
                    resultado=resultado.toLowerCase();
                }

                if (second.equalsIgnoreCase("v")){
                    for (int i = 4; i < text.length(); i++) {
                        letra=text.charAt(i);
                        if (letra < 123 && letra > 96){
                            resultado+=text.charAt(i);
                        }else resultado+=" "+text.charAt(i);
                    }
                    resultado=resultado.toLowerCase();
                }
                if (second.equalsIgnoreCase("C")){
                    resultado=text.charAt(4)+"";
                    for (int i = 5; i < text.length(); i++) {
                        letra=text.charAt(i);
                        if (letra < 123 && letra > 96){
                            resultado+=text.charAt(i);
                        }else resultado+=" "+text.charAt(i);
                    }
                    resultado=resultado.toLowerCase();
                }

            }else{
                if (second.equalsIgnoreCase("M")){
                    int i=4;
                    boolean bandera= false;
                    while (i<text.length()){

                        textL=text.charAt(i)+"";
                        if (textL.equalsIgnoreCase(" ")){
                            bandera=true;
                            i++;
                            continue;
                        }
                        if(bandera){
                            resultado+=(textL).toUpperCase();
                        }else resultado+=textL;

                        bandera=false;
                        i++;
                    }
                    resultado+="()";
                }
                if (second.equalsIgnoreCase("v")){
                    int i=4;
                    boolean bandera= false;
                    while (i<text.length()){

                        textL=text.charAt(i)+"";
                        if (textL.equalsIgnoreCase(" ")){
                            bandera=true;
                            i++;
                            continue;
                        }
                        if(bandera){
                            resultado+=(textL).toUpperCase();
                        }else resultado+=textL;

                        bandera=false;
                        i++;
                    }
                }
                if (second.equalsIgnoreCase("C")){
                    int i=5;
                    resultado=(text.charAt(4)+"").toUpperCase();
                    boolean bandera= false;
                    while (i<text.length()){

                        textL=text.charAt(i)+"";
                        if (textL.equalsIgnoreCase(" ")){
                            bandera=true;
                            i++;
                            continue;
                        }
                        if(bandera){
                            resultado+=(textL).toUpperCase();
                        }else resultado+=textL;

                        bandera=false;
                        i++;
                    }
                }
            }
            f+=1;
            System.out.println(resultado);
        }

    }
}
