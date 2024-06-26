package org.riwi.simulacros.simulacro2_1.repository;

import java.util.List;

public interface CrudRepository {
    Object save(Object object);

    void update(Object object);

    void delete(Object object);

    Object find(Object object);

    List<Object> findAll();
}
