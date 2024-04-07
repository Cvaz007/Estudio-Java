package org.riwi.simulacros.simulacro2_1;

import org.riwi.simulacros.simulacro2_1.entity.Appointment;
import org.riwi.simulacros.simulacro2_1.entity.Doctor;
import org.riwi.simulacros.simulacro2_1.entity.Patient;
import org.riwi.simulacros.simulacro2_1.entity.Specialty;
import org.riwi.simulacros.simulacro2_1.model.AppointmentModel;
import org.riwi.simulacros.simulacro2_1.model.DoctorModel;
import org.riwi.simulacros.simulacro2_1.model.PatientModel;
import org.riwi.simulacros.simulacro2_1.model.SpecialtyModel;
import org.riwi.simulacros.simulacro2_1.controller.GenericController;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GenericController controller = new GenericController();
        AppointmentModel appointmentModel = new AppointmentModel();
        DoctorModel doctorModel = new DoctorModel();
        PatientModel patientModel = new PatientModel();
        SpecialtyModel specialtyModel = new SpecialtyModel();

        String optionEntity, optionCrud;
        String[] optionsEntity = {"1.CRUD DOCTOR", "2.CRUD PATIENT", "3.CRUD SPECIALTY", "4.CRUD APPOINTMENT", "5. EXIT"};
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
                case "1.CRUD DOCTOR":
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
                                controller.save(doctorModel, Doctor.class);
                                break;
                            case "2. Delete":
                                controller.delete(doctorModel);
                                break;
                            case "3. Update":
                                controller.update(doctorModel, Doctor.class);
                                break;
                            case "4. List":
                                controller.get(doctorModel);
                                break;
                            case "5. List all":
                                controller.getAll(doctorModel);
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
                case "2.CRUD PATIENT":
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
                                controller.save(patientModel, Patient.class);
                                break;
                            case "2. Delete":
                                controller.delete(patientModel);
                                break;
                            case "3. Update":
                                controller.update(patientModel, Patient.class);
                                break;
                            case "4. List":
                                controller.get(patientModel);
                                break;
                            case "5. List all":
                                controller.getAll(patientModel);
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
                case "3.CRUD SPECIALTY":
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
                                controller.save(specialtyModel, Specialty.class);
                                break;
                            case "2. Delete":
                                controller.delete(specialtyModel);
                                break;
                            case "3. Update":
                                controller.update(specialtyModel, Specialty.class);
                                break;
                            case "4. List":
                                controller.get(specialtyModel);
                                break;
                            case "5. List all":
                                controller.getAll(specialtyModel);
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
                case "4.CRUD APPOINTMENT":
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
                                controller.save(appointmentModel, Appointment.class);
                                break;
                            case "2. Delete":
                                controller.delete(appointmentModel);
                                break;
                            case "3. Update":
                                controller.update(appointmentModel, Appointment.class);
                                break;
                            case "4. List":
                                controller.get(appointmentModel);
                                break;
                            case "5. List all":
                                controller.getAll(appointmentModel);
                                break;
                            case "6. List by something":
                                //ReservationController reservationController = new ReservationController();
                                //controller.getBySomething(appointmentModel);
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
