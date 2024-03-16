package org.riwi.delivery.service;

import org.riwi.delivery.controller.ProductController;
import org.riwi.delivery.model.Status;
import org.riwi.delivery.model.entity.Order;
import org.riwi.delivery.model.entity.PayMethodImpl;
import org.riwi.delivery.model.entity.Product;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {
    private final ArrayList<Order> orders = new ArrayList<>();
    private final Scanner objScanner = new Scanner(System.in);

    public Order createOrder(String clientId) {
        String id = String.valueOf(System.currentTimeMillis());
        String date = LocalDate.now().toString();
        Status statusEmun = Status.INCOMPLE;
        Order order = new Order(clientId, date,id, statusEmun);
        orders.add(order);
        return order;
    }

    public void selectPayMethod(Order order) {
        System.out.print("Ingresa tu meto de pago (card-cash):");
        String payMethod = objScanner.next();
        order.setPayMethod(new PayMethodImpl(payMethod));
    }

    public void addProduct(ProductController objProduct, Order order) {
        ArrayList<Product> products = new ArrayList<Product>();
        String option = "si";
        while (option.equalsIgnoreCase("si")) {
            objProduct.showProducts();
            System.out.print("Ingresa el id del producto:");
            String id = objScanner.next();
            products.add(objProduct.getProductById(id));
            System.out.println("¿Vas agregar mas productos?");
            option = objScanner.next();
        }
        order.setListProducts(products);
        order.setTotalPrice(calculateTotal(products));
    }

    public double calculateTotal(ArrayList<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void deliveryTime(Order order){
        order.setDeliveryTime(LocalTime.now().toString());
    }
    public void assignDeliveryMan(String deliveryId,Order order){
        order.setDeliveryManId(deliveryId);
    }
    public void finishOrder(Order order){
        order.setStatus(Status.COMPLETED);
    }

    public void showOrders(){
        for (Order order:orders){
            System.out.println("Order:" + order.getId());
            System.out.println("Status:"+order.getStatus());
        }
    }

    public Order getOrderById(String id) {
        for (Order order:orders){
            if (order.getId().equalsIgnoreCase(id)){
                return order;
            }
        }
        return  null;
    }
}
