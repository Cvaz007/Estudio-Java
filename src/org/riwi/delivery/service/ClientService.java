package org.riwi.delivery.service;

import org.riwi.delivery.model.entity.Account;
import org.riwi.delivery.model.entity.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientService {
    private final ArrayList<Client> clients = new ArrayList<>();
    private final ArrayList<Client> inactiveClients = new ArrayList<>();
    Scanner objScanner = new Scanner(System.in);

    public void updateClient(String id) {
        Client currentClient = getClientById(id);
        if (currentClient != null) {
            System.out.print("Enter your new address:");
            String newAddress = objScanner.next();
            System.out.print("Enter your new name:");
            String name = objScanner.next();
            System.out.print("Enter your new phone:");
            String phone = objScanner.next();

            currentClient.setAddress(newAddress);
            currentClient.setName(name);
            currentClient.setPhone(phone);

            show();
        } else System.out.println("This user doesn't exist");
    }

    public void createClient(Account account) {
        Client client = new Client(account.getId(), account.getEmail(), account.getPassword(), account.getRol());
        clients.add(client);
    }

    public Client getClientById(String id) {
        if (!clients.isEmpty()) {
            for (Client client : clients) {
                System.out.println(client.getId());
                if (client.getId().equalsIgnoreCase(id)) {
                    return client;
                }
            }
        }
        return null;
    }

    public void show() {
        for (Client client : clients) {
            System.out.println(client.getEmail());
            System.out.println(client.getPassword());
        }
    }

    public void inactiveClient(String id) {
        Client currentClient = getClientById(id);
        if (currentClient != null) {
            inactiveClients.add(currentClient);
            clients.remove(currentClient);
        }
    }

}
