package org.hackerRank.basic.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SparseArray {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);
        List<String> string = new ArrayList<>();
        List<String> query = new ArrayList<>();

        int stringSize= objScanner.nextInt();
        for (int i = 0; i < stringSize; i++) {
            string.add(objScanner.next());
        }
        int querySize= objScanner.nextInt();
        for (int i = 0; i < querySize; i++) {
            query.add(objScanner.next());
        }
        System.out.println(matchingStrings(string,query));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> list = new ArrayList<>();
        int cont;
        for (int i = 0; i < queries.size(); i++) {
            cont=0;
            for (int j = 0; j < strings.size(); j++) {
                if (strings.get(j).equalsIgnoreCase(queries.get(i))){
                    cont+=1;
                }
            }
            list.add(cont);
        }

        return list;
    }
}
