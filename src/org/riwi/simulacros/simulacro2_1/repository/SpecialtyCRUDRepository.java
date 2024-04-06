package org.riwi.simulacros.simulacro2_1.repository;

import org.riwi.simulacros.simulacro2_1.entity.Specialty;

import java.util.List;

public interface SpecialtyCRUDRepository {
    Specialty saveSpecialty(Specialty specialty);
    void deleteSpecialty(int id);
    void updateSpecialty(Specialty specialty);
    Specialty findSpecialtyById(int id);
    Specialty findSpecialtyByName(String name);
    List<Specialty> findAll();

}
