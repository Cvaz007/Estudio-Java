package org.riwi.delivery.controller;

import org.riwi.delivery.model.entity.Order;
import org.riwi.delivery.service.OrderService;
import org.riwi.delivery.service.ProductService;

public class OrderController {
    private final OrderService service = new OrderService();

    public Order createOrder(String clientId) {
        return service.createOrder(clientId);
    }

    public void selectPayMethod(Order order) {
        service.selectPayMethod(order);
    }

    public void addProduct(ProductService objProduct, Order order) {
        service.addProduct(objProduct, order);
    }

    public void deliveryTime(Order order) {
        service.deliveryTime(order);
    }

    public void assignDeliveryMan(String deliveryId, Order order) {
        service.assignDeliveryMan(deliveryId, order);
    }

    public void finishOrder(Order order) {
        service.finishOrder(order);
    }
}
