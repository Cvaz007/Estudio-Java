package org.hackerRank.basic.week1;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlusMinus {
    public static void main(String[] args) throws IOException {
        Scanner leer =  new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();

        int n = leer.nextInt();

        for (int i = 0; i < n; i++) {
            lista.add(leer.nextInt());
        }
        plusMinus(lista);
    }

    public static void plusMinus(List<Integer> arr) {
        DecimalFormat df = new DecimalFormat("0.00000");
        double size = arr.size();
        double opNegativos,opPositivos,opCeros;
        int contNegativos=0, contPositivos=0, contCeros=0;

        for (int i = 0; i < size; i++) {
            if (arr.get(i) < 0){
                contNegativos+=1;
            } else if (arr.get(i) == 0) {
                contCeros+=1;
            }else {
                contPositivos+=1;
            }
        }
        opCeros=(double) (contCeros/size);
        opNegativos=contNegativos/size;
        opPositivos=contPositivos/size;

        System.out.println(df.format(opPositivos));
        System.out.println(df.format(opNegativos));
        System.out.println(df.format(opCeros));
    }
}
