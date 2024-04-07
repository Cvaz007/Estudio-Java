package org.riwi.simulacros.simulacro2_2;

import org.riwi.simulacros.simulacro2_2.controller.GenericController;
import org.riwi.simulacros.simulacro2_2.controller.ReservationController;
import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.entity.Flight;
import org.riwi.simulacros.simulacro2_2.entity.Passenger;
import org.riwi.simulacros.simulacro2_2.entity.Reservation;
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
        FlightModel flightModel = new FlightModel();
        ReservationModel reservationModel = new ReservationModel();

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
                                controller.save(passengerModel, Passenger.class);
                                break;
                            case "2. Delete":
                                controller.delete(passengerModel);
                                break;
                            case "3. Update":
                                controller.update(passengerModel, Passenger.class);
                                break;
                            case "4. List":
                                controller.get(passengerModel);
                                break;
                            case "5. List all":
                                controller.getAll(passengerModel);
                                break;
                            case "7. Exit":
                                System.out.println("BYE!");
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
                            case "7. Exit":
                                System.out.println("BYE!");
                                break;
                            default:
                                JOptionPane.showInputDialog("I'm sorry, this options is not valid with this entity");
                                break;
                        }
                    } while (!optionCrud.equalsIgnoreCase("7. Exit"));
                    break;
                case "3.CRUD FLIGHT":
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
                                controller.save(flightModel, Flight.class);
                                break;
                            case "2. Delete":
                                controller.delete(flightModel);
                                break;
                            case "3. Update":
                                controller.update(flightModel, Flight.class);
                                break;
                            case "4. List":
                                controller.get(flightModel);
                                break;
                            case "5. List all":
                                controller.getAll(flightModel);
                                break;
                            case "7. Exit":
                                System.out.println("BYE!");
                                break;
                            default:
                                JOptionPane.showInputDialog("I'm sorry, this options is not valid with this entity");
                                break;
                        }
                    } while (!optionCrud.equalsIgnoreCase("7. Exit"));
                    break;
                case "4.CRUD RESERVATION":
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
                                controller.save(reservationModel, Reservation.class);
                                break;
                            case "2. Delete":
                                controller.delete(reservationModel);
                                break;
                            case "3. Update":
                                controller.update(reservationModel, Reservation.class);
                                break;
                            case "4. List":
                                controller.get(reservationModel);
                                break;
                            case "5. List all":
                                controller.getAll(reservationModel);
                                break;
                            case "6. List by something":
                                //ReservationController reservationController = new ReservationController();
                                controller.getBySomething(reservationModel,reservationModel);
                                break;
                            case "7. Exit":
                                System.out.println("BYE!");
                                break;
                            default:
                                JOptionPane.showInputDialog("I'm sorry, this options is not valid with this entity");
                                break;
                        }
                    } while (!optionCrud.equalsIgnoreCase("7. Exit"));
                    break;
            }
        } while (!optionEntity.equalsIgnoreCase("5. EXIT"));

    }
}
