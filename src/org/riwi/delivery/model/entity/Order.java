package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.Status;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String clientId;
    private String deliveryManId;
    private String orderDate;
    private String id;
    private Status status;
    private double totalPrice;
    private ArrayList<Product> listProducts;
    private String deliveryTime;
    private PayMethod payMethod;

    public Order(String clientId, String deliveryManId, String orderDate, String id, Status status, double totalPrice, ArrayList<Product> listProducts, String deliveryTime, PayMethod payMethod) {
        this.clientId = clientId;
        this.deliveryManId = deliveryManId;
        this.orderDate = orderDate;
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
        this.listProducts = listProducts;
        this.deliveryTime = deliveryTime;
        this.payMethod = payMethod;
    }

    public Order(String clientId, String orderDate, String id, Status status) {
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.id = id;
        this.status = status;
    }

    public Order() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(String deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
