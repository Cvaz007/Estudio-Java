package org.riwi.delivery.controller;

import org.riwi.delivery.model.entity.Order;
import org.riwi.delivery.model.entity.User;
import org.riwi.delivery.service.UserService;

public class UserController {
    private final UserService userService = new UserService();

    public void addOrderToHistory(User user, Order order) {
        userService.addOrderToHistory(user, order);
    }
}
