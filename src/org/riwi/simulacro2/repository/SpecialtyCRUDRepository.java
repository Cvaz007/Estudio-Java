package org.riwi.simulacro2.repository;

import org.riwi.simulacro2.entity.Specialty;

import java.util.List;

public interface SpecialtyCRUDRepository {
    Specialty saveSpecialty(Specialty specialty);
    void deleteSpecialty(int id);
    void updateSpecialty(Specialty specialty);
    Specialty findSpecialtyById(int id);
    Specialty findSpecialtyByName(String name);
    List<Specialty> findAll();

}
