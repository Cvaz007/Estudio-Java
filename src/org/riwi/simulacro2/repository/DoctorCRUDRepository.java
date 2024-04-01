package org.riwi.simulacro2.repository;

import org.riwi.simulacro2.entity.Doctor;

import java.util.List;

public interface DoctorCRUDRepository {
    Doctor saveDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
    Doctor findDoctorById(int id);
    List<Doctor> findAll();
}
