package org.riwi.EjerciciosArrays;

import org.riwi.EjerciciosArrays.calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.calculator();
    }

    public void calculator(){
        Calculator calculatorObj = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do{
            calculatorObj.menu();
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.print("Grade:");
                    double grade = scanner.nextDouble();
                    System.out.print("Name:");
                    String name = scanner.next();
                    calculatorObj.saveGrade(grade,name);
                    break;
                case 2:
                    calculatorObj.averageGrades();
                    break;
                case 3:
                    option=3;
                    System.out.println("Bye, bye...!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while (option != 3);
    }
}
