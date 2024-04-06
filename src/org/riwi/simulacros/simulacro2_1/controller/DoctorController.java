package org.riwi.simulacros.simulacro2_1.controller;

import org.riwi.simulacros.simulacro2_1.entity.Doctor;
import org.riwi.simulacros.simulacro2_1.model.DoctorModel;

import javax.swing.*;

public class DoctorController {
    private final DoctorModel doctorModel;
    private final SpecialtyController specialtyController;

    public DoctorController() {
        this.doctorModel = new DoctorModel();
        this.specialtyController = new SpecialtyController();
    }

    public void saveDoctor() {
        String name = JOptionPane.showInputDialog("Type the doctor's name: ");
        String lastName = JOptionPane.showInputDialog("typle the doctor's lastname: ");
        specialtyController.finAllSpecialty();
        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog("Type the id of the doctor's specialty "));

        Doctor doctor = new Doctor(name, lastName, specialtyId);
        doctorModel.saveDoctor(doctor);
        JOptionPane.showMessageDialog(null, doctor + "\nDoctor was successfully created");
    }

    public void updateDoctor() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the doctor id that you want to update"));
        String name = JOptionPane.showInputDialog("Type the doctor's name: ");
        String lastName = JOptionPane.showInputDialog("typle the doctor's lastname: ");
        specialtyController.finAllSpecialty();
        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog("Type the id of the physician's specialty "));

        Doctor doctor = new Doctor(id, name, lastName, specialtyId);
        doctorModel.updateDoctor(doctor);
        JOptionPane.showMessageDialog(null, doctor + "\nDoctor was successfully updated");
    }

    public void deleteDoctor() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the doctor id that you want to delete"));
        doctorModel.deleteDoctor(id);
        JOptionPane.showMessageDialog(null, "Doctor was successfully deleted");
    }

    public void findAll() {
        String doctors = "DOCTORS \n";
        for (Doctor doctor : doctorModel.findAll()) {
            doctors += doctor.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, doctors);
    }

    public void findDoctorById() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the doctor id that you want to find"));
        JOptionPane.showMessageDialog(null, doctorModel.findDoctorById(id).toString());
    }

    public void findDoctorBySpecialty() {
        specialtyController.finAllSpecialty();
        String specialty = JOptionPane.showInputDialog("Type the id of the doctor's specialty ");


    }
}
