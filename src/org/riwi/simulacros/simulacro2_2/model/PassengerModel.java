package org.riwi.simulacros.simulacro2_2.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.entity.Passenger;
import org.riwi.simulacros.simulacro2_2.repository.CrudRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassengerModel implements CrudRepository {
    static Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Passenger passenger = (Passenger) object;
        try {
            String sql = "INSERT INTO passanger (name,lastname,identity_document) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getLastName());
            statement.setString(3, passenger.getIdentityDocument());

            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                passenger.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "passenger insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return passenger;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Passenger passenger = (Passenger) object;
        try {
            String sql = "UPDATE passanger SET name = ?, lastname = ?, identity_document = ? WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getLastName());
            statement.setString(3, passenger.getIdentityDocument());
            statement.setInt(4, passenger.getId());

            statement.execute();

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Passenger updating completed successfully");
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
        Passenger passenger = (Passenger) object;
        try {
            String sql = "DELETE FROM passanger WHERE id =?";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, passenger.getId());
            statement.execute();

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Passenger deleting completed successfully");
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public Object find(int id) {
        objConnection = ConfigurationDB.openConnection();
        Passenger passenger;
        try {
            String sql = "SELECT * FROM passanger WHERE id = ?;";

            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            String lastname = resultSet.getString("lastname");
            String identityDocument = resultSet.getString("identity_document");

            passenger = new Passenger(id, name, lastname, identityDocument);
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return passenger;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Passenger> passengers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM passanger";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String lastname = resultSet.getString("lastname");
                    String identityDocument = resultSet.getString("identity_document");
                    int id = resultSet.getInt("id");

                    passengers.add(new Passenger(id, name, lastname, identityDocument));
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(passengers);
    }
}
