package org.riwi.EjerciciosArrays.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    ArrayList<Grade> grades = new ArrayList<>();

    public void averageGrades() {
        double finalGrade = 0;
        for (Grade grade : grades) {
            finalGrade += grade.getGrade();
        }
        System.out.println("The average of the grades is " + finalGrade / grades.size());
    }

    public void saveGrade(double grade, String name) {
        Grade currentGrade = new Grade(grade, name);
        grades.add(currentGrade);
    }

    public void menu (){
        System.out.println("--- MENU EXERCISE 1. ---");
        System.out.println("1. Save grade");
        System.out.println("2. See the average grade");
        System.out.println("3. exit");
    }

    public void calculatorOptions(){
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
