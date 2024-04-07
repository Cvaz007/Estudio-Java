package org.riwi.simulacros.simulacro2_2.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_2.entity.Flight;
import org.riwi.simulacros.simulacro2_2.entity.Passenger;
import org.riwi.simulacros.simulacro2_2.entity.Reservation;
import org.riwi.simulacros.simulacro2_2.repository.CrudRepository;
import org.riwi.simulacros.simulacro2_2.repository.JoinTest;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationModel implements CrudRepository {
    Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Reservation reservation = (Reservation) object;
        try {
            String sql = "INSERT INTO reservation (flight_id,passenger_id,seat,reservation_date) VALUES (?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reservation.getFlightId());
            statement.setInt(2, reservation.getPassengerId());
            statement.setString(3, reservation.getSeat());
            statement.setDate(4, new Date(reservation.getReservationDate().getTime()));
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                reservation.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Reservation insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return reservation;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Reservation reservation = (Reservation) object;
        try {
            String sql = "UPDATE reservation SET flight_id = ?, passenger_id = ?, seat = ?, reservation_date = ? WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, reservation.getFlightId());
            statement.setInt(2, reservation.getPassengerId());
            statement.setString(3, reservation.getSeat());
            statement.setDate(4, new Date(reservation.getReservationDate().getTime()));
            statement.setInt(5, reservation.getId());

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Reservation updating completed successfully");
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void delete(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Reservation reservation = (Reservation) object;
        try {
            String sql = "DELETE FROM reservation WHERE id =?";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, reservation.getId());
            statement.execute();

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Flight deleting completed successfully");
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public Object find(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Reservation reservation = (Reservation) object;
        try {
            String sql = "SELECT * FROM reservation  WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) object);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reservation.setId(resultSet.getInt("id"));
                reservation.setReservationDate(resultSet.getDate("reservation_date"));
                reservation.setSeat(resultSet.getString("seat"));
                reservation.setFlightId(resultSet.getInt("flight_id"));
                reservation.setPassengerId(resultSet.getInt("passenger_id"));
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, option not available");
            }

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return reservation;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Reservation> reservations = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reservation INNER JOIN flight ON flight.id = reservation.flight_id INNER JOIN passanger ON passanger.id = reservation.passenger_id;";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight();
                    Passenger passenger = new Passenger();
                    Reservation reservation = new Reservation();

                    reservation.setId(resultSet.getInt("reservation.id"));
                    reservation.setReservationDate(resultSet.getDate("reservation.reservation_date"));
                    reservation.setSeat(resultSet.getString("reservation.seat"));
                    reservation.setPassengerId(resultSet.getInt("reservation.passenger_id"));
                    reservation.setFlightId(resultSet.getInt("reservation.flight_id"));

                    passenger.setId(resultSet.getInt("passanger.id"));
                    passenger.setIdentityDocument(resultSet.getString("passanger.identity_document"));
                    passenger.setName(resultSet.getString("passanger.name"));
                    passenger.setLastName(resultSet.getString("passanger.lastname"));

                    flight.setId(resultSet.getInt("flight.id"));
                    flight.setTime(resultSet.getTime("flight.time"));
                    flight.setStart(resultSet.getDate("flight.start"));
                    flight.setDestination(resultSet.getString("flight.destination"));
                    flight.setAirplaneId(resultSet.getInt("flight.airplane_id"));

                    reservation.setPassenger(passenger);
                    reservation.setFlight(flight);

                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(reservations);
    }


    public List<Object> findEntityBySomething(Reservation entity) {
        objConnection = ConfigurationDB.openConnection();
        List<Reservation> reservations = new ArrayList<>();

        try {
            String sql = "SELECT * FROM reservation INNER JOIN flight ON flight.id = reservation.flight_id INNER JOIN passanger ON passanger.id = reservation.passenger_id where = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1,entity.getId() );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight();
                Passenger passenger = new Passenger();
                Reservation reservation = new Reservation();

                reservation.setId(resultSet.getInt("reservation.id"));
                reservation.setReservationDate(resultSet.getDate("reservation.reservation_date"));
                reservation.setSeat(resultSet.getString("reservation.seat"));
                reservation.setPassengerId(resultSet.getInt("reservation.passenger_id"));
                reservation.setFlightId(resultSet.getInt("reservation.flight_id"));

                passenger.setId(resultSet.getInt("passanger.id"));
                passenger.setIdentityDocument(resultSet.getString("passanger.identity_document"));
                passenger.setName(resultSet.getString("passanger.name"));
                passenger.setLastName(resultSet.getString("passanger.lastname"));

                flight.setId(resultSet.getInt("flight.id"));
                flight.setTime(resultSet.getTime("flight.time"));
                flight.setStart(resultSet.getDate("flight.start"));
                flight.setDestination(resultSet.getString("flight.destination"));
                flight.setAirplaneId(resultSet.getInt("flight.airplane_idpassanger."));

                reservation.setPassenger(passenger);
                reservation.setFlight(flight);

                reservations.add(reservation);
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(reservations);
    }
}
