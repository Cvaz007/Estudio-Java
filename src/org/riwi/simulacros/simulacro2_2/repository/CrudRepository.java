package org.riwi.simulacros.simulacro2_2.repository;

import java.util.List;

public interface CrudRepository {
    void save(Object object);

    void update(Object object);

    void delete(Object object);

    Object find();

    List<Object> findAll();
}
