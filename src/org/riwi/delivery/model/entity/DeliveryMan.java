package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.Rol;
import org.riwi.delivery.model.Status;

import java.util.ArrayList;

public class DeliveryMan extends User{
    private String vehicle;
    private String plate;
    private String document;
    private Status status;

    public DeliveryMan() {
    }

    public DeliveryMan(String id, String email, String password, Rol rol, String name, String phone, ArrayList<Order> orderHistory, String vehicle, String plate, String document, Status status) {
        super(id, email, password, rol, name, phone, orderHistory);
        this.vehicle = vehicle;
        this.plate = plate;
        this.document = document;
        this.status = status;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
