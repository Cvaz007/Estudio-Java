package org.riwi.JDBC;


import org.riwi.JDBC.controller.CoderController;
import org.riwi.JDBC.entity.Coder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main objMain = new Main();
        CoderController controller = new CoderController();
        Scanner objScnner = new Scanner(System.in);


        //System.out.println("-------=== LIST ONE CODER ===-------------");
        //controller.getById(1);

        //Coder coder = new Coder("Juancho", 18, "Jobs");
        //controller.insert(coder);

        //Coder coder = new Coder(1,"Keiber Alimaña", 29, "Meta");
        // controller.update(coder);

        controller.delete(8);
        int option = 0, age, id;
        String name, clan;
        Coder coder;

        do {
            objMain.menu();
            option = objScnner.nextInt();

            switch (option) {
                case 1:
                    controller.getAll();
                    break;

                case 2:
                    System.out.println("----- CREATE A CODER -----");
                    System.out.print("Name:");
                    name = objScnner.next();
                    System.out.print("Age:");
                    age = objScnner.nextInt();
                    System.out.print("Clan:");
                    clan = objScnner.next();
                    coder = new Coder(name, age, clan);
                    controller.insert(coder);
                    break;

                case 3:
                    System.out.println(" ----- UPDATE A CODER ------");
                    System.out.print("Id:");
                    id = objScnner.nextInt();
                    System.out.print("Name:");
                    name = objScnner.next();
                    System.out.print("Age:");
                    age = objScnner.nextInt();
                    System.out.print("Clan:");
                    clan = objScnner.next();
                    coder = new Coder(id, name, age, clan);
                    controller.update(coder);
                    break;
                case 4:
                    System.out.println(" ----- DELETE A CODER ------");
                    System.out.print("Id:");
                    id = objScnner.nextInt();
                    controller.delete(id);
                    break;
                case 5:
                    System.out.println(" ----- GET A CODER BY ID ------");
                    System.out.print("Id:");
                    id = objScnner.nextInt();
                    controller.getById(id);
                    break;

            }
        } while (option != 7);
    }

    public void menu() {
        System.out.println("""
                MENU
                1. List Coders
                2. Insert Coder
                3. Update Coder
                4. Delete Coder
                5. Get By id
                6. Get by name
                7. Exit
                                    
                Choose an option
                             
                """);
    }
}
