package org.riwi.simulacros.simulacro2_2;

import org.riwi.simulacros.simulacro2_2.controller.GenericController;
import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.model.AirplaneModel;
import org.riwi.simulacros.simulacro2_2.model.FlightModel;
import org.riwi.simulacros.simulacro2_2.model.PassengerModel;
import org.riwi.simulacros.simulacro2_2.model.ReservationModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GenericController controller = new GenericController();
        AirplaneModel airplaneModel = new AirplaneModel();
        PassengerModel passengerModel = new PassengerModel();

        String optionEntity, optionCrud;
        String[] optionsEntity = {"1.CRUD PASSENGER", "2.CRUD AIRPLANE", "3.CRUD FLIGHT", "4.CRUD RESERVATION", "5. EXIT"};
        String[] optionsCrud = {"1. Create", "2. Delete", "3. Update", "4. List", "5. List all", "6. List by something", "7. Exit"};
        do {
            optionEntity = (String) JOptionPane.showInputDialog(
                    null,
                    "Select one option",
                    "Select Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsEntity,
                    optionsEntity[0]
            );
            System.out.println(optionEntity);
            switch (optionEntity) {
                case "1.CRUD PASSENGER":
                    do {
                        optionCrud = (String) JOptionPane.showInputDialog(
                                null,
                                "Select one option",
                                "Select Menu",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                optionsCrud,
                                optionsCrud[0]);

                        switch (optionCrud) {
                            case "1. Create":
                                controller.save(passengerModel, Airplane.class);
                                break;
                            case "2. Delete":
                                controller.delete(passengerModel);
                                break;
                            case "3. Update":
                                controller.update(passengerModel, Airplane.class);
                                break;
                            case "4. List":
                                controller.get(passengerModel);
                                break;
                            case "5. List all":
                                controller.getAll(passengerModel);
                                break;
                            default:
                                JOptionPane.showInputDialog("I'm sorry, this options is not valid with this entity");
                                break;
                        }
                    } while (!optionCrud.equalsIgnoreCase("7. Exit"));
                    break;
                case "2.CRUD AIRPLANE":
                    do {
                        optionCrud = (String) JOptionPane.showInputDialog(
                                null,
                                "Select one option",
                                "Select Menu",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                optionsCrud,
                                optionsCrud[0]);

                        switch (optionCrud) {
                            case "1. Create":
                                controller.save(airplaneModel, Airplane.class);
                                break;
                            case "2. Delete":
                                controller.delete(airplaneModel);
                                break;
                            case "3. Update":
                                controller.update(airplaneModel, Airplane.class);
                                break;
                            case "4. List":
                                controller.get(airplaneModel);
                                break;
                            case "5. List all":
                                controller.getAll(airplaneModel);
                                break;
                            default:
                                JOptionPane.showInputDialog("I'm sorry, this options is not valid with this entity");
                                break;
                        }
                    } while (!optionCrud.equalsIgnoreCase("7. Exit"));
                    break;
                case "3.CRUD FLIGHT":
                    break;
                case "4.CRUD RESERVATION":
                    break;
            }
        } while (!optionEntity.equalsIgnoreCase("5. EXIT"));

    }
}
