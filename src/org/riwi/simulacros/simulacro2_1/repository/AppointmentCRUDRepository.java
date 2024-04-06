package org.riwi.simulacros.simulacro2_1.repository;

import org.riwi.simulacros.simulacro2_1.entity.Appointment;

import java.util.List;

public interface AppointmentCRUDRepository {
    Appointment saveAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int id);
    Appointment findAppointmentById(int id);
    List<Appointment> findAll();
}
