package org.riwi.simulacros.simulacro2_2.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_1.entity.Appointment;
import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.repository.CrudRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirplaneModel implements CrudRepository {
    Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Airplane airplane = (Airplane) object;
        try {
            String sql = "INSERT INTO airplane (model,capacity) VALUES (?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, airplane.getModel());
            statement.setInt(2, airplane.getCapacity());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                airplane.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Airplane insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return airplane;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Airplane airplane = (Airplane) object;
        try {
            String sql = "UPDATE airplane SET model = ?, capacity = ? WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, airplane.getModel());
            statement.setInt(2, airplane.getCapacity());
            statement.setInt(3, airplane.getId());
            statement.execute();

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Airplane updating completed successfully");
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
        Airplane airplane = (Airplane) object;
        try {
            String sql = "DELETE FROM airplane WHERE id =?";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, airplane.getId());
            statement.execute();

            if (statement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Airplane deleting completed successfully");
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
        Airplane airplane;
        try {
            String sql = "SELECT * FROM airplane WHERE id = ?;";

            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) object);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int capacity = resultSet.getInt("capacity");
            String model = resultSet.getString("model");

            airplane = new Airplane((int) object, model, capacity);
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return airplane;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Airplane> airplanes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM airplane";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int capacity = resultSet.getInt("capacity");
                    String model = resultSet.getString("model");
                    int id = resultSet.getInt("id");

                    airplanes.add(new Airplane(id, model, capacity));
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(airplanes);
    }
}
