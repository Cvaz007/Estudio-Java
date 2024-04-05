package org.riwi.simulacros.simulacro2_1.repository;

import org.riwi.simulacros.simulacro2_1.entity.Doctor;

import java.util.List;

public interface DoctorCRUDRepository {
    Doctor saveDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
    Doctor findDoctorById(int id);
    List<Doctor> findAll();
}
