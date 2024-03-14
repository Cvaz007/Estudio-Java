package org.riwi.delivery.controller;

import org.riwi.delivery.model.entity.Account;
import org.riwi.delivery.service.DeliveryManService;

public class DeliveryManController {
    private final DeliveryManService deliveryManService = new DeliveryManService();

    public void update(String id){
        deliveryManService.updateDeliveryMan(id);
    }
    public void inactive(String id){
        deliveryManService.inactiveClient(id);
    }
    public void create (Account account){
        deliveryManService.createClient(account);
    }
}
