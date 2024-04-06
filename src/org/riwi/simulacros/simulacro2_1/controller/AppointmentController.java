package org.riwi.simulacros.simulacro2_1.controller;

import org.riwi.simulacros.simulacro2_1.entity.Appointment;
import org.riwi.simulacros.simulacro2_1.model.AppointmentModel;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class AppointmentController {
    private final AppointmentModel appointmentModel;
    private final DoctorController docotrController;
    private final PatientController patientController;

    public AppointmentController() {
        this.appointmentModel = new AppointmentModel();
        this.docotrController = new DoctorController();
        this.patientController = new PatientController();
    }

    public void saveAppointment() {
        patientController.findAll();
        int patientId = Integer.parseInt(JOptionPane.showInputDialog("\n¿To which patient does the appointment belong??"));
        docotrController.findAll();
        int doctorId = Integer.parseInt(JOptionPane.showInputDialog("\n¿To which doctor does the appointment belong??"));
        String reason = JOptionPane.showInputDialog("Type the reason");
        String timeString = JOptionPane.showInputDialog("type the time (HH:mm:ss)");
        String dateString = JOptionPane.showInputDialog("Type the date (yyyy-MM-dd)");

        Date date,time;
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
            time = (Date) dateFormat.parse(timeString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error:Format invalid. You need to use HH:mm:ss");
            return;
        }

        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = (Date) dateFormat.parse(dateString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: Format invalid. You need to use yyyy-MM-dd");
            return;
        }

        Appointment appointment = new Appointment(doctorId, patientId, date,time,reason);
        appointmentModel.saveAppointment(appointment);
        JOptionPane.showMessageDialog(null, "Appointment was successful created\n" + appointment);
    }

    public void updateAppointment() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿Which appointment do you want to update??"));
        docotrController.findAll();
        int doctorId = Integer.parseInt(JOptionPane.showInputDialog("\n¿To which doctor does the appointment belong??"));
        String reason = JOptionPane.showInputDialog("Type the reason");
        String timeString = JOptionPane.showInputDialog("type the time (HH:mm:ss)");
        String dateString = JOptionPane.showInputDialog("Type the date (yyyy-MM-dd)");

        Date date,time = new Date();
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
            time = (Date) dateFormat.parse(timeString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error:Format invalid. You need to use HH:mm:ss");
        }
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = (Date) dateFormat.parse(dateString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: Format invalid. You need to use yyyy-MM-dd");
            return;
        }
        Appointment appointment = appointmentModel.findAppointmentById(id);
        appointment.setDoctorId(doctorId);
        appointment.setReason(reason);
        appointment.setDate(date);
        appointment.setTime(time);
        appointmentModel.updateAppointment(appointment);
    }

    public void deleteAppointment() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿Which appointment do you want to delete??"));
        appointmentModel.deleteAppointment(id);
        JOptionPane.showMessageDialog(null, "Appointment was successful deleted\n");
    }

    public void findAllAppointment() {
        String appointments = "APPOINTS \n";
        for (Appointment appointment : appointmentModel.findAll()){
            appointments += appointment.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, appointments);
    }

    public void findAppointment(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n¿Which appointment do you want to update??"));
        JOptionPane.showMessageDialog(null, appointmentModel.findAppointmentById(id).toString());
    }

    public void findAppointmentByDate(){
        String dateString = JOptionPane.showInputDialog("Type the date (yyyy-MM-dd)");
        Date date = new Date();
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = (Date) dateFormat.parse(dateString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: Format invalid. You need to use yyyy-MM-dd");
            return;
        }
        JOptionPane.showMessageDialog(null, appointmentModel.findAppointmentByDate(date));

    }


}
