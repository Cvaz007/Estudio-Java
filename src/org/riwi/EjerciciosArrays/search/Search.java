package org.riwi.EjerciciosArrays.search;

import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    ArrayList<Integer> listNumbers = new ArrayList<Integer>();

    public void addNumber(int number) {
        listNumbers.add(number);
    }

    public void organizeAsc() {
        listNumbers.sort((a, b) -> a - b);
    }

    public void organizeDesc() {
        listNumbers.sort((a, b) -> b - a);
    }

    public void seeList(){
        System.out.print("List of numbers: ");
        for (int listNumber :listNumbers) {
            System.out.print(listNumber + " - ");
        }
        System.out.println();
    }

    public void menu() {
        System.out.println("--- MENU EXERCISE 2. ---");
        System.out.println("1. Add number");
        System.out.println("2. See min number");
        System.out.println("3. See max number");
        System.out.println("4. See list of numbers");
        System.out.println("0. Exit");
    }

    public void searchOptions() {
        Search searchObj = new Search();
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        do {
            searchObj.menu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Number:");
                    searchObj.addNumber(scanner.nextInt());
                    break;
                case 2:
                    searchObj.organizeAsc();
                    System.out.println("The minimum number is "+searchObj.listNumbers.get(0));
                    break;
                case 3:
                    searchObj.organizeDesc();
                    System.out.println("The maximum number is "+searchObj.listNumbers.get(0));
                    break;
                case 4:
                    searchObj.seeList();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 0);

    }
}
