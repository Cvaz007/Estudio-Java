package org.riwi.simulacros.simulacro2_2.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.entity.Flight;
import org.riwi.simulacros.simulacro2_2.repository.CrudRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightModel implements CrudRepository {
    Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Flight flight = (Flight) object;
        try {
            String sql = "INSERT INTO flight (destination,start,time,airplane_id) VALUES (?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, flight.getDestination());
            statement.setDate(2, new Date(flight.getStart().getTime()));
            statement.setTime(3, flight.getTime());
            statement.setInt(4, flight.getAirplaneId());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                flight.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Flight insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return flight;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Flight flight = (Flight) object;
        try {
            String sql = "UPDATE flight SET destination = ?, start = ?, time = ?, airplane_id = ? WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, flight.getDestination());
            statement.setDate(2, new Date(flight.getStart().getTime()));
            statement.setTime(3, flight.getTime());
            statement.setInt(4, flight.getAirplaneId());
            statement.setInt(5, flight.getId());
            statement.execute();

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Flight updating completed successfully");
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
        Flight flight = (Flight) object;
        try {
            String sql = "DELETE FROM flight WHERE id =?";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, flight.getId());
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
        Flight flight = new Flight();
        try {
            String sql = "SELECT * FROM flight INNER JOIN airplane ON flight.airplane_id = airplane.id WHERE destination LIKE ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, "%"+object.toString()+"%" );
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Airplane airplane = new Airplane();
                flight.setAirplaneId(resultSet.getInt("flight.airplane_id"));
                flight.setId(resultSet.getInt("flight.id"));
                flight.setDestination(resultSet.getString("flight.destination"));
                flight.setStart(resultSet.getDate("flight.start"));
                flight.setTime(resultSet.getTime("flight.time"));

                airplane.setModel(resultSet.getString("airplane.model"));
                airplane.setId(resultSet.getInt("airplane.id"));
                airplane.setCapacity(resultSet.getInt("airplane.capacity"));

                flight.setAirplane(airplane);
            } else {
                JOptionPane.showMessageDialog(null,"Sorry, option not available");
            }

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return flight;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Flight> flights = new ArrayList<>();
        try {
            String sql = "SELECT * FROM flight INNER JOIN airplane ON flight.airplane_id = airplane.id;";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight();
                    Airplane airplane = new Airplane();

                    flight.setAirplaneId(resultSet.getInt("flight.airplane_id"));
                    flight.setId(resultSet.getInt("flight.id"));
                    flight.setDestination(resultSet.getString("flight.destination"));
                    flight.setStart(resultSet.getDate("flight.start"));
                    flight.setTime(resultSet.getTime("flight.time"));

                    airplane.setModel(resultSet.getString("airplane.model"));
                    airplane.setId(resultSet.getInt("airplane.id"));
                    airplane.setCapacity(resultSet.getInt("airplane.capacity"));

                    flight.setAirplane(airplane);

                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(flights);
    }
}
