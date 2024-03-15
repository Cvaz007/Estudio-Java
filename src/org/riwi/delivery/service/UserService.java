package org.riwi.delivery.service;

import org.riwi.delivery.model.entity.Order;
import org.riwi.delivery.model.entity.User;

import java.util.ArrayList;

public class UserService {

    public void addOrderToHistory(User user, Order order) {
        ArrayList<Order> orders = user.getOrderHistory();
        orders.add(order);
        user.setOrderHistory(orders);
    }
}
