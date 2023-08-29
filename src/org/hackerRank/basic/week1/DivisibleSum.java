package org.hackerRank.basic.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DivisibleSum {
    public static void main(String[] args) throws IOException, IOException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(2);

        System.out.println(divisibleSumPairs(6, 3, list));

    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int aux, op, numPair = 0;
        for (int i = 0; i < n; i++) {
            aux = ar.get(i);
            for (int j = i+1; j < n ; j++) {
                op = aux + ar.get(j);
                if ((op % k) == 0) {
                    numPair += 1;
                }
            }
        }
        return numPair;
    }
}
