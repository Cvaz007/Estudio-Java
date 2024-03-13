package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.Rol;

import java.util.ArrayList;

public class User extends Account{
    private String name;
    private String phone;
    private ArrayList<Order> orderHistory;

    public User() {
    }

    public User(String id, String email, String password, Rol rol, String name, String phone, ArrayList<Order> orderHistory) {
        super(id, email, password, rol);
        this.name = name;
        this.phone = phone;
        this.orderHistory = orderHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
