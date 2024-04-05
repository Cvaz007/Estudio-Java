package org.riwi.simulacros.simulacro2_2.repository;

import java.util.List;

public interface CrudRepository {
    Object save(Object object);

    void update(Object object);

    void delete(Object object);

    Object find(int id);

    List<Object> findAll();
}
