package org.riwi.delivery.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String clientId;
    private String deliveryManId;
    private Date orderDate;
    private String id;
    private String status;
    private double totalPrice;
    private ArrayList<Product> listProducts;
    private Date deliveryTime;
    private PayMethod payMethod;

    public Order(String clientId, String deliveryManId, Date orderDate, String id, String status, double totalPrice, ArrayList<Product> listProducts, Date deliveryTime, PayMethod payMethod) {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }
}
