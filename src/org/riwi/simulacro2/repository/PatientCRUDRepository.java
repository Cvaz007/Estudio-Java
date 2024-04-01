package org.riwi.simulacro2.repository;

import org.riwi.simulacro2.entity.Patient;

import java.util.List;

public interface PatientCRUDRepository {
    Patient savePatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(int id);
    Patient findPatientById(int id);
    List<Patient> findAll();
}
