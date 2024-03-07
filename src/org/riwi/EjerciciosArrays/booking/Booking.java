package org.riwi.EjerciciosArrays.booking;

import java.util.Scanner;

public class Booking {
    boolean cinema[][] = new boolean[5][10];

    public void bookingSit(int row, int column) {
        cinema[row][column] = true;
    }

    public void cancelBooking(int row, int column) {
        if (cinema[row][column]) {
            cinema[row][column] = false;
        } else System.out.println("This sit haven't a booking");
    }

    public void showAvailableSits() {
        System.out.println("Colum - 0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < cinema.length; i++) {
            System.out.print("Row " + i + " - ");
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j] == false) {
                    System.out.print("O ");
                } else System.out.print("X ");
            }
            System.out.println();
        }
    }

    public void countAvailableSits() {
        int available = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j] == false) {
                    available++;
                }
            }
        }
        System.out.println("There are " + available + " available sits and " + ((cinema.length * cinema[0].length)-available) + " unavailable sits");
    }

    public void menu() {
        System.out.println("--- MENU EXERCISE 3. ---");
        System.out.println("1. Booking");
        System.out.println("2. cancel booking");
        System.out.println("3. Show available seats ");
        System.out.println("4. Count available sits and unavailable sits.");
        System.out.println("0. Exit");
    }

    public void bookingOptions() {
        Booking bookingObj = new Booking();
        Scanner scanner = new Scanner(System.in);
        int option = -1, row = 0, column = 0;
        do {
            bookingObj.menu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Column:");
                    column = scanner.nextInt();
                    System.out.print("row:");
                    row = scanner.nextInt();
                    bookingObj.bookingSit(row, column);
                    break;
                case 2:
                    System.out.print("Column:");
                    column = scanner.nextInt();
                    System.out.print("row:");
                    row = scanner.nextInt();
                    bookingObj.cancelBooking(row, column);
                    break;
                case 3:
                    bookingObj.showAvailableSits();
                    break;
                case 4:
                    bookingObj.countAvailableSits();
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
