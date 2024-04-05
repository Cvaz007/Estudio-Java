package org.riwi.simulacros.simulacro2_2.repository;

import org.riwi.simulacros.simulacro2_2.entity.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> findFlightsByDestination();
}
