package org.riwi.simulacros.simulacro2_1.model;


import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_1.entity.Patient;
import org.riwi.simulacros.simulacro2_1.repository.CrudRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatientModel implements CrudRepository {
    Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Patient patient = (Patient) object;
        try {
            String sql = "INSERT INTO paciente (nombre, apellidos, fecha_nacimiento,documento_identidad) VALUES (?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getLastName());
            statement.setDate(3, (Date) patient.getDateBirth());
            statement.setString(4, patient.getIdentityCard());


            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                patient.setId(rs.getInt(1));
            }
            System.out.println("Patient insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return patient;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Patient patient = (Patient) object;
        try {
            String sql = "UPDATE paciente SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, documento_identidad = ? WHERE id_paciente = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getLastName());
            statement.setDate(3, (Date) patient.getDateBirth());
            statement.setString(4, patient.getIdentityCard());
            statement.setInt(5, patient.getId());


            statement.executeUpdate();

            System.out.println("Patient was update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void delete(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Patient patient = (Patient) object;
        try {
            String sql = "DELETE FROM paciente WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, patient.getId());

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object find(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Patient patient;
        try {
            String sql = "SELECT * FROM paciente WHERE id_paciente = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) object);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int patientId = resultSet.getInt("id_paciente");
            String name = resultSet.getString("nombre");
            String lastName = resultSet.getString("apellidos");
            Date dateBirth = resultSet.getDate("fecha_nacimiento");
            String identity_car = resultSet.getString("documento_identidad");

            patient = new Patient(patientId, name, lastName, dateBirth, identity_car);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return patient;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Patient> patients = new ArrayList<>();
        try {
            String sql = "SELECT * FROM paciente";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_paciente");
                    String name = resultSet.getString("nombre");
                    String lastName = resultSet.getString("apellidos");
                    Date dateBirth = resultSet.getDate("fecha_nacimiento");
                    String identity_car = resultSet.getString("documento_identidad");

                    Patient patient = new Patient(id, name, lastName, dateBirth, identity_car);
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(patients);
    }
}
