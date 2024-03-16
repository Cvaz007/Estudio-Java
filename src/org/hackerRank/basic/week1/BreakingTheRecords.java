package org.hackerRank.basic.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreakingTheRecords {
    public static void main(String[] args) {
        Scanner leer =  new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();

        int n = leer.nextInt();

        for (int i = 0; i < n; i++) {
            lista.add(leer.nextInt());
        }
        System.out.println(breakingRecords(lista));
    }
    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> maxMin = new ArrayList<>();
        int max=scores.get(0),min=scores.get(0),contMax=0,contMin=0;

        for (int i = 1; i < scores.size(); i++) {

                if (scores.get(i)>max){
                    max=scores.get(i);
                    contMax+=1;
                }
                if (scores.get(i)<min){
                    min=scores.get(i);
                    contMin+=1;
                }

        }
        maxMin.add(contMax);
        maxMin.add(contMin);
        return maxMin;
    }
}
