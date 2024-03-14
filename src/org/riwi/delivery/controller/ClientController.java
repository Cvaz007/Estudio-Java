package org.riwi.delivery.controller;

import org.riwi.delivery.model.entity.Account;
import org.riwi.delivery.model.entity.Client;
import org.riwi.delivery.service.ClientService;

import java.util.ArrayList;

public class ClientController {
    private final ClientService clientService = new ClientService();

    public void update(String id){
        clientService.updateClient(id);
    }
    public void inactive(String id){
        clientService.inactiveClient(id);
    }
    public void create (Account account){
        clientService.createClient(account);
    }
}
