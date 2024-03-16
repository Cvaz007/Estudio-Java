package org.riwi.delivery.service;

import org.riwi.delivery.model.Status;
import org.riwi.delivery.model.entity.Account;
import org.riwi.delivery.model.entity.DeliveryMan;

import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryManService {
    private final ArrayList<DeliveryMan> deliveriesMen = new ArrayList<>();

    private final ArrayList<DeliveryMan> inactiveDeliveriesMen = new ArrayList<>();
    Scanner objScanner = new Scanner(System.in);

    public void updateDeliveryMan(String id) {
        DeliveryMan currentDeliveryMan = getDeliveryManById(id);
        if (currentDeliveryMan != null) {
            System.out.print("Enter your new vehicle:");
            String vehicle = objScanner.next();
            System.out.print("Enter your new plate:");
            String plate = objScanner.next();
            System.out.print("Enter your new document:");
            String document = objScanner.next();
            System.out.print("Enter your new status:");
            String status = objScanner.next();

            currentDeliveryMan.setDocument(document);
            currentDeliveryMan.setPlate(plate);
            currentDeliveryMan.setVehicle(vehicle);

            if (status.equalsIgnoreCase("active")) {
                Status statusEmun = Status.ACTIVE;
                currentDeliveryMan.setStatus(statusEmun);
            } else if (status.equalsIgnoreCase("inactive")) {
                Status statusEmun = Status.INACTIVE;
                currentDeliveryMan.setStatus(statusEmun);
            }

        } else System.out.println("This user doesn't exist");
    }

    public void createClient(Account account) {
        DeliveryMan deliveryMan = new DeliveryMan(account.getId(), account.getEmail(), account.getPassword(), account.getRol());
        deliveriesMen.add(deliveryMan);
    }

    public DeliveryMan getDeliveryManById(String id) {
        if (!deliveriesMen.isEmpty()) {
            for (DeliveryMan deliveryMan : deliveriesMen) {
                System.out.println(deliveryMan.getId());
                if (deliveryMan.getId().equalsIgnoreCase(id)) {
                    return deliveryMan;
                }
            }
        }
        return null;
    }
    public DeliveryMan getDeliveryManByEmail(String email) {
        if (!deliveriesMen.isEmpty()) {
            for (DeliveryMan deliveryMan : deliveriesMen) {
                System.out.println(deliveryMan.getId());
                if (deliveryMan.getEmail().equalsIgnoreCase(email)) {
                    return deliveryMan;
                }
            }
        }
        return null;
    }

    public void show() {
        for (DeliveryMan deliveryMan : deliveriesMen) {
            System.out.println(deliveryMan.getEmail());
            System.out.println(deliveryMan.getPassword());
            System.out.println(deliveryMan.getDocument());
        }
    }

    public void inactiveClient(String email) {
        DeliveryMan currentDeliveryMan = getDeliveryManByEmail(email);
        if (currentDeliveryMan != null) {
            inactiveDeliveriesMen.add(currentDeliveryMan);
            deliveriesMen.remove(currentDeliveryMan);
        }
    }
}
