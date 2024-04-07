package org.riwi.simulacros.simulacro2_2.repository;

import org.riwi.simulacros.simulacro2_2.entity.Flight;

import java.util.List;

public interface CrudRepository {
    Object save(Object object);

    void update(Object object);

    void delete(Object object);

    Object find(Object object);

    List<Object> findAll();
}
