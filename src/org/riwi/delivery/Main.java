package org.riwi.delivery;

import org.riwi.delivery.controller.*;
import org.riwi.delivery.model.Rol;
import org.riwi.delivery.model.entity.Account;
import org.riwi.delivery.model.entity.Order;
import org.riwi.delivery.service.AccountService;

import java.util.Scanner;

public class Main {
    static Scanner objScanner = new Scanner(System.in);
    static AccountController accountController = new AccountController();
    static ClientController clientController = new ClientController();
    static DeliveryManController deliveryManController = new DeliveryManController();
    static OrderController orderController = new OrderController();
    static ProductController productController = new ProductController();
    static UserController userController = new UserController();
    static boolean state = false;

    public static void main(String[] args) {

        productController.createProductStatic();
        Main objMain = new Main();
        int opction = 1;
        do {
            objMain.menuLogin();
            opction = objScanner.nextInt();

            switch (opction) {
                case 1:
                    System.out.print("Enter your email:");
                    String email = objScanner.next();
                    System.out.print("Enter your password:");
                    String password = objScanner.next();
                    state = accountController.login(email, password);
                    if (state) objMain.logicAfterLogin(email);
                    else System.out.println("Credential no valid");
                    break;
                case 2:
                    Account account =  accountController.register();
                    if (account.getRol() == Rol.CLIENT){
                        clientController.create(account);
                    }else {
                        deliveryManController.create(account);
                    }
                    break;
                default:
                    System.out.println("Option no valid");
            }
        } while (opction != 0);

    }

    public void menuLogin() {
        System.out.println("""
                --------------------------
                | 1. Login
                | 2. Register
                | 3. finish program
                --------------------------
                """);
    }

    public void logicAfterLogin(String email) {
        Account account = accountController.getAccountByEmail(email);
        if (account.getRol().equals(Rol.CLIENT)) {
            int option = 0;

            do {
                client();
                option = objScanner.nextInt();

                switch (option) {
                    case 1:
                        clientController.update(account.getId());
                        break;
                    case 2:
                        Order order = orderController.createOrder(account.getId());
                        orderController.addProduct(productController, orderController.getOrderById(order.getId()));
                        break;
                    case 3:
                        clientController.inactive(account.getId());
                        break;
                    case 4:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Option no valid");
                }
            } while (option != 4);
        } else {
            int option = 0;
            deliveryManController.create(account);
            if(deliveryManController.getDeliveryManById(account.getId()).getDocument() != null) deliveryManController.update(account.getId());
            String id="";
            do {
                deliveryMan();
                option = objScanner.nextInt();
                switch (option) {
                    case 1:
                        orderController.showOrders();
                        System.out.print("Enter the id order:");
                        id = objScanner.next();
                        Order currentOrder = orderController.getOrderById(id);
                        orderController.assignDeliveryMan(id, currentOrder);
                        break;
                    case 2:
                        System.out.print("Enter the id order:");
                        id = objScanner.next();
                        orderController.finishOrder(orderController.getOrderById(id));
                        break;
                    case 3:
                        orderController.showOrders();
                        break;
                    case 4:
                        productController.create();
                        break;
                    case 5:
                        System.out.println("Enter you email address:");
                        email = objScanner.next();
                        deliveryManController.inactive(email);
                        break;
                    case 6:
                        System.out.println("Enter you email address:");
                        email = objScanner.next();
                        deliveryManController.update(accountController.getAccountByEmail(email).getId());
                        break;
                    default:
                        System.out.println("Option no valid");
                }
            } while (option != 7);
        }
        int option = 0;

    }

    public void client() {
        System.out.println("""
                --------------------------
                | 1. Complete your profile. 
                | 2. Do an order.
                | 3. Inactive account.
                | 4. log out.
                --------------------------
                """);
    }

    public void deliveryMan() {
        System.out.println("""
                --------------------------
                | 1. Take an order.
                | 2. Finish order
                | 3. View history orders.
                | 4. Add product.
                | 5. Inactive account.
                | 6. Update profile.
                | 7. Log out.
                --------------------------
                """);
    }
}
