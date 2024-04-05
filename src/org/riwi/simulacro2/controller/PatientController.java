package org.riwi.simulacro2.controller;

import org.riwi.simulacro2.entity.Patient;
import org.riwi.simulacro2.model.PatientModel;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class PatientController {
    private final PatientModel patientModel;

    public PatientController() {
        this.patientModel = new PatientModel();
    }

    public void savePatient() {
        Patient patient = new Patient();
        patient.setName(JOptionPane.showInputDialog("Enter patient name"));
        patient.setLastName(JOptionPane.showInputDialog("Enter patient last name"));
        String dateBirth = JOptionPane.showInputDialog("Type the date (yyyy-MM-dd)");
        patient.setIdentityCard(JOptionPane.showInputDialog("Enter patient identity card"));

        Date date;
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = (Date) dateFormat.parse(dateBirth);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: Format invalid. You need to use yyyy-MM-dd");
            return;
        }
        patient.setDateBirth(date);
        patientModel.savePatient(patient);
        JOptionPane.showMessageDialog(null, "Patient saved");
    }

    public void updatePatient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿To which patient do you want to update?"));
        Patient patient = patientModel.findPatientById(id);
        patient.setName(JOptionPane.showInputDialog("Enter patient name"));
        patient.setLastName(JOptionPane.showInputDialog("Enter patient last name"));
        String dateBirth = JOptionPane.showInputDialog("Type the date (yyyy-MM-dd)");
        patient.setIdentityCard(JOptionPane.showInputDialog("Enter patient identity card"));

        Date date;
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = (Date) dateFormat.parse(dateBirth);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: Format invalid. You need to use yyyy-MM-dd");
            return;
        }
        patient.setDateBirth(date);
        patientModel.updatePatient(patient);
        JOptionPane.showMessageDialog(null, "Patient updated");
    }

    public void deletePatient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿To which patient do you want to delete?"));
        patientModel.deletePatient(id);
        JOptionPane.showMessageDialog(null, "Patient deleted");
    }

    public void findPatient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿To which patient do you want to find?"));
        Patient patient = patientModel.findPatientById(id);
        JOptionPane.showMessageDialog(null, patient.toString());
    }

    public void findAll() {
        String patients = "PATIENTS \n";
        for(Patient patient : patientModel.findAll() ){
            patients += patient.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, patients);
    }
}
