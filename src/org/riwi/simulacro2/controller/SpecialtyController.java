package org.riwi.simulacro2.controller;

import org.riwi.simulacro2.entity.Specialty;
import org.riwi.simulacro2.model.SpecialtyModel;

import javax.swing.*;

public class SpecialtyController {
    private final SpecialtyModel specialtyModel;

    public SpecialtyController() {
        this.specialtyModel = new SpecialtyModel();
    }

    public void saveSpecialty() {
        String name = JOptionPane.showInputDialog("Type the specialty's name: ");
        String description = JOptionPane.showInputDialog("Type the 'description: ");

        Specialty specialty = new Specialty(name, description);
        specialtyModel.saveSpecialty(specialty);
        specialtyModel.saveSpecialty(specialty);

        JOptionPane.showMessageDialog(null, "Specialty was successfully saved");
    }

    public void updateSpecialty(){
        int patientId = Integer.parseInt(JOptionPane.showInputDialog("\n¿which specialty do you want to update?"));
        String name = JOptionPane.showInputDialog("Type the specialty's name: ");
        String description = JOptionPane.showInputDialog("Type the 'description: ");

        Specialty specialty = new Specialty(name, description);
        specialtyModel.updateSpecialty(specialty);
        JOptionPane.showInputDialog(null,"Update Specialty");
    }

    public void deleteSpecialty(){
        int patientId = Integer.parseInt(JOptionPane.showInputDialog("\n¿which specialty do you want to delete?"));
        specialtyModel.deleteSpecialty(patientId);
        JOptionPane.showMessageDialog(null, "Specialty was successfully deleted");
    }

    public void findSpecialty() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿which specialty do you want to find?"));
        Specialty specialty = specialtyModel.findSpecialtyById(id);
        JOptionPane.showMessageDialog(null, specialty.toString());
    }

    public void finAllSpecialty() {
        String specialties = "specialties \n";
        for (Specialty specialty : specialtyModel.findAll()) {
            specialties += specialty.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, specialties);
    }
}
