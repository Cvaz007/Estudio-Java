package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.Rol;

import java.util.ArrayList;

public class Client extends User{
    private String address;

    public Client() {
    }

    public Client(String id, String email, String password, Rol rol) {
        super(id, email, password, rol);
    }

    public Client(String id, String email, String password, Rol rol, String name, String phone, ArrayList<Order> orderHistory, String address) {
        super(id, email, password, rol, name, phone, orderHistory);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
