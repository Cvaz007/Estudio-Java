package org.hackerRank.basic.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxMinSum {
    public static void main(String[] args) {
        Scanner leer =  new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            lista.add(leer.nextInt());
        }
        miniMaxSum(lista);
    }

    public static void miniMaxSum(List<Integer> arr) {
        long maxSum=0,minSum=0;
        arr.sort((n1,n2)-> n1.compareTo(n2));
        for (int i = 0; i < 4; i++) {
            maxSum+=arr.get(4-i);
            minSum+=arr.get(i);
        }
        System.out.println(minSum+" "+maxSum);
    }
}
