package org.riwi.EjerciciosArrays;

import org.riwi.EjerciciosArrays.booking.Booking;
import org.riwi.EjerciciosArrays.calculator.Calculator;
import org.riwi.EjerciciosArrays.search.Search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Calculator calculatorObj = new Calculator();
        Search searchObj = new Search();
        Booking bookingObj = new Booking();
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            main.menu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    calculatorObj.calculatorOptions();
                    break;
                case 2:
                    searchObj.searchOptions();
                    break;
                case 3:
                    bookingObj.bookingOptions();
                    break;
                case 0:
                    option=0;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }while (option != 0);
    }

    public void menu(){
        System.out.println("--- Menu ---");
        System.out.println("1. Exercise 1");
        System.out.println("2. Exercise 2");
        System.out.println("3. Exercise 3");
        System.out.println("0. Exit");
    }
}
