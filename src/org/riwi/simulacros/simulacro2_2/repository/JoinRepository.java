package org.riwi.simulacros.simulacro2_2.repository;

import org.riwi.simulacros.simulacro2_2.entity.Reservation;

import java.util.List;

public interface JoinRepository {
    List<Object> findEntityBySomething(Object entity);
}
