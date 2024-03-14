package org.riwi.delivery;

import org.riwi.delivery.controller.*;
import org.riwi.delivery.service.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);
        AccountController accountController = new AccountController();
        ClientController clientController = new ClientController();
        DeliveryManController deliveryManController = new DeliveryManController();
        OrderController orderController = new OrderController();
        ProductController productController = new ProductController();
        UserController userController = new UserController();


        clientController.create(accountController.register());
        accountController.show();


        System.out.print("Here:");
        String id = objScanner.next();
        clientController.update(id);

//Falta terminar el ProductService

    }
}
