package org.riwi.simulacro2.repository;

import org.riwi.simulacro2.entity.Appointment;

import java.util.List;

public interface AppointmentCRUDRepository {
    Appointment saveAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int id);
    Appointment findAppointmentById(int id);
    List<Appointment> findAll();
}
